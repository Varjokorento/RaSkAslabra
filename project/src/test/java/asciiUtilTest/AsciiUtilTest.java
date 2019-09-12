package asciiUtilTest;

import asciiutil.AsciiUtil;
import org.junit.Test;

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
