package thiModule2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public final String FILE_PATH = "product.csv";
    ArrayList <Product> products = new ArrayList<>();
    Scanner nhap = new Scanner(System.in);

    public Product creatProduct(){
        int id;
        id = products.size();
        System.out.println("Nhập tên sản phẩm");
        String name = nhap.nextLine();
        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(nhap.nextLine()) ;
        System.out.println("Nhập số lượng sản phẩm");
        int amount = nhap.nextInt();
        System.out.println("Nhập mô tả sản phẩm");
        String describe = nhap.nextLine();
        Product product = new Product( id, name,price,amount,describe);

        return product;

    }


    public void addProduct() {
       Product product = creatProduct();
       products.add(product);
       writer(FILE_PATH , products);

        }

    public void showProduct(){
        for (Product pro: products) {
            System.out.println(pro);
            writer(FILE_PATH , products);
        }


    }

    public void deleteProduct(){
        showProduct();
        System.out.println("Nhập id sản phẩm cần xóa");
        int id = Integer.parseInt(nhap.nextLine());
        int index = findIndexByIdProduct(id);
        if (index >= 0){
            products.remove(index);
            System.out.println("Đã xóa thành công");
            writer(FILE_PATH , products);
        } else System.err.println("Không tìm thấy id sản phẩm");

    }

    public void findTheMostExpensiveProduct(){
        double price = 0;
        int k = 0;
        for (int i=0;i<products.size();i++){
            if (price<products.get(i).getPrice()){
                price = products.get(i).getPrice();
                k=i;
            }
        }
        System.out.println(products.get(k));




    }

    public void editProduct(){
        showProduct();
            System.out.print("Nhập id sẩn phẩm cần sửa: ");
            int id= Integer.parseInt(nhap.nextLine());
            int index = findIndexByIdProduct(id);
            if (index >= 0){
            for (int i = 0; i < products.size(); i++){
                if (products.get(i).getId() == id){
                    System.out.print("Tên mới: ");
                    String name =nhap.nextLine();
                    System.out.print("Gía mới: ");
                    double price = Integer.parseInt(nhap.nextLine());
                    System.out.print("Số lượng mới: ");
                    int amount =  Integer.parseInt(nhap.nextLine());
                    System.out.print("Mô tả mới: ");
                    String describe =nhap.nextLine();
                    products.get(i).setName(name);
                    products.get(i).setPrice(price);
                    products.get(i).setAmount(amount);
                    products.get(i).setDescribe(describe);
                    writer(FILE_PATH , products);
                }
            }

            }System.err.println("Không tìm thấy id sản phẩm !");
        }



    public int findIndexByIdProduct(int id){
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getId() == id) {
                return i;

            }
        } return -1;
    }

    public void shortProduct(){

    }





    public void writer(String filePath, List<Product> list){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i)+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void reader(){

    }

    public void menuProduct() {
        int choice;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm kiếm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn");
            choice = Integer.parseInt(nhap.nextLine());
            switch (choice) {
                case 1:
                    showProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    shortProduct();
                    break;
                case 6:
                    findTheMostExpensiveProduct();
                    break;
                case 7:
                    reader();
                    break;
                case 8:
                    writer(FILE_PATH , products);
                    break;
                case 0:
                    System.out.println("Đã trở lại");
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 0 đến 9");
                    break;

            }
        } while (choice != 0);
    }

}
