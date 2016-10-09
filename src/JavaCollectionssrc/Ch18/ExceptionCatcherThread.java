import EDU.oswego.cs.dl.util.concurrent.*;
import java.util.Iterator;
public class ExceptionCatcherThread extends ThreadGroup {

  private Runnable runnable;
  private Thread runner;
  private CopyOnWriteArrayList listenerList = new CopyOnWriteArrayList();

  /* For autonumbering our group. */
  private static int threadInitNumber;
  private static synchronized int nextThreadNum() {
    return threadInitNumber++;
  }

  public ExceptionCatcherThread(Runnable r) {
    super("ExceptionCatcherThread-" + nextThreadNum());
    runnable = r;
    // Create thread in this group
    runner = new Thread(this, runnable);
  }

  public void start() {
    runner.start();
  }

  /* Listener registration methods */

  public synchronized void 
      addThreadExceptionListener(ThreadListener t) {
    listenerList.add(t);
  }
  public synchronized void 
      removeThreadExceptionListener(ThreadListener t) {
    listenerList.remove(t);
  }

  public void uncaughtException(Thread source, Throwable t) {
    fireExceptionHappened(t);
    super.uncaughtException(source, t);
  }

  protected void fireExceptionHappened(Throwable t) {
    ThreadException e = (t instanceof ThreadException) ?
      (ThreadException)t : new ThreadException(runnable, t);
    Iterator iterator = listenerList.iterator();
    while (iterator.hasNext()) {
      ThreadListener tl = (ThreadListener) iterator.next();
      tl.exceptionHappened(e);
    }
  }
}
