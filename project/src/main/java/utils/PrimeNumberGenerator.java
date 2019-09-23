package utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
        //TODO make own implementation of arrays fill
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        //TODO Make own implementation of LinkedList
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }

        Integer bigPrime = primeNumbers.get(primeNumbers.size() - 1);
        BigInteger retVal = BigInteger.valueOf(bigPrime);
        return retVal;
    }



}
