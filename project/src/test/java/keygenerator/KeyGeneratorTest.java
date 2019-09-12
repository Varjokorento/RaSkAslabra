package keygenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class KeyGeneratorTest {


    @Before
    public void setUp() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        //todo once own implementation is done then this class is not just a getter/setter and requires testing

    }

    @Test
    public void generateKeyPairCallsKeyPairGenerator() {
        //todo once own implementation is done then this class is not just a getter/setter and requires testing
    }

    @Test
    public void getPrivateKeyCallsGetPrivateKey() {
        //todo once own implementation is done then this class is not just a getter/setter and requires testing
    }

    @Test
    public void getPublicKeyCallsGetPublicKey() {
        //todo once own implementation is done then this class is not just a getter/setter and requires testing
    }
}
