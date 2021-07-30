import java.util.concurrent.BlockingQueue;

public class Operator extends Thread {
    private final int WAITING_TIME = 3000;
    private final int PROCESSING_TIME = 3000;
    BlockingQueue queue;

    public Operator(String name, BlockingQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " ждет звонка...");
                    Thread.sleep(WAITING_TIME);
                    if (queue.isEmpty()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    System.out.printf("Оператор %s обрабатываю звонок %s\n",
                            Thread.currentThread().getName(), queue.take());
                    Thread.sleep(PROCESSING_TIME);
                    System.out.printf("Оператор %s обрабатал звонок\n",
                            Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("У %s звонков нет\n", Thread.currentThread().getName());
    }
}
