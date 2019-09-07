import Decryptor.Decrypter;
import Encrypter.Encrypter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Please enter plain text");
        //String plainText = scanner.nextLine();
        Encrypter encrypter = new Encrypter();
        Decrypter decrypter = new Decrypter();
        char encryptedCHar = encrypter.encrypt("b");
        System.out.println(encryptedCHar);
     //   System.out.println(decrypter.decrypt(encrypter.encrypt("b")));
    }
}
