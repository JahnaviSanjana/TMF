public class ThreadPriority extends Thread {
    public void run() {
        System.out.println("Thread Running...");
    }

    public static void main(String[] args) {
        ThreadPriority thread = new ThreadPriority();
        thread.start();

        System.out.println("max thread priority : " + Thread.MAX_PRIORITY);
        System.out.println("min thread priority : " + Thread.MIN_PRIORITY);
        System.out.println("normal thread priority : " + Thread.NORM_PRIORITY);
    }
}
