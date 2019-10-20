package primenumbergeneratortest;

import org.junit.Test;
import utils.OwnBigInteger;
import utils.PrimeNumberGenerator;
import utils.PrimeNumberGeneratorWithBigInt;

import java.math.BigInteger;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PrimeNumberGeneratorTest {

    private PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
    private PrimeNumberGeneratorWithBigInt primeNumberGeneratorWithBigInt = new PrimeNumberGeneratorWithBigInt();

    @Test
    public void generatorNumbersArePrimes() {
        BigInteger number = primeNumberGenerator.generateLargePrime(100);
        assertTrue((number.isProbablePrime(100)));
        BigInteger number2 = primeNumberGenerator.generateLargePrime(100);
        assertTrue((number2.isProbablePrime(100)));
    }

    @Test
    public void testMillerRabinPrimality() {
        int errors = 0;
        for (int i = 0; i < 1000; i++) {
            String value = String.valueOf(i);
            OwnBigInteger possiblePrime = new OwnBigInteger(value);
            BigInteger bi = new BigInteger(value);
            boolean answer = PrimeNumberGeneratorWithBigInt.millerRabinPrimality(possiblePrime, 1);
            if (answer && !bi.isProbablePrime(100)) {
                errors++;
            }
        }
        System.out.println(errors);
    }

    @Test
    public void notPrimeShouldReturnFalse() {
        OwnBigInteger fourtyNine = new OwnBigInteger("28");
        boolean answer = PrimeNumberGeneratorWithBigInt.millerRabinPrimality(fourtyNine, 1);
        assertFalse(answer);
    }

    @Test
    public void ownImplementationNumberArePrime() {
        OwnBigInteger number = PrimeNumberGeneratorWithBigInt.generateLargePrime();
        BigInteger numberAsBigInt = new BigInteger(number.valueOf());
        assertTrue(numberAsBigInt.isProbablePrime(100));
    }

}
