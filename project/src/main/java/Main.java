import rsatool.RSATool;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
        System.out.println("Encrypted:");
        printArray(encrypted);
        System.out.println("\n");
        System.out.println("Decrypted: ");
        printArray(decrypted);
        System.out.println("\n");
        System.out.println("Restored: " + restoredMessage);
        encryptWithLibraries(scanner, rsaTool);
    }

    private static void encryptWithLibraries(Scanner scanner, RSATool rsaTool) {
        System.out.println("Please enter a new plain text message. Maximum length 200 characters.");
        String message = scanner.nextLine();
        try {
            libraryRSA(message, rsaTool);
        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }

    private static void libraryRSA(String message, RSATool rsaTool) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {

        if (message.length() <= 239) {
            rsaTool.generateKeysWithLibraries();
            byte[] encrypted = rsaTool.encryptWithLibraries(message);
            String plainText = rsaTool.decryptWithLibraries(encrypted);
            System.out.println("Has been decrypted:");
            System.out.println(plainText);
        }
    }

    private static void printArray(BigInteger[] array) {
        for (BigInteger a: array) {
            System.out.print(a);
        }
    }


}
