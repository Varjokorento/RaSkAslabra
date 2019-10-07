package BigIntegerTest;

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
        BigIntegerImpl bigInteger = new BigIntegerImpl("106051560997741464980169234474");
        BigIntegerImpl impl2 = bigInteger.shiftLeft(1);
        BigInteger integer = new BigInteger("106051560997741464980169234474");
        System.out.println(impl2);
        System.out.println(integer.shiftLeft(1));
    }
}
