
import java.util.Scanner;

public class chuyenTienTe {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập số tiền");
        double vnd = 23000;
        double usd = nhap.nextDouble();
        double quydoi = usd*23000;
        System.out.println("số tiền VND là : " + quydoi);

    }
}
