import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

import java.util.Scanner;

public class AddElementInArray {
    public static void main(String[] args) {
        int count;
        int[] array;
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng");
        count = nhap.nextInt();
        array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Giá trị thứ " + (i + 1)+ ": ");
            array[i] = nhap.nextInt();
        }
        System.out.println("Danh sách các giá trị là : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("Nhập số cần thêm :");
        int number = nhap.nextInt();
        System.out.println("Nhập vị trí mà bạn muốn thêm vào :");
        int index = nhap.nextInt();
        int[] arr = new int[count+1];
        for (int i = 0; i < index-1 ; i++) {
            arr[i] = array[i];
            }
        arr[index-1]=number;
        for (int i = index-1; i < array.length ; i++) {
            arr[i+1] = array[i];
        }

        System.out.print("Danh sách mảng mới là : " );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        }
    }

