import java.util.*;
import java.io.*;

public class Crawler  {
	private Set<String> links = null;
	private Set<String> visitedLinks = new HashSet<String>();
	private Set<String> emails = null;
	private Set<String> subLinkSet = null; //for testing purposes
	private int threadCount = 0;
	
	public Crawler(String url) { //adds seed website upon construction of crawler.
		links = new HashSet<String>();
		links.add(url);
	}
	
	public Crawler() { 
		super();
	}
	
	public setThreadCount(int count) {
		this.threadCount = count;
	}
	
	public set<String> getLinks() {
		return links;
	}
	
	public set<String> getVisited() {
		return visitedLinks;
	}
	
	public set<String> getEmails() {
		return emails;
	}	
	
	private synchronized void addLinks(Set<String> linkSubSet) {
		if (!visitedLinks.isEmpty()) {
			Iterator<String> itr = linkSubSet.iterator();
			while (itr.hasNext()) {
				if (visitedLinks.contains(itr.next())) {
					linkSubSet.remove(itr.next());
				}
			}
		}
		else {			
			links.addAll(linkSubSet);
		}
	}
	
	
	private synchronized void addEmails(Set<String> subEmailSet) {
		if (emails == null) {
			emails = new HashSet<String>();
			emails.addAll(subEmailSet);
		}
		else {
			emails.addAll(subEmailSet);
		}
	}
	
	private synchronized void addToVisitedSet(String url) {
		if (visitedLinks == null) {
			visitedLinks = new HashSet<String>();
			visitedLinks.add(url);
		}
		else {
			visitedLinks.add(url);
		}
	}
	
	private synchronized void printVisited() {
		Iterator itr = visitedLinks.iterator();
		System.out.println("VISITED");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	private synchronized void printEmails() {
		Iterator itr = emails.iterator();
		System.out.println("EMAILS");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	private synchronized void printLinks() {
		Iterator itr = links.iterator();
		System.out.println("LINKS");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
					
			
	
				
	/**
	public static void main(String[] args) {
	
		Crawler crawler = new Crawler();
		crawler.launch();
	}
	*/
	
	public void launch() { //change to run() for multi-threading
	//launch method will only contain Thread initialisation.
	
		/**
		* Test: OK
		subLinkSet = new HashSet<String>();
		subLinkSet.add("Hello");
		subLinkSet.add("item1");
		subLinkSet.add("item2");		
		
		this.addLinks(subLinkSet);
		*/

		/**
		* For each link in the main set, invokes a PageReader to visit the link and parse the page,
		* while the set of links isn't empty and the number of sites visited is less than 51.
		*/
		
		Iterator<String> iterator = links.iterator(); //at this point iterator only has bbk.ac.uk, hence it gets reassigned at end of loop to include updated links.
		while (iterator.hasNext() && TestReader.getCount() <= 50) {		
			String element = iterator.next();
			//System.out.println(element); //test print
			TestReader testReader = new TestReader(element);			
			addEmails(testReader.getEmails()); 
			addLinks(testReader.getLinks());
			addToVisitedSet(element);
			this.printEmails();
			this.printLinks();
			this.printVisited();
			links.remove(element);
			iterator = links.iterator();
		}
		
		/**
		Iterator<String> iterator = Bot.getLinkSet().iterator(); //at this point iterator only has bbk.ac.uk, hence it gets reassigned at end of loop to include updated links.
		while (iterator.hasNext() && TestReader.getCount() <= 50) {		
			String element = iterator.next();
			//System.out.println(element); //test print
			TestReader testReader = new TestReader(element);			
			Bot.addEmails(testReader.getEmails()); 
			Bot.addLinks(testReader.getLinks());
			Bot.addToVisitedSet(element);
			Bot.getLinkSet().remove(element);
			iterator = Bot.getLinkSet().iterator();
		}
		*/
		
		
		
	
		
	
	
	
		
		
			
	}
}

/**
* Add threading -- this class will implement Runnable
* Deal with unchecked exception handling.
*/







/**
First, they need to know / remember all the links to be visited;
they also need to know / remember those links that have already been visited,
so as to not visit and parse the same page twice. 
The third type of data they need to store are the emails they get from webpages.
Crawlers need a way to terminate their execution.
It is up to you to decide when crawlers will
end. Some possibilities for your considerations are time limits, number of email addresses found,
number of unsuccessful attempts to read a link, or to find new links.
In a first stage of design, it may help to have only one active crawler (i.e. one thread). Once the
functionality is ready, you should be able to span several crawlers in parallel, all of them sharing the
information described above. You should at least launch a crawler per processor in your machine2,
and possibly more, because I/O waits over the network connection will make your crawlers waste
a lot of time.
*/
			
	
