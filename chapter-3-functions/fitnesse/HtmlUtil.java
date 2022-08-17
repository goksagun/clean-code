package fitnesse;

/**
 * HtmlUtil
 */
public class HtmlUtil {

    public static void main(String[] args) {
        PageData pageData = new PageData();
        try {
            System.out.println(testableHtml(pageData, false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String testableHtml(PageData pageData, boolean isSuite) throws Exception {
        boolean isTestPage = pageData.hasAttritube("Test");
        if (isTestPage) {
            WikiPage testPage = pageData.getWikiPage();
            StringBuffer newPageContent = new StringBuffer();
            includeSetupPages(testPage, newPageContent, isSuite);
            newPageContent.append(pageData.getContent());  
            includeTeardownPages(testPage, newPageContent, isSuite);
            pageData.setContent(newPageContent.toString());
        }
        return pageData.getHtml();
    }

    private static void includeSetupPages(WikiPage testPage, StringBuffer newPageContent, boolean isSuite) {
        if (isSuite) {
            WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(
                SuiteResponder.SUITE_SETUP_NAME, testPage
            );
            if (suiteSetup != null) {
                WikiPagePath pagePath = suiteSetup.getPageCrawler().getFullPath(suiteSetup);
                String pagePathName = PathParser.render(pagePath);
                newPageContent.append("!include -setup .")
                    .append(pagePathName)
                    .append("\n");
            }
        }
        WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", testPage);
        if (setup != null) {
            WikiPagePath setupPath = testPage.getPageCrawler().getFullPath(setup);
            String setupPathName = PathParser.render(setupPath);
            newPageContent.append("!include -setup .")
                .append(setupPathName)
                .append("\n");
        }
    }

    private static void includeTeardownPages(WikiPage testPage, StringBuffer newPageContent, boolean isSuite) {
        WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", testPage);
        if (teardown != null) {
            WikiPagePath tearDownPath = testPage.getPageCrawler().getFullPath(teardown);
            String tearDownPathName = PathParser.render(tearDownPath);
            newPageContent.append("\n")
                .append("!include -teardown .")
                .append(tearDownPathName)
                .append("\n");
        }
        if (isSuite) {
            WikiPage suiteTearDown = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_TEARDOWN_NAME, testPage);
            if (suiteTearDown != null) {
                WikiPagePath pagePath = suiteTearDown.getPageCrawler().getFullPath(suiteTearDown);
                String pagePathName = PathParser.render(pagePath);
                newPageContent.append("!include -teardown. ")
                    .append(pagePathName)
                    .append("\n");
            }
        }
    }
    
} 