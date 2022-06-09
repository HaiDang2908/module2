import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        String password;
        do {
            password = nhap.nextLine();
        } while (password.equals("vung oi mo ra"));

    }
}
