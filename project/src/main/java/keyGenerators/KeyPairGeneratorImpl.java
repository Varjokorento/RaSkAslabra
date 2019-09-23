package keygenerators;


import keyimpl.KeyPairImpl;
import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;
import utils.PrimeNumberGenerator;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class KeyPairGeneratorImpl {

    /**
     * Generates two public keys e,n and d.
     * @return
     */

    public KeyPairImpl generateKeyPair() {
        BigInteger p = PrimeNumberGenerator.generateLargePrime();
        BigInteger q = PrimeNumberGenerator.generateLargePrime();
        BigInteger n = findN(p, q);
        BigInteger phi = getPhi(p, q);
        BigInteger e = genE(phi);
        BigInteger d = extEuclid(e, phi)[1];
        return new KeyPairImpl(new PublicKeyImpl(e, n), new PrivateKeyImpl(d));
    }

    /**
     * Find mod n from large prime numbers
     * @param p a large prime number
     * @param q a large prime number
     * @return mod n
     */

    private BigInteger findN(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }


    /** Compute phi(n) (Euler's totient function)
     * (Modern version uses Carmichael totient function.)
     *  phi(n) = (p-1)(q-1)
     * @return phi
     */
    private BigInteger getPhi(BigInteger p, BigInteger q) {
        return (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    }

    /**
     * Generate e by finding a Phi such that the greatest common denominator is one
     * @param phi
     * @return
     */

    static BigInteger genE(BigInteger phi) {
        Random rand = new SecureRandom();
        BigInteger e;
        do {
            e = new BigInteger(phi.bitLength(), rand);
        }
        while (e.compareTo(BigInteger.ONE) <= 0
                    || e.compareTo(phi) >= 0
                    || !greatestCommonDenominator(phi, e).equals(BigInteger.ONE));
        return e;
    }

    static BigInteger greatestCommonDenominator(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        } else {
            return greatestCommonDenominator(b, a.mod(b));
        }
    }

    /** Extended Euclidean algorithm to solve Bezout's identity (ax + by = gcd(a,b))
     * and finds the multiplicative inverse which is the solution to ax ≡ 1 (mod m)
     * @return [d, p, q] where d = gcd(a,b) and ap + bq = d
     */

    static BigInteger[] extEuclid(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[] {a, BigInteger.ONE, BigInteger.ZERO};
        }
        BigInteger[] values = extEuclid(b, a.mod(b));
        BigInteger d = values[0];
        BigInteger p = values[2];
        BigInteger q = values[1].subtract(a.divide(b).multiply(values[2]));
        return new BigInteger[] {d, p, q};
    }
}
