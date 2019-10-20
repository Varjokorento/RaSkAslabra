package keys;


import keys.keyimpl.OwnKeyPair;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;
import utils.PrimeNumberGeneratorWithBigInt;

import java.util.Random;

public class OwnKeyPairGenerator {

    /**
     * Generates two public keys e,n and d.
     *
     * @return
     */

    public OwnKeyPair generateKeyPair() {
        OwnBigInteger p = PrimeNumberGeneratorWithBigInt.generateLargePrime();
        OwnBigInteger q = PrimeNumberGeneratorWithBigInt.generateLargePrime();
        OwnBigInteger n = findN(p, q);
        OwnBigInteger phi = getPhi(p, q);
        OwnBigInteger e = genE(phi);
        OwnBigInteger[] array = extEuclid(e, phi);
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
     * Extended Euclidean algorithm to solve Bezout's identity (ax + by = gcd(a,b))
     * and finds the multiplicative inverse which is the solution to ax ≡ 1 (mod m)
     *
     * @return [d, p, q] where d = gcd(a,b) and ap + bq = d
     */

    static OwnBigInteger[] extEuclid(OwnBigInteger p, OwnBigInteger q) {
        if (q.compareTo(OwnBigInteger.ZERO) == 0)
            return new OwnBigInteger[]{p, OwnBigInteger.ONE, OwnBigInteger.ZERO};
        OwnBigInteger[] vals = extEuclid(q, p.mod(q));
        OwnBigInteger d = vals[0];
        OwnBigInteger a = vals[2];
        OwnBigInteger subtractor = (p.divide(q)).multiply(vals[2]);
        OwnBigInteger b = vals[1].subtract(subtractor);
        return new OwnBigInteger[]{d, a, b};
    }

    static OwnBigInteger extendedEuclid(OwnBigInteger e, OwnBigInteger phi) {
        if (e.compareTo(phi) > 0) {
            OwnBigInteger a = phi;
            phi = e;
            e = a;
        }
        if (e.compareTo(OwnBigInteger.ONE) == 0) {
            return OwnBigInteger.ONE;
        }
        OwnBigInteger d = OwnBigInteger.ONE.add(phi.multiply(e.subtract(extendedEuclid(phi.mod(e), e)))).divide(e);
        return d;
    }
}
