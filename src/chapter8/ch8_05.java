package chapter8;

public class ch8_05 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(4/0);
            System.out.println(5);
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException!");
        }
        System.out.println(6);
    }
}
