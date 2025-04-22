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

    @Test (expected = Exception.class)
    public void doesLionHasManeThrowsExceptionTest() throws Exception {
        try
        {
            Lion lion = new Lion("1", feline);
        }
        catch(Exception exception)
        {
            String message = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(message, exception.getMessage());
            throw exception;
        }
        fail("Wrong argument exception did not throw!");
    }

    @Test
    public void getFoodForLionReturnsMeatTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
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
