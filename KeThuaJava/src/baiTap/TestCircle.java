package baiTap;

import java.util.concurrent.Callable;

public class TestCircle {
    public static void main(String[] args) {
     Circle circle1 = new Circle();
        System.out.println(circle1);

        circle1 = new Circle(3.5);
        System.out.println(circle1);

        circle1 = new Circle("indigo",false,3.5);
        System.out.println(circle1);

    }
}
