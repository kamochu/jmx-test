
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author kamochu
 */
public class Consumer implements Runnable {

    final LinkedList<Integer> list;
    final Random random = new Random();

    public Consumer(LinkedList<Integer> theList) {
        list = theList;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (list) {
                if (list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace(System.err);
                    }
                }
                if (list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " Oops - no items in the queue");
                } else {
                    int removed = list.remove();
                    System.out.println(Thread.currentThread().getName() + " removed "
                            + removed + " from the queue, the size after is " + list.size() + " sleep time is " + App.mxBean.consumerSleepTime);

                    App.mxBean.messageConsumedCount++;
                    App.mxBean.count--;
                }
            }

            int sleepTime = random.nextInt(App.mxBean.consumerSleepTime) + 201;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }

        }

    }

}
