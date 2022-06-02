import java.util.Scanner;

public class thTinhDienTichHinhChuNhat {
    static public  void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        double a,b;
        System.out.println("Nhập vào số a");
        a = nhap.nextDouble();
        System.out.println("Nhập vào số b");
        b = nhap.nextDouble();
        System.out.println(hcn(a,b));
    }
    static String  hcn(double a,double b){
        double area = a*b;
        return "Diện tích là :"+area;
    }
}
