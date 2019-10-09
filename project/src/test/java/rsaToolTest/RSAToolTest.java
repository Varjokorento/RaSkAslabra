package rsatooltest;

import org.junit.Before;
import org.junit.Test;
import rsatool.RSATool;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;


public class RSAToolTest {



    private static final String testString = "testString";

    private RSATool rsaTool;


    @Before
    public void setUp() {
        this.rsaTool = new RSATool();
        rsaTool.generateKeys(100);
    }

    @Test
    public void rsaToolEncryptsAndDecryptsAGivenString() {
        BigInteger[] array = rsaTool.encrypt(testString);
        BigInteger[] decrypted = rsaTool.decrypt(array);
        assertEquals(testString, rsaTool.cipherToString(decrypted));
    }





}
