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
    public void generateKeyPairGeneratesKeysThatAreKeysToEachOther() {
        OwnKeyPairGenerator keyPairGenerator = new OwnKeyPairGenerator();
        OwnKeyPair kp = keyPairGenerator.generateKeyPair();
        OwnBigInteger test = new OwnBigInteger("97");
        OwnBigInteger eModN = test.modPow(kp.getPublicKey().getN(), kp.getPublicKey().getE());
        OwnBigInteger dModN = eModN.modPow(kp.getPublicKey().getN(), kp.getPrivateKey().getPrivateKey());
        assertEquals(test, dModN);
    }


}
