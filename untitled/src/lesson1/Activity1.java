package lesson1;

import java.util.Scanner;

public class Activity1 {

    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<50;i++) {
            Thread thread1 = new Thread1();
            thread1.start();
        }
    }
}
class Thread1 extends  Thread{
    @Override
    public void run(){
            try{
                System.out.println(Thread.currentThread().getName());
            }catch (Exception e){
                System.out.println("Error");
            }

    }
}
