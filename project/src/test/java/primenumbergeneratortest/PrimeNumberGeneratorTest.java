package primenumbergeneratortest;

import org.junit.Test;
import utils.BigIntegerImpl;
import utils.PrimeNumberGenerator;
import utils.PrimeNumberGeneratorWithBigInt;

import java.math.BigInteger;

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
    public void ownImplementationNumberArePrime() {
        BigIntegerImpl number = PrimeNumberGeneratorWithBigInt.generateLargePrime(100);
        BigInteger numberAsBigInt = new BigInteger(number.valueOf());
        assertTrue(numberAsBigInt.isProbablePrime(100));

    }

}
