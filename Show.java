
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRating() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAvailableOn(String provider) {
		// TODO Auto-generated method stub
		return false;
	}

}
