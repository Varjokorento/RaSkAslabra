package utils;

import javaLibImplementations.ArraysImpl;
import javaLibImplementations.LinkedListImpl;

import java.math.BigInteger;
import java.util.Random;

public class PrimeNumberGenerator {

    /**
     * Generates a large prime number
     * @return BigIntegerThatIsPrime
     */

    public static BigInteger generateLargePrime() {
        Random random = new Random();
        int randomInteger = random.nextInt(10000000);
        return sieveOfEratosthenes(randomInteger);
    }

    /**
     * Generates a large prime from int n using sieve of eratosthenes algorithm
     *  O(n log n).
     * @param n
     * @return BigInteger
     */
    private static BigInteger sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];

        ArraysImpl.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        LinkedListImpl primeNumbers = new LinkedListImpl();
        int latestPrime = 3;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                latestPrime = i;
            }
        }
        // this is actually an unnecessary operation and only done to try out linkedListImplementation
        primeNumbers.insert(latestPrime);
        Integer bigPrime = primeNumbers.getLast();
        BigInteger retVal = BigInteger.valueOf(bigPrime);
        return retVal;
    }



}
