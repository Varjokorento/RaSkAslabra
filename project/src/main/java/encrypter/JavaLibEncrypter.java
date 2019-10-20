package encrypter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public class JavaLibEncrypter {


    /**
     * Encrypts a given byteArray with given privateKey
     *
     * @return encrypted byteArray
     */
    public byte[] encrypt(String plainText, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] ciphered = cipher.doFinal(plainText.getBytes());
        return ciphered;
    }
}
