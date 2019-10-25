package utils.asciiutil;

import utils.OwnBigInteger;


public class AsciiUtil {


    /**
     * Converts plainText message to OwnBigIntegerArray.
     *
     * @param message message in plaintext
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
     * Converts cipher OwnBigInteger[] to a plainText String
     *
     * @param message as OwnBigInteger[]
     * @return message plainText message
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
