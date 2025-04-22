import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundForCatReturnsMeowTest(){
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodForCatReturnsMeatTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        List<String> Meat = List.of("Животные", "Птицы", "Рыба");
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Mockito.when(feline.eatMeat()).thenReturn(Meat);
        Assert.assertEquals(Meat, cat.getFood());
    }

}
