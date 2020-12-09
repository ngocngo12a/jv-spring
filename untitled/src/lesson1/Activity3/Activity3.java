package lesson1.Activity3;

import java.util.Random;

public class Activity3 {
    public static Integer number = null;

    public static void main(String[] args) {
        Number number = new Number();
        Thread genNumber = new Thread3(number);
        genNumber.setName("GEN");
        Thread checkNumber = new Thread3(number);
        checkNumber.setName("CHECK");

        genNumber.start();
        checkNumber.start();
    }
}
class Number{
    public synchronized void checkAndGen(){
        if(Thread.currentThread().getName().equals("CHECK")){
            if(Activity3.number != null){
                int num = Activity3.number;
                if ( (num% 400==0) ||(num % 4 == 0 &&  num % 100 != 0)){
                    System.out.println("Nam  " + num + " la nam nhuan ");
                }else{
                    System.out.println("Nam " + num + " la nam thuong");
                }
                Activity3.number = null;
                try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        else if(Thread.currentThread().getName().equals("GEN")){
            if(Activity3.number == null){
                Random random = new Random();
                Activity3.number = 1000 + random.nextInt(9999);
                System.out.println("Gen " + Activity3.number);
            }
        }
    }
}
class Thread3 extends Thread{
    Number number ;

    public Thread3(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        while(true) {
            number.checkAndGen();
        }
    }
}

