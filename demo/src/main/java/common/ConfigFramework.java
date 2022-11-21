package common;

public abstract class ConfigFramework {
   public static final String PLATFORM_AND_BROWSER = "win_chrome";

   /**
    * Clear browser cookies after each action
    * if true - clear cookies
    */
   public static final Boolean CLEAR_COOKIES = false;

    /*
    * Clear localSorage after ech iteration
    * if true - clearc local Storage
    */
   public static final Boolean CLEAR_LOCAL_STORAGE = false;

   /**
    * close browser after test/suite
    * if true - browser close
    * if false - hold browser
    */
   public static final Boolean CLOSE_BROWSER = true;

   public static class TimeoutVariable{
      public static final int IMPLICIT_WAIT = 4;
      public static final int EXPLICIT_WAIT = 10;
      public static final int PAGE_LOAD_TIMEOUT = 10;
   }
}
