import java.io.FileNotFoundException;

// --== CS400 Project One W3 ==--
// Name: Mojtaba Javid
// Role: Data Wrangler
// CSL Username: mojtaba
// Email: javid2@wisc.edu
// Lecture #: 002 @1:00pm

public class DataWranglerTests {
	//constructors 
	public static Show a = new Show("Rick & Morty", 2013, 100, "Netflix, Hulu");
	public static Show b = new Show("Whitcher", 2019, 96, "Netflix, Disney+");
	public static Show c = new Show("Sherlock", 2011, 100, "Prime video, Disney+");
	
	//accessors
	public static boolean test1() {
		if(!a.getTitle().equals("Rick & Morty")) return false;
		if(b.getYear() != 2019) return false;
		if(c.getRating() != 100) return false;
		
		return true;
	}
	
	//compareTo & Availability
	public static boolean test2() {
		if(a.compareTo(b) != 1) return false;
		if(b.compareTo(c) != -1) return false;
		if(c.compareTo(a) != 0) return false;
		
		if(!a.isAvailableOn("hUlu")) return false;
		if(b.isAvailableOn("hulu")) return false;
		
		return true;
	}
	
	//Showloader constructor
	public static boolean test3() {
		ShowLoader showLoader = new ShowLoader();
		try {
			showLoader.loadShows("/home/javid2/Project1_BU_red/tv_shows.csv");
		} catch (FileNotFoundException e) {
			return false;
		} 
		
		return true;
	}
	
	//showloader helpers tests
	public static boolean test4() {
		ShowLoader sl = new ShowLoader();
		try {
			sl.loadShows("/home/javid2/Project1_BU_red/tv_shows.csv");
		} catch (FileNotFoundException e) {
			return false;
		} 
		
		Show t = sl.ShowObject("196,197,The Staircase,2005,16+,7.9/10,74/100,1,0,0,0,1");
		
		if(!t.getTitle().equals("The Staircase") ||
			t.getRating() != 74 || t.getYear() != 2005
			|| !t.isAvailableOn("Netflix")) return false;
		
		return true;
	}
	
	//variants and errors
	public static boolean test5() {
		ShowLoader sl = new ShowLoader();
		ShowLoader s2 = new ShowLoader();
		
		Show t = s2.ShowObject("196,197,\"The ,Staircase\",2005,16+,7.9/10,74/100,1,0,0,0,1");
		Show t2 = s2.ShowObject("196,197,\"\"The ,Staircase\"\",2005,16+,7.9/10,74/100,1,0,0,0,1");
		Show t3 = s2.ShowObject("1065,1068,\"Nicky, Ricky, Dicky & Dawn\",2014,all,5.2/10,51/100,1,0,0,0,1");
		
		if(!t.getTitle().equals("The ,Staircase") || !t2.getTitle().equals("\"The ,Staircase\"") || !t3.getTitle().equals("Nicky, Ricky, Dicky & Dawn")) return false;
		
		try {
			sl.loadShows("/home/javid2/Project1_BU_red/tv_sho.csv");
		} catch (FileNotFoundException e) {
			return true;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("1: " + test1() + "   2: " + test2() + "   3: " + test3() + "   4: " + test4() + "   5: " + test5());
	}
}
