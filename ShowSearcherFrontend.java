// --== CS400 Project One File Header ==--
// Name: Yunhao Jiang
// CSL Username: yunhaoj
// Email: jiang297@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: :)
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ShowSearcherFrontend implements IShowSearcherFrontend {
  Scanner scnr;
  IShowSearcherBackend backend;

  public ShowSearcherFrontend(IShowSearcherBackend backend) {
    this.backend = backend;
    this.scnr = new Scanner(System.in);
  }

  public ShowSearcherFrontend(String input, IShowSearcherBackend backend) {
    this.backend = backend;
    this.scnr = new Scanner(input);
  }

  /**
   * This method drives the entire read, eval, print loop (repl) for the
   * Song Search App.  This loop will continue to run until the user
   * explicitly enters the quit command.
   */
  @Override
  public void runCommandLoop() {
    System.out.println("Welcome to the Show Searcher App!");
    System.out.println("=================================");
    char input;
    do {
      this.displayCommandMenu();
      input = this.scnr.nextLine().toUpperCase().charAt(0);

      if (input == '1' || input == 'T') {
        this.titleSearch();
      }

      if (input == '2' || input == 'Y') {
        this.yearSearch();
      }

      if (input == '3' || input == 'F') {
        this.filterProvider();
      }
    } while (input != 'Q' && input != '4');

  }

  private void filterProvider() {
    char input;
    do {
      this.displayFilterMenu();
      input = this.scnr.nextLine().toUpperCase().charAt(0);

      if (input == '1' || input == 'N') {
        this.backend.toggleProviderFilter("Netflix");
      }

      if (input == '2' || input == 'H') {
        this.backend.toggleProviderFilter("Hulu");
      }

      if (input == '3' || input == 'P') {
        this.backend.toggleProviderFilter("Prime Video");
      }

      if (input == '4' || input == 'D') {
        this.backend.toggleProviderFilter("Disney+");
      }
    } while (input != '5' && input != 'Q');
  }

  private void displayFilterMenu() {
    System.out.println("Providers that shows are being searched for:");
    System.out.println(
        "\t1) " + (this.backend.getProviderFilter("Netflix") ? "_x_" : "___") + " [N]etflix");
    System.out.println(
        "\t2) " + (this.backend.getProviderFilter("Hulu") ? "_x_" : "___") + " [H]ulu");
    System.out.println("\t3) " + (this.backend.getProviderFilter("Prime Video") ? "_x_" : "___")
        + " [P]rime Video");
    System.out.println(
        "\t4) " + (this.backend.getProviderFilter("Disney+") ? "_x_" : "___") + " [D]isney+");
    System.out.println("\t5) [Q]uit toggling provider filters");
    System.out.print("Choose a command from the menu above: ");
  }

  @Override
  public void displayCommandMenu() {
    System.out.println("Command Menu:");
    System.out.println("\t1) Search by [T]itle Word");
    System.out.println("\t2) Search by [Y]ear First Produced");
    System.out.println("\t3) [F]ilter by Streaming Provider");
    System.out.println("\t4) [Q]uit");
    System.out.print("Choose a command from the menu above: ");
  }

  @Override
  public void displayShows(List<IShow> shows) {
    System.out.println("Found " + shows.size() + "/" + backend.getNumberOfShows() + " matches.");
    for (int i = 0; i < shows.size(); i++) {
      IShow currentShow = shows.get(i);
      System.out.println(i + 1 + ". " + currentShow.getTitle());
      System.out.println(
          "\t" + currentShow.getRating() + "/100 (" + currentShow.getYear() + ") on: "
              + this.checkProviders(currentShow));
    }
  }

  private String checkProviders(IShow show) {
    String[] videoProviders = {"Netflix", "Hulu", "Prime Video", "Disney+"};
    String result = "";
    for (String currentProvider : videoProviders) {
      if (show.isAvailableOn(currentProvider)) {
        result += currentProvider + ", ";
      }
    }
    result = result.substring(0, result.length() - 2);
    return result;
  }

  @Override
  public void titleSearch() {
    System.out.print("Choose a word that you would like to search for: ");
    String userKeyword = this.scnr.next();
    this.scnr.nextLine(); // skip the \n in the input
    List<IShow> searchResult = this.backend.searchByTitleWord(userKeyword);
    this.displayShows(searchResult);
  }

  @Override
  public void yearSearch() {
    boolean correctInput = false;
    int yearNumber = -1;

    do {
      System.out.print("Enter the year that you would like to search for: ");
      try {
        yearNumber = this.scnr.nextInt();
        this.scnr.nextLine(); // skip the \n in the input
        if (yearNumber > 0) {
          correctInput = true;
        } else {
          System.out.println("INCORRECT INPUT. Please enter an VALID year number.");
        }
      } catch (InputMismatchException e) {
        System.out.println("INCORRECT INPUT. Please enter an INTEGER year number.");
        this.scnr.nextLine(); // skip the \n in the input
      }
    } while (!correctInput);

    List<IShow> searchResult = this.backend.searchByYear(yearNumber);
    this.displayShows(searchResult);
  }
}
