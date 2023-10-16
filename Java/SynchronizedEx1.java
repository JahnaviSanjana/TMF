public class SynchronizedEx1 extends Thread {

    public static synchronized void printThreadName() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
    }

    public void run() {
        for (int i =1; i < 5; i++) {
            printThreadName();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedEx1 thread1 = new SynchronizedEx1();
        SynchronizedEx1 thread2 = new SynchronizedEx1();

        thread1.start();
        thread2.start();
    }
}
