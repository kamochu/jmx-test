
/**
 *
 * @author kamochu
 */
public class SystemConfig implements SystemConfigMBean {

    private int threadCount;
    private String schemaName;

    int messageConsumedCount;
    int messageProducedCount;
    int count;

    int consumerSleepTime = 200;
    int producerSleepTime = 500;

    @Override
    public void setMessageConsumedCount(int value) {
        messageConsumedCount += value;
    }

    @Override
    public int getMessageConsumedCount() {
        return messageConsumedCount;
    }

    @Override
    public void setMessageProducedCount(int value) {
        messageProducedCount += value;
    }

    @Override
    public int getMessageProducedCount() {
        return messageProducedCount;
    }

    @Override
    public void setCount(int value) {
        count += value;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String adjustSleepConsumerTimeRange(int value) {
        consumerSleepTime = value;
        return "New Consumer Sleep time value: " + value;
    }

    @Override
    public String adjustSleepProducerTimeRange(int value) {
        producerSleepTime = value;
        return "New Producer Sleep time  value: " + value;
    }

    @Override
    public int getConsumerSleepTime() {
        return consumerSleepTime;
    }

    @Override
    public int getProducerSleepTime() {
        return producerSleepTime;
    }

    @Override
    public void setConsumerSleepTime(int value) {
        consumerSleepTime = value;
    }

    @Override
    public void setProducerSleepTime(int value) {
        producerSleepTime = value;
    }

    public SystemConfig(int numThreads, String schema) {
        this.threadCount = numThreads;
        this.schemaName = schema;
    }

    @Override
    public void setThreadCount(int noOfThreads) {
        this.threadCount = noOfThreads;
    }

    @Override
    public int getThreadCount() {
        return this.threadCount;
    }

    @Override
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public String getSchemaName() {
        return this.schemaName;
    }

    @Override
    public String doConfig() {
        return "No of Threads=" + this.threadCount + " and DB Schema Name=" + this.schemaName;
    }
}
