package rsaToolTest;

import asciiutil.AsciiUtil;
import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import rsatool.RSATool;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class RSAToolTest {
    @Mock
    private Encrypter encrypter;

    @Mock
    private Decrypter decrypter;

    @Mock
    private AsciiUtil asciiUtil;

    @Mock
    private KeyGenerator keyGenerator;

    private static final String testString = "testString";

    private RSATool rsaTool;

    private PrivateKey testPrivateKey;

    @Before
    public void setUp() {
        initMocks(this);
        try {
            this.rsaTool = new RSATool();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void encryptCallsEncryptor() {
        try {
            rsaTool.encrypt(testString);
            verify(encrypter).encrypt(anyString(), any(PrivateKey.class));
        } catch (IllegalBlockSizeException | NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void decryptCallsDecryptor() {
        try {
            rsaTool.decrypt(testString.getBytes());
            verify(decrypter.decrypt(any(byte[].class), any(PublicKey.class)));
        } catch (IllegalBlockSizeException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }

    }



}
