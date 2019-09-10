package asciiUtil;

import java.nio.charset.StandardCharsets;

public class AsciiUtil {

    public static String getStringFromByteArray(byte[] byteArray) {
        return new String(byteArray, StandardCharsets.UTF_8);
    }
}
