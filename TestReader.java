import java.util.*;

public class TestReader {
	private static int linksCount = 0;
    private String url;
    // Current list of lines from the webpage.
    private List<String> pageLines = new ArrayList<String>();
    
    public TestReader(String url) {
        this.url = url;
        linksCount++;
    }
            
    public String getUrl() {
        return url;
    }
    
    public static int getCount() {
    	return linksCount;
    }
    
    public Set<String> getLinks() {
        Set<String> myLinkSet = new HashSet<String>();
        myLinkSet.add("www.1.com");
        myLinkSet.add("www.2.com");
        return myLinkSet;
    }
    
    public Set<String> getEmails() {
        Set<String> myEmailSet = new HashSet<String>();
        myEmailSet.add("avictaylor@hotmail.com");
        myEmailSet.add("avictaylor@gmail.com");
        return myEmailSet;
    }
}