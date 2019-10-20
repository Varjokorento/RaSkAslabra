package utils.asciiutil;

import utils.OwnBigInteger;

import java.nio.charset.StandardCharsets;

public class AsciiUtil {


    /**
     * Constructs a new String from byteArray.
     *
     * @return Stringified byteArray
     */

    public String getStringFromByteArray(byte[] byteArray) {
        return new String(byteArray, StandardCharsets.UTF_8);
    }

    /**
     * Converts plainText message to bigIntegerArray.
     *
     * @param message
     * @return BigInteger[] decipheredArray
     */

    public OwnBigInteger[] stringToCipher(String message) {
        OwnBigInteger[] cipherString = new OwnBigInteger[message.length()];
        int i = 0;
        while (i < message.length()) {
            int ch = (int) message.charAt(i);
            OwnBigInteger character = new OwnBigInteger(String.valueOf(ch));
            cipherString[i] = character;
            i++;
        }
        return cipherString;
    }

    /**
     * Converts cipher BigInteger[] to a plainText String
     *
     * @param message
     * @return message
     */

    public String cipherToString(OwnBigInteger[] message) {
        String output = "";
        for (int i = 0; i < message.length; i++) {
            int temp = Integer.valueOf(message[i].valueOf());
            char ch = (char) temp;
            output = output + ch;
        }
        return output;
    }


}
