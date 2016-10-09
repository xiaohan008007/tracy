import javax.swing.*;
import javax.swing.event.*;

public class TestListModel {
  public static void main (String args[]) {
    ListDataListener ldl = new ListDataListener() {
      public void intervalAdded(ListDataEvent e) {
        System.out.println("Added: " + e);
      }
      public void intervalRemoved(ListDataEvent e) {
        System.out.println("Removed: " + e);
      }
      public void contentsChanged(ListDataEvent e) {
        System.out.println("Changed: " + e);
      }
    };
    WeakListModel model = new WeakListModel();
    model.addListDataListener(ldl);
    model.addElement("New Jersey");
    model.addElement("Massachusetts");
    model.addElement("Maryland");
    model.removeElement("New Jersey");
    ldl = null;
    System.gc();
    model.addElement("New Jersey");
    System.out.println(model);
  }
}