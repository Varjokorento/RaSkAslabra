package keygenerator;

import keygenerators.KeyPairGeneratorImpl;
import keyimpl.KeyPairImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class KeyPairGeneratorImplTest {

    @Test
    public void generateKeyPairGeneratesKeysThatAreKeysToEachOther() {
        KeyPairGeneratorImpl keyPairGenerator = new KeyPairGeneratorImpl();
        KeyPairImpl kp = keyPairGenerator.generateKeyPair(1024);
        BigInteger test = new BigInteger("97");
        BigInteger eModN = test.modPow(kp.getPublicKey().getE(), kp.getPublicKey().getN());
        BigInteger dModN = eModN.modPow(kp.getPrivateKey().getPrivateKey(), kp.getPublicKey().getN());
        assertEquals(test, dModN);
    }








}
