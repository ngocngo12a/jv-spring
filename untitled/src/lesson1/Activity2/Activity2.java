package lesson1.Activity2;

public class Activity2 {
    public static void main(String[] args) {
        Thread myThread1 = new MyThread1("ABC", 3500);
        Thread myThread2 = new MyThread1("DEF", 2500);
        myThread1.start();
        myThread2.start();
    }

}
class MyThread1 extends Thread{
    String name;
    int sleep;

    public MyThread1(String name, int sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(" " + name);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
