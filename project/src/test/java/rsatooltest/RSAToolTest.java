package rsatooltest;

import org.junit.Before;
import org.junit.Test;
import rsatool.RSATool;
import utils.OwnBigInteger;

import static org.junit.Assert.assertEquals;


public class RSAToolTest {


    private static final String testString = "testString";

    private RSATool rsaTool;


    @Before
    public void setUp() {
        this.rsaTool = new RSATool();
        rsaTool.generateKeys();
    }

    @Test
    public void rsaToolEncryptsAndDecryptsAGivenString() {
        OwnBigInteger[] array = rsaTool.encrypt(testString);
        OwnBigInteger[] decrypted = rsaTool.decrypt(array);
        assertEquals(testString, rsaTool.cipherToString(decrypted));
    }


}
