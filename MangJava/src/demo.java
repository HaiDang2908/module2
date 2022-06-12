import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        int count;
        int [] array;
        Scanner nhap = new Scanner(System.in);
        do {
            System.out.println("Enter a count");
            count = nhap.nextInt();
            if (count > 20){
                System.out.println("Count doesn't exceed 20");
            }
        } while (count > 20);
        array = new int[count];
        int i = 0;
        while (i < array.length){
            System.out.println("Enter element" + (i + 1) + ": ");
            array[i] = nhap.nextInt();
            i++;
        }
        System.out.println("%-20s%" +"Element in array :"+ "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        for (int j = 0; j < array.length/2; j++) {
            int temp = array[j];
            array[j] = array[count - 1 - j];
            array[count-1-j] = temp;
        }
        System.out.println("\n%-20s%s" + "Reverse array: "+ "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j]+ "\t");

        }




    }
}
