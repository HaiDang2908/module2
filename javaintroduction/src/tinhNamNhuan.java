import java.util.Scanner;

public class tinhNamNhuan {
    public static void main(String[] args) {
        int year;
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập số năm");
        year = nhap.nextInt();
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ){
            System.out.println(year + " là năm nhuận");
        } else {
            System.out.println(year + " không phải năm nhuận");
        }
    }
}
