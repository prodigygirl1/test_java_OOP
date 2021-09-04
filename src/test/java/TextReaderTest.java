
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.nio.charset.StandardCharsets;

public class TextReaderTest extends Assert {
    @Test
    public void get_words_number_correct_test () {
        TextReader tr = new TextReader();
        String test_string_data = "fuhd fd uf";
        byte[] test_byte_data = test_string_data.getBytes(StandardCharsets.UTF_8);
        tr.setDataBytes(test_byte_data);
        Assert.assertEquals(tr.get_words_number(), test_string_data.split("[\\s]").length);
    }
    @Test
    public void get_words_number_incorrect_test () {
        TextReader tr = new TextReader();
        tr.setDataBytes(null);
        Assert.assertEquals(tr.get_words_number(), 0);
    }
    @Test
    public void get_words_dict_test () {
        TextReader tr = new TextReader();
        String test_string_data = "hello world";
        HashMap<String, Integer> hmap_correct_data = new HashMap<>();
        hmap_correct_data.put("hello", 1);
        hmap_correct_data.put("world", 1);
        byte[] test_byte_data = test_string_data.getBytes(StandardCharsets.UTF_8);
        tr.setDataBytes(test_byte_data);
        HashMap<String, Integer> hmap_res = tr.get_words_dict();
        Assert.assertEquals(hmap_res, hmap_correct_data);

    }
    @Test
    public void setDataBytes_incorrect_test () {
        TextReader tr = new TextReader();
        tr.setDataBytes(null);
        Assert.assertNull(tr.words_array);
    }

    @Test
    public void setDataBytes_correct_test () {
        TextReader tr = new TextReader();
        String test_text = "fuhd fd uf";
        byte[] test_data = test_text.getBytes(StandardCharsets.UTF_8);
        tr.setDataBytes(test_data);
        Assert.assertEquals(tr.words_array, Arrays.asList(test_text.split("[\\s]")));
    }
}
