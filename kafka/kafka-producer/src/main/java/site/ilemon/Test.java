package site.ilemon;

public class Test implements Runnable{
    private int count = 10;
    public synchronized void run(){
        count--;
        System.out.println(Thread.currentThread().getName()
        +" count = "+count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            Test test = new Test();
            new Thread(test).start();
        }
    }
}
