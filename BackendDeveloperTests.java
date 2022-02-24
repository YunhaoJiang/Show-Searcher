
public class BackendDeveloperTests {

  /**
   * Test1: Creates BackendDeveloper object, and call the search with "show". By default all filters
   * should be true, thus, call shows with the word "show" in it should be returned
   * 
   * @return true if expected behavior observed
   */
  public static boolean test1() {
    ShowSearcherBackend test = new ShowSearcherBackend();
    
    // Checks if all the shows returned has the word 'show' in it
    if (!test.searchByTitleWord("show").toString()
        .equals("[Netflix show, Hulu show, Prime Video show]")) {
      return false;
    }
    return true;
  }

  /**
   * Test2: Creates BackendDeveloper object, and add Disney+ show to the map, and then call the
   * search with "show". Now it should also have Disney+ show in it
   * 
   * @return true expected behavior observed
   */
  public static boolean test2() {
    ShowSearcherBackend test = new ShowSearcherBackend();
    
    // Creates and adds a Disney+ show
    TempShow disney = new TempShow("Disney+ show", 2021, 7, false, false, false, true);
    test.addShow(disney);
    
    // Checks if Disney+ show shows up when searching 'Disney+'
    if (!test.searchByTitleWord("Disney+").toString().equals("[Disney+ show]")) {
      return false;
    }
    
    // Checks if Disney+ show and all original shows show up when searching 'show'
    if (!test.searchByTitleWord("show").toString()
        .equals("[Netflix show, Hulu show, Prime Video show, Disney+ show]")) {
      return false;
    }
    return true;
  }

  /**
   * Test3: Creates BackendDeveloper object, add Disney+ show to the map, and then disable the
   * Netflix and Hulu filter, then search with "show", should return with just Prime Video show and
   * Disney+ show
   * 
   * @return true if expected behavior observed
   */
  public static boolean test3() {
    ShowSearcherBackend test = new ShowSearcherBackend();
    
    // Creates and adds a Disney+ show
    TempShow disney = new TempShow("Disney+ show", 2021, 7, false, false, false, true);
    test.addShow(disney);
    
    // Turn off the filter for "Netflix" and "Hulu"
    test.toggleProviderFilter("Netflix");
    test.setProviderFilter("Hulu", false);
    
    // Checks to see if only Prime Video show and Disney+ show remains if searching by 'show'
    if (!test.searchByTitleWord("show").toString().equals("[Prime Video show, Disney+ show]")) {
      return false;
    }
    return true;
  }

  /**
   * Test4: Creates BackendDeveloper object, add Disney+ show to the map, then search with the key
   * "2021". Should return Prime Video show and Disney+ show.
   * 
   * @return true if expected behavior observed
   */
  public static boolean test4() {
    ShowSearcherBackend test = new ShowSearcherBackend();
    
    // Creates and adds Disney+ show
    TempShow disney = new TempShow("Disney+ show", 2021, 7, false, false, false, true);
    test.addShow(disney);
    
    // Checks if the correct shows are return when searching by year 2021
    if (!test.searchByYear(2021).toString().equals("[Prime Video show, Disney+ show]")) {
      return false;
    }
    return true;
  }

  /**
   * Test4: Creates BackendDeveloper object, checks the size (should be 3), add Disney+ show, check the size again (should be 4)
   * 
   * @return true if expected behavior observed
   */
  public static boolean test5() {
    ShowSearcherBackend test = new ShowSearcherBackend();
    
    // Checks the size of the show list
    if (test.getNumberOfShows() != 3) {
      return false;
    }
    
    // Creates and adds a Disney+ show
    TempShow disney = new TempShow("Disney+ show", 2021, 7, false, false, false, true);
    test.addShow(disney);
    
    // Checks the size of the show list post addition of new show
    if (test.getNumberOfShows() != 4) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("Test 1: " + test1());
    System.out.println("Test 2: " + test2());
    System.out.println("Test 3: " + test3());
    System.out.println("Test 4: " + test4());
    System.out.println("Test 5: " + test5());
  }

}
