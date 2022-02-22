// --== CS400 Project One File Header ==--
// Name: Yunhao Jiang
// CSL Username: yunhaoj
// Email: jiang297@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: :)


import java.util.ArrayList;
import java.util.List;

public class FrontendDeveloperTests {
  /**
   * Test titleSearch and displayShows.
   * This test ONLY works with the placeholder class created by the frontend developer.
   *
   * @return true if it works as expected, false otherwise
   */
  public static boolean test1() {
    try {
      TextUITester tester = new TextUITester("1\ntest\n4\n");
      IShowSearcherFrontend frontend = new ShowSearcherFrontend(new ShowSearcherBackend());
      frontend.runCommandLoop();
      String output = tester.checkOutput();

      if (!output.contains("1. Test1\n\t50/100 (2000) on: Netflix") || !output.contains(
          "2. Test2\n\t51/100 (2001) on: Prime Video")) {
        System.out.println("Test 1 failed, the titleSearch and displayShows does not display the "
            + "shows correctly.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Test yearSearch and displayShows.
   * This test ONLY works with the placeholder class created by the frontend developer.
   *
   * @return true if it works as expected, false otherwise
   */
  public static boolean test2() {
    try {
      TextUITester tester = new TextUITester("2\ntest\n-1\n2000\n4\n");
      IShowSearcherFrontend frontend = new ShowSearcherFrontend(new ShowSearcherBackend());
      frontend.runCommandLoop();
      String output = tester.checkOutput();

      if (!output.contains("1. Test3\n\t50/100 (2000) on: Netflix") || !output.contains(
          "2. Test4\n\t51/100 (2001) on: Prime Video")) {
        System.out.println("Test 2 failed, the yearSearch and displayShows does not display the "
            + "shows correctly.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Test filterProvider and displayFilter.
   * This test ONLY works with the placeholder class created by the frontend developer.
   *
   * @return true if it works as expected, false otherwise
   */
  public static boolean test3() {
    try {
      TextUITester tester = new TextUITester("3\n5\n4\n");
      IShowSearcherFrontend frontend = new ShowSearcherFrontend(new ShowSearcherBackend());
      frontend.runCommandLoop();
      String output = tester.checkOutput();

      if (!output.contains("_x_ [N]etflix") || !output.contains("___ [D]isney+")) {
        System.out.println("Test 3 failed, filterProvider and displayFilter does not display the "
            + "filter status correctly.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Test menu function with letters not number.
   * This test ONLY works with the placeholder class created by the frontend developer.
   *
   * @return true if it works as expected, false otherwise
   */
  public static boolean test4() {
    try {
      TextUITester tester = new TextUITester("T\nword\ny\n2000\nF\nQ\nq\n");
      IShowSearcherFrontend frontend = new ShowSearcherFrontend(new ShowSearcherBackend());
      frontend.runCommandLoop();
      String output = tester.checkOutput();

      if (!output.contains("Test1") || !output.contains("Test3") || !output.contains("_x_")) {
        System.out.println("Test 4 failed: the menu does not recognize letter command correctly.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Test empty list for displayShows method
   *
   * @return true if it works as expected, false otherwise
   */
  public static boolean test5() {
    try {
      TextUITester tester = new TextUITester("");
      IShowSearcherFrontend frontend = new ShowSearcherFrontend(new ShowSearcherBackend());
      List<IShow> shows = new ArrayList<>();
      frontend.displayShows(shows);
      String output = tester.checkOutput();

      if (!output.equals("Found 0/4 matches.\n")) {
        System.out.println("Test 5 failed: displayShows should not display other things when the "
            + "list is empty.");
        return false;
      }
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("test1: " + test1());
    System.out.println("test2: " + test2());
    System.out.println("test3: " + test3());
    System.out.println("test4: " + test4());
    System.out.println("test5: " + test5());
  }
}
