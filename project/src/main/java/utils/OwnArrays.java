package utils;

public class OwnArrays {

    /**
     * Copies an array to another array starting from specified index and copying to
     * a specified index for length len.
     * @param source the source array
     * @param sourceIndex  index where the copying begins from
     * @param destinationArray the destination array
     * @param destinationInt the index from where the copying to begins from
     * @param len the length of how much is copied.
     */

    public static void arraycopy(int[] source, int sourceIndex, int[] destinationArray, int destinationInt, int len) {
        int s = sourceIndex;
        int times = 0;
        for (int a = destinationInt; s < source.length; a++) {
            if (times >= len) {
                break;
            }
            destinationArray[a] = source[s];
            s++;
            times++;
        }
    }

}
