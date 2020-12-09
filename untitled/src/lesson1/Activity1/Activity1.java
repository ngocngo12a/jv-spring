package lesson1.Activity1;

public class Activity1 {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread thread = new MyThread(i);
            thread.start();
        }
    }
}
class MyThread extends Thread{
    int STT;
    boolean test = false;
    MyThread(int x){
        this.STT = x;

    }

    @Override
    public void run() {
        while(true){
            if(test == false){
                System.out.println("Thread "  + STT + " is running ");
                test = true;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
