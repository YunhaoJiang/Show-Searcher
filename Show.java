
public class Show implements IShow{
	protected final String Title;
	protected final int Year;
	protected int Rating;
	protected String Providers;
	
	public Show(String title, int year, int rating, String providers) {
		this.Title=title;
		this.Year=year;
		this.Rating=rating;
		this.Providers=providers;
	}

	
	public int compareTo(IShow o) {
		if(this.Rating > o.getRating()) return 1;
		else if(this.Rating < o.getRating()) return -1;
		return 0;
	}

	@Override
	public String getTitle() {
		return this.Title;
	}

	@Override
	public int getYear() {
		return this.Year;
	}

	@Override
	public int getRating() {
		return this.Rating;
	}

	@Override
	public boolean isAvailableOn(String provider) {
		return this.Providers.contains(provider);
	}

}
