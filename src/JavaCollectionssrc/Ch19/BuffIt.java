import cern.colt.buffer.*;
import cern.colt.list.*;
import java.awt.event.*;

public class BuffIt {
  public static void main (String args[]) {
    ObjectArrayList list = new ObjectArrayList();
    MyConsumer consumer = new MyConsumer(list);
    ObjectBuffer buffer = new ObjectBuffer(consumer, 3);
    ActionListener listener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
      }
    };
    consumer.addActionListener(listener);
    for (int i=0, n=args.length; i<n; i++) {
      buffer.add(args[i]);
    }
    buffer.flush();
  }
}