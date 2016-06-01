package concurrency.sync.cache;

import java.math.BigInteger;

/**
 * Created by yangjingyi on 2016-6-1.
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        Thread.sleep(1000L);
        return new BigInteger(arg);
    }
}
