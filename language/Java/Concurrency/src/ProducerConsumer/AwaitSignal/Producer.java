package ProducerConsumer.AwaitSignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    private static final Lock lock = Storage.getLock();
    private static final Condition full = Storage.getFullCondition();
    private static final Condition empty = Storage.getEmptyCondition();
    private String producer;

    public Producer(String producer) {
        this.producer = producer;
    }

    public void run() {
        lock.lock();
        try {
            while (Storage.isFull()) {
                full.await();
            }
            Storage.add(new Object());
            empty.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
