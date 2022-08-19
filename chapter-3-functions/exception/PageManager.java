package exception;

public class PageManager {
    private static final String E_OK = "OK";
    private static final String E_ERROR = "ERROR";
    
    private static Registry registry;
    private static Logger logger;
    private static ConfigKeyList configKeys;
    
    public static String delete(Page page) {
        if (deletePage(page) == E_OK) {
            if (registry.deleteReference(page.name) == E_OK) {
                if (configKeys.deleteKey(page.name.makeKey()) == E_OK) {
                    logger.log("page deleted");
                } else {
                    logger.log("configKey not deleted");
                }
            } else {
                logger.log("deleteReference from registry failed");
            }
        } else {
            logger.log("delete failed");
            return E_ERROR;
        }
        return null;
    }

    private static String deletePage(Page page) {
        return null;
    }
}
