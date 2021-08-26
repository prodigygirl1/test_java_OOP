import java.util.*;
import java.util.HashMap;


public class App
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input_url = scanner.nextLine();
        scanner.close();
        ReaderFile fr = new ReaderFile();
        fr.setFile_path(input_url);
        byte[] data_bytes = fr.get_file();
        TextReader tr = new TextReader();
        tr.setDataBytes(data_bytes);
        System.out.println("Количество слов: " + tr.get_words_number());
        HashMap<String, Integer> hmap = tr.get_words_dict();
        if (hmap.isEmpty()) {
            System.out.println("Not found.");
        } else {
            hmap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
        }
        }
    }