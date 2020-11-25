package lesson1;

public class Activity2 {
    public static void main(String[] args) {

    MyThread myThread1 = new MyThread("ABC", 3500 );
    MyThread myThread2 = new MyThread("DEF", 6000);
    Thread myThread11 = new Thread(myThread1);
    Thread myThread22 = new Thread(myThread2);
    myThread11.start();
    myThread22.start();
    }
}
class MyThread implements Runnable{
    String name;
    int sleep;

    public MyThread(String name, int sleep) {
        this.name = name;
        this.sleep = sleep;
    }
    public void run(){
        try {
            Thread.sleep(sleep);
            System.out.println("" +name);
        }
        catch (Exception e){
            System.out.println("" +e);
        }
    }
}