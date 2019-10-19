package decryptertest;

import decrypter.Decrypter;
import encrypter.Encrypter;
import keys.KeyUtil;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import utils.BigIntegerImpl;


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
        OwnPublicKey publicKey = new OwnPublicKey(new BigIntegerImpl("10400312739031"), new BigIntegerImpl("21423684981763"));
        OwnPrivateKey privateKey = new OwnPrivateKey(new BigIntegerImpl("4860493505831"));
        BigIntegerImpl[] encryptedByteArray = {new BigIntegerImpl("3547036742032"),
                new BigIntegerImpl("7533585362812"),
                new BigIntegerImpl("10644284804799") };
        BigIntegerImpl[] decrypted = decrypter.decrypt(encryptedByteArray, privateKey, publicKey);
        Assertions.assertEquals(new BigInteger("97"), decrypted[0]);
        Assertions.assertEquals(new BigInteger("98"), decrypted[1]);
        Assertions.assertEquals(new BigInteger("99"), decrypted[2]);

    }
}
