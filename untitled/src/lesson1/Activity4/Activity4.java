package lesson1.Activity4;


import java.util.*;

public class Activity4 {
    public static Integer number = null;
    public static Map<String,String> map = new HashMap();
    public static  void main(String[] args){
        map.put("Monday","Thứ hai");
        map.put("Tuesday","Thứ ba");
        map.put("Wednesday","Thứ tư");
        map.put("Thursday","Thứ năm");
        map.put("Friday","Thứ sáu");
        map.put("Saturday","Thứ bảy");
        map.put("Sunday","Chủ nhật");
        Number number = new Number();
        Thread genNumber = new T1(number);
        genNumber.setName("GEN");
        Thread checkNumber = new T2(number);
        checkNumber.setName("CHECK");

        genNumber.start();
        checkNumber.start();
    }
}
class Number{
    public synchronized void check(){
        if(Activity4.number != null){
            String value = Activity4.map.keySet().toArray()[Activity4.number].toString();
            System.out.println(" " + value);
            Activity4.number = null;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void gen(){
        if(Activity4.number == null){
            Random random = new Random();
            Activity4.number = random.nextInt(7);
            String value = Activity4.map.keySet().toArray()[Activity4.number].toString();
            System.out.println("" + Activity4.map.get(value));
        }
    }
}
class T1 extends Thread{
    Number number;

    public T1(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true){
            number.gen();
        }
    }
}
class T2 extends  Thread{
    Number number;

    public T2(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true){
            number.check();
        }
    }
}
