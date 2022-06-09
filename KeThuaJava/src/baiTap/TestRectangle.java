package baiTap;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        System.out.println(rectangle1);

        rectangle1 = new Rectangle(2.3,5.8);
        System.out.println(rectangle1);

        rectangle1 = new Rectangle("orange",true,2);
        System.out.println(rectangle1);
    }
}
