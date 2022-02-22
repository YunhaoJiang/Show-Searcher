
import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder class for backend objects not included in the git
 */
public class ShowSearcherBackend implements IShowSearcherBackend{
  @Override
  public void addShow(IShow show) {

  }

  @Override
  public int getNumberOfShows() {
    return 4;
  }

  @Override
  public void setProviderFilter(String provider, boolean filter) {

  }

  @Override
  public boolean getProviderFilter(String provider) {
    if (provider.equals("Netflix")){
      return true;
    }
    if (provider.equals("Prime Video")){
      return false;
    }
    if (provider.equals("Hulu")){
      return true;
    }
    if (provider.equals("Disney+")){
      return false;
    }
    return false;
  }

  @Override
  public void toggleProviderFilter(String provider) {
  }

  @Override
  public List<IShow> searchByTitleWord(String word) {
    List<IShow> shows = new ArrayList<>();
    shows.add(new Show("Test1",2000,50,"Netflix"));
    shows.add(new Show("Test2",2001,51,"Prime Video"));
    return shows;
  }

  @Override
  public List<IShow> searchByYear(int year) {
    List<IShow> shows = new ArrayList<>();
    shows.add(new Show("Test3",2000,50,"Netflix"));
    shows.add(new Show("Test4",2001,51,"Prime Video"));
    return shows;
  }
}
