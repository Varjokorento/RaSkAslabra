package keygenerator;

import keygenerators.KeyPairGeneratorImpl;
import keygenerators.KeyPairImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class KeyPairGeneratorImplTest {



    @Test
    public void generateKeyPairGeneratesALargePrivateKey() {
        KeyPairGeneratorImpl keyPairGenerator = new KeyPairGeneratorImpl();
        KeyPairImpl kp = keyPairGenerator.generateKeyPair(2024);
        assertNotNull((kp.getPrivateKey().getPrivateKey()));
    }

    @Test
    public void generateKeyPairGeneratesALargePublicKey() {
        KeyPairGeneratorImpl keyPairGenerator = new KeyPairGeneratorImpl();
        KeyPairImpl kp = keyPairGenerator.generateKeyPair(2024);
        assertNotNull((kp.getPublicKey().getN()));
    }







}
