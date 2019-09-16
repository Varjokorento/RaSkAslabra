package mathImplTest;

import utils.MathImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathImplTest {


    @Test
    public void powerFunctionWorks() {
        double result1 = MathImpl.pow(2, 30);
        assertEquals(1073741824, result1, 0.0);
        double result2 = MathImpl.pow(2, 16);
        assertEquals(65536, result2, 0.0);
        double result3 = MathImpl.pow(-10, 2);
        assertEquals(100, result3, 0.0);
    }

}
