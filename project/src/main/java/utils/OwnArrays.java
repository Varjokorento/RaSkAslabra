package utils;

public class OwnArrays {

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
