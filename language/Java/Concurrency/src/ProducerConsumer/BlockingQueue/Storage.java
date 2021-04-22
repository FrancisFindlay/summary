package ProducerConsumer.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
    // 仓库最大存储量
    private static final int MAX_SIZE = 100;
    // 仓库存储的载体
    private static final LinkedBlockingQueue<Object> QUEUE = new LinkedBlockingQueue<>(MAX_SIZE);

    public static void put(Object object) throws InterruptedException {
        QUEUE.put(object);
    }

    public static void take() throws InterruptedException {
        QUEUE.take();
    }

    public static boolean isEmpty() {
        return QUEUE.isEmpty();
    }

    public static boolean isFull() {
        return QUEUE.size() == MAX_SIZE;
    }

    public static int size() {
        return QUEUE.size();
    }
}
