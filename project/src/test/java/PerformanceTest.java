import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import rsatool.JavaLibRSATool;
import rsatool.RSATool;
import utils.OwnBigInteger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class PerformanceTest {

    private RSATool rsaTool = new RSATool();
    private JavaLibRSATool javaLibRSATool = new JavaLibRSATool();

    public PerformanceTest() throws NoSuchAlgorithmException {
    }


    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        rsaTool = new RSATool();
        javaLibRSATool = new JavaLibRSATool();
    }

    @Test
    public void comparingKeyGenerationPerformance() throws NoSuchAlgorithmException {
        System.out.println("KEY-GENERATION-PERFORMANCE");
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            javaLibRSATool.generateKeysWithLibraries();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("It took " + duration / (1000000 * 10) + " milliseconds with libraries");

        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            rsaTool.generateKeys();
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("It took " + duration / (1000000 * 10) + " milliseconds without libraries");
        System.out.println("-----------");
    }


    @Test
    public void comparingEncryptionPerformance() throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        System.out.println("ENCRYPTION PERFORMANCE");
        javaLibRSATool.generateKeysWithLibraries();
        rsaTool.generateKeys();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            javaLibRSATool.encryptWithLibraries("message");
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("It took " + duration / (1000000 * 10) + " milliseconds with libraries");

        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            rsaTool.encrypt("message");
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("It took " + duration / (1000000 * 10) + " milliseconds without libraries");

        System.out.println("-----------------");
    }

    @Test
    public void comparingEndToEndPerformance() throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        System.out.println("END-TO-END-PERFORMANCE");
        javaLibRSATool.generateKeysWithLibraries();
        rsaTool.generateKeys();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            byte[] array = javaLibRSATool.encryptWithLibraries("message");
            javaLibRSATool.decryptWithLibraries(array);

        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("It took " + duration / (1000000 * 10) + " milliseconds with libraries");

        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            OwnBigInteger[] encrypted = rsaTool.encrypt("message");
            rsaTool.decrypt(encrypted);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("It took " + duration / (1000000 * 10) + " milliseconds without libraries");
        System.out.println("------------------");

    }

}
