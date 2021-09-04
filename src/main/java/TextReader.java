
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.lang.Character.isLetter;
import static java.lang.Character.isDigit;

public class TextReader {
    
    List<String> words_array;
    private HashMap<String, Integer> word_dictionary;

    public TextReader() {
        this.words_array = null;
        this.word_dictionary = new HashMap<>();
    }

    public int get_words_number() {
        if (words_array != null) {
            return words_array.size();
        }else {
            return 0;
        }
    }

    public void setDataBytes(byte[] data_bytes) {
        if (data_bytes != null) this.words_array = Arrays.asList(new String(data_bytes).split("[\\s]"));
    }

    public HashMap<String, Integer> get_words_dict() {
        if (words_array != null) {
            this.words_array.forEach(this::add_word_to_dict);
        }
        // без использования Stream API
        /*
        HashMap <String, Integer> hmap = new HashMap<>();
        if (words_array != null) {
            for (String s : words_array) {
                if (!s.isEmpty()) {
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
        */
        return this.word_dictionary;
    }

    private void add_word_to_dict(String s) {
        if (!s.isEmpty()) {
            if (isLetter(s.charAt(0)) | (isDigit(s.charAt(0)))) {
                if (word_dictionary.containsKey(s.toLowerCase())) {
                    Integer word_count = word_dictionary.get(s.toLowerCase());
                    word_dictionary.put(s.toLowerCase(), word_count + 1);
                } else {
                    word_dictionary.put(s.toLowerCase(), 1);
                }
            }
        }
    }
}
