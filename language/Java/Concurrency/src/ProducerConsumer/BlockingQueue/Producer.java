package ProducerConsumer.BlockingQueue;

public class Producer implements Runnable {
    private String producer;

    public Producer(String producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        if (Storage.isFull()) {

        }
        try {
            Storage.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
