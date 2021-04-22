package ProducerConsumer.AwaitSignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    private static final Lock lock = Storage.getLock();
    private static final Condition full = Storage.getFullCondition();
    private static final Condition empty = Storage.getEmptyCondition();
    private String consumer;

    public Consumer(String consumer) {
        this.consumer = consumer;
    }

    public void run() {
        lock.lock();
        try {
            while (Storage.isEmpty()) {
                empty.await();
            }
            Storage.remove();
            full.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
