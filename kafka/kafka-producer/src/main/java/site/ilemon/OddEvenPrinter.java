package site.ilemon;

/**
 * 使用synchronized实现两个线程交替打印奇偶数
 */
public class OddEvenPrinter {
    private final Object lock = new Object();
    private volatile int count = 0;
    public void print(){
        synchronized (lock){
            while(count < 10){
                try{
                    System.out.println(String.format("[%s]:%d", Thread.currentThread().getName(), count++));
                    lock.notifyAll();
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }
    public static void main(String[] args) throws Exception {
        final OddEvenPrinter printer = new OddEvenPrinter();

        Thread oddThread = new Thread(new PrintThread(printer));
        oddThread.setName("偶数线程");
        oddThread.start();

        Thread evenThread = new Thread(new PrintThread(printer));
        evenThread.setName("奇数线程");
        evenThread.start();
    }
}

class PrintThread implements Runnable{
    OddEvenPrinter printer;
    public PrintThread(OddEvenPrinter printer){
        this.printer=printer;
    }
    @Override
    public void run() {
        printer.print();
    }
}
