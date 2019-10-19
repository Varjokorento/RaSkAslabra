package keygenerator;

import keys.OwnKeyPairGenerator;
import keys.keyimpl.OwnKeyPair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utils.BigIntegerImpl;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class KeyPairGeneratorImplTest {

    @Test
    public void generateKeyPairGeneratesKeysThatAreKeysToEachOther() {
        OwnKeyPairGenerator keyPairGenerator = new OwnKeyPairGenerator();
        OwnKeyPair kp = keyPairGenerator.generateKeyPair(1024);
        BigIntegerImpl test = new BigIntegerImpl("97");
        BigIntegerImpl eModN = test.modPow(kp.getPublicKey().getE(), kp.getPublicKey().getN());
        BigIntegerImpl dModN = eModN.modPow(kp.getPrivateKey().getPrivateKey(), kp.getPublicKey().getN());
        assertEquals(test, dModN);
    }








}
