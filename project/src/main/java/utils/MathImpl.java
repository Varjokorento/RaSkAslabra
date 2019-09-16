package utils;

public class MathImpl {

    /**
     * Raises a number to it's nth power
     * @param number
     * @param power
     * @return number^power
     */

    public static double pow(int number, int power) {
        if (power == 0) {
            return 1.0;
        }
        if (power < 0) {
            // Negative power.
            if (number == 0) {
                throw new IllegalArgumentException(
                        "You can't raise 0 to a negative power");
            }
            return 1 / pow(number, -power);
        } else {
            // Positive power
            double powerOfHalfN = pow(number, power / 2);
            if (power % 2 == 1) {
                // Odd n
                return number * powerOfHalfN * powerOfHalfN;
            } else {
                // Even n
                return powerOfHalfN * powerOfHalfN;
            }
        }
    }
}
