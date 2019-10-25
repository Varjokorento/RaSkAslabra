import org.junit.Test;
import utils.OwnBigInteger;

import java.math.BigInteger;

public class OwnBigIntegerPerformanceTest {

    private static final int iterations = 1000;
    private static final int powIterations = 10;

    @Test
    public void testAdding() {
        String numberString = "20000000000000000000";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.add(number);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ;
        System.out.println("Addition took " + duration/iterations + " with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.add(bigInteger);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) ;
        System.out.println("Addition took " + duration/iterations + " with libraries");
    }


    @Test
    public void testSubtracting() {
        String numberString = "200000000000000000";
        String numberSubtract = "10";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger subtractImpl = new OwnBigInteger(numberSubtract);
        BigInteger bigIntegerSubtract = new BigInteger(numberSubtract);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.subtract(subtractImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ;
        System.out.println("Subtraction took " + duration/iterations + " with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.subtract(bigIntegerSubtract);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) ;
        System.out.println("Subtraction took " + duration/iterations + " with libraries");
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
        long duration = (endTime - startTime) ;
        System.out.println("Multiplication took " + duration/iterations + " with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.subtract(multiyplyBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / iterations;
        System.out.println("Multiplication took " + duration + " with libraries");
    }

    @Test
    public void testDivision() {
        String numberString = "20000000000";
        String numberDivide = "10";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger divideImpl = new OwnBigInteger(numberDivide);
        BigInteger divideBI = new BigInteger(numberDivide);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            number = number.divide(divideImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ;
        System.out.println("Division took " + duration/iterations + " with own implementation");
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger = bigInteger.divide(divideBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) ;
        System.out.println("Division took " + duration/iterations + " with libraries");
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
        for (int i = 0; i < iterations; i++) {
            number.mod(divideImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ;
        System.out.println("Mod took " + duration/iterations + " with own implementation");
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            bigInteger.mod(divideBI);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) ;
        System.out.println("Mod took " + duration/iterations + " with libraries");
    }

    @Test
    public void testPow() {
        String numberString = "200";
        String numberPow = "3397";
        OwnBigInteger number = new OwnBigInteger(numberString);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger powerImpl = new OwnBigInteger(numberPow);
        long startTime = System.nanoTime();
        for (int i = 0; i < powIterations; i++) {
            number.pow(powerImpl);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Power took " + duration/iterations + "nanoseconds with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < powIterations; i++) {
            bigInteger.pow(10);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Power took " + duration/iterations + "nanoseconds with libraries");
    }


    @Test
    public void testMulPow() {
        String numberString = "200";
        String numberPow = "3397";
        String numberMod = "23323";
        OwnBigInteger number = new OwnBigInteger(numberString);
        OwnBigInteger pow = new OwnBigInteger(numberPow);
        OwnBigInteger mod = new OwnBigInteger(numberMod);
        BigInteger bigInteger = new BigInteger(numberString);
        OwnBigInteger powerImpl = new OwnBigInteger(numberPow);
        long startTime = System.nanoTime();
        for (int i = 0; i < powIterations; i++) {
            number.modPow(pow, mod);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Power took " + duration/iterations + "nanoseconds with own implementation");

        startTime = System.nanoTime();
        for (int i = 0; i < powIterations; i++) {
            bigInteger.modPow(new BigInteger(numberPow), new BigInteger(numberMod));
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Power took " + duration/iterations + "nanoseconds with libraries");
    }


}
