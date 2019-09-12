package decrypterTest;

import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyUtil;
import org.junit.Test;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.assertEquals;


public class DecrypterTest {


    private Decrypter decrypter = new Decrypter();
    private Encrypter encrypter = new Encrypter();



    @Test
    public void decryptedStringIsDecryptedCorrectly() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        PublicKey publicKey = KeyUtil.readPublicKeyFile("src/test/resources/publicKey.pub");
        PrivateKey privateKey = KeyUtil.readPrivateKeyFile("src/test/resources/privateKey.key");
        byte[] encryptedByteArray = encrypter.encrypt("TestString", privateKey);
        byte[] decryptedStringArray= decrypter.decrypt(encryptedByteArray, publicKey);
        assertEquals("TestString", new String(decryptedStringArray));
    }
}
