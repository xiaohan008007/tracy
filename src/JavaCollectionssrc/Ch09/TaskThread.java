public class TaskThread extends Thread {
  private ThreadPool pool;

  public TaskThread(ThreadPool thePool) {
    pool = thePool;
  }

  public void run() {
    while (true) {
      // blocks until job
      Runnable job = pool.getNext();
      try {
        job.run();
      } catch (Exception e) {
        // Ignore exceptions thrown from jobs
        System.err.println("Job exception: " + e);
      }
    }
  }
}