package randomimpltest;

import utils.RandomImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RandomImplTest {

    @Test
    public void randomGeneratorReturnsPseudoRandomNumber() {
        for (int i = 0; i < 10000; i++) {
            int randomNumber1 = RandomImpl.generateRandomInteger();
            int randomNumber2 = RandomImpl.generateRandomInteger();
            assertNotEquals(randomNumber1, randomNumber2);
        }
    }
}
