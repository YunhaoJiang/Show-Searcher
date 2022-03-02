import java.io.FileNotFoundException;
import java.util.List;

/**
 * Represents the main class that will be run
 * 
 * @author Danny
 *
 */
public class ShowSearcherApp {

  public static void main(String[] args) {
    
    IShowLoader loader = new ShowLoader(); //new ShowLoader();
    List<IShow> shows = null;
    try {
      shows = loader.loadShows("tv_shows.csv");
    } catch (FileNotFoundException e) {
      System.out.println("Error File Not Found");
      e.printStackTrace();
    }
    ShowSearcherBackend backend = new ShowSearcherBackend(); //new ShowSearcherBackend();
    for(IShow show : shows) backend.addShow(show);
    IShowSearcherFrontend frontend = new ShowSearcherFrontend(backend); //new ShowSearcherFrontend(backend);
    frontend.runCommandLoop();
  }
}
