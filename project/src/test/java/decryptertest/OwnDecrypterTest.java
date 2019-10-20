package decryptertest;

import decrypter.OwnDecrypter;
import encrypter.OwnEncrypter;
import keys.keyimpl.OwnPrivateKey;
import keys.keyimpl.OwnPublicKey;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import utils.OwnBigInteger;


import static org.junit.Assert.assertEquals;


public class OwnDecrypterTest {


    private OwnDecrypter decrypter = new OwnDecrypter();
    private OwnEncrypter ownEncrypter = new OwnEncrypter();

    @Test
    public void encryptedStringIsDecryptedCorrectlyWithImplementation() {
        OwnPublicKey publicKey = new OwnPublicKey(new OwnBigInteger("19"), new OwnBigInteger("1333"));
        OwnPrivateKey privateKey = new OwnPrivateKey(new OwnBigInteger("199"));
        OwnBigInteger[] encryptedArray = {new OwnBigInteger("97"),
                new OwnBigInteger("98"),
                new OwnBigInteger("99")};
        encryptedArray = ownEncrypter.encrypt(encryptedArray, publicKey);
        OwnBigInteger[] decrypted = decrypter.decrypt(encryptedArray, privateKey, publicKey);
        Assertions.assertEquals(new OwnBigInteger("97").valueOf(), decrypted[0].valueOf());
        Assertions.assertEquals(new OwnBigInteger("98").valueOf(), decrypted[1].valueOf());
        Assertions.assertEquals(new OwnBigInteger("99").valueOf(), decrypted[2].valueOf());
    }
}
