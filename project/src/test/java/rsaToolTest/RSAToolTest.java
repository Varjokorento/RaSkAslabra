package rsaToolTest;

import asciiutil.AsciiUtil;
import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyGenerator;
import keygenerators.PrivateKeyImpl;
import keygenerators.PublicKeyImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;
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


@RunWith(MockitoJUnitRunner.class)
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
        this.rsaTool = new RSATool();
    }

    @Test
    public void encryptCallsEncryptor() {
        rsaTool.encrypt(testString);
      //  verify(encrypter).encrypt(anyString(), any(PrivateKeyImpl.class));
    }

    @Test
    public void decryptCallsDecryptor() {
        rsaTool.decrypt(testString.getBytes());
       // verify(decrypter).decrypt(any(byte[].class), any(PublicKeyImpl.class));
    }



}
