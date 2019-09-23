package rsaToolTest;

import asciiutil.AsciiUtil;
import decrypter.Decrypter;
import encrypter.Encrypter;
import keygenerators.KeyGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;
import rsatool.RSATool;

import java.security.PrivateKey;

import static org.mockito.Matchers.any;
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
   /*   rsaTool.encrypt(testString);
      verify(encrypter).encrypt(anyString(), any(PrivateKeyImpl.class));*/
    }

    @Test
    public void decryptCallsDecryptor() {
       /* rsaTool.decrypt(testString);
        verify(decrypter).decrypt(any(byte[].class), any(PublicKeyImpl.class));**/
    }



}
