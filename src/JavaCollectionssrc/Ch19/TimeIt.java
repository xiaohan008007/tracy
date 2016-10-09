import cern.colt.*;

public class TimeIt {
  public static void main (String args[]) {
    Timer timer = new Timer();
    timer.start();
    System.out.println(args);
    System.out.println(Arrays.toString(args));
    timer.stop();
    System.out.println(timer);
  }
}