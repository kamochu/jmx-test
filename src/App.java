
import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 *
 * @author kamochu
 */
public class App {

    public static SystemConfig mxBean = new SystemConfig(10, "default");

    public static void main(String args[]) {
        LinkedList<Integer> queue = new LinkedList<>();

        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//            ObjectName name = new ObjectName("tech.meliora.jmx.tut:type=Counters");
//            mbs.registerMBean(mxBean, name);

            ObjectName name2 = new ObjectName("com.journaldev.jmx:type=SystemConfig");
            mbs.registerMBean(mxBean, name2);

        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }

        Producer producer1 = new Producer(queue);
        new Thread(producer1, "producer-thread-1").start();

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        new Thread(consumer1, "consumer-thread-1").start();
        new Thread(consumer2, "consumer-thread-2").start();
        new Thread(consumer3, "consumer-thread-3").start();

    }

}
