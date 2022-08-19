package exception;

public class Error {
    public static void main(String[] args) {
        Page page = new Page();
        PageManager.delete(page);
    }
}