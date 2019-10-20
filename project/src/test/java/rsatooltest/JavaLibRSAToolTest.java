package rsatooltest;

import org.junit.Before;
import org.junit.Test;
import rsatool.JavaLibRSATool;
import rsatool.RSATool;
import utils.OwnBigInteger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class JavaLibRSAToolTest {

    private static final String testString = "testString";

    private JavaLibRSATool rsaTool;


    @Before
    public void setUp() throws NoSuchAlgorithmException {
        this.rsaTool = new JavaLibRSATool();
        rsaTool.generateKeysWithLibraries();
    }

    @Test
    public void rsaToolEncryptsAndDecryptsAGivenString() throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        byte[] array = rsaTool.encryptWithLibraries(testString);
        String decrypted = rsaTool.decryptWithLibraries(array);
        assertEquals(testString, decrypted);
    }
}
