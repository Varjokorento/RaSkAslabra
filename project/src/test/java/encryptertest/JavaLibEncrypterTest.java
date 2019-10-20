package encryptertest;

import encrypter.JavaLibEncrypter;
import keys.JavaLibKeyUtil;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaLibEncrypterTest {

    private JavaLibEncrypter encrypter = new JavaLibEncrypter();
    private String encryptedString = "[25, -89, 89, -34, -93, -97, 52, -87, -119, -113, -25, -82, -123, -107, -128, -39, -83, 119, 6, 5, 61, 5, -122, 54, -28, -112, -121, 114, 83, 23, -80, -91, -97, 39, 99, -8, -45, -117, -101, 15, -22, 109, 78, 92, 23, -37, -67, -17, 70, 0, 76, 80, -25, -81, 16, -23, 1, 66, -116, 100, 77, 110, 27, 94, -42, -80, -117, 35, -2, 111, -36, 8, -48, 104, -58, 51, 12, -90, -66, -41, 125, 69, 120, -4, -63, -10, 21, -73, -81, -8, -116, -75, 72, 127, -102, 94, -81, -125, -60, 82, -16, 2, 25, -89, -120, -40, -89, 97, 56, -63, -6, 27, -90, 96, -44, -14, -73, 113, 74, -8, 73, 9, -119, -72, 112, -55, 42, 35, 59, -12, -13, -113, 59, 6, 46, 14, 15, -127, -32, -25, 112, -107, 93, 85, 117, -76, 13, -3, 105, 24, 110, -14, 25, 52, 120, -12, 53, -100, 68, 0, -71, 62, -128, -21, -99, -31, 105, 122, -61, -102, 90, -122, -25, 67, -128, 98, -44, -54, -53, -64, -118, -72, -113, 48, 100, 90, -26, -10, -33, 75, -88, 50, 109, -73, 75, -80, 80, 35, -58, 33, 125, 65, 35, -68, 68, -87, 106, 68, -73, 125, -99, 81, 54, -75, -117, 56, -29, -21, 72, -17, -106, 120, -85, -26, 91, 94, 95, -31, 75, 115, 18, -60, 17, 5, 90, 54, 55, 24, -64, -86, -80, 124, -112, -11, -10, 123, -12, 44, 11, 2, 65, 5, -90]";

    @Test
    public void encrypterEncryptEncryptsCorrectlyWithLibraries() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        PrivateKey privateKey = JavaLibKeyUtil.readPrivateKeyFile("src/test/resources/privateKey.key");
        String testString = "testString";
        byte[] array = encrypter.encrypt(testString, privateKey);
        String arrayTo = Arrays.toString(array);
        assertEquals(encryptedString, arrayTo);
    }
}
