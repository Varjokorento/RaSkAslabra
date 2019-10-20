package utils;

/**
 * This is a class to hold two int[] arrays. Used in BigIntegerImpl
 */
public class TwoArrayHolder {
    private int[] biggerArray;
    private int[] smallerArray;

    public int[] getBiggerArray() {
        return biggerArray;
    }

    public void setBiggerArray(int[] biggerArray) {
        this.biggerArray = biggerArray;
    }

    public int[] getSmallerArray() {
        return smallerArray;
    }

    public void setSmallerArray(int[] smallerArray) {
        this.smallerArray = smallerArray;
    }
}
