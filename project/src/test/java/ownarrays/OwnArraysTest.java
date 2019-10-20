package ownarrays;

import org.junit.Test;
import utils.OwnArrays;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnArraysTest {

    @Test
    public void testCopy() {
        int[] array1 = new int[]{1,2,3};
        int[] array2 = new int[3];
        OwnArrays.arraycopy(array1, 0, array2, 0, array2.length);
        for(int i = 0; i < array1.length; i++) {
            assertEquals(array2[i], array1[i]);
        }
    }

    @Test
    public void testSmallCopies() {
        int[] array1 = new int[]{0,1};
        int[] array2 = new int[1];
        OwnArrays.arraycopy(array1, 1, array2, 0, array2.length);
        assertEquals(array2[0], 1);
    }

    @Test
    public void lenLimitsCopying() {
        int[] array1 = new int[]{2,0};
        int[] array2 = new int[1];
        int[] array3 = new int[]{2,0};
        int[] array4 = new int[1];
        OwnArrays.arraycopy(array1, 0, array2, 0, 1);
        System.arraycopy(array3, 0, array4, 0, 1);
        assertEquals(Arrays.toString(array3), Arrays.toString(array1));
    }

    @Test
    public void testCopyWithPosition() {
        int[] array1 = new int[]{1,2,3};
        int[] array2 = new int[6];
        int[] array3 = new int[6];
        for(int a = 0; a < 10; a++) {
            OwnArrays.arraycopy(array1, 0, array2, 3, array1.length);
            System.arraycopy(array1, 0, array3, 3, array1.length);
            for (int i = 0; i < array2.length; i++) {
                assertEquals(array2[i], array3[i]);
            }
        }
    }

}
