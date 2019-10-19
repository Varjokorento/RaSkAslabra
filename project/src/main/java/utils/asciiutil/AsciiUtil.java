package utils.asciiutil;

import utils.BigIntegerImpl;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class AsciiUtil {


    /**
     * Constructs a new String from byteArray.
     * @return Stringified byteArray
     */

    public String getStringFromByteArray(byte[] byteArray) {
        return new String(byteArray, StandardCharsets.UTF_8);
    }

    /**
     * Converts plainText message to bigIntegerArray.
     * @param message
     * @return BigInteger[] decipheredArray
     */

    public BigIntegerImpl[] stringToCipher(String message) {
        BigIntegerImpl[] cipherString = new BigIntegerImpl[message.length()];
        int i = 0;
        while (i < message.length()) {
            int ch = (int) message.charAt(i);
            BigIntegerImpl character = new BigIntegerImpl(String.valueOf(ch));
            cipherString[i] = character;
            i++;
        }
        return cipherString;
    }

    /**
     * Converts cipher BigInteger[] to a plainText String
     * @param message
     * @return message
     */

    public String cipherToString(BigIntegerImpl[] message) {
        String output = "";
        for (int i = 0; i < message.length; i++) {
            int temp = Integer.valueOf(message[i].valueOf());
            char ch = (char) temp;
            output = output + ch;
        }
        return output;
    }


}
