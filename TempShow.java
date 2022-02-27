
/**
 * PLACEHOLDER CLASS FOR SHOW CLASS
 * @author Danny
 *
 */
public class TempShow implements IShow {

  private String name;
  private int year;
  private int rating;
  private boolean Netflix;
  private boolean Hulu;
  private boolean PrimeVid;
  private boolean Disney;


  /**
   * Constructor that includes all necessary information of a show
   * 
   * @param name title of show
   * @param year release year
   * @param rating rating of show
   * @param Netflix availability on Netflix
   * @param Hulu availability on Hulu
   * @param PrimeVid availability on Prime Video
   * @param Disney availability on Disney+
   */
  public TempShow(String name, int year, int rating, boolean Netflix, boolean Hulu,
      boolean PrimeVid, boolean Disney) {
    this.name = name;
    this.year = year;
    this.rating = rating;
    this.Netflix = Netflix;
    this.Hulu = Hulu;
    this.PrimeVid = PrimeVid;
    this.Disney = Disney;
  }

  @Override
  public int compareTo(IShow o) {
    return this.rating - o.getRating();
  }

  @Override
  public String getTitle() {
    return this.name;
  }

  @Override
  public int getYear() {
    return this.year;
  }

  @Override
  public int getRating() {
    return this.rating;
  }

  @Override
  /**
   * Hard coded method that checks if the a show is available on a specific provider
   */
  public boolean isAvailableOn(String provider) {
    switch (provider) {
      case "Netflix":
        return this.Netflix;
      case "Hulu":
        return this.Hulu;
      case "Prime Video":
        return this.PrimeVid;
      case "Disney+":
        return this.Disney;
      default:
        return false;
    }
  }

  @Override
  public String toString() {
    return this.name;
  }

}
