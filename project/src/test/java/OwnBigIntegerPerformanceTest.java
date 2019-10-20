import org.junit.Test;
import utils.OwnBigInteger;

import java.math.BigInteger;

public class OwnBigIntegerPerformanceTest {

    private static final int iterations = 100;
    private static final int powIterations = 10;

    @Test
    public void testAdding() {
        String numberString = "200000000000000000";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.add(number);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / (10) ;
        System.out.println("Addition took " + duration + " with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.add(bigInteger);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / (10) ;
        System.out.println("Addition took " + duration + " with libraries");
    }


    @Test
    public void testSubtracting() {
        String numberString = "200000000000000000";
        String numberSubtract = "1";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger subtractImpl = new OwnBigInteger(numberSubtract);
        BigInteger bigIntegerSubtract = new BigInteger(numberSubtract);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.subtract(subtractImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / (10) ;
        System.out.println("Subtraction took " + duration + " with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.subtract(bigIntegerSubtract);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / (10) ;
        System.out.println("Subtraction took " + duration + " with libraries");
    }

    @Test
    public void testMultiplication() {
        String numberString = "200000000000000000";
        String numberMultiply = "1000000";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger multiplyImpl = new OwnBigInteger(numberMultiply);
        BigInteger multiyplyBI = new BigInteger(numberMultiply);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.multiply(multiplyImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / (10) ;
        System.out.println("Multiplication took " + duration + " with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.subtract(multiyplyBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / (10) ;
        System.out.println("Multiplication took " + duration + " with libraries");
    }

    @Test
    public void testDivision() {
        String numberString = "200000";
        String numberDivide = "10";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger divideImpl = new OwnBigInteger(numberDivide);
        BigInteger divideBI = new BigInteger(numberDivide);
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            number = number.divide(divideImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / (100) ;
        System.out.println("Division took " + duration + " with own implementation");
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.divide(divideBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / (100) ;
        System.out.println("Division took " + duration + " with libraries");
    }

    @Test
    public void testMod() {
        String numberString = "2000000000";
        String numberDivide = "100";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger divideImpl = new OwnBigInteger(numberDivide);
        BigInteger divideBI = new BigInteger(numberDivide);
        long startTime = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            number.mod(divideImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / (10) ;
        System.out.println("Mod took " + duration + " with own implementation");
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.mod(divideBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / (10) ;
        System.out.println("Mod took " + duration + " with libraries");
    }

    @Test
    public void testPow() {
        String numberString = "200";
        String numberPow = "3397";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger powerImpl = new OwnBigInteger(numberPow);
        BigInteger powerBI = new BigInteger(numberPow);
        long startTime = System.nanoTime();
        for (int i = 0; i < powIterations; i++) {
            number.pow(powerImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / (10) ;
        System.out.println("Power took " + duration + "seconds with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < powIterations; i++) {
            bigInteger.pow(10);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / (10) ;
        System.out.println("Power took " + duration + "seconds with libraries");
    }


}
