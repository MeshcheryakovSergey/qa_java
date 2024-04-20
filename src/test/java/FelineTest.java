import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnsCorrectValue() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturnsCorrectValue() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensShouldReturn1() {
        int expectedCount = 1;
        int actualCount = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(expectedCount);
        Assert.assertEquals(expectedCount, actualCount);
    }

}
