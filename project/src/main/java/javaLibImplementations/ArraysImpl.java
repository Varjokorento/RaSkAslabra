package javaLibImplementations;

public class ArraysImpl {

    /**
     * Fills an given boolean array with wanted value
     * @param array
     * @param value
     */

    public static void fill(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
}
