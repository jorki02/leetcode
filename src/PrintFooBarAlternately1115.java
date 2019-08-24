public class PrintFooBarAlternately1115 {

    public static void main(String[] args){
        test();
    }

    public static void test(){
        FooBar fooBar = new FooBar(6);

        Thread thread1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

    }

}

class FooBar {
    private int n;
    private volatile boolean fooM = true;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(!fooM){
                try{
                    wait();
                } catch (InterruptedException e){}
            }

            fooM = false;
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(fooM){
                try{
                    wait();
                } catch (InterruptedException e){}
            }

            fooM = true;
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();

            notifyAll();
        }
    }
}
