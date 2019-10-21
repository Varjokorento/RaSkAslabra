package bigintegertest;

import org.junit.Test;
import utils.OwnBigInteger;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OwnBigIntegerTest {


    @Test
    public void testAdditionWithSmallNumbers() {
        OwnBigInteger int1 = new OwnBigInteger("10");
        OwnBigInteger int2 = new OwnBigInteger("20");
        OwnBigInteger int3 = int1.add(int2);
        assertEquals("30", int3.valueOf());
    }


    @Test
    public void testAdditionWithLargeNumbers() {
        OwnBigInteger int1 = new OwnBigInteger("1000000000000000000000000");
        OwnBigInteger int2 = new OwnBigInteger("2000000000000000000000000");
        OwnBigInteger int3 = int1.add(int2);
        assertEquals("3000000000000000000000000", int3.valueOf());
    }



    @Test
    public void testSubtraction() {
        OwnBigInteger int1 = new OwnBigInteger("1000000000000000000000000");
        OwnBigInteger int2 = new OwnBigInteger("2000000000000000000000000");
        OwnBigInteger int3 = int2.subtract(int1);
        assertEquals("1000000000000000000000000", int3.valueOf());
    }

    @Test
    public void testSubtractionWithCarry() {
        OwnBigInteger int1 = new OwnBigInteger("220");
        OwnBigInteger int2 = new OwnBigInteger("90");
        OwnBigInteger int3 = int1.subtract(int2);
        assertEquals("130", int3.valueOf());
    }


    @Test
    public void testSubtractionWithNegativeNumbers() {
        OwnBigInteger int1 = new OwnBigInteger("10");
        OwnBigInteger int2 = new OwnBigInteger("20");
        OwnBigInteger int3 = int1.subtract(int2);
        assertEquals("-10", int3.valueOf());
    }

    @Test
    public void testNegativeSubstraction() {
        OwnBigInteger int1 = new OwnBigInteger("30");
        OwnBigInteger int2 = new OwnBigInteger("20");
        OwnBigInteger int3 = int2.subtract(int1);
        assertEquals("-10", int3.valueOf());
    }

    @Test
    public void subtractOneFromOneResultsInZero() {
        OwnBigInteger one = new OwnBigInteger("1");
        OwnBigInteger result = one.subtract(one);
        assertEquals(new OwnBigInteger("0"), result);

    }

    @Test
    public void testMultiplicationWithSmallNumbers() {
        OwnBigInteger int1 = new OwnBigInteger("240");
        OwnBigInteger int2 = new OwnBigInteger("102");
        OwnBigInteger int3 = int2.multiply(int1);
        assertEquals("24480", int3.valueOf());
    }

    @Test
    public void testMultiplicationWithLargeNumbers() {
        OwnBigInteger int1 = new OwnBigInteger("2");
        OwnBigInteger int2 = new OwnBigInteger("2000000");
        OwnBigInteger int3 = int2.multiply(int1);
        assertEquals("4000000", int3.valueOf());
    }

    @Test
    public void testDivision() {
        OwnBigInteger int1 = new OwnBigInteger("18000");
        OwnBigInteger int2 = new OwnBigInteger("200501");
        OwnBigInteger int3 = int2.divide(int1);
        assertEquals("11", int3.valueOf());
    }


    @Test
    public void shiftLeft() {
        OwnBigInteger bigInteger = new OwnBigInteger("2");
        OwnBigInteger impl2 = bigInteger.shiftLeft(1);
        BigInteger integer = new BigInteger("2");
        integer = integer.shiftLeft(1);
        assertEquals(integer.toString(), impl2.valueOf());
    }

    @Test
    public void moduloTest() {
        OwnBigInteger impl = new OwnBigInteger("131131323");
        OwnBigInteger divisor = new OwnBigInteger("2323232");
        assertEquals("1030331", impl.mod(divisor).valueOf());
    }

    @Test
    public void powerTest() {
        OwnBigInteger two = new OwnBigInteger("22");
        OwnBigInteger four = new OwnBigInteger("75");
        BigInteger twoBI = new BigInteger("22");
        BigInteger result = twoBI.pow(75);
        OwnBigInteger newNumber = two.pow(four);
        OwnBigInteger modulo = newNumber.mod(new OwnBigInteger("22"));
        assertEquals(result.toString(), newNumber.valueOf());
    }


    @Test
    public void testMulPow() {
        OwnBigInteger int2 = new OwnBigInteger("2000000000");
        OwnBigInteger exponent = new OwnBigInteger("3000000000");
        OwnBigInteger modulus = new OwnBigInteger("3000000000");
        OwnBigInteger result = int2.modPow(exponent, modulus);
        BigInteger compare = new BigInteger("2000000000");
        compare = compare.modPow(new BigInteger("3000000000"), new BigInteger("3000000000"));
        assertEquals(compare.toString(), result.toString());
    }

}
