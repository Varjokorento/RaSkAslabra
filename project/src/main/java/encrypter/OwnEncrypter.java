package encrypter;

import keys.keyimpl.OwnPublicKey;
import utils.OwnBigInteger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

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
            encrypted[i] = array[i].mulPow(publicKey.getE(), publicKey.getN());
        }
        return encrypted;
    }



}
