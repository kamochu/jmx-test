/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kamochu
 */
public interface SystemConfigMBean {

    public void setMessageConsumedCount(int value);

    public int getMessageConsumedCount();

    public void setMessageProducedCount(int value);

    public int getMessageProducedCount();

    public void setCount(int value);

    public int getCount();

    int getConsumerSleepTime();

    int getProducerSleepTime();

    void setConsumerSleepTime(int value);

    void setProducerSleepTime(int value);

    public String adjustSleepConsumerTimeRange(int value);

    public String adjustSleepProducerTimeRange(int value);

    public void setThreadCount(int noOfThreads);

    public int getThreadCount();

    public void setSchemaName(String schemaName);

    public String getSchemaName();

    // any method starting with get and set are considered
    // as attributes getter and setter methods, so I am 
    // using do* for operation.
    public String doConfig();
}
