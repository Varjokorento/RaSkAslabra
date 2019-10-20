import rsatool.JavaLibRSATool;
import rsatool.RSATool;
import utils.OwnBigInteger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter plain text");
        String message = scanner.nextLine();
        RSATool rsaTool = new RSATool();
        try {
            rsaTool.generateKeys();
            OwnBigInteger[] encrypted = rsaTool.encrypt(message);
            OwnBigInteger[] decrypted = rsaTool.decrypt(encrypted);
            String restoredMessage = rsaTool.cipherToString(decrypted);
            System.out.println("Original message: " + message);
            System.out.println("Encrypted:");
            printArray(encrypted);
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("Restored: " + restoredMessage);
        } catch (Exception e) {
            System.out.println("An unknown exception happpened.");
        }
        encryptWithLibraries(scanner);
    }

    private static void encryptWithLibraries(Scanner scanner) throws NoSuchAlgorithmException {
        JavaLibRSATool javaLibRSATool = new JavaLibRSATool();
        System.out.println("Please enter a new plain text message. Maximum length 200 characters.");
        String message = scanner.nextLine();
        try {
            libraryRSA(message, javaLibRSATool);
        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }

    private static void libraryRSA(String message, JavaLibRSATool rsaTool) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        if (message.length() <= 239) {
            rsaTool.generateKeysWithLibraries();
            byte[] encrypted = rsaTool.encryptWithLibraries(message);
            String plainText = rsaTool.decryptWithLibraries(encrypted);
            System.out.println("Has been decrypted:");
            System.out.println(plainText);
        }
    }

    private static void printArray(OwnBigInteger[] array) {
        for (OwnBigInteger a : array) {
            for(int i: a.getDigits()) {
                System.out.print(i);
            }
        }
    }


}
