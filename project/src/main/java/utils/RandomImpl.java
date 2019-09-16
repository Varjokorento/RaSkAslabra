package utils;

import utils.MathImpl;

public class RandomImpl {

    /**
     * Generates a random number using linear congruential formula.
     * Constants taken from Microsoft's random formula except instead of 2^31 it's 2^30
     * @return random integer
     */
    public static int generateRandomInteger() {
        double random = (214013 * System.nanoTime() + 2531011) % (MathImpl.pow(2, 30));
        int randomInteger = (int) random;
        return randomInteger;
    }


}
