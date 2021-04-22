package ProducerConsumer.AwaitSignal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
    private static final int SIZE = 100;
    private static final LinkedList<Object> list = new LinkedList<>();
    private static final Lock lock = new ReentrantLock();
    private static final Condition full = lock.newCondition();
    private static final Condition empty = lock.newCondition();

    public static void add(Object obj) {
        list.add(obj);
    }

    public static void remove() {
        list.remove();
    }

    public static boolean isEmpty() {
        return list.isEmpty();
    }

    public static boolean isFull() {
            return list.size() == SIZE;
}

    public static int size() {
        return list.size();
    }

    public static Lock getLock() {
        return lock;
    }

    public static Condition getFullCondition() {
        return full;
    }

    public static Condition getEmptyCondition() {
        return empty;
    }
}
