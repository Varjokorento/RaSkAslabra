package asciiutil;

import java.nio.charset.StandardCharsets;

public class AsciiUtil {


    /**
     * Constructs a new String from byteArray.
     * @return Stringified byteArray
     */

    public static String getStringFromByteArray(byte[] byteArray) {
        return new String(byteArray, StandardCharsets.UTF_8);
    }

}
