package keygenerator;

import keys.OwnKeyPairGenerator;
import keys.keyimpl.OwnKeyPair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utils.OwnBigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class KeyPairGeneratorImplTest {

    @Test
    public void generateKeyPairGeneratesKeysThatAreKeysToEachOther() throws Exception {
        OwnKeyPairGenerator keyPairGenerator = new OwnKeyPairGenerator();
        OwnKeyPair kp = null;
        kp = keyPairGenerator.generateKeyPair();
        OwnBigInteger test = new OwnBigInteger("97");
        OwnBigInteger eModN = test.modPow(kp.getPublicKey().getE(), kp.getPublicKey().getN());
        OwnBigInteger dModN = eModN.modPow(kp.getPrivateKey().getPrivateKey(), kp.getPublicKey().getN());
        assertEquals(test, dModN);
    }


}
