import java.io.IOException.*;
import java.util.*;

public class Bot implements SpamBot {
	private String seed;
	private Set<String> emailSet = new HashSet<String>();
	private Set<String> visitedLinks = new HashSet<String>();
	private int threadCount;
	
	
	public void setSeed(String seedUrl) {
		//try {
			this.seed = seedUrl;
		//}
		//catch (MalformedURLException ex) {
		//	System.out.println("Invalid url; please try again: ");
		//	String seed = System.console().readLine();
		//	setSeed(seed);
	//	}
	}
	
	public void setThreads(int count) {
		threadCount = count;
	}	
	
	public Set<String> getEmails() {
		return emailSet;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Bot spamBot = new Bot();
		spamBot.launch();
		
	}
	
	private void launch() {
		
		System.out.println("--SPAMBOT--");
		System.out.print("Enter a seed: ");
		String seed = System.console().readLine();
		setSeed(seed);
		System.out.print("Enter the number of crawlers to use: ");
		int num = Integer.parseInt(System.console().readLine());
		setThreads(num);
		this.scanSite();
		
	}
	
	public void scanSite() {
	//launch crawler from here. When multithreaded, launch its threads - pass thread
	//count to Crawler class to set number of threads.
		
		
		
	}
	
}