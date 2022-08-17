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

    public static String testableHtml(PageData pageData, boolean includeSuitSetup) throws Exception {
        WikiPage wikiPage = pageData.getWikiPage();
        StringBuffer buffer = new StringBuffer();
        if (pageData.hasAttritube("Test")) {
            if (includeSuitSetup) {
                WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(
                    SuiteResponder.SUITE_SETUP_NAME, wikiPage
                );
                if (suiteSetup != null) {
                    WikiPagePath pagePath = suiteSetup.getPageCrawler().getFullPath(suiteSetup);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -setup .")
                        .append(pagePathName)
                        .append("\n");
                }
            }
            WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
            if (setup != null) {
                WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
                String setupPathName = PathParser.render(setupPath);
                buffer.append("!include -setup .")
                    .append(setupPathName)
                    .append("\n");
            }
        }
        buffer.append(pageData.getContent());
        if (pageData.hasAttritube("Test")) {
            WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
            if (teardown != null) {
                WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
                String tearDownPathName = PathParser.render(tearDownPath);
                buffer.append("\n")
                    .append("!include -teardown .")
                    .append(tearDownPathName)
                    .append("\n");
            }
            if (includeSuitSetup) {
                WikiPage suiteTearDown = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage);
                if (suiteTearDown != null) {
                    WikiPagePath pagePath = suiteTearDown.getPageCrawler().getFullPath(suiteTearDown);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -teardown. ")
                        .append(pagePathName)
                        .append("\n");
                }
            }
        }
        pageData.setContent(buffer.toString());
        return pageData.getHtml();
    }
    
} 