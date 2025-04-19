import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final Boolean result;

    public LionTest (String sex, Boolean result) throws Exception {
        this.sex = sex;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] hasMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesLionHasManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        MatcherAssert.assertThat(lion.doesHaveMane(), is(result));
    }

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

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getFoodForLionReturnsMeat() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getKittensForLionReturnsKittensCount() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Mockito.when(feline.getKittens()).thenReturn(5);
        Assert.assertEquals(5, lion.getKittens());
    }

}
