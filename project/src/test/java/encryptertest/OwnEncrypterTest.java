package encryptertest;

import encrypter.OwnEncrypter;
import keys.keyimpl.OwnPublicKey;
import org.junit.Test;
import utils.OwnBigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnEncrypterTest {

    private OwnEncrypter ownEncrypter = new OwnEncrypter();


    @Test
    public void encrypterEncryptsCorrectlyWithoutLibraries() {
        OwnPublicKey publicKey = new OwnPublicKey(new OwnBigInteger("19"), new OwnBigInteger("1333"));
        OwnBigInteger[] bigIntArray = {new OwnBigInteger("97"), new OwnBigInteger("98"), new OwnBigInteger("99")};
        OwnBigInteger[] encrypted = ownEncrypter.encrypt(bigIntArray, publicKey);
        assertEquals(new OwnBigInteger("876").valueOf(), encrypted[0].valueOf());
        assertEquals(new OwnBigInteger("966").valueOf(), encrypted[1].valueOf());
        assertEquals(new OwnBigInteger("874").valueOf(), encrypted[2].valueOf());
    }

}
