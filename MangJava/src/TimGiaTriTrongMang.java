import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] student = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory"};
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập tên học sinh cần tìm");
        String name = nhap.nextLine();
        boolean isExit = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(name)) {
                System.out.println("Vị trí của học sinh " + name + " trong danh sách " + " là :" + i);
                isExit = true;
                break;
            }
        }
        if (!isExit){
            System.out.println(name + " không có trong danh sách");
        }
    }
}

