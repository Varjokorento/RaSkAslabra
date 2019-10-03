package primenumbergeneratortest;

import org.junit.Test;
import utils.PrimeNumberGenerator;

import java.math.BigInteger;

import static junit.framework.TestCase.assertTrue;

public class PrimeNumberGeneratorTest {

    private PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();

    @Test
    public void generatorNumbersArePrimes() {
        BigInteger number = primeNumberGenerator.generateLargePrime(1024);
        assertTrue((number.isProbablePrime(100)));
        BigInteger number2 = primeNumberGenerator.generateLargePrime(1024);
        assertTrue((number2.isProbablePrime(100)));
    }

}
