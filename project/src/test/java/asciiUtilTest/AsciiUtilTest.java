package asciiUtilTest;

import asciiUtil.AsciiUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsciiUtilTest {

    private AsciiUtil asciiUtil = new AsciiUtil();

    @Test
    public void asciiUtilReturnsCorrectStringForByteArray() {
        String testString = "String";
        byte[] byteArray = testString.getBytes();
        assertEquals(testString, asciiUtil.getStringFromByteArray(byteArray));
    }
}
