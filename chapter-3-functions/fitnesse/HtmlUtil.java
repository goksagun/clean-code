package fitnesse;
/**
 * HtmlUtil
 */
public class HtmlUtil {

    public static void main(String[] args) {
        PageData pageData = new PageData();
        try {
            System.out.println(SetupTeardownIncluder.render(pageData, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
} 