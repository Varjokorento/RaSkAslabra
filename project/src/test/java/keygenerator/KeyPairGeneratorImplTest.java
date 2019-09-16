package keygenerator;

import keygenerators.KeyPairGeneratorImpl;
import keygenerators.KeyPairImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class KeyPairGeneratorImplTest {



    @Test
    public void generateKeyPairGeneratesALargePrivateKeyThatIsPrime() {
        KeyPairGeneratorImpl keyPairGenerator = new KeyPairGeneratorImpl();
        KeyPairImpl kp = keyPairGenerator.generateKeyPair(2024);
        assertTrue((kp.getPrivateKey().getPrivateKey().isProbablePrime(100)));
    }

    @Test
    public void generateKeyPairGeneratesALargePublicKeyThatIsPrime() {
        KeyPairGeneratorImpl keyPairGenerator = new KeyPairGeneratorImpl();
        KeyPairImpl kp = keyPairGenerator.generateKeyPair(2024);
        assertTrue((kp.getPublicKey().getPublicKey().isProbablePrime(100)));
    }







}
