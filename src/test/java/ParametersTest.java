import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;


@RunWith(Parameterized.class)
public class ParametersTest {

        private final int kittensCount;

        public ParametersTest(int kittensCount) {
            this.kittensCount = kittensCount;
        }

        @Parameterized.Parameters
        public static Object [][] getKittensCount() {
            return new Object[][] {
                    {1},
                    {2},
                    {3},
                    {10},
                    {15}
            };
        }

        @Test
        public void getKittensWithCountReturnsCorrectValue() {
            Feline feline = new Feline();
            int expected = kittensCount;
            int actual = feline.getKittens(kittensCount);
            Assert.assertEquals(expected, actual);
        }
    }
