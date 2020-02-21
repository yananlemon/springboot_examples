package site.ilemon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHowto {



    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        MyThread thread1 = new MyThread(reentrantLockDemo);
        MyThread thread2 = new MyThread(reentrantLockDemo);
        MyThread thread3 = new MyThread(reentrantLockDemo);
        MyThread thread4 = new MyThread(reentrantLockDemo);
        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
        new Thread(thread4).start();
    }



}
class MyThread implements Runnable{
    private ReentrantLockDemo reentrantLockDemo;
    public MyThread(ReentrantLockDemo reentrantLockDemo){
        this.reentrantLockDemo=reentrantLockDemo;
    }
    @Override
    public void run() {

        reentrantLockDemo.getCount();

    }
}
class ReentrantLockDemo{
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private volatile int count;

    //Implicit locking using synchronized keyword
    public int getCount() {
        lock.lock();
        try{
            while( count < 6){

                System.out.println(Thread.currentThread().getName()+"gets count:"+(++count));
                condition.signalAll();
                condition.await();
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread())
                lock.unlock();
        }
        return count;
    }

    //Implicit locking using synchronized keyword
    public int getCountTwo() {
        synchronized(lock){
            try {
                while( count < 6){
                    System.out.println(Thread.currentThread().getName()+"gets count:"+(++count));
                    lock.notifyAll();
                    lock.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}

