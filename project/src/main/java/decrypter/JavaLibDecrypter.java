package decrypter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class JavaLibDecrypter {


    /**
     * LIBRARY IMPLEMENTATION
     * Decrypts a given byteArray with given public key
     *
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
