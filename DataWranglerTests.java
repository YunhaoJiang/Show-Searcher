import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

// --== CS400 Project One W3 ==--
// Name: Mojtaba Javid
// Role: Data Wrangler
// CSL Username: mojtaba
// Email: javid2@wisc.edu
// Lecture #: 002 @1:00pm

public class DataWranglerTests {
	//constructors 
	public static Show a = new Show("Rick & Morty", 2013, 100, "Netflix, Hulu");
	public static Show b = new Show("Witcher", 2019, 96, "Netflix, Disney+");
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
			showLoader.loadShows("tv_shows.csv");
		} catch (FileNotFoundException e) {
			return false;
		} 
		
		return true;
	}
	
	//showloader helpers tests
	public static boolean test4() {
		ShowLoader sl = new ShowLoader();
		try {
			sl.loadShows("tv_shows.csv");
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

        //test using Backend code
        public static boolean test6() {
		ShowLoader s2 = new ShowLoader();
		
		Show t = s2.ShowObject("196,197,\"The ,Staircase\",2005,16+,7.9/10,74/100,1,0,0,0,1");
		Show t2 = s2.ShowObject("196,197,\"\"The ,Staircase\"\",2005,16+,7.9/10,74/100,1,0,0,0,1");
		Show t3 = s2.ShowObject("1065,1068,\"Nicky, Ricky, Dicky & Dawn\",2014,all,5.2/10,51/100,1,0,0,0,1");
		
		ShowSearcherBackend test = new ShowSearcherBackend();
		test.addShow(t);
		test.addShow(t2);
		test.addShow(t3);
		
		if(!test.searchByTitleWord("The").contains(t) || !test.searchByTitleWord("\"The").contains(t2)) return false;
		if(!test.searchByYear(2014).contains(t3)) return false;
		
		return true;
	}

        //test using AE HashtableMap
	public static boolean test7() {
		ShowLoader s2 = new ShowLoader();
		
		Show t = s2.ShowObject("196,197,\"The ,Staircase\",2005,16+,7.9/10,74/100,1,0,0,0,1");
		Show t2 = s2.ShowObject("196,197,\"\"The ,Staircase\"\",2005,16+,7.9/10,74/100,1,0,0,0,1");
		Show t3 = s2.ShowObject("1065,1068,\"Nicky, Ricky, Dicky & Dawn\",2014,all,5.2/10,51/100,1,0,0,0,1");
		
		HashtableMap<Integer, Show> test = new HashtableMap<Integer, Show>(19);
		if(!test.put(t.Year, t)) return false;
		if(!test.put(t2.Year, t2)) return false;
		if(!test.put(t3.Year, t3)) return false;
		try {
			test.get(t.Year);
			test.get(t3.Year);
			test.get(t2.Year);
		} catch (NoSuchElementException e) {
			return false;
		}
		
		return true;
	}


        //test for backend [title search]
	public static boolean test8() {
		ShowSearcherBackend test = new ShowSearcherBackend();
		test.addShow(a);
		test.addShow(b);
		test.addShow(c);
		
		if(!test.searchByTitleWord("Rick").contains(a) || !test.searchByTitleWord("Witcher").contains(b) 
				|| !test.searchByTitleWord("&").contains(a) || !test.searchByTitleWord("Sherlock").contains(c)) return false;
		
		return true;
	}
	
	//test for backend [year search]
	public static boolean test9() {
		ShowSearcherBackend test = new ShowSearcherBackend();
		test.addShow(a);
		test.addShow(b);
		test.addShow(c);
		
		if(!test.searchByYear(2013).contains(a) || !test.searchByYear(2019).contains(b) || !test.searchByYear(2011).contains(c)) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("1: " + test1() + "   2: " + test2() + "   3: " + test3() + "   4: " + test4() + "   5: " + test5()
		+ "   6(additional): " + test6() + "   7(additional): " + test7() + "   8(additional for BED): " + test8() + "   9(additional for BED): " + test9());
	}
}
