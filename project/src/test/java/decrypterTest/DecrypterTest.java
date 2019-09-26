package decrypterTest;

import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyUtil;
import keyimpl.PrivateKeyImpl;
import keyimpl.PublicKeyImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.math.BigInteger;
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
    public void decryptedStringIsDecryptedCorrectlyWithLibraries() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        PublicKey publicKey = KeyUtil.readPublicKeyFile("src/test/resources/publicKey.pub");
        PrivateKey privateKey = KeyUtil.readPrivateKeyFile("src/test/resources/privateKey.key");
        byte[] encryptedByteArray = encrypter.encrypt("TestString", privateKey);
        byte[] decryptedStringArray= decrypter.decrypt(encryptedByteArray, publicKey);
        assertEquals("TestString", new String(decryptedStringArray));
    }

    @Test
    public void encryptedStringIsDecryptedCorrectlyWithImplementation() {
        PublicKeyImpl publicKey = new PublicKeyImpl(new BigInteger("10400312739031"), new BigInteger("21423684981763"));
        PrivateKeyImpl privateKey = new PrivateKeyImpl(new BigInteger("4860493505831"));
        BigInteger[] encryptedByteArray = {new BigInteger("3547036742032"),
                new BigInteger("7533585362812"),
                new BigInteger("10644284804799") };
        BigInteger[] decrypted = decrypter.decrypt(encryptedByteArray, privateKey, publicKey);
        Assertions.assertEquals(new BigInteger("97"), decrypted[0]);
        Assertions.assertEquals(new BigInteger("98"), decrypted[1]);
        Assertions.assertEquals(new BigInteger("99"), decrypted[2]);

    }
}
