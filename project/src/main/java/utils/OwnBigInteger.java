package utils;

import java.math.BigInteger;
import java.util.Random;

/**
 * This is my implementation of BigInteger. It stores the number as a digit array. The Arithmetic operations use
 * the paper-and-pen techniques.
 *
 * Note: This implemenentation only implements the operations required for this program. It does not, for example,
 * allow for negative multiplications or square roots.
 */

public class OwnBigInteger implements Comparable<OwnBigInteger> {

    private int[] digits;

    public static final OwnBigInteger ONE = new OwnBigInteger("1");
    public static final OwnBigInteger ZERO = new OwnBigInteger("0");

    /**
     * Constructor for random number
     * @param random
     */
    public OwnBigInteger(Random random) {
        this(String.valueOf(random.nextInt( 100)));
    }

    /**
     * Constructor with String value
     * @param number
     */
    public OwnBigInteger(String number) {
        this.digits = new int[number.length()];
        for (int index = 0; index < number.length(); index++) {
            int digitNumberValue = Character.getNumericValue(number.charAt(index));
            digits[index] = digitNumberValue;
        }
    }

    /**
     * Constructor with digit array
     * @param digits
     */

    public OwnBigInteger(int[] digits) {
        this.digits = filterZeroesFromBeginning(digits);
    }

    /**
     * Shifts BigInt by n bytes
     *
     * @param n
     * @return BigIntegerImpl that has been shifted left
     */

    public OwnBigInteger shiftLeft(int n) {
        return new OwnBigInteger(shiftLeft(this.digits, n));
    }

    /**
     * String value of the number
     * @return String value of number
     */
    public String valueOf() {
        String value = "";
        for (int digit : digits) {
               value = value + digit;
        }
        return value;
    }

    public int[] getDigits() {
        return this.digits;
    }
    /**
     * Adds a bigInteger to another BigInteger
     *
     * @param otherNumber
     * @return sum of two bigIntegers
     */
    public OwnBigInteger add(OwnBigInteger otherNumber) {
        TwoArrayHolder holder = this.manageBiggerAndSmallerArrays(this, otherNumber);
        int[] biggerArray = holder.getBiggerArray();
        int[] smallerArray = holder.getSmallerArray();
        int carry = 0;
        int currentBiggerArrayIndex = 0;
        for (int i = 0; i < smallerArray.length; i++) {
            currentBiggerArrayIndex = biggerArray.length - 1 - i;
            biggerArray[currentBiggerArrayIndex] += carry;
            biggerArray[currentBiggerArrayIndex] += smallerArray[smallerArray.length - 1 - i];
            if (biggerArray[currentBiggerArrayIndex] > 9) {
                carry = 1;
                biggerArray[currentBiggerArrayIndex] -= 10;
            } else {
                carry = 0;
            }
        }
        currentBiggerArrayIndex--;
        while (carry == 1) {
            biggerArray[currentBiggerArrayIndex] += 1;
            if (biggerArray[currentBiggerArrayIndex] > 9) {
                carry = 1;
                biggerArray[currentBiggerArrayIndex] -= 10;
            } else {
                carry = 0;
            }
            currentBiggerArrayIndex--;
        }
        return new OwnBigInteger(biggerArray);
    }

    /**
     * Subtracts a BigInteger from BigInteger
     * Does not support an operation where the subtracting number
     * has more digits that the number to subtract from.
     * @param otherNumber
     * @return subtracted bigInteger
     */
    public OwnBigInteger subtract(OwnBigInteger otherNumber) {
        TwoArrayHolder holder = this.manageBiggerAndSmallerArrays(this, otherNumber);
        int[] biggerArray = filterZeroesFromBeginning(holder.getBiggerArray());
        int[] smallerArray = filterZeroesFromBeginning(holder.getSmallerArray());
        int carry = 0;
        int biggerArrayIndex = 0;
        for (int i = 0; i < smallerArray.length; i++) {
            biggerArrayIndex = biggerArray.length - 1 - i;
            biggerArray[biggerArrayIndex] -= carry;
            biggerArray[biggerArrayIndex] -= smallerArray[smallerArray.length - 1 - i];
            if (biggerArray[biggerArrayIndex] < 0 && biggerArrayIndex != 0) {
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
        return new OwnBigInteger(filterZeroesFromBeginning(biggerArray));
    }

    /**
     * Multiplies a BigInteger with another BigInteger
     * It adds each number n times from smallerNumber index and then adds the resulting numbers
     * together. Works like long multiplication.
     * @param otherNumber
     * @return product of BigInteger
     */
    public OwnBigInteger multiply(OwnBigInteger otherNumber) {
        TwoArrayHolder holder = this.manageBiggerAndSmallerArrays(this, otherNumber);
        int[] biggerArray = holder.getBiggerArray();
        int[] smallerArray = holder.getSmallerArray();
        OwnBigInteger bigger = new OwnBigInteger(biggerArray);
        int[] result = new int[smallerArray.length + biggerArray.length + 1];
        for (int i = 0; i < smallerArray.length; i++) {
            OwnBigInteger currentTotal = OwnBigInteger.ZERO;
            for (int j = 0; j < smallerArray[smallerArray.length - 1 - i]; j++) {
                currentTotal = currentTotal.add(bigger);
            }
            for (int j = 0; j < currentTotal.digits.length; j++) {
                int resultIndex = result.length - i - j - 1;
                int totalIndex = currentTotal.digits.length - j - 1;
                result[resultIndex] += currentTotal.digits[totalIndex];
                if (result[resultIndex] > 9) {
                    int carry = 1;
                    result[resultIndex] -= 10;
                    result[resultIndex - 1] += carry;
                }
            }
        }
        return new OwnBigInteger(filterZeroesFromBeginning(result));
    }

    /**
     * Divides a BigInteger with BigInteger
     * Long division algorithm implemented
     * @param otherNumber
     * @return result of division
     */
    public OwnBigInteger divide(OwnBigInteger otherNumber) {
        int compareResult = this.compareTo(otherNumber);
        if (compareResult < 0) {
            return OwnBigInteger.ZERO;
        } else if (compareResult == 0) {
            return OwnBigInteger.ONE;
        }
        int[] thisCopy = new int[this.digits.length];
        OwnArrays.arraycopy(this.digits, 0, thisCopy, 0, this.digits.length);
        OwnBigInteger dividend = new OwnBigInteger(thisCopy);
        int beginningIndex = 0;
        int endingIndex = 1;
        int[] result = new int[this.digits.length];
        while (true) {
            if (endingIndex > this.digits.length) {
                break;
            }
            int[] longDividerArray = new int[endingIndex - beginningIndex];
            OwnArrays.arraycopy(dividend.digits, beginningIndex, longDividerArray, 0, endingIndex - beginningIndex);
            OwnBigInteger currentDividend = new OwnBigInteger(longDividerArray);
            int times = 0;
            if (currentDividend.compareTo(otherNumber) >= 0) {
                while (currentDividend.compareTo(otherNumber) >= 0) {
                    currentDividend = currentDividend.subtract(otherNumber);
                    times++;
                }
                if (currentDividend.compareTo(OwnBigInteger.ZERO) == 0) {
                    beginningIndex = endingIndex;
                } else {
                    int digitsLeftFromSubtract = currentDividend.digits.length;
                    beginningIndex = endingIndex - digitsLeftFromSubtract;
                    OwnArrays.arraycopy(currentDividend.digits, 0, dividend.digits, beginningIndex, digitsLeftFromSubtract);
                }
            }
            result[endingIndex - 1] = times;
            endingIndex++;
        }
        return new OwnBigInteger(filterZeroesFromBeginning(result));
    }

    /**
     * Returns a mod divisor. As divide operation only returns the result without the decimal
     * the modulo is simply originalNumber - (result*divisor)
     * @param divisor
     * @return modulus
     */
    public OwnBigInteger mod(OwnBigInteger divisor) {
        OwnBigInteger divided = this.divide(divisor);
        return this.subtract(divided.multiply(divisor));
    }

    /**
     * First takes a modulus of the number and then raises it to power of pow
     *
     * @param mod
     * @param pow
     * @return this mod pow
     */

    public OwnBigInteger modPow(OwnBigInteger mod, OwnBigInteger pow) {
        OwnBigInteger power = this.pow(pow);
        return power.mod(mod);
    }

    /**
     * Raises a number to a power
     *
     * @param power
     * @return n^p
     */
    public OwnBigInteger pow(OwnBigInteger power) {
        OwnBigInteger zero = new OwnBigInteger("0");
        OwnBigInteger result = new OwnBigInteger("1");
        if (power.equals(zero)) {
            return new OwnBigInteger("1");
        } else if (power.compareTo(zero) > 0) {
            OwnBigInteger newPower = power.subtract(new OwnBigInteger("1"));
            return this.multiply(pow(newPower));
        }
        return result;
    }

    @Override
    public int compareTo(OwnBigInteger other) {
        if (digits.length > other.digits.length) {
            return 1;
        } else if (digits.length < other.digits.length) {
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

        OwnBigInteger other = (OwnBigInteger) o;

        if (this.digits.length != other.digits.length) {
            return false;
        }

        for (int i = 0; i < this.digits.length; i++) {
            if (this.digits[i] != other.digits[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.valueOf();
    }

    /**
     * Helper method to ensure that smallerArray is below biggerArray in operations
     *
     * @param numberOne
     * @param numberTwo
     * @return TwoArrayHolder that stores created arrays
     */

    private TwoArrayHolder manageBiggerAndSmallerArrays(OwnBigInteger numberOne, OwnBigInteger numberTwo) {
        TwoArrayHolder twoArrayHolder = new TwoArrayHolder();
        int[] biggerNumber = null;
        int[] smallerNumber = null;
        if (numberOne.digits.length < numberTwo.digits.length) {
            biggerNumber = new int[numberTwo.digits.length + 1];
            OwnArrays.arraycopy(numberTwo.digits, 0, biggerNumber, 1, numberTwo.digits.length);
            smallerNumber = new int[this.digits.length];
            OwnArrays.arraycopy(this.digits, 0, smallerNumber, 0, this.digits.length);
        } else {
            biggerNumber = new int[this.digits.length + 1];
            OwnArrays.arraycopy(this.digits, 0, biggerNumber, 1, this.digits.length);
            smallerNumber = new int[numberTwo.digits.length];
            OwnArrays.arraycopy(numberTwo.digits, 0, smallerNumber, 0, numberTwo.digits.length);
        }
        twoArrayHolder.setBiggerArray(biggerNumber);
        twoArrayHolder.setSmallerArray(smallerNumber);
        return twoArrayHolder;
    }

    /**
     * The arithmetic operations sometimes copy arrays so that there are leading zeroes.
     * As this causes problems after the number has been
     * generated this filters them out.
     * @param array
     * @return a number without the leading zeroes
     */

    private int[] filterZeroesFromBeginning(int[] array) {
        int[] finalArray = array;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (i == 0) {
                    break;
                }
                finalArray = new int[array.length - i];
                OwnArrays.arraycopy(array, i, finalArray, 0, finalArray.length);
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
     * Shifts a number to left. Ends up multiplying the number
     * @param mag the digits of the number
     * @param n the shift length
     * @return number shifted n to the left
     */
    private String shiftLeft(int[] mag, int n) {
        int nInts = n >>> 5;
        int nBits = n & 31;
        int magLen = mag.length;
        int[] newMag = null;
        if (nBits == 0) {
            newMag = new int[magLen + nInts];
            OwnArrays.arraycopy(mag, 0, newMag, 0, magLen);
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
            for (j = 0; j < magLen - 1; newMag[i++] = mag[j++] << nBits | mag[j] >>> nBits2) {
            }

            newMag[i] = mag[j] << nBits;
        }
        StringBuilder number = new StringBuilder();
        for (int i : newMag) {
            number.append(String.valueOf(i));
        }
        return number.toString();
    }

}