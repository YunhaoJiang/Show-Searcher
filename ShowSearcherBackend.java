import java.util.LinkedList;
import java.util.List;

public class ShowSearcherBackend implements IShowSearcherBackend {

  private TempHashTableSortedSets<String, IShow> titleSet;
  private TempHashTableSortedSets<Integer, IShow> yearSet;
  private boolean Netflix;
  private boolean Hulu;
  private boolean PrimeVid;
  private boolean Disney;

  /**
   * Default constructor instantiates titleSet and yearSet HashtableMaps. Also sets all provider
   * filters to true by default
   */

  public ShowSearcherBackend() {
    titleSet = new TempHashTableSortedSets<String, IShow>();
    yearSet = new TempHashTableSortedSets<Integer, IShow>();
    this.Netflix = true;
    this.Hulu = true;
    this.PrimeVid = true;
    this.Disney = true;
  }

  /**
   * Private helper method that filters a list of shows based on the current provider settings
   * 
   * @param shows shows to be filtered
   * @return filtered shows
   */
  private List<IShow> filterShows(List<IShow> shows) {

    // List to be returned
    LinkedList<IShow> filterList = new LinkedList<IShow>();
    // Deep copy of all the shows in the show list
    for (IShow i : shows) {
      filterList.add(i);
    }

    // Filter the copied list
    for (IShow i : shows) {
      i = (TempShow) i;
      if (!this.Netflix) {
        if (i.isAvailableOn("Netflix")) {
          filterList.remove(i);
        }
      }
      if (!this.Hulu) {
        if (i.isAvailableOn("Hulu")) {
          filterList.remove(i);
        }
      }
      if (!this.PrimeVid) {
        if (i.isAvailableOn("Prime Video")) {
          filterList.remove(i);
        }
      }
      if (!this.Disney) {
        if (i.isAvailableOn("Disney+")) {
          filterList.remove(i);
        }
      }
    }

    // return the filtered copied list
    return filterList;
  }

  @Override
  /**
   * Method that adds a show to the database
   * 
   * @param show show to be added
   */
  public void addShow(IShow show) {
    String showTitle = show.getTitle();

    // Splits the title into individual words
    String[] splitTitle = showTitle.split(" ");

    // Add the show to the hashtable corresponding to each word
    for (int i = 0; i < splitTitle.length; i++) {
      titleSet.add(splitTitle[i], show);
    }

    // Adds the show to the hashtable corresponding to the year
    yearSet.add(show.getYear(), show);
  }

  @Override
  /**
   * Method that returns the size of the database
   * 
   * @return database size
   */
  public int getNumberOfShows() {
    return titleSet.size();
  }

  @Override
  /**
   * Method that sets the filter option of a specific provider to a specific value
   * 
   * @param provider provider filter that will be altered
   * @param filter   filter value that will be changed to
   */
  public void setProviderFilter(String provider, boolean filter) {
    if (provider.equals("Netflix")) {
      this.Netflix = filter;
    }
    if (provider.equals("Hulu")) {
      this.Hulu = filter;
    }
    if (provider.equals("Prime Video")) {
      this.PrimeVid = filter;
    }
    if (provider.equals("Disney+")) {
      this.Disney = filter;
    }
  }

  @Override
  /**
   * Method that returns the current filter value of a specific provider
   * 
   * @param provider specified provider
   * @return the filter value of that provider
   */
  public boolean getProviderFilter(String provider) {
    if (provider.equals("Netflix")) {
      return this.Netflix;
    }
    if (provider.equals("Hulu")) {
      return this.Hulu;
    }
    if (provider.equals("Prime Video")) {
      return this.PrimeVid;
    }
    if (provider.equals("Disney+")) {
      return this.Disney;
    }
    return false;
  }

  @Override
  /**
   * Method that changes the selected provider's filter value to it opposite value
   * 
   * @param provider specified providered to be toggled
   */
  public void toggleProviderFilter(String provider) {
    if (provider.equals("Netflix")) {
      this.Netflix = !this.Netflix;
    }
    if (provider.equals("Hulu")) {
      this.Hulu = !this.Hulu;
    }
    if (provider.equals("Prime Video")) {
      this.PrimeVid = !this.PrimeVid;
    }
    if (provider.equals("Disney+")) {
      this.Disney = !this.Disney;
    }
  }

  @Override
  /**
   * Searches and filters according to word in title and providers
   * 
   * @param word keyword to look for
   * @return list of shows with the key word in it and is in the selected providers
   */
  public List<IShow> searchByTitleWord(String word) {
    return filterShows(titleSet.get(word));
  }

  @Override
  /**
   * Searches and filters according to year and providers
   * 
   * @param year to look for
   * @return list of shows made in specified year and is in the selected providers
   */
  public List<IShow> searchByYear(int year) {
    return filterShows(yearSet.get(year));
  }

}
