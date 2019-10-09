package asciiutiltest;

import utils.asciiutil.AsciiUtil;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsciiUtilTest {

    private AsciiUtil asciiUtil = new AsciiUtil();

    @Test
    public void asciiUtilReturnsCorrectStringForByteArray() {
        String testString = "String";
        byte[] byteArray = testString.getBytes();
        assertEquals(testString, asciiUtil.getStringFromByteArray(byteArray));
    }

    @Test
    public void stringToCipherWorksCorrectly() {
        BigInteger[] abc = asciiUtil.stringToCipher("abc");
        BigInteger[] asciiValues = new BigInteger[]{new BigInteger("97"), new BigInteger("98"), new BigInteger("99")};
        for(int i = 0; i < abc.length; i++) {
            assertEquals(asciiValues[i], abc[i]);
        }
    }

    @Test
    public void cipherToStringWorksCorrectly() {
        BigInteger[] asciiValues = new BigInteger[]{new BigInteger("97"), new BigInteger("98"), new BigInteger("99")};
        assertEquals("abc",  asciiUtil.cipherToString(asciiValues));
    }


}
