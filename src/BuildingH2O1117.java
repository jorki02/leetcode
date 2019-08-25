import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class BuildingH2O1117 {

    public static void main(String[] args){
        test();
    }

    public static void test(){
        H2O h2O = new H2O();

        Thread thread1h = new Thread(() -> {
            try {
                h2O.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2h = new Thread(() -> {
            try {
                h2O.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3h = new Thread(() -> {
            try {
                h2O.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread4h = new Thread(() -> {
            try {
                h2O.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread1o = new Thread(() -> {
            try {
                h2O.oxygen(() -> System.out.print("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2o = new Thread(() -> {
            try {
                h2O.oxygen(() -> System.out.print("O"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1h.start();
        thread2h.start();
        thread3h.start();
        thread4h.start();
        thread1o.start();
        thread2o.start();

    }
}

class H2O {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        semaphoreO.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semaphoreH.release(2);
    }
}
