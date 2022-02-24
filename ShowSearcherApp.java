import java.util.List;

/**
 * Represents the main class that will be run
 * 
 * @author Danny
 *
 */
public class ShowSearcherApp {

  public static void main(String[] args) {
    
    IShowLoader loader = new TempShowLoader(); //new ShowLoader();
    List<IShow> shows = loader.loadShows("data/tv_shows.csv");
    ShowSearcherBackend backend = new ShowSearcherBackend(); //new ShowSearcherBackend();
    for(IShow show : shows) backend.addShow(show);
    IShowSearcherFrontend frontend = new TempShowSearcherFrontend(backend); //new ShowSearcherFrontend(backend);
    frontend.runCommandLoop();
  }
}
