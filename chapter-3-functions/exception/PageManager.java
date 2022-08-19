package exception;

public class PageManager {
    private static Registry registry;
    private static Logger logger;
    private static ConfigKeyList configKeys;
    
    public static void delete(Page page) {
        try {
            deletePageAndAllReferences(page);
        }
        catch (Exception e) {
            logError(e);
        }
    }

    private static void deletePageAndAllReferences(Page page) throws Exception {
        deletePage(page);
        registry.deleteReference(page.name);
        configKeys.deleteKey(page.name.makeKey());
    }

    private static void deletePage(Page page) throws Exception {
    }

    private static void logError(Exception e) {
        logger.log(e.getMessage());
    }
}
