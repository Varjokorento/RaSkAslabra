package encrypter;

import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Encrypter {

    /**
     * Encrypts a given BigInteger-array with
     * @param array
     * @param publicKey
     * @return encrypted BigInteger-array
     */
    public BigInteger[] encrypt(BigInteger[] array, PublicKeyImpl publicKey) {
        BigInteger[] encrypted = new BigInteger[array.length];
        for (int i = 0; i < array.length; i++) {
            encrypted[i] = array[i].modPow(publicKey.getE(), publicKey.getN());
        }
        return encrypted;
    }

    /**
     * Encrypts a given byteArray with given privateKey
     * @return encrypted byteArray
     */
    public byte[] encrypt(String plainText, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] ciphered = cipher.doFinal(plainText.getBytes());
        return ciphered;
    }
}
