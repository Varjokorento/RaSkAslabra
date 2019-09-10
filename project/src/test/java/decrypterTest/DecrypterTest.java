package decrypterTest;

import decrypter.Decrypter;
import encrypter.Encrypter;
import keyGenerators.KeyUtil;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecrypterTest {


    private Decrypter decrypter = new Decrypter();
    private Encrypter encrypter = new Encrypter();



    @Test
    public void decryptedStringIsDecryptedCorrectly() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        PublicKey publicKey = KeyUtil.readPublicKeyFile("src/test/resources/publicKey.pub");
        PrivateKey privateKey = KeyUtil.readPrivateKeyFile("src/test/resources/privateKey.key");

        //byte[] decryptedStringArray = decrypter.decrypt(encryptedText.getBytes(), publicKey);
        String fileName = "encryptedText.txt";

      /*  BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(new String(encrypter.encrypt("testString", privateKey), StandardCharsets.UTF_8));
        writer.close();*/
        byte[] encryptedByteArray = encrypter.encrypt("TestString", privateKey);
        Files.write(new File("src/test/resources/encryptedText").toPath(), encryptedByteArray);
        byte[] encryptedBytes= IOUtils.toByteArray(new FileReader("src/test/resources/encryptedText"));
        byte[] decryptedStringArray= decrypter.decrypt(encryptedByteArray, publicKey);

        assertEquals("TestString", new String(decryptedStringArray));
    }
}
