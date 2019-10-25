package utils;

/**
 * This is a class to hold two int[] arrays. Used in OwnBigInteger when checking which array has more digits.
 */
public class TwoArrayHolder {
    private int[] longerArray;
    private int[] shorterArray;

    public int[] getLongerArray() {
        return longerArray;
    }

    public void setLongerArray(int[] longerArray) {
        this.longerArray = longerArray;
    }

    public int[] getShorterArray() {
        return shorterArray;
    }

    public void setShorterArray(int[] shorterArray) {
        this.shorterArray = shorterArray;
    }
}
