import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void hasManeReturnTrue() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodReturnPredatorFood() throws Exception {
        Lion lion = new Lion("Самец",feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getKittensReturnsCorrectResult() throws Exception {
        Lion lion = new Lion("Самка",feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maneExeption() throws Exception {
        Exception exception = null;
        try {
            Lion lion = new Lion("СамецЦ",feline);
        } catch (Exception ex) {
            exception = ex;
        }
        String expectedText = "Используйте допустимые значения пола животного - самей или самка";
        String actual = exception.getMessage();
        Assert.assertNotNull(exception);
        Assert.assertEquals(expectedText, actual);
    }

}
