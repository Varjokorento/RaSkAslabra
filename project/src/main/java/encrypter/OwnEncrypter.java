package encrypter;

import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;

public class OwnEncrypter {

    /**
     * Encrypts a given OwnBigInteger-array with publicKey
     * @param array array to be encrypted
     * @param publicKey publicKey to encrypt with
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
