import java.util.Scanner;

public class giaiPT {
    public static void main(String[] args) {
        Scanner ptbac1 = new Scanner(System.in);
        double a, b, c;
        System.out.println("Nhập số a");
        a = ptbac1.nextDouble();
        System.out.println("Nhập số b");
        b = ptbac1.nextDouble();
        System.out.println("Nhập số c");
        c = ptbac1.nextDouble();

        if (a == 0){
            if (b==c){
                System.out.println("PT vô số nghiệm");
            } else {
                System.out.println("PT vô nghiệm");
            }
        }  else {
            double kq = (c-b)/a ;
            System.out.println("kết quả là : "+kq);
        }
    }
}


