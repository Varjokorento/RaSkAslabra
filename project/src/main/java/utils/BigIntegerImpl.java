package utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class BigIntegerImpl implements Comparable<BigIntegerImpl> {

    private String numberAsString;
    private int[] digits;



    public BigIntegerImpl(int bitLength, Random random) {
        this(String.valueOf(random.nextInt()));

    }

    public BigIntegerImpl(String number){
        this.digits = new int[number.length()];
        numberAsString = number;
        for (int index = 0; index < number.length(); index++) {
                int digitNumberValue = Character.getNumericValue(number.charAt(index));
                digits[index] = digitNumberValue;
        }
    }

    /**
     * Shifts BigInt by n bytes
     * @param n
     * @return BigIntegerImpl that has been shifted left
     */

    public BigIntegerImpl shiftLeft(int n) {
        return new BigIntegerImpl(shiftLeft(this.digits, n));
    }


    /**
     * Bit operation that shifts a number n to the right
     * @param n
     * @return BigInteger that has been shifted n to the right
     */

    public BigIntegerImpl shiftRight(int n) {
        return new BigIntegerImpl(this.shiftRightImpl(n));
    }

  
    public String valueOf() {
        return this.toString();
    }

    /**
     * Adds a bigInteger to another BigInteger
     * @param otherNumber
     * @return sum of two bigIntegers
     */
    public BigIntegerImpl add(BigIntegerImpl otherNumber) {
        int[] longerNumber;
        int[] shorterNumber;
        if (digits.length >= otherNumber.digits.length) {
            longerNumber = digits;
            shorterNumber = otherNumber.digits;
        }
        else {
            longerNumber = otherNumber.digits;
            shorterNumber = digits;
        }
        int lengthsDifferences = longerNumber.length - shorterNumber.length;
        StringBuilder resultString = new StringBuilder();
        int carry = 0;
        for (int index = shorterNumber.length - 1; index >= 0; index--) {
            int shorterNumberDigit = shorterNumber[index];
            int longerNumberDigit = longerNumber[index + lengthsDifferences];
            int newDigit = shorterNumberDigit + longerNumberDigit + carry;
            carry = newDigit / 10;
            newDigit = newDigit % 10;
            resultString.append(newDigit);
        }

        for (int index = lengthsDifferences - 1; index >= 0; index--) {
            int currDig = longerNumber[index];
             if (currDig + carry == 10) {
                resultString.append(0);
                carry = 1;
            } else {
                resultString.append(currDig + carry);
                carry = 0;
            }
        }
        if (carry > 0) {
            resultString.append(carry);
        }
        return new BigIntegerImpl(resultString.reverse().toString());
    }

    /**
     * Subtracts a BigInteger from BigInteger
     * @param otherNumber
     * @return subtracted bigInteger
     */
    public BigIntegerImpl subtract(BigIntegerImpl otherNumber){
        int lengthsDifferences = digits.length - otherNumber.digits.length;
        StringBuilder resultString = new StringBuilder();
        int carry = 0;
        for (int index = otherNumber.digits.length - 1;index >=0; index--) {
            int biggerNumDig = digits[index + lengthsDifferences] - carry;
            int smallerNumDig = otherNumber.digits[index];
            carry = 0;
            if (biggerNumDig < smallerNumDig){
                carry = 1;
                biggerNumDig += 10;
            }
            resultString.append(biggerNumDig - smallerNumDig);
        }

        for (int index = lengthsDifferences - 1; index >=0 ; index--) {
            int currDig = digits[index];
            if (carry > currDig){
                resultString.append(currDig + 10 - carry);
                carry = 1;
            } else {
                resultString.append(currDig - carry);
                carry = 0;
            }
        }
        String resultedString = resultString.reverse().toString();
        char[] array = resultedString.toCharArray();
        StringBuilder toBuild = new StringBuilder();
        boolean numberHasStarted = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0' && !numberHasStarted && array.length != 1) {
                array[i] = 'X';
             } else {
                numberHasStarted = true;
                toBuild.append(array[i]);
            }
        }

        return new BigIntegerImpl(toBuild.toString());
    }

    /**
     * Multiplies a BigInteger with another BigInteger
     * @param otherNumber
     * @return product of BigInteger
     */


    public BigIntegerImpl multiply(BigIntegerImpl otherNumber) {
        BigIntegerImpl finalResult = new BigIntegerImpl("0");
        BigIntegerImpl currentUnit = new BigIntegerImpl("1");

        for (int otherNumIndex = otherNumber.digits.length - 1; otherNumIndex >=0; otherNumIndex--){
            int currentOtherNumDigit = otherNumber.digits[otherNumIndex];
            BigIntegerImpl currentResult = new BigIntegerImpl("0");
            BigIntegerImpl currentDigitUnit = new BigIntegerImpl(currentUnit.toString());

            for (int index = digits.length - 1; index >=0; index--) {
                int currentDigit = digits[index];
                int digitsMultiplication = currentDigit * currentOtherNumDigit;

                currentResult = currentDigitUnit.MultiplyUnit(digitsMultiplication);
                currentDigitUnit.multiplyByTen();
            }

            currentUnit.multiplyByTen();
            finalResult = finalResult.add(currentResult);
        }

        return finalResult;
    }

    /**
     * Divides a BigInteger with BigInteger
     * @param otherNumber
     * @return result of division
     */
    public BigIntegerImpl divide(BigIntegerImpl otherNumber) {
        if (otherNumber.valueOf().equals("0"))
            throw new ArithmeticException();
        int compareResult = this.compareTo(otherNumber);
        if (compareResult == 0) {
            return new BigIntegerImpl("1");
        }

        else if (compareResult < 0) {
            return new BigIntegerImpl("0");
        }
        BigIntegerImpl result = new BigIntegerImpl("0");
        BigIntegerImpl tempNumber = new BigIntegerImpl("0");

        while (tempNumber.compareTo(this) < 0) {
            tempNumber = tempNumber.add(otherNumber);
            result = result.add(new BigIntegerImpl("1"));
        }
        return result;
    }

  
    /**
     * Returns a modulus of two numbers
     * @param divisor
     * @return modulus
     */
    public BigIntegerImpl mod( BigIntegerImpl divisor) {
       
        BigIntegerImpl bigInteger = this;
        while(bigInteger.compareTo(divisor) > 0) {
            bigInteger = bigInteger.subtract(divisor);
        }
        return bigInteger;
    }

    /**
     * First takes a modulus of the number and then raises it to power of pow
     * @param mod
     * @param pow
     * @return this mod pow
     */

    public BigIntegerImpl modPow(BigIntegerImpl mod, BigIntegerImpl pow) {
        BigIntegerImpl power =  this.pow(this, pow);
        return this.mod(mod);
    }

    /**
     * Raises a number to a power
     * @param number
     * @param power
     * @return n^p
     */

    public BigIntegerImpl pow(BigIntegerImpl number, BigIntegerImpl power) {
        BigIntegerImpl zero = new BigIntegerImpl("0");
        BigIntegerImpl result = new BigIntegerImpl("1");
        if (power.equals(zero)) {
            return new BigIntegerImpl("1");
        } else if (power.compareTo(zero) > 0 ) {
            BigIntegerImpl newPower = power.subtract(new BigIntegerImpl("1"));
            return number.multiply(pow(number, newPower));
        }
        return result;
    }

    @Override
    public int compareTo(BigIntegerImpl other) {
        if (digits.length > other.digits.length) {
            return 1;
        }
        else if (digits.length < other.digits.length) {
            return -1;
        } else {
            for (int index = 0; index < digits.length; index++) {
                if (digits[index] > other.digits[index])
                    return 1;
            else if (digits[index] < other.digits[index])
                    return -1;
            }
        }
       return 0;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        BigIntegerImpl other = (BigIntegerImpl) o;
        return other.toString().equals(numberAsString);
    }

    @Override
    public String toString() {
        return numberAsString;
    }

    private BigIntegerImpl MultiplyUnit(int majorUnits){
        String majorUnitsString = String.valueOf(majorUnits);
        String newNumber = majorUnitsString + numberAsString.substring(1);
        return new BigIntegerImpl(newNumber);
    }


    private void multiplyByTen() {
        int[] newDigit = new int[this.digits.length +1];
        newDigit[this.digits.length] = 0;
        this.digits = newDigit;
        numberAsString += '0';
    }

    private String shiftRightImpl(int n) {
        int nInts = n >>> 5;
        int nBits = n & 31;
        int magLen = this.digits.length;
        int[] newMag = null;
        if (nInts >= magLen) {
        } else {
            int newMagLen;
            int i;
            int nBits2;
            if (nBits == 0) {
                newMagLen = magLen - nInts;
                newMag = Arrays.copyOf(this.digits, newMagLen);
            } else {
                newMagLen = 0;
                i = this.digits[0] >>> nBits;
                if (i != 0) {
                    newMag = new int[magLen - nInts];
                    newMag[newMagLen++] = i;
                } else {
                    newMag = new int[magLen - nInts - 1];
                }
                nBits2 = 32 - nBits;
                for(int j = 0; j < magLen - nInts - 1; newMag[newMagLen++] = this.digits[j++] << nBits2 | this.digits[j] >>> nBits) {
                }
            }
            StringBuilder number = new StringBuilder();
            for (int a: newMag) {
                number.append(String.valueOf(a));
            }
            return number.toString();
        }
        return "";
    }



    private String shiftLeft(int[] mag, int n) {
        int nInts = n >>> 5;
        int nBits = n & 31;
        int magLen = mag.length;
        int[] newMag = null;
        if (nBits == 0) {
            newMag = new int[magLen + nInts];
            System.arraycopy(mag, 0, newMag, 0, magLen);
        } else {
            int i = 0;
            int nBits2 = 32 - nBits;
            int highBits = mag[0] >>> nBits2;
            if (highBits != 0) {
                newMag = new int[magLen + nInts + 1];
                newMag[i++] = highBits;
            } else {
                newMag = new int[magLen + nInts];
            }

            int j;
            for(j = 0; j < magLen - 1; newMag[i++] = mag[j++] << nBits | mag[j] >>> nBits2) {
            }

            newMag[i] = mag[j] << nBits;
        }
        StringBuilder number = new StringBuilder();
        for (int i: newMag) {
            number.append(String.valueOf(i));
        }
       return number.toString();
    }


}