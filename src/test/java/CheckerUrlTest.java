import org.junit.Test;
import org.junit.Assert;

public class CheckerUrlTest extends Assert {
    @Test
    public void url_is_correct_true () {
        String test_correct_url = "https://yandex.ru/";
        CheckerUrl checker = new CheckerUrl(test_correct_url);
        Assert.assertTrue(checker.url_is_correct());
    }

    @Test
    public void url_is_correct_false () {
        String test_correct_url = "fjsdjfkjdk";
        CheckerUrl checker = new CheckerUrl(test_correct_url);
        Assert.assertFalse(checker.url_is_correct());

        test_correct_url = "1111111";
        checker = new CheckerUrl(test_correct_url);
        Assert.assertFalse(checker.url_is_correct());
    }
}