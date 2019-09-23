import rsatool.RSATool;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter plain text");
        String message = scanner.nextLine();
        RSATool rsaTool = new RSATool();
        rsaTool.generateKeys();
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
    }

    private static void printArray(BigInteger[] array) {
        for (BigInteger a: array) {
            System.out.print(a);
        }
    }


}
