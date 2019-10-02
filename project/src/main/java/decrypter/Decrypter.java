package decrypter;

import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Decrypter {
    /**
     * OWN IMPLEMENTATION
     * @param array
     * @param privateKey
     * @param publicKey
     * @return
     */
    public BigInteger[] decrypt(BigInteger[] array, PrivateKeyImpl privateKey, PublicKeyImpl publicKey) {
        BigInteger[] decrypted = new BigInteger[array.length];
        for (int i = 0; i < array.length; i++) {
            decrypted[i] = array[i].modPow(privateKey.getPrivateKey(), publicKey.getN());
        }
        return decrypted;
    }

    /**
     * LIBRARY IMPLEMENTATION
     * Decrypts a given byteArray with given public key
     * @return decrypted byteArray
     */

    public byte[] decrypt(byte[] cyphered, PublicKey publicKey) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decipheredText = cipher.doFinal(cyphered);
        return decipheredText;
    }
}
