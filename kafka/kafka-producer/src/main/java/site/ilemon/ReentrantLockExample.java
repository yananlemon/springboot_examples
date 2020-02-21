package site.ilemon;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    // 是否执行打印的标志
    private static volatile boolean flag = false;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        Thread oddThread = new Thread(new PrintOddNumberThread2(lock));
        Thread evenThread = new Thread(new PrintEvenNumberThread2(lock));
        evenThread.setName("奇数线程");
        oddThread.setName("偶数线程");
        oddThread.start();
        evenThread.start();

    }
}


class PrintEvenNumberThread2 implements Runnable{
    ReentrantLock lock;

    public PrintEvenNumberThread2(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i < 101;i++){

            if( i % 2 == 1){
                lock.tryLock();
                System.out.println(Thread.currentThread().getName()+":"+i);
            }else{
                if( lock.isHeldByCurrentThread())
                    lock.unlock();
            }


        }

    }
}


class PrintOddNumberThread2 implements Runnable{
    ReentrantLock lock;

    public PrintOddNumberThread2(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i < 101;i++){
            if( i % 2 == 0){
                lock.tryLock();
                System.out.println(Thread.currentThread().getName()+":"+i);
            }else{
                if( lock.isHeldByCurrentThread())
                    lock.unlock();
            }

        }
    }
}