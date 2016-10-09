import java.util.*;

public class ThreadPool {
  private LinkedList tasks = new LinkedList();

  public ThreadPool(int size) {
    for (int i=0; i<size; i++) {
      Thread thread = new TaskThread(this);
      thread.start();
    }
  }

  public void run(Runnable task) {
    synchronized (tasks) {
      tasks.addLast(task);
      tasks.notify();
    }
  }

  public Runnable getNext() {
    Runnable returnVal = null;
    synchronized (tasks) {
      while (tasks.isEmpty()) {
        try {
          tasks.wait();
        } catch (InterruptedException e) {
          System.err.println("Interrupted: " + e);
        }
      }
      returnVal = (Runnable)tasks.removeFirst();
    }
    return returnVal;
  }

  public static void main (String args[]) {
    final String message[] = {"Reference List", "Christmas List", 
      "Wish List", "Priority List", "'A' List"};
    ThreadPool pool = new ThreadPool(message.length/2);
    for (int i=0, n=message.length; i<n; i++) {
      final int innerI = i;
      Runnable runner = new Runnable() {
        public void run() {
          for (int j=0; j<25; j++) {
            System.out.println("j: " + j + ": " + message[innerI]);
          }
        }
      };
      pool.run(runner);
    }
  }
}