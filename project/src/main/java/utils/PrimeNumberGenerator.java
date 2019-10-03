package utils;


import java.math.BigInteger;
import java.util.Random;

public class PrimeNumberGenerator {

    /**
     * Generates a large prime number
     * @return BigInteger that is a prime
     */
    public static BigInteger generateLargePrime(int bitLength) {
        return generatePrime(bitLength);
    }

    /**
     * Generates a prime number with a specified length with Miller-Rabin primality test
     * @param bitLength
     * @return a BigInteger that should be a prime
     */
    private static BigInteger generatePrime(int bitLength) {
        //TODO Implement BigInteger
        BigInteger prime = new BigInteger(bitLength, 2, new Random());
        boolean isPrime = true;
        while (true) {
            if (!isPrime) {
                prime = prime.add(BigInteger.valueOf(2));
            }
            if (!millerRabinPrimality(prime, 4)) {
                isPrime = false;
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
    public static boolean millerRabinPrimality(BigInteger possiblePrime, int iterations) {
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        BigInteger four = new BigInteger("4");
        if (possiblePrime.compareTo(BigInteger.ONE) <= 0 || possiblePrime.compareTo(four) == 0 || possiblePrime.compareTo(three) <= 0) {
            return false;
        }
        BigInteger d = possiblePrime.subtract(BigInteger.ONE);
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

    private static boolean millerRabinTest(BigInteger d, BigInteger n) {
        BigInteger a = new BigInteger(n.bitLength(), 2, new Random());
        BigInteger x = a.modPow(d, n);
        if (x.compareTo(BigInteger.ONE) == 0 || x.compareTo(n.subtract(BigInteger.ONE)) == 0) {
            return true;
        }
        while (d.compareTo(n.subtract(BigInteger.ONE)) != 0) {
            x = x.multiply(x).mod(n);
            d = d.shiftLeft(1);
            if (x.compareTo(BigInteger.ONE) == 0) {
                return false;
            }
            if (x.compareTo(n.subtract(BigInteger.ONE)) == 0) {
                return true;
            }
        }
        return false;
    }


}
