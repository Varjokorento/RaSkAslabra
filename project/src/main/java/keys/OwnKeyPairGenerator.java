package keys;


import keys.keyimpl.OwnKeyPair;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import utils.BigIntegerImpl;
import utils.PrimeNumberGenerator;
import utils.PrimeNumberGeneratorWithBigInt;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class OwnKeyPairGenerator {

    /**
     * Generates two public keys e,n and d.
     * @return
     */

    public OwnKeyPair generateKeyPair(int bitLength) {
        BigIntegerImpl p = PrimeNumberGeneratorWithBigInt.generateLargePrime(bitLength);
        BigIntegerImpl q = PrimeNumberGeneratorWithBigInt.generateLargePrime(bitLength);
        BigIntegerImpl n = findN(p, q);
        BigIntegerImpl phi = getPhi(p, q);
        BigIntegerImpl e = genE(phi);
        BigIntegerImpl d = extEuclid(e, phi)[1];
        return new OwnKeyPair(new OwnPublicKey(e, n), new OwnPrivateKey(d));
    }

    /**
     * Find mod n from large prime numbers
     * @param p a large prime number
     * @param q a large prime number
     * @return mod n
     */

    private BigIntegerImpl findN(BigIntegerImpl p, BigIntegerImpl q) {
        return p.multiply(q);
    }


    /** Compute phi(n) (Euler's totient function)
     * (Modern version uses Carmichael totient function.)
     *  phi(n) = (p-1)(q-1)
     * @return phi
     */
    private BigIntegerImpl getPhi(BigIntegerImpl p, BigIntegerImpl q) {
        return (p.subtract(BigIntegerImpl.ONE)).multiply(q.subtract(BigIntegerImpl.ONE));
    }

    /**
     * Generate e by finding a Phi such that the greatest common denominator is one
     * @param phi
     * @return
     */

    static BigIntegerImpl genE(BigIntegerImpl phi) {
        Random rand = new SecureRandom();
        BigIntegerImpl e;
        do {
            e = new BigIntegerImpl(100, rand);
        }
        while (e.compareTo(BigIntegerImpl.ONE) <= 0
                    || e.compareTo(phi) >= 0
                    || !greatestCommonDenominator(phi, e).equals(BigIntegerImpl.ONE));
        return e;
    }

    static BigIntegerImpl greatestCommonDenominator(BigIntegerImpl a, BigIntegerImpl b) {
        if (b.equals(BigIntegerImpl.ZERO)) {
            return a;
        } else {
            return greatestCommonDenominator(b, a.mod(b));
        }
    }

    /** Extended Euclidean algorithm to solve Bezout's identity (ax + by = gcd(a,b))
     * and finds the multiplicative inverse which is the solution to ax ≡ 1 (mod m)
     * @return [d, p, q] where d = gcd(a,b) and ap + bq = d
     */

    static BigIntegerImpl[] extEuclid(BigIntegerImpl a, BigIntegerImpl b) {
        if (b.equals(BigIntegerImpl.ZERO)) {
            return new BigIntegerImpl[] {a, BigIntegerImpl.ONE, BigIntegerImpl.ZERO};
        }
        BigIntegerImpl[] values = extEuclid(b, a.mod(b));
        BigIntegerImpl d = values[0];
        BigIntegerImpl p = values[2];
        BigIntegerImpl q = values[1].subtract(a.divide(b).multiply(values[2]));
        return new BigIntegerImpl[] {d, p, q};
    }
}
