
public class CheckerUrl {
    String path_to_check;
    
    public CheckerUrl(String path) {
        this.path_to_check = path;
    }
    
    public boolean url_is_correct() {
        return this.path_to_check != null && this.path_to_check.matches("^(https?|ftp|file)://" +
                "[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    }
}