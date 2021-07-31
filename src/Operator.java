import java.util.concurrent.BlockingQueue;

public class Operator extends Thread {
    private final int PROCESSING_TIME = 3000;
    private Ats ats;

    public Operator(String name, Ats ats) {
        super(name);
        this.ats = ats;
    }

    @Override
    public void run() {
        while (ats.isAlive()) {
            try {
                System.out.printf("Оператор %s обрабатываю звонок %s\n",
                        Thread.currentThread().getName(), ats.getCallsQueue().poll());
                Thread.sleep(PROCESSING_TIME);
                System.out.printf("Оператор %s обрабатал звонок\n",
                        Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("У %s звонков нет\n", Thread.currentThread().getName());
    }
}
