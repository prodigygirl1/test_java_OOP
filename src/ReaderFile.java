import java.io.*;
import java.net.URL;
import java.io.File;

public class ReaderFile {
    String file_path;
    PathType path_type;

    public ReaderFile() {
            this.file_path = null;
            this.path_type = PathType.NONE;
    }

    public byte[] get_file() {
        try {
            byte[] data_bytes;
            if (path_type == PathType.URL) {
                InputStream ins = new URL(this.file_path).openStream();
                data_bytes = ins.readAllBytes();
            } else if (path_type == PathType.LOCAL_FILE) {
                FileInputStream ins = new FileInputStream(this.file_path);
                data_bytes = ins.readAllBytes();
                ins.close();
            } else {
                return null;
            }
            return data_bytes; 
        } catch (IOException e) {
            return null;
        }
    }

    public boolean setFile_path(String file_path) {
        CheckerUrl checker = new CheckerUrl(file_path);
        File file = new File(file_path);
        if (checker.url_is_correct()) {
            this.path_type = PathType.URL;
            this.file_path = file_path;
            return true;
        } else if (file.exists()) {
            this.path_type = PathType.LOCAL_FILE;
            this.file_path = file_path;
            return true;
        }
        return false;
    }
    public String getFile_path() {
        return file_path;
    }

    
}
