import com.example.Alex;
import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

public class AlexTest {

    Feline feline;

    @Test
    public void getKittensForAlexReturnsZeroTest() throws Exception {
        Alex lionAlex = new Alex(feline);
        Assert.assertEquals(0, lionAlex.getKittens());
    }

    @Test
    public void getPlaceOfLivingForAlexReturnsNewYorkZooTest() throws Exception {
        Alex lionAlex = new Alex(feline);
        Assert.assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    public void getFriendsForAlexReturnsFriendsListTest() throws Exception {
        Alex lionAlex = new Alex(feline);
        Assert.assertEquals(List.of("Марти", "Глория", "Мелман"), lionAlex.getFriends());
    }

    @Test
    public void doesHaveAlexManeReturnsTrue() throws Exception {
        Alex lionAlex = new Alex(feline);
        MatcherAssert.assertThat(lionAlex.doesHaveMane(), is(true));
    }

}
