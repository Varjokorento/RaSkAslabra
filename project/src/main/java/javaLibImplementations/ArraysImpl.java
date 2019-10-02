package javaLibImplementations;

public class ArraysImpl {

    public static void fill(boolean[] array, boolean value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
}
