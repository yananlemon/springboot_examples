package site.ilemon;

/**
 * 使用Synchronized实现两个线程交替打印
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread oddThread = new Thread(new PrintOddNumberThread(obj));
        Thread evenThread = new Thread(new PrintEvenNumberThread(obj));
        evenThread.setName("奇数线程");
        oddThread.setName("偶数线程");
        evenThread.start();
        oddThread.start();
    }
}


class PrintEvenNumberThread implements Runnable{
    Object lock;

    public PrintEvenNumberThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for(int i = 0; i < 101;i++){
                if( i % 2 == 1){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    lock.notifyAll();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}


class PrintOddNumberThread implements Runnable{
    Object lock;

    public PrintOddNumberThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for(int i = 0; i < 101;i++){
                if( i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    lock.notifyAll();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
