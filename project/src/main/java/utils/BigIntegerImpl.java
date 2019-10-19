package utils;

import java.util.Arrays;
import java.util.Random;

public class BigIntegerImpl implements Comparable<BigIntegerImpl> {

    private String numberAsString;
    private int[] digits;

    public static final BigIntegerImpl ONE = new BigIntegerImpl("1");
    public static final BigIntegerImpl ZERO = new BigIntegerImpl("0");



    public BigIntegerImpl(int bitLength, Random random) {
        this(String.valueOf(random.nextInt(1000)));

    }

    public BigIntegerImpl(String number){
        this.digits = new int[number.length()];
        numberAsString = number;
        for (int index = 0; index < number.length(); index++) {
                int digitNumberValue = Character.getNumericValue(number.charAt(index));
                digits[index] = digitNumberValue;
        }
    }

    public BigIntegerImpl(int[] digits) {
        this.digits = filterZeroesFromBeginning(digits);
        this.numberAsString = "";
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
        StringBuilder sb = new StringBuilder();
        if (numberAsString.length() > 1) {
            return this.toString();
        } else {
            for (int digit : digits) {
                sb.append(digit);
            }
            return sb.toString();
        }

    }

    /**
     * Adds a bigInteger to another BigInteger
     * @param otherNumber
     * @return sum of two bigIntegers
     */
    public BigIntegerImpl add(BigIntegerImpl otherNumber) {
        int[] biggerNumber;
        int[] smallerNumber;
        if (this.digits.length < otherNumber.digits.length) {
            biggerNumber = new int[otherNumber.digits.length + 1];
            System.arraycopy(otherNumber.digits, 0, biggerNumber, 1, otherNumber.digits.length);
            smallerNumber = new int[this.digits.length];
            System.arraycopy(this.digits, 0, smallerNumber, 0, this.digits.length);
        } else {
            biggerNumber = new int[this.digits.length + 1];
            System.arraycopy(this.digits, 0, biggerNumber, 1, this.digits.length);
            smallerNumber = new int[otherNumber.digits.length];
            System.arraycopy(otherNumber.digits, 0, smallerNumber, 0, otherNumber.digits.length);
        }
        int carry = 0;
        int biggerArrayIndex = 0;
        for (int i = 0; i < smallerNumber.length; i++) {
            biggerArrayIndex = biggerNumber.length - 1 - i;
            biggerNumber[biggerArrayIndex] += carry;
            biggerNumber[biggerArrayIndex] += smallerNumber[smallerNumber.length - 1 - i];
            if (biggerNumber[biggerArrayIndex] > 9) {
                carry = 1;
                biggerNumber[biggerArrayIndex] -= 10;
            } else {
                carry = 0;
            }
        }
        biggerArrayIndex--;
        while (carry == 1) {
            biggerNumber[biggerArrayIndex] += 1;
            if (biggerNumber[biggerArrayIndex] > 9) {
                carry = 1;
                biggerNumber[biggerArrayIndex] -= 10;
            } else {
                carry = 0;
            }
            biggerArrayIndex--;
        }
        int[] finalArray = biggerNumber;
        for (int i = 0; i < biggerNumber.length; i++) {
            if (biggerNumber[i] != 0) {
                if (i == 0) {
                    break;
                }
                finalArray = new int[biggerNumber.length - i];
                System.arraycopy(biggerNumber, i, finalArray, 0, finalArray.length);
                break;
            }
            if (i == biggerNumber.length - 1) {
                finalArray = new int[1];
                finalArray[0] = biggerNumber[biggerNumber.length - 1];
            }
        }
        return new BigIntegerImpl(finalArray);
    }

    /**
     * Subtracts a BigInteger from BigInteger
     * @param otherNumber
     * @return subtracted bigInteger
     */
    public BigIntegerImpl subtract(BigIntegerImpl otherNumber){
            int[] biggerArray;
            int[] smallerArray;
            if (this.digits.length < otherNumber.digits.length) {
                biggerArray = new int[otherNumber.digits.length + 1];
                System.arraycopy(otherNumber.digits, 0, biggerArray, 1, otherNumber.digits.length);
                smallerArray = new int[this.digits.length];
                System.arraycopy(this.digits, 0, smallerArray, 0, this.digits.length);
            } else {
                biggerArray = new int[this.digits.length + 1];
                System.arraycopy(this.digits, 0, biggerArray, 1, this.digits.length);
                smallerArray = new int[otherNumber.digits.length];
                System.arraycopy(otherNumber.digits, 0, smallerArray, 0, otherNumber.digits.length);
            }
            int carry = 0;
            int biggerArrayIndex = 0;
            biggerArray = filterZeroesFromBeginning(biggerArray);
            for (int i = 0; i < smallerArray.length; i++) {
                biggerArrayIndex = biggerArray.length - 1 - i;
                biggerArray[biggerArrayIndex] -= carry;
                biggerArray[biggerArrayIndex] -= smallerArray[smallerArray.length - 1 - i];
                if (biggerArray[biggerArrayIndex] < 0) {
                    carry = 1;
                    biggerArray[biggerArrayIndex] += 10;
                } else {
                    carry = 0;
                }
            }
            biggerArrayIndex--;
            while (carry == 1) {
                biggerArray[biggerArrayIndex] -= 1;
                if (biggerArray[biggerArrayIndex] < 0) {
                    carry = 1;
                    biggerArray[biggerArrayIndex] += 10;
                } else {
                    carry = 0;
                }
                biggerArrayIndex--;
            }
            int[] finalArray = filterZeroesFromBeginning(biggerArray);
            return new BigIntegerImpl(finalArray);
    }

    /**
     * Multiplies a BigInteger with another BigInteger
     * @param x
     * @return product of BigInteger
     */


    public BigIntegerImpl multiply(BigIntegerImpl x) {
        int[] bigArr;
        int[] smallArray;
        if (this.digits.length < x.digits.length) {
            bigArr = new int[x.digits.length];
            System.arraycopy(x.digits, 0, bigArr, 0, x.digits.length);
            smallArray = new int[this.digits.length];
            System.arraycopy(this.digits, 0, smallArray, 0, this.digits.length);
        } else {
            bigArr = new int[this.digits.length];
            System.arraycopy(this.digits, 0, bigArr, 0, this.digits.length);
            smallArray = new int[x.digits.length];
            System.arraycopy(x.digits, 0, smallArray, 0, x.digits.length);
        }
        BigIntegerImpl bigger = new BigIntegerImpl(bigArr);
        int[] result = new int[smallArray.length + bigArr.length + 1];
        for (int i = 0; i < smallArray.length; i++) {
            BigIntegerImpl total = BigIntegerImpl.ZERO;
            for (int j = 0; j < smallArray[smallArray.length - 1 - i]; j++) {
                total = total.add(bigger);
            }
            for (int j = 0; j < total.digits.length; j++) {
                int resultIndex = result.length - i - j - 1;
                int totalIndex = total.digits.length - j - 1;
                result[resultIndex] += total.digits[totalIndex];
                if (result[resultIndex] > 9) {
                    result[resultIndex] -= 10;
                    result[resultIndex - 1] += 1;
                }
            }
        }
        result = filterZeroesFromBeginning(result);
        return new BigIntegerImpl(result);
    }

    private int[] filterZeroesFromBeginning(int[] array) {
        int[] finalArray = array;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (i == 0) {
                    break;
                }
                finalArray = new int[array.length - i];
                System.arraycopy(array, i, finalArray, 0, finalArray.length);
                break;
            }
            if (i == array.length - 1) {
                finalArray = new int[1];
                finalArray[0] = array[array.length - 1];
            }
        }
        return finalArray;
    }

    /**
     * Divides a BigInteger with BigInteger
     * @param otherNumber
     * @return result of division
     */
    public BigIntegerImpl divide(BigIntegerImpl otherNumber) {
        int compareResult = this.compareTo(otherNumber);
        if (compareResult < 0) {
            return BigIntegerImpl.ZERO;
        } else if (compareResult == 0) {
            return BigIntegerImpl.ONE;
        }
        int[] thisCopy = new int[this.digits.length];
        System.arraycopy(this.digits, 0, thisCopy, 0, this.digits.length);
        BigIntegerImpl dividend = new BigIntegerImpl(thisCopy);
        int thisBeginIndex = 0;
        int thisEndIndex = 1;
        int[] result = new int[this.digits.length];
        while (true) {
            if (thisEndIndex > this.digits.length) {
                break;
            }
            int[] longDividerArray = new int[thisEndIndex - thisBeginIndex];
            System.arraycopy(dividend.digits, thisBeginIndex, longDividerArray, 0, thisEndIndex - thisBeginIndex);
            BigIntegerImpl longDividend = new BigIntegerImpl(longDividerArray);
            int times = 0;
            if (longDividend.compareTo(otherNumber) >= 0) {
                while (longDividend.compareTo(otherNumber) >= 0) {
                    longDividend = longDividend.subtract(otherNumber);
                    times++;
                }
                if (longDividend.compareTo(BigIntegerImpl.ZERO) == 0) {
                    thisBeginIndex = thisEndIndex;
                } else {
                    int digitsLeftFromSubtract = longDividend.digits.length;
                    thisBeginIndex = thisEndIndex - digitsLeftFromSubtract;
                    System.arraycopy(longDividend.digits, 0, dividend.digits, thisBeginIndex, digitsLeftFromSubtract);
                }
            }
            result[thisEndIndex - 1] = times;
            thisEndIndex++;

        }
        result = filterZeroesFromBeginning(result);
        return new BigIntegerImpl(result);
    }
  
    /**
     * Returns a modulus of two numbers
     * @param divisor
     * @return modulus
     */
    public BigIntegerImpl mod (BigIntegerImpl divisor) {
        BigIntegerImpl divided = this.divide(divisor);
        return this.subtract(divided.multiply(divisor));
    }

    /**
     * First takes a modulus of the number and then raises it to power of pow
     * @param mod
     * @param pow
     * @return this mod pow
     */

    public BigIntegerImpl modPow(BigIntegerImpl mod, BigIntegerImpl pow) {
        BigIntegerImpl power =  this.pow(pow);
        return power.mod(mod);
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

    public BigIntegerImpl pow(BigIntegerImpl power) {
        BigIntegerImpl zero = new BigIntegerImpl("0");
        BigIntegerImpl result = new BigIntegerImpl("1");
        if (power.equals(zero)) {
            return new BigIntegerImpl("1");
        } else if (power.compareTo(zero) > 0 ) {
            BigIntegerImpl newPower = power.subtract(new BigIntegerImpl("1"));
            return this.multiply(pow(newPower));
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

        if (this.digits.length != other.digits.length) {
            return false;
        }

        for(int i = 0; i < this.digits.length; i++) {
            if (this.digits[i] != other.digits[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return numberAsString;
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