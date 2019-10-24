package asciiutiltest;

import utils.OwnBigInteger;
import utils.asciiutil.AsciiUtil;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsciiUtilTest {

    private AsciiUtil asciiUtil = new AsciiUtil();

    @Test
    public void stringToCipherWorksCorrectly() {
        OwnBigInteger[] abc = asciiUtil.stringToCipher("abc");
        OwnBigInteger[] asciiValues = new OwnBigInteger[]{new OwnBigInteger("97"), new OwnBigInteger("98"), new OwnBigInteger("99")};
        for (int i = 0; i < abc.length; i++) {
            assertEquals(asciiValues[i], abc[i]);
        }
    }

    @Test
    public void cipherToStringWorksCorrectly() {
        OwnBigInteger[] asciiValues = new OwnBigInteger[]{new OwnBigInteger("97"), new OwnBigInteger("98"), new OwnBigInteger("99")};
        assertEquals("abc", asciiUtil.cipherToString(asciiValues));
    }


}
