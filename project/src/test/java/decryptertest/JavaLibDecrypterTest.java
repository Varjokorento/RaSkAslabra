package decryptertest;

import decrypter.JavaLibDecrypter;
import encrypter.JavaLibEncrypter;
import keys.JavaLibKeyUtil;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.assertEquals;

public class JavaLibDecrypterTest {

    private JavaLibEncrypter encrypter = new JavaLibEncrypter();
    private JavaLibDecrypter decrypter = new JavaLibDecrypter();

    @Test
    public void decryptedStringIsDecryptedCorrectlyWithLibraries() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        PublicKey publicKey = JavaLibKeyUtil.readPublicKeyFile("src/test/resources/publicKey.pub");
        PrivateKey privateKey = JavaLibKeyUtil.readPrivateKeyFile("src/test/resources/privateKey.key");
        byte[] encryptedByteArray = encrypter.encrypt("TestString", privateKey);
        byte[] decryptedStringArray = decrypter.decrypt(encryptedByteArray, publicKey);
        assertEquals("TestString", new String(decryptedStringArray));
    }
}
