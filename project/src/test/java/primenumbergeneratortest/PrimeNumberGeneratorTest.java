package primenumbergeneratortest;

import org.junit.Test;
import utils.OwnBigInteger;
import utils.PrimeNumberGenerator;

import java.math.BigInteger;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PrimeNumberGeneratorTest {


    @Test
    public void testMillerRabinPrimality() {
        int errors = 0;
        for (int i = 0; i < 1000; i++) {
            String value = String.valueOf(i);
            OwnBigInteger possiblePrime = new OwnBigInteger(value);
            BigInteger bi = new BigInteger(value);
            boolean answer = PrimeNumberGenerator.millerRabinPrimality(possiblePrime, 1);
            if (answer && !bi.isProbablePrime(100)) {
                errors++;
            }
        }
        System.out.println(errors);
    }

    @Test
    public void notPrimeShouldReturnFalse() {
        OwnBigInteger fourtyNine = new OwnBigInteger("26");
        boolean answer = PrimeNumberGenerator.millerRabinPrimality(fourtyNine, 3);
        assertFalse(answer);
    }

    @Test
    public void ownImplementationNumberArePrime() {
        OwnBigInteger number = PrimeNumberGenerator.generateLargePrime();
        BigInteger numberAsBigInt = new BigInteger(number.valueOf());
        assertTrue(numberAsBigInt.isProbablePrime(100));
    }

}
