import java.util.concurrent.*;

public class Ats extends Thread {
    private BlockingQueue<String> callsQueue = new LinkedBlockingQueue<>();
    public final int CALLS_QUANTITY = 10;
    public final int CALL_TIME_LATENCY = 1000;

    public BlockingQueue<String> getCallsQueue() {
        return callsQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < CALLS_QUANTITY; i++) {
                System.out.println("Входящий звонок " + i);
                getCallsQueue().put("Входящий звонок " + i);
                Thread.sleep(CALL_TIME_LATENCY);
            }
        } catch (
                InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
