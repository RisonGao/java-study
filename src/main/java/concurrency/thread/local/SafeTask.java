package concurrency.thread.local;

import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Jingyi.Yang
 * Date: 2016/6/20
 * Time: 14:12
 **/
// 安全的本地线程变量
@Log4j
public class SafeTask implements Runnable {
    private ThreadLocal<Date> startDate;

    //a. OR use initialValue(), generates value on first fetch
    {
        startDate = new ThreadLocal<Date>() {
            @Override
            protected Date initialValue() {
                return new Date();
            }
        };

    }
    @Override
    public void run() {
        //b. OR use manual set()
        /*startDate = new ThreadLocal<>();
        startDate.set(new Date());*/

        log.info(Thread.currentThread().getName() + " starts at: " + startDate.get());

        try {
            TimeUnit.SECONDS.sleep(RandomUtils.nextInt(0, 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(Thread.currentThread().getName() + " end with: " + startDate.get());
    }
}
