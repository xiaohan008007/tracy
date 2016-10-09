package thread.test_20160223;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ArrayListConcurrentProblem {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        final Set<Integer> set = new HashSet<Integer>();
        System.out.println(set.size());
        // final List list = new ArrayList();
        final List list = new Vector();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++)
            new Thread() {

                @Override
                public void run() {
                    int k = 0;
                    for (int i = 0; i < 1000; i++) {
                        int m = (int) list.remove(0);
                        if (set.contains(m)) {
                            System.out.println("rep:" + m);
                        } else {
                            set.add(m);
                        }
                        // System.out.println(list.remove(0));
                        k++;
                    }
                    // System.out.println(k);
                }
            }.start();
        // for (int i = 0; i < 10; i++)
        // new Thread() {
        //
        // @Override
        // public void run() {
        // for (int i = 0; i < 1000; i++)
        // list.add(10000 * i + i);
        // }
        // }.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println((System.currentTimeMillis() - t1) + " " + list.size());
    }
}
