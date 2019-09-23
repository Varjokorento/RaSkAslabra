import asciiutil.AsciiUtil;
import decrypter.Decrypter;
import encrypter.Encrypter;
import rsatool.RSATool;
import utils.MathImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter plain text");
        String message = scanner.nextLine();
        RSATool rsaTool = new RSATool();
        rsaTool.generateKeys(1024);
        BigInteger[] encrypted = rsaTool.encrypt(message);
        BigInteger[] decrypted = rsaTool.decrypt(encrypted);
        String restoredMessage = rsaTool.cipherToString(decrypted);
        System.out.println("Original message: " + message);
        System.out.println("Encrypted:" );
        for (BigInteger a: encrypted) {
         //   System.out.println(a);
        }
        System.out.println("Decrypted: " + decrypted);
        for (BigInteger a: decrypted) {
          //  System.out.print(a);
        }
        System.out.println("");
        System.out.println("Restored: " + restoredMessage);
    }


}
