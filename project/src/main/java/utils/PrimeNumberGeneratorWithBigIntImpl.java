package utils;


import java.math.BigInteger;
import java.util.Random;

public class PrimeNumberGeneratorWithBigIntImpl {

    /**
     * Generates a large prime number
     * @return BigInteger that is a prime
     */
    public static BigIntegerImpl generateLargePrime(int bitLength) {
        return generatePrime(bitLength);
    }

    /**
     * Generates a prime number with a specified length with Miller-Rabin primality test
     * @param bitLength
     * @return a BigInteger that should be a prime
     */
    private static BigIntegerImpl generatePrime(int bitLength) {
        //TODO Implement BigInteger
        BigIntegerImpl prime = new BigIntegerImpl(bitLength, new Random());
        while (true) {
            if (!millerRabinPrimality(prime, 4)) {
                prime = prime.add(new BigIntegerImpl("1"));
                continue;
            } else {
                return prime;
            }
        }
    }

    /**
     * Miller-Rabin test for primality
     * @param possiblePrime
     * @param iterations
     * @return boolean isPrime
     */
    public static boolean millerRabinPrimality(BigIntegerImpl possiblePrime, int iterations) {
        BigIntegerImpl one = new BigIntegerImpl("1");
        BigIntegerImpl two = new BigIntegerImpl("2");
        BigIntegerImpl three = new BigIntegerImpl("3");
        BigIntegerImpl four = new BigIntegerImpl("4");
        if (possiblePrime.compareTo(one) <= 0 || possiblePrime.compareTo(four) == 0 || possiblePrime.compareTo(three) <= 0) {
            return false;
        }
        BigIntegerImpl d = possiblePrime.subtract(one);
        while (d.mod(two).equals(BigInteger.ZERO)) {
            d = d.shiftRight(1);
        }
        for (int i = 0; i < iterations; i++) {
            if (millerRabinTest(d, possiblePrime)) {
                return true;
            }
        }
        return false;
    }

    private static boolean millerRabinTest(BigIntegerImpl d, BigIntegerImpl n) {
        BigIntegerImpl one = new BigIntegerImpl("1");
        BigIntegerImpl a = new BigIntegerImpl(211, new Random());
        BigIntegerImpl x = a.modPow(d, n);
        if (x.compareTo(one) == 0 || x.compareTo(n.subtract(one)) == 0) {
            return true;
        }
        while (d.compareTo(n.subtract(one)) != 0) {
            x = x.multiply(x).mod(n);
            d = d.shiftLeft(1);
            if (x.compareTo(one) == 0) {
                return false;
            }
            if (x.compareTo(n.subtract(one)) == 0) {
                return true;
            }
        }
        return false;
    }


}
