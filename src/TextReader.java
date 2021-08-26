import java.util.HashMap;
import static java.lang.Character.isLetter;
import static java.lang.Character.isDigit;

public class TextReader {
    
    private String[] words_array;

    public TextReader() {
        this.words_array = null;
    }

    public int get_words_number() {
        if (words_array != null) {
            return words_array.length;
        }else {
            return 0;
        }
    }

    public void setDataBytes(byte[] data_bytes) {
        if (data_bytes != null) this.words_array = new String(data_bytes).split("[\\s]");
    }

    public HashMap<String, Integer> get_words_dict() {
        HashMap <String, Integer> hmap = new HashMap<>();
        if (words_array != null) {
            for (String s : words_array) {
                if (!s.equals("")) {
                    if (isLetter(s.charAt(0)) | (isDigit(s.charAt(0)))) { 
                        if (hmap.containsKey(s.toLowerCase())){
                            Integer word_count = hmap.get(s.toLowerCase());
                            hmap.put(s.toLowerCase(), word_count+1);
                        } else {
                            hmap.put(s.toLowerCase(), 1);
                        }
                    }
                }
            }
        }
        return hmap;
    }
}
