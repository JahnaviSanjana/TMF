public class SynchronizedBlockExample extends Thread {
    public void run() {
        synchronized (this) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " is completed.");
        }
    }

    public static void main(String[] args) {
        SynchronizedBlockExample thread1 = new SynchronizedBlockExample();
        SynchronizedBlockExample thread2 = new SynchronizedBlockExample();

        thread1.start();
        try {
            thread1.join(); // Wait for thread1 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }
}
