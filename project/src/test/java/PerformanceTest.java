import org.junit.Test;
import rsatool.RSATool;
import utils.BigIntegerImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class PerformanceTest {

    private RSATool rsaTool = new RSATool();


    @Test
    public void comparingKeyGenerationPerformance() throws NoSuchAlgorithmException {
        long startTime = System.nanoTime();
        for(int i = 0; i < 10; i++) {
            rsaTool.generateKeysWithLibraries();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("It took " + duration/(1000000*10) + " milliseconds with libraries");

        startTime = System.nanoTime();
        for(int i = 0; i < 10; i++) {
            rsaTool.generateKeys(100);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("It took " + duration/(1000000*10) + " milliseconds without libraries");

    }


    @Test
    public void comparingEncryptionPerformance() throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        rsaTool.generateKeysWithLibraries();
        rsaTool.generateKeys(1024);
        long startTime = System.nanoTime();
        for(int i = 0; i < 10; i++) {
            rsaTool.encryptWithLibraries("message");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("It took " + duration/(1000000*10) + " milliseconds with libraries");

        startTime = System.nanoTime();
        for(int i = 0; i < 10; i++) {
            rsaTool.encrypt("message");
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("It took " + duration/(1000000*10) + " milliseconds without libraries");

    }

    @Test
    public void comparingEndToEndPerformance() throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        rsaTool.generateKeysWithLibraries();
        rsaTool.generateKeys(1024);
        long startTime = System.nanoTime();
        for(int i = 0; i < 10; i++) {
            byte[] array = rsaTool.encryptWithLibraries("message");
            rsaTool.decryptWithLibraries(array);

        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("It took " + duration/(1000000*10) + " milliseconds with libraries");

        startTime = System.nanoTime();
        for(int i = 0; i < 10; i++) {
            BigIntegerImpl[] encrypted = rsaTool.encrypt("message");
            rsaTool.decrypt(encrypted);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("It took " + duration/(1000000*10) + " milliseconds without libraries");

    }

}
