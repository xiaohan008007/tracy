import cern.colt.buffer.*;
import cern.colt.list.*;
import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyConsumer implements ObjectBufferConsumer {
  private ObjectArrayList list;
  private ActionListener listenerList;
  public synchronized void 
      addActionListener(ActionListener t) {
    listenerList = AWTEventMulticaster.add(listenerList, t);
  }
  public synchronized void 
      removeActionListener(ActionListener t) {
    listenerList = AWTEventMulticaster.remove(listenerList, t);
  }
  public MyConsumer(ObjectArrayList list) {
    this.list = list;
  }
  public void addAllOf(ObjectArrayList list) {
    int size = list.size();
    this.list.addAllOfFromTo(list, 0, size-1);
    ActionEvent event = new ActionEvent (
      list, ActionEvent.ACTION_PERFORMED, "Adding " + size);
    listenerList.actionPerformed(event);      
  }
}
