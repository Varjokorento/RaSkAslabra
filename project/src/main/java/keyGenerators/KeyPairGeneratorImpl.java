package keygenerators;


import utils.RandomImpl;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KeyPairGeneratorImpl {

    public KeyPairImpl generateKeyPair(int keySize) {
        BigInteger p = generateLargePrime();
        BigInteger q = generateLargePrime();
        return new KeyPairImpl(new PublicKeyImpl(p), new PrivateKeyImpl(q));
    }

    public BigInteger generateLargePrime() {
        int randomInteger = RandomImpl.generateRandomInteger();
        BigInteger largePrime = sieveOfEratosthenes(randomInteger);
        return largePrime;
    }

    /**
     * Generates a large prime from int n using sieve of eratosthenes algorithm
     *  O(n log n).
     * @param n
     * @return BigInteger
     */
    private BigInteger sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        Integer bigPrime = primeNumbers.get(primeNumbers.size()-1);
        return BigInteger.valueOf(bigPrime.intValue());
    }
}
