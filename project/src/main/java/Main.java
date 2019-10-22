import rsatool.RSATool;
import utils.OwnBigInteger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter plain text. Exit quits the program.");
            String message = scanner.nextLine();
            if (message.equals("exit")) {
                break;
            }
            ;
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
                System.out.println("An unknown exception happened.");
            }
        }
    }


    private static void printArray(OwnBigInteger[] array) {
        for (OwnBigInteger a : array) {
            for (int i : a.getDigits()) {
                System.out.print(i);
            }
        }
    }


}
