package ArraysTest;

import javaLibImplementations.ArraysImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ArraysImplTest {


    @Test
    public void arraysFillFillsArrayWithTrue() {
        boolean[] array1 = new boolean[10];
        ArraysImpl.fill(array1, true);
        for (int i = 0; i < 10; i++){
            assertTrue(array1[i]);
        }
    }

    @Test
    public void arraysFillFillsArrayWithFalse() {
        boolean[] array2 = new boolean[10];
        ArraysImpl.fill(array2, false);
        for (int i = 0; i < 10; i++){
            assertFalse(array2[i]);
        }
    }
}
