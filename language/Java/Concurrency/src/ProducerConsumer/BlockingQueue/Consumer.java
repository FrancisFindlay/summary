package ProducerConsumer.BlockingQueue;

public class Consumer implements Runnable {
    private String consumer;

    public Consumer(String consumer) {
        this.consumer = consumer;
    }

    public void run() {
        if (Storage.isEmpty()) {
        }
        try {
            Storage.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

