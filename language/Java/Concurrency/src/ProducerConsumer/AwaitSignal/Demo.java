package ProducerConsumer.AwaitSignal;

public class Demo {
    public static void main(String[] args) {
        int count = 0;
        while (count < 100) {
            new Thread(new Producer("Producer" + count)).start();
            new Thread(new Consumer("Consumer" + count)).start();
            count++;
        }
    }
}
