import org.junit.Test;
import org.junit.Assert;

public class ReaderFileTest extends Assert{
    @Test
    public void setFile_path_url_test() {
        String test_filepath = "http://madbrains.github.io/java_course_test";
        ReaderFile rf = new ReaderFile();
        rf.setFile_path(test_filepath);
        Assert.assertEquals(rf.getFile_path(), test_filepath);
    }
    @Test
    public void setFile_path_localfile_test() {
        String test_filepath = "./test-files/data.txt";
        ReaderFile rf = new ReaderFile();
        Assert.assertTrue(rf.setFile_path(test_filepath));
        Assert.assertEquals(rf.getFile_path(), test_filepath);
    }
    @Test
    public void setFile_path_incorrect_localfile_test() {
        String test_filepath = "./test-files/dfhuduhdhfd.txt";
        ReaderFile rf = new ReaderFile();
        Assert.assertFalse(rf.setFile_path(test_filepath));
        Assert.assertNull(rf.getFile_path());
    }
    @Test
    public void setFile_path_incorrect_test() {
        String test_filepath = "fdokfdokfodk";
        ReaderFile rf = new ReaderFile();
        rf.setFile_path(test_filepath);
        Assert.assertNull(rf.getFile_path());

        test_filepath = "";
        rf = new ReaderFile();
        rf.setFile_path(test_filepath);
        Assert.assertNull(rf.getFile_path());

        test_filepath = "1230";
        rf = new ReaderFile();
        rf.setFile_path(test_filepath);
        Assert.assertNull(rf.getFile_path());
        
    }
    @Test
    public void get_file_incorrect_test() {
        String test_filepath = "fdokfdokfodk";
        ReaderFile rf = new ReaderFile();
        rf.setFile_path(test_filepath);
        Assert.assertNull(rf.get_file());
    }

    @Test
    public void get_file_correct_test() {
        String test_filepath = "http://madbrains.github.io/java_course_test";
        ReaderFile rf = new ReaderFile();
        rf.setFile_path(test_filepath);
        Assert.assertNotNull(rf.get_file());
    }

}
