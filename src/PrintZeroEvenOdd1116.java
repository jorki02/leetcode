import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd1116 {

    public static void main(String[] args) {
        testZeroEvenOdd();
    }

    public static void testZeroEvenOdd(){
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);

        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }

}

class ZeroEvenOdd {
    private int n;
    private final Semaphore semaphore0 = new Semaphore(1);
    private final Semaphore semaphore1 = new Semaphore(0);
    private final Semaphore semaphore2 = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++){
            semaphore0.acquire();
            printNumber.accept(0);
            if(i % 2 == 0){
                semaphore1.release();
            } else {
                semaphore2.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i = i + 2){
            semaphore2.acquire();
            printNumber.accept(i);
            semaphore0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i = i + 2){
            semaphore1.acquire();
            printNumber.accept(i);
            semaphore0.release();
        }
    }
}
