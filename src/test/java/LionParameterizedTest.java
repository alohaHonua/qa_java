import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final Boolean result;
    Feline feline;

    public LionParameterizedTest (String sex, Boolean result) throws Exception {
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

}
