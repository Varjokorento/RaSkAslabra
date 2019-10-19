package bigintegertest;

import org.junit.Test;
import utils.BigIntegerImpl;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class BigIntegerImplTest {

    @Test
    public void testValueOfBigInteger() {
        BigIntegerImpl bigInteger = new BigIntegerImpl("100000000000000000000000000000000000000");
        assertEquals("100000000000000000000000000000000000000", bigInteger.valueOf());
    }

    @Test
    public void testAddition() {
        BigIntegerImpl int1 = new BigIntegerImpl("1000000000000000000000000");
        BigIntegerImpl int2 = new BigIntegerImpl("2000000000000000000000000");
        BigIntegerImpl int3 = int1.add(int2);
        assertEquals("3000000000000000000000000", int3.valueOf());
    }

    @Test
    public void testSubtraction() {
        BigIntegerImpl int1 = new BigIntegerImpl("1000000000000000000000000");
        BigIntegerImpl int2 = new BigIntegerImpl("2000000000000000000000000");
        BigIntegerImpl int3 = int2.subtract(int1);
        assertEquals("1000000000000000000000000", int3.valueOf());
    }

    @Test
    public void subtractOneFromOneResultsInZero() {
        BigIntegerImpl one = new BigIntegerImpl("1");
        BigIntegerImpl result = one.subtract(one);
        assertEquals(new BigIntegerImpl("0"), result);

    }

    @Test
    public void testMultiplication() {
        BigIntegerImpl int1 = new BigIntegerImpl("2");
        BigIntegerImpl int2 = new BigIntegerImpl("2000000000000000000000000");
        BigIntegerImpl int3 = int2.multiply(int1);
        assertEquals("4000000000000000000000000", int3.valueOf());
    }

    @Test
    public void testDivision() {
        BigIntegerImpl int1 = new BigIntegerImpl("2");
        BigIntegerImpl int2 = new BigIntegerImpl("20");
        BigIntegerImpl int3 = int2.divide(int1);
        assertEquals("10", int3.valueOf());
    }

    @Test
    public void shiftLeft() {
        BigIntegerImpl bigInteger = new BigIntegerImpl("2");
        BigIntegerImpl impl2 = bigInteger.shiftLeft(1);
        BigInteger integer = new BigInteger("2");
        System.out.println(impl2);
        System.out.println(integer.shiftLeft(1));
    }

    @Test
    public void moduloTest() {
        BigIntegerImpl impl = new BigIntegerImpl("1311313232323232323232323232323");
        BigIntegerImpl divisor = new BigIntegerImpl("23232323232323232323322323");
        assertEquals("11212121212121207041355234", impl.mod(divisor).valueOf());
    }

    @Test
    public void powerTest() {
        BigIntegerImpl two = new BigIntegerImpl("22");
        BigIntegerImpl four = new BigIntegerImpl("75");
        BigInteger twoBI = new BigInteger("22");
        BigInteger result = twoBI.pow(75);
        BigIntegerImpl newNumber = two.pow(four);
        BigIntegerImpl modulo = newNumber.mod(new BigIntegerImpl("22"));
        assertEquals(result.toString(), newNumber.valueOf());
    }

    @Test
    public void modPow() {
        BigIntegerImpl five = new BigIntegerImpl("30");
        BigIntegerImpl mod = new BigIntegerImpl("4");
        BigIntegerImpl pow = new BigIntegerImpl("5");
        BigIntegerImpl modPow = five.modPow(mod, pow);
        BigInteger modPowBI = new BigInteger("30").modPow(new BigInteger("4"), new BigInteger("5"));
        assertEquals(modPowBI.toString(), modPow.valueOf());
    }
}
