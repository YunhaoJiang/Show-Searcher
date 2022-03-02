// --== CS400 Project One W3 ==--
// Name: Mojtaba Javid
// Role: Data Wrangler
// CSL Username: mojtaba
// Email: javid2@wisc.edu
// Lecture #: 002 @1:00pm

public class Show implements IShow{
	protected final String Title;
	protected final int Year;
	protected int Rating;
	protected String Providers;
	
	/**
	 * Initializes a show object of the given details
	 * @param title, year, rating, availability/provider
	 */
	public Show(String title, int year, int rating, String providers) {
		this.Title=title;
		this.Year=year;
		this.Rating=rating;
		this.Providers=providers;
	}

	/**
	 * compares the 2 shows by their rotten tomato rating
	 * @param show being compared to
	 * @return 0 for being equal, 1 for being better, -1 for being worse
	 */
	@Override
	public int compareTo(IShow o) {
		if(this.Rating > o.getRating()) return 1;
		else if(this.Rating < o.getRating()) return -1;
		return 0;
	}

	/**
	 * retrieve the title of this show object
	 * @return title
	 */
	@Override
	public String getTitle() {
		return this.Title;
	}

	/**
	 * retrieve the year this show war first produced
	 * @return year
	 */
	@Override
	public int getYear() {
		return this.Year;
	}

	/**
	 * retrieve the rotten tomato rating of this show object
	 * @return rating
	 */
	@Override
	public int getRating() {
		return this.Rating;
	}

	/**
	 * checks the availability of the show based on its Provider field
	 * @return true if available
	 */
	@Override
	public boolean isAvailableOn(String provider) {
		String p = provider.toLowerCase();
		String a = this.Providers.toLowerCase();
		//to avoid any unforeseen bug or input
		
		return a.contains(p);
	}

>>>>>>> DataWrangler
}
