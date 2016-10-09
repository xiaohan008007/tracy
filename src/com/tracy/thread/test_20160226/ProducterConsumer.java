/**
 * 
 */
package thread.test_20160226;

import java.util.PriorityQueue;

/**
 * @author tracy.lu
 * @date:2016年2月26日 下午5:34:43
 * @version :
 */
public class ProducterConsumer {

    private int                    queueSize = 10;
    private PriorityQueue<Integer> queue     = new PriorityQueue<Integer>(queueSize);

    class Producter extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满了，等待消费");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();// 通知可以消费
                    System.out.println("在队列里装填一个元素，队列长度为:" + queue.size());
                }
            }
        }
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空了，等待装填");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("在队列里移走一个元素，队列长度为:" + queue.size());
                }
            }
        }

    }

    public static void main(String[] args) {
        ProducterConsumer p = new ProducterConsumer();
        Producter producter = p.new Producter();
        Consumer consumer = p.new Consumer();
        producter.start();
        consumer.start();
    }
}
