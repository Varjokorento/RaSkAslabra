package asciiutiltest;

import utils.BigIntegerImpl;
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
        BigIntegerImpl[] abc = asciiUtil.stringToCipher("abc");
        BigInteger[] asciiValues = new BigInteger[]{new BigInteger("97"), new BigInteger("98"), new BigInteger("99")};
        for(int i = 0; i < abc.length; i++) {
            assertEquals(asciiValues[i], abc[i]);
        }
    }

    @Test
    public void cipherToStringWorksCorrectly() {
        BigIntegerImpl[] asciiValues = new BigIntegerImpl[]{new BigIntegerImpl("97"), new BigIntegerImpl("98"), new BigIntegerImpl("99")};
        assertEquals("abc",  asciiUtil.cipherToString(asciiValues));
    }


}
