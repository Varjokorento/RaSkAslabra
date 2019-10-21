package utils;


import java.util.Random;

public class PrimeNumberGenerator {

    /**
     * Generates a large prime number
     *
     * @return BigInteger that is a prime
     */
    public static OwnBigInteger generateLargePrime() {
        return generatePrime();
    }

    /**
     * Generates a prime number with a specified length with Miller-Rabin primality test
     *
     * @return a BigInteger that should be a prime
     */
    private static OwnBigInteger generatePrime() {
        OwnBigInteger prime = OwnBigInteger.getLargeRandom(new Random());
        while (true) {
            if (!millerRabinPrimality(prime, 4)) {
                prime = prime.add(OwnBigInteger.ONE);
                continue;
            } else {
                return prime;
            }
        }
    }

    /**
     * Miller-Rabin test for primality
     *
     * @param possiblePrime
     * @param iterations
     * @return boolean isPrime
     */
    public static boolean millerRabinPrimality(OwnBigInteger possiblePrime, int iterations) {
        OwnBigInteger two = new OwnBigInteger("2");
        OwnBigInteger three = new OwnBigInteger("3");
        OwnBigInteger four = new OwnBigInteger("4");
        if (possiblePrime.compareTo(OwnBigInteger.ONE) <= 0 || possiblePrime.compareTo(four) == 0) {
            return false;
        }
        if (possiblePrime.compareTo(three) <= 0) {
            return true;
        }
        OwnBigInteger d = possiblePrime.subtract(OwnBigInteger.ONE);
        while (d.mod(two).equals(new OwnBigInteger("0"))) {
            d = d.divide(new OwnBigInteger("2"));
        }
        for (int i = 0; i < iterations; i++) {
            if (millerRabinTest(d, possiblePrime)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates A to use in the Miller Rabin test
     * @param n
     * @return a
     */

    private static OwnBigInteger generateA(OwnBigInteger n) {
        OwnBigInteger random = new OwnBigInteger(new Random());
        OwnBigInteger nSubtracted = n.subtract(new OwnBigInteger("4"));
        OwnBigInteger moddedRandom = random.mod(nSubtracted);
        OwnBigInteger a = new OwnBigInteger("2").add(moddedRandom);
        return a;
    }

    /**
     * Tests number n for primality
     * @param d
     * @param n
     * @return boolean isPrime
     */
    private static boolean millerRabinTest(OwnBigInteger d, OwnBigInteger n) {
        OwnBigInteger a = generateA(n);
        OwnBigInteger x = a.mulPow(d, n);
        if (x.compareTo(OwnBigInteger.ONE) == 0 || x.compareTo(n.subtract(OwnBigInteger.ONE)) == 0) {
            return true;
        }
        while (d.compareTo(n.subtract(OwnBigInteger.ONE)) != 0) {
            x = (x.multiply(x)).mod(n);
            d = d.multiply(new OwnBigInteger("2"));
            if (x.compareTo(new OwnBigInteger("1")) == 0) {
                return false;
            }
            if (x.compareTo(n.subtract(OwnBigInteger.ONE)) == 0) {
                return true;
            }
        }
        return false;
    }


}
