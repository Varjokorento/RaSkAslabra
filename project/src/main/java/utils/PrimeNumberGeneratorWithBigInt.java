package utils;


import java.math.BigInteger;
import java.util.Random;

public class PrimeNumberGeneratorWithBigInt {

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
       // BigIntegerImpl prime = new BigIntegerImpl(bitLength, new Random());
        BigIntegerImpl prime = new BigIntegerImpl("8");
        while (true) {
            if (!millerRabinPrimality(prime, 2)) {
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
        if (possiblePrime.compareTo(one) <= 0 || possiblePrime.compareTo(four) == 0) {
            return false;
        }
        if (possiblePrime.compareTo(three) <= 0) {
            return true;
        }
        BigIntegerImpl d = possiblePrime.subtract(one);
        while (d.mod(two).equals(new BigIntegerImpl("0"))) {
            d = d.divide(new BigIntegerImpl("2"));
        }
        for (int i = 0; i < iterations; i++) {
            if (millerRabinTest(d, possiblePrime)) {
                return true;
            }
        }
        return false;
    }



    private static long modPower(long x, long exponent, long modulo) {
         long res = 1L;
         x = x % modulo;
         while (exponent > 0) {
             if ((exponent & 1) == 1) {
                 res = (res * x) % modulo;
             }
             exponent = exponent >> 1;
             x = (x * x) % modulo;
         }
         return res;
    }

    private static boolean millerRabinTestWithLongs(BigIntegerImpl d, BigIntegerImpl n) {
        long dL = Long.valueOf(d.valueOf());
        long nL = Long.valueOf(n.valueOf());
        Random random = new Random();
        long randomL = random.nextLong();
        randomL = 20;
        long a =  2 + (randomL % (nL-4));
        long x = modPower(a, dL, nL);
        if (x == 1 || x == nL -1 ) {
            return true;
        }
        while (dL != nL-1) {
            x = (x * x) % nL;
            dL *= 2;
            if (x == 1) {
                return false;
            }
            if (x == nL - 1) {
                return true;
            }
        }
        return false;

    }

    private static BigIntegerImpl generateA(BigIntegerImpl n) {
        BigIntegerImpl random = new BigIntegerImpl(211, new Random());
        random = new BigIntegerImpl("20");
        BigIntegerImpl two = new BigIntegerImpl("2");
        BigIntegerImpl nSubtracted = n.subtract(new BigIntegerImpl("4"));
        BigIntegerImpl moddedRandom = random.mod(nSubtracted);
        BigIntegerImpl a = new BigIntegerImpl("2").add(moddedRandom);
        return a;
    }

    private static boolean millerRabinTest(BigIntegerImpl d, BigIntegerImpl n) {
        BigIntegerImpl one = new BigIntegerImpl("1");
        BigIntegerImpl a = generateA(n);
        BigIntegerImpl x = a.modPow(n, d);
        BigIntegerImpl y = new BigIntegerImpl("0");
        if (x.compareTo(one) == 0 || x.compareTo(n.subtract(one)) == 0) {
            return true;
        }
        while (d.compareTo(n.subtract(one)) != 0) {
            x = (x.multiply(x)).mod(n);
            d = d.multiply(new BigIntegerImpl("2"));
            if (x.compareTo(new BigIntegerImpl("1"))  == 0) {
                return false;
            }
            if (x.compareTo(n.subtract(one)) == 0) {
                return true;
            }
        }
        return false;
    }


}
