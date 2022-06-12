import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập các giá trị cần tìm : ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i =0;i<arr.length;i++){
            System.out.println("Giá trị thứ " +(i+1)+ ": ");
            arr[i] = input.nextInt();
        }
        System.out.println("Danh sách các giá trị :");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println("Nhập số bạn muốn xóa : ");
        int num = input.nextInt();
        int index = 0;
        for (int i =0;i<arr.length;i++){
            if (arr[i]== num){
                index =i;
                System.out.println("Số của mảng");
                break;
            }
        }
        for (int i = index;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1] = 0;
        System.out.println("Danh sách giá trị mới :");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }

    }
}


