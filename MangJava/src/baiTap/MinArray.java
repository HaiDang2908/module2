package baiTap;

import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {

   
    Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng :");
    int count = nhap.nextInt();
    int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
        System.out.println("Giá trị thứ " + (i + 1) + "của mảng :");
        array[i] = nhap.nextInt();
    }

        System.out.print("Danh sách mảng :");
        for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }

    int min = array[0];
        for (int i = 0; i < array.length; i++) {
        if (array[i] < min) {
            min = array[i];
        }
    }
        System.out.println("Min :" + min);

}
}
