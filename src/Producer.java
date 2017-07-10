
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author kamochu
 */
public class Producer implements Runnable {

    final LinkedList<Integer> list;

    public Producer(LinkedList<Integer> theList) {
        list = theList;
    }

    @Override
    public void run() {

        while (true) {

            Random random = new Random();

            int sleep = random.nextInt(App.mxBean.producerSleepTime);

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
            int value = random.nextInt();

            list.add(value);
            App.mxBean.messageProducedCount++;
            App.mxBean.count++;

            synchronized (list) {
                list.notifyAll();
            }

            System.out.println(Thread.currentThread().getName() + " added  " + value + " to the list and new size " + list.size() + " sleep time is " + App.mxBean.producerSleepTime);

        }

    }

}
