package BaseExercise;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.*;

@Setter
@Getter
public class Fruit {
    private String name="fruit";

    @Setter
    @Getter
    @ToString
    class Apple  extends Fruit{
        private String name="apple";

    }
     public static void main(String[] args){
         Fruit fruit = new Fruit();
//         fruit.test();
         fruit.demo1();


     }

    private void demo1() {
        String format = String.format("%s,hello,world,%s", "hcj", "pad");
        System.out.println(format);

        int hash = Objects.hash("192.168.2.142","192.168.2.144");
        System.out.println(hash);
        int hash1 = Objects.hash("192.168.2.142");
        System.out.println(hash1);

        int i = Objects.hashCode("192.168.2.142");
        System.out.println(i);
    }

    private void test() {
        Logger com = Logger.getLogger("com");
        com.info("");
        MemoryHandler memoryHandler = new MemoryHandler();
        memoryHandler.setPushLevel(Level.ALL);


        Formatter formatter = new SimpleFormatter();
        String format = formatter.format(new LogRecord(Level.INFO, ""));

        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());

        print(apples);


    }
        //  ArrayList<Fruit> fruits ->   ArrayList<Apple> apples 无关
     //
    private void print(ArrayList<? extends Fruit> fruits) {
        for (Fruit apple:fruits){
            System.out.println(apple);
        }
    }
}
