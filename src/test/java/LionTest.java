import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void doesLionHasManeThrowsExceptionTest() throws Exception {
        String message = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("1", feline);
        });
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void getFoodForLionReturnsMeatTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        List<String> Meat = List.of("Животные", "Птицы", "Рыба");
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
        Mockito.when(feline.getFood("Хищник")).thenReturn(Meat);
        Assert.assertEquals(Meat, lion.getFood());
    }

    @Test
    public void getKittensForLionReturnsKittensCountTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Mockito.when(feline.getKittens()).thenReturn(5);
        Assert.assertEquals(5, lion.getKittens());
    }

}
