import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import rsatool.RSATool;
import utils.OwnBigInteger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class PerformanceTest {

    private RSATool rsaTool = new RSATool();


    @BeforeEach
    public void setUp() {
        rsaTool = new RSATool();
    }

    @Test
    public void comparingKeyGenerationPerformance() throws Exception {
        System.out.println("KEY-GENERATION-PERFORMANCE");
        long startTime = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            rsaTool.generateKeys();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Key generation took " + duration / (1000000) + " milliseconds");
        System.out.println("-----------");
    }


    @Test
    public void comparingEncryptionPerformance() throws Exception {
        System.out.println("ENCRYPTION PERFORMANCE");
        rsaTool.generateKeys();
        long startTime = System.nanoTime();
        rsaTool.encrypt("message");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Encryption took " + duration / (1000000) + " milliseconds without libraries");

        System.out.println("-----------------");
    }

    @Test
    public void comparingEndToEndPerformance() throws Exception {
        System.out.println("END-TO-END-PERFORMANCE");
        long startTime = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            rsaTool.generateKeys();
            OwnBigInteger[] encrypted = rsaTool.encrypt("message");
            rsaTool.decrypt(encrypted);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("End to End took " + duration / (1000000) + " milliseconds without libraries");
        System.out.println("------------------");

    }

}
