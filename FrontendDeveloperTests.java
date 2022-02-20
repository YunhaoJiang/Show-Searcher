public class FrontendDeveloperTests {
  public static boolean test1() {
    try {
      System.out.println("");
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public static boolean test2() {
    try {
      System.out.println("");
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public static boolean test3() {
    try {
      System.out.println("");
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public static boolean test4() {
    try {
      System.out.println("");
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public static boolean test5() {
    try {
      System.out.println("");
    } catch (Exception e) {
      System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " failed: an "
          + "unexpected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static void main (String[] args){
    System.out.println("test1: " + test1());
    System.out.println("test2: " + test2());
    System.out.println("test3: " + test3());
    System.out.println("test4: " + test4());
    System.out.println("test5: " + test5());
  }
}
