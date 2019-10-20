package keys;


import keys.keyimpl.OwnKeyPair;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;
import utils.PrimeNumberGenerator;

import java.util.Random;

public class OwnKeyPairGenerator {

    /**
     * Generates two public keys e,n and d.
     *
     * @return
     */

    public OwnKeyPair generateKeyPair() {
        OwnBigInteger p = PrimeNumberGenerator.generateLargePrime();
        OwnBigInteger q = PrimeNumberGenerator.generateLargePrime();
        OwnBigInteger n = findN(p, q);
        OwnBigInteger phi = getPhi(p, q);
        OwnBigInteger e = genE(phi);
        OwnBigInteger d = extendedEuclid(e, phi);
        return new OwnKeyPair(new OwnPublicKey(e, n), new OwnPrivateKey(d));
    }

    /**
     * Find mod n from large prime numbers
     *
     * @param p a large prime number
     * @param q a large prime number
     * @return mod n
     */

    private OwnBigInteger findN(OwnBigInteger p, OwnBigInteger q) {
        return p.multiply(q);
    }


    /**
     * Compute phi(n) (Euler's totient function)
     * (Modern version uses Carmichael totient function.)
     * phi(n) = (p-1)(q-1)
     *
     * @return phi
     */
    private OwnBigInteger getPhi(OwnBigInteger p, OwnBigInteger q) {
        return (p.subtract(OwnBigInteger.ONE)).multiply(q.subtract(OwnBigInteger.ONE));
    }

    /**
     * Generate e by finding a Phi such that the greatest common denominator is one
     *
     * @param phi
     * @return e
     */
    static OwnBigInteger genE(OwnBigInteger phi) {
        OwnBigInteger e;
        do {
            e = new OwnBigInteger(new Random());
        }
        while (e.compareTo(OwnBigInteger.ONE) <= 0
                || e.compareTo(phi) >= 0
                || !gcd(phi, e).equals(OwnBigInteger.ONE));
        return e;
    }

    /**
     * Recursively Returns greatest common denominator between two numbers
     * @param a
     * @param b
     * @return gcd(a,b)
     */

    static OwnBigInteger gcd(OwnBigInteger a, OwnBigInteger b) {
        if (b.equals(OwnBigInteger.ZERO)) {
            return a;
        } else {
            return gcd(b, a.mod(b));
        }
    }

    /**
     * Extended Euclidean algorithm to solve Bezout's identity INV(m,n)
     * and finds the multiplicative inverse which is the solution to ax ≡ 1 (mod m)
     * Read (https://fi.wikipedia.org/wiki/Modulaariaritmetiikan_käänteisluku) (in Finnish)
     * @return INV(m,n)
     */
    static OwnBigInteger extendedEuclid(OwnBigInteger m, OwnBigInteger n) {
        // for the formula to work 0 < m < n
        if (m.compareTo(n) > 0) {
            OwnBigInteger a = n;
            n = m;
            m = a;
        }
        if (m.compareTo(OwnBigInteger.ONE) == 0) {
            return OwnBigInteger.ONE;
        }
        OwnBigInteger d = OwnBigInteger.ONE.add(n.multiply(m.subtract(extendedEuclid(n.mod(m), m)))).divide(m);
        return d;
    }
}
