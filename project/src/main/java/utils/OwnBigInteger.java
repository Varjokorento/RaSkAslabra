package utils;

import java.util.Random;

/**
 * This is my implementation of BigInteger. It stores the number as a digit array. The Arithmetic operations use
 * the paper-and-pen techniques.
 * <p>
 * This implementation copies arrays using OwnArrays.arraycopy.
 * <p>
 * Note: This implemenentation only implements the operations required for this program. It does not, for example,
 * allow for negative multiplications or square roots.
 */

public class OwnBigInteger implements Comparable<OwnBigInteger> {

    private int[] digits;

    public static final OwnBigInteger ONE = new OwnBigInteger("1");
    public static final OwnBigInteger ZERO = new OwnBigInteger("0");

    /**
     * Constructor for random number
     *
     * @param random a random number
     */
    public OwnBigInteger(Random random) {
        this(String.valueOf(random.nextInt(1000000000)));
    }


    /**
     * Generates a random number based on the Microsoft formula for linear congruential generator
     * @return a random OwnBigInteger
     */
    public static OwnBigInteger getLargeRandom() {
        long randomString = System.nanoTime();
        OwnBigInteger random = new OwnBigInteger(Long.toString(randomString));
        random = random.multiply(new OwnBigInteger("214013"));
        random = random.add(new OwnBigInteger("2531011").mod(new OwnBigInteger("2").pow(new OwnBigInteger("31"))));
        return random;
    }

    /**
     * Constructor with String value
     *
     * @param number String value of the number to be created
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
     *
     * @param digits the digits of the number in an array form
     */

    public OwnBigInteger(int[] digits) {
        this.digits = filterZeroesFromBeginning(digits);
    }

    /**
     * Shifts BigInt by n bytes
     *
     * @param n how many bytes are shifted
     * @return BigIntegerImpl that has been shifted left
     */

    public OwnBigInteger shiftLeft(int n) {
        return new OwnBigInteger(shiftLeft(this.digits, n));
    }

    /**
     * String value of the number
     *
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
     * @param otherNumber the number to be added
     * @return sum of two bigIntegers
     */
    public OwnBigInteger add(OwnBigInteger otherNumber) {
        TwoArrayHolder holder = this.manageLongerAndShorterArrays(this, otherNumber);
        int[] longerArray = holder.getLongerArray();
        int[] shorterArray = holder.getShorterArray();
        int carry = 0;
        int currentBiggerArrayIndex = 0;
        for (int i = 0; i < shorterArray.length; i++) {
            currentBiggerArrayIndex = longerArray.length - 1 - i;
            longerArray[currentBiggerArrayIndex] += carry;
            longerArray[currentBiggerArrayIndex] += shorterArray[shorterArray.length - 1 - i];
            if (longerArray[currentBiggerArrayIndex] > 9) {
                carry = 1;
                longerArray[currentBiggerArrayIndex] -= 10;
            } else {
                carry = 0;
            }
        }
        currentBiggerArrayIndex--;

        boolean doCarry = carry == 1;

        while (doCarry) {
            longerArray[currentBiggerArrayIndex] += 1;
            if (longerArray[currentBiggerArrayIndex] > 9) {
                longerArray[currentBiggerArrayIndex] -= 10;
            } else {
                doCarry = false;
            }
            currentBiggerArrayIndex--;
        }
        return new OwnBigInteger(longerArray);
    }

    /**
     * Subtracts a BigInteger from BigInteger
     * Does not support an operation where the subtracting number
     * has more digits that the number to subtract from.
     *
     * @param otherNumber number that is used to subtract
     * @return subtracted bigInteger
     */
    public OwnBigInteger subtract(OwnBigInteger otherNumber) {
        TwoArrayHolder holder = this.manageLongerAndShorterArrays(this, otherNumber);
        int[] longerArray = filterZeroesFromBeginning(holder.getLongerArray());
        int[] shorterArray = filterZeroesFromBeginning(holder.getShorterArray());
        int carry = 0;
        int biggerArrayIndex = 0;
        for (int i = 0; i < shorterArray.length; i++) {
            biggerArrayIndex = longerArray.length - 1 - i;
            longerArray[biggerArrayIndex] -= carry;
            longerArray[biggerArrayIndex] -= shorterArray[shorterArray.length - 1 - i];
            if (longerArray[biggerArrayIndex] < 0 && biggerArrayIndex != 0) {
                carry = 1;
                longerArray[biggerArrayIndex] += 10;
            } else {
                carry = 0;
            }
        }
        biggerArrayIndex--;

        boolean doCarry = (carry == 1);

        while (doCarry) {
            longerArray[biggerArrayIndex] -= 1;
            if (longerArray[biggerArrayIndex] < 0) {
                longerArray[biggerArrayIndex] += 10;
            } else {
                doCarry = false;
            }
            biggerArrayIndex--;
        }
        return new OwnBigInteger(filterZeroesFromBeginning(longerArray));
    }

    /**
     * Multiplies a BigInteger with another BigInteger
     * It adds each number n times from smallerNumber index and then adds the resulting numbers
     * together. Works like long multiplication.
     *
     * @param otherNumber number to be multiplied with
     * @return product of BigInteger
     */
    public OwnBigInteger multiply(OwnBigInteger otherNumber) {
        TwoArrayHolder holder = this.manageLongerAndShorterArrays(this, otherNumber);
        int[] longerArray = holder.getLongerArray();
        int[] shorterArray = holder.getShorterArray();
        OwnBigInteger bigger = new OwnBigInteger(longerArray);
        int[] result = new int[longerArray.length + longerArray.length];
        for (int i = 0; i < shorterArray.length; i++) {
            OwnBigInteger currentTotal = OwnBigInteger.ZERO;
            int times = shorterArray[shorterArray.length - 1 - i];
            for (int j = 0; j < times; j++) {
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
     * Divides a this with BigInteger
     * Long division algorithm implemented
     *
     * @param dividor the dividor
     * @return result of division
     */
    public OwnBigInteger divide(OwnBigInteger dividor) {
        int[] copy = new int[this.digits.length];
        OwnArrays.arraycopy(this.digits, 0, copy, 0, this.digits.length);
        OwnBigInteger dividend = new OwnBigInteger(copy);
        int beginningIndex = 0;
        int[] result = new int[this.digits.length];
        for (int endingIndex = 1; endingIndex <= this.digits.length; endingIndex++) {
            int[] longDividerArray = new int[endingIndex - beginningIndex];
            OwnArrays.arraycopy(dividend.digits, beginningIndex, longDividerArray, 0, endingIndex - beginningIndex);
            OwnBigInteger currDiv = new OwnBigInteger(longDividerArray);
            int multiple = 0;
            if (currDiv.compareTo(dividor) >= 0) {
                while (currDiv.compareTo(dividor) >= 0) {
                    currDiv = currDiv.subtract(dividor);
                    multiple++;
                }
                if (currDiv.compareTo(OwnBigInteger.ZERO) == 0) {
                    beginningIndex = endingIndex;
                } else {
                    int leftDigits = currDiv.digits.length;
                    beginningIndex = endingIndex - leftDigits;
                    OwnArrays.arraycopy(currDiv.digits, 0, dividend.digits, beginningIndex, leftDigits);
                }
            }
            result[endingIndex - 1] = multiple;
        }
        return new OwnBigInteger(filterZeroesFromBeginning(result));
    }

    /**
     * Returns a mod divisor. As divide operation only returns the result without the decimal
     * the modulo is simply originalNumber - (result*divisor)
     *
     * @param divisor the divisor
     * @return modulus
     */
    public OwnBigInteger mod(OwnBigInteger divisor) {
        OwnBigInteger divided = this.divide(divisor);
        return this.subtract(divided.multiply(divisor));
    }

    /**
     * Raises a number to a power
     * Isn't actually used anymore due to refactoring. However, it is used in some performance tests.
     *
     * @param power the power to be raised to
     * @return n^p
     */
    public OwnBigInteger pow(OwnBigInteger power) {
        OwnBigInteger result = new OwnBigInteger("1");
        if (power.equals(OwnBigInteger.ZERO)) {
            return new OwnBigInteger("1");
        } else if (power.compareTo(OwnBigInteger.ZERO) > 0) {
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
                if (digits[index] > other.digits[index]) {
                    return 1;
                } else if (digits[index] < other.digits[index]) {
                    return -1;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
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
     * Uses modular exponentiation to raise a number to it's n power and then
     * takes its modulus.
     *
     * @param exponent the power to be raised to
     * @param modulus the modulo
     * @return a^exponent mod modulus
     */

    public OwnBigInteger modPow(OwnBigInteger exponent, OwnBigInteger modulus) {
        OwnBigInteger base = this;
        if (modulus.compareTo(OwnBigInteger.ONE) == 0) {
            return OwnBigInteger.ZERO;
        }
        OwnBigInteger result = OwnBigInteger.ONE;
        base = base.mod(modulus);
        while (exponent.compareTo(OwnBigInteger.ZERO) > 0) {
            if (exponent.mod(new OwnBigInteger("2")).compareTo(OwnBigInteger.ONE) == 0) {
                result = (result.multiply(base)).mod(modulus);
            }
            exponent = exponent.divide(new OwnBigInteger("2"));
            base = (base.multiply(base)).mod(modulus);
        }
        return result;
    }


    /**
     * Helper method to ensure that smallerArray is below biggerArray in operations
     *
     * @param numberOne one number
     * @param numberTwo another number
     * @return TwoArrayHolder that stores created arrays
     */

    private TwoArrayHolder manageLongerAndShorterArrays(OwnBigInteger numberOne, OwnBigInteger numberTwo) {
        TwoArrayHolder twoArrayHolder = new TwoArrayHolder();
        int[] longerNumber = null;
        int[] shorterNumber = null;
        if (numberOne.digits.length < numberTwo.digits.length) {
            longerNumber = new int[numberTwo.digits.length + 1];
            OwnArrays.arraycopy(numberTwo.digits, 0, longerNumber, 1, numberTwo.digits.length);
            shorterNumber = new int[this.digits.length];
            OwnArrays.arraycopy(this.digits, 0, shorterNumber, 0, this.digits.length);
        } else {
            longerNumber = new int[this.digits.length + 1];
            OwnArrays.arraycopy(this.digits, 0, longerNumber, 1, this.digits.length);
            shorterNumber = new int[numberTwo.digits.length];
            OwnArrays.arraycopy(numberTwo.digits, 0, shorterNumber, 0, numberTwo.digits.length);
        }
        twoArrayHolder.setLongerArray(longerNumber);
        twoArrayHolder.setShorterArray(shorterNumber);
        return twoArrayHolder;
    }

    /**
     * The arithmetic operations often copy arrays so that there are leading zeroes.
     * As this causes problems after the number has been
     * generated this filters them out.
     *
     * @param array array with possible zeroes
     * @return a number without the leading zeroes
     */

    private int[] filterZeroesFromBeginning(int[] array) {
        int[] arrayWithoutZeroes = array;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (i == 0) {
                    return arrayWithoutZeroes;
                }
                arrayWithoutZeroes = new int[array.length - i];
                OwnArrays.arraycopy(array, i, arrayWithoutZeroes, 0, arrayWithoutZeroes.length);
                return arrayWithoutZeroes;
            }
            if (i == array.length - 1) {
                return new int[1];
            }
        }
        return arrayWithoutZeroes;
    }


    /**
     * Shifts a number to left. Ends up multiplying the number
     *
     * @param mag the digits of the number
     * @param n   the shift length
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
                //not needed
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