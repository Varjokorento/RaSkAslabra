package primenumbergeneratortest;

import org.junit.Test;
import utils.OwnBigInteger;
import utils.PrimeNumberGenerator;

import java.math.BigInteger;
import java.util.Random;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PrimeNumberGeneratorTest {


    @Test
    public void testMillerRabinPrimality() {
        Random random = new Random();
        int errors = 0;
        int totalPrimes = 0;
        for (int i = 0; i < 10000; i++) {
            OwnBigInteger possiblePrime = OwnBigInteger.getLargeRandom(random);
            BigInteger bi = new BigInteger(possiblePrime.valueOf());
            boolean answer = PrimeNumberGenerator.millerRabinPrimality(possiblePrime, 3);

            if (answer) {
                totalPrimes++;
            }

            if (answer && !bi.isProbablePrime(100)) {
                errors++;
            }
        }
        System.out.println("Error rate: " + errors + "/" + totalPrimes);
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
