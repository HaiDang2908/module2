import java.util.Scanner;

public class thTinhCanNang {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập cân nặng của bạn");
        double weight = nhap.nextDouble();
        System.out.println("Nhập chiều cao cảu bạn");
        double height = nhap.nextDouble();
        double bmi = weight/ Math.pow(height,2);
        if (bmi<18.5){
            System.out.println("Bạn hơi gầy");
        } else if (bmi<=25){
            System.out.println("Chỉ số của bạn bình thường");
        } else if (bmi<30){
            System.out.println("Bạn hơi mập");
        } else {
            System.out.println("Bạn quá mập");
        }
    }
}
