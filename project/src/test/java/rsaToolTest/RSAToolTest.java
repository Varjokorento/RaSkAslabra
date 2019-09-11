package rsaToolTest;

import asciiUtil.AsciiUtil;
import decrypter.Decrypter;
import encrypter.Encrypter;
import keyGenerators.KeyGenerator;
import keyGenerators.KeyUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import RSATool.RSATool;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

    @BeforeEach
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
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void decryptCallsDecryptor() {
        try {
            rsaTool.decrypt(testString.getBytes());
            verify(decrypter.decrypt(any(byte[].class), any(PublicKey.class)));
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

    }



}
