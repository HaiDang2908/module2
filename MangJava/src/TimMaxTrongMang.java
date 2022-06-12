import java.util.Scanner;

public class TimMaxTrongMang {
    public static void main(String[] args) {
        int count;
        int[] array;
        Scanner nhap = new Scanner(System.in);
        do {
            System.out.println("Nhập số lượng giá trị muốn tìm");
            count = nhap.nextInt();
            if (count > 20) {
                System.out.println("không đc nhập quá 20 giá trị");
            }
        } while (count > 20);
        array = new int[count];
        int i = 0;
        while (i < array.length) {
            System.out.println("Nhập giá trị " + (i + 1) + ": ");
            array[i] = nhap.nextInt();
            i++;
        }
        System.out.println("Danh sách giá trị :");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max){
                max = array[j];
                index = j;
            }
        }
        System.out.println("Giá trị lớn nhất là :" + max + " vị trí " + index);
    }
}