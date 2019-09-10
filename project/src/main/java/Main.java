import asciiUtil.AsciiUtil;
import decrypter.Decrypter;
import RSATool.RSATool;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter plain text");
        String plainText = scanner.nextLine();
        try {
            RSATool rsaTool = new RSATool();
            byte[] encryptedText = rsaTool.encrypt(plainText);
            System.out.println("It has been encryptered");
            System.out.println(AsciiUtil.getStringFromByteArray(encryptedText));
            byte[] decipheredText = rsaTool.decrypt(encryptedText);
            System.out.println(AsciiUtil.getStringFromByteArray(decipheredText));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
