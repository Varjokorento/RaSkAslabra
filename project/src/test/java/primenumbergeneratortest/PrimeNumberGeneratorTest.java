package primenumbergeneratortest;

import org.junit.Test;
import utils.PrimeNumberGenerator;

import java.math.BigInteger;

import static junit.framework.TestCase.assertTrue;

public class PrimeNumberGeneratorTest {


    @Test
    public void generatorNumbersArePrimes() {
        BigInteger number = PrimeNumberGenerator.generateLargePrime();
        assertTrue((number.isProbablePrime(100)));
        BigInteger number2 = PrimeNumberGenerator.generateLargePrime();
        assertTrue((number2.isProbablePrime(100)));
    }

}
