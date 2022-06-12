package baiTap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {

        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng 1");
        int count = nhap.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.println("giá trị thứ " + (i + 1) + "của mảng 1 :");
            array[i] = nhap.nextInt();

        }
        System.out.println("Danh sách phần tử mảng 1 :");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }



        System.out.println("Nhập số lượng phần tử của mảng 2");
        int  count1 = nhap.nextInt();
        int[] array1 = new int[count1];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("giá trị thứ " + (i + 1) + "của mảng 2 :");
            array1[i] = nhap.nextInt();
        }
        System.out.println("Danh sách phần tử mảng 2 :");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");

        }

        int[] array2 = new int[count + count1];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        for (int i = count; i < array2.length; i++) {
            array2[i] = array1[i-count];
        }

        System.out.println("Danh sách mảng mới :");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");

        }

    }
}
