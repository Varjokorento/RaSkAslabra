package keys;


import keys.keyimpl.OwnKeyPair;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;
import utils.PrimeNumberGenerator;

import java.util.Random;

public class OwnKeyPairGenerator {

    /**
     * Generates two keys: Public key with e and n and a Private key with d.
     *
     * @return OwnKeyPair that holds both keys
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
     * Finds n from large prime numbers
     *
     * @param p a large prime number
     * @param q a large prime number
     * @return n
     */

    private OwnBigInteger findN(OwnBigInteger p, OwnBigInteger q) {
        return p.multiply(q);
    }


    /**
     * Compute phi(pq) (Euler's totient function)
     * phi(pq) = (p-1)(q-1)
     *
     * @return phi
     */
    private OwnBigInteger getPhi(OwnBigInteger p, OwnBigInteger q) {
        return (p.subtract(OwnBigInteger.ONE)).multiply(q.subtract(OwnBigInteger.ONE));
    }

    /**
     * Generate E so that E != 1, e >= 0 and gcd(phi, e) == 1.
     *
     * @param phi phi
     * @return e
     */
    static OwnBigInteger genE(OwnBigInteger phi) {
        OwnBigInteger e = OwnBigInteger.getLargeRandom();

        while (e.compareTo(OwnBigInteger.ONE) <= 0
                || e.compareTo(phi) >= 0
                || !gcd(phi, e).equals(OwnBigInteger.ONE)) {
            e = OwnBigInteger.getLargeRandom();
        }
        return e;
    }

    /**
     * Recursively returns greatest common denominator between two numbers
     * @param a number a
     * @param b number b
     * @return gcd(a, b)
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
     * INV(m,n) = ((1 + n(m - INV(MOD(n,m),m)))/m
     * @param m number m
     * @param n number n
     * @return INV(m, n)
     */
    static OwnBigInteger extendedEuclid(OwnBigInteger m, OwnBigInteger n) {
        // for the formula to work 0 < m < n
        if (m.compareTo(n) > 0) {
            OwnBigInteger store = n;
            n = m;
            m = store;
        }
        if (m.compareTo(OwnBigInteger.ONE) == 0) {
            return OwnBigInteger.ONE;
        }
        OwnBigInteger d = OwnBigInteger.ONE.add(n.multiply(m.subtract(extendedEuclid(n.mod(m), m)))).divide(m);
        return d;
    }
}
