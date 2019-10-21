package encrypter;

import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;

public class OwnEncrypter {

    /**
     * OWN IMPLEMENTATION
     * Encrypts a given BigInteger-array with
     *
     * @param array
     * @param publicKey
     * @return encrypted BigInteger-array
     */
    public OwnBigInteger[] encrypt(OwnBigInteger[] array, OwnPublicKey publicKey) {
        OwnBigInteger[] encrypted = new OwnBigInteger[array.length];
        for (int i = 0; i < array.length; i++) {
            encrypted[i] = array[i].modPow(publicKey.getE(), publicKey.getN());
        }
        return encrypted;
    }



}
