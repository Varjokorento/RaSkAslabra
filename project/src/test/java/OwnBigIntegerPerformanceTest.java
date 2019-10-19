import org.junit.Test;
import utils.BigIntegerImpl;

import java.math.BigInteger;

public class OwnBigIntegerPerformanceTest {

    private static final int iterations = 100;

    @Test
    public void testAdding() {
        String numberString = "200000000000000000";
        BigIntegerImpl number = new BigIntegerImpl(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.add(number);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Addition took " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.add(bigInteger);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Addition took " + duration);
    }


    @Test
    public void testSubtracting() {
        String numberString = "200000000000000000";
        String numberSubtract  = "1";
        BigIntegerImpl number = new BigIntegerImpl(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        BigIntegerImpl subtractImpl = new BigIntegerImpl(numberSubtract);
        BigInteger bigIntegerSubtract = new BigInteger(numberSubtract);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.subtract(subtractImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Subtraction took " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.subtract(bigIntegerSubtract);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Subtraction took " + duration);
    }

    @Test
    public void testMultiplication() {
        String numberString = "200000000000000000";
        String numberMultiply  = "1000000";
        BigIntegerImpl number = new BigIntegerImpl(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        BigIntegerImpl multiplyImpl = new BigIntegerImpl(numberMultiply);
        BigInteger multiyplyBI = new BigInteger(numberMultiply);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.multiply(multiplyImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Multiplication took " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.subtract(multiyplyBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Multiplication took " + duration);
    }

    @Test
    public void testDivision() {
        String numberString = "200000";
        String numberDivide  = "10";
        BigIntegerImpl number = new BigIntegerImpl(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        BigIntegerImpl divideImpl = new BigIntegerImpl(numberDivide);
        BigInteger divideBI = new BigInteger(numberDivide);
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            number = number.divide(divideImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Division took " + duration);
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.divide(divideBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Division took " + duration);
    }

    @Test
    public void testMod() {
        String numberString = "2000000000";
        String numberDivide  = "100";
        BigIntegerImpl number = new BigIntegerImpl(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        BigIntegerImpl divideImpl = new BigIntegerImpl(numberDivide);
        BigInteger divideBI = new BigInteger(numberDivide);
        long startTime = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            number.mod(divideImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Division took " + duration);
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.mod(divideBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Division took " + duration);
    }

    @Test
    public void testPow() {
        String numberString = "2000";
        String numberPow  = "300";
        BigIntegerImpl number = new BigIntegerImpl(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        BigIntegerImpl powerImpl = new BigIntegerImpl(numberPow);
        BigInteger powerBI = new BigInteger(numberPow);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number.pow(powerImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Power took " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger.pow(10);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Power took " + duration);
    }



}
