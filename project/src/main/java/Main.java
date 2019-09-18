import asciiutil.AsciiUtil;
import rsatool.RSATool;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter plain text");
        String plainText = scanner.nextLine();
        RSATool rsaTool = new RSATool();
        rsaTool.generateKeys();
            //byte[] encryptedText = rsaTool.encrypt(plainText);
        System.out.println("It has been encryptered");
           // System.out.println(AsciiUtil.getStringFromByteArray(encryptedText));
            //byte[] decipheredText = rsaTool.decrypt(encryptedText);
        rsaTool.writeKeysToFile();
           // System.out.println(AsciiUtil.getStringFromByteArray(decipheredText));
    }
}
