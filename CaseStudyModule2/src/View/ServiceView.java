package View;

import Model.Account;
import Model.Computer;
import Model.Service;
import io.ReadAndWrite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceView {


    AccountView accountView = new AccountView();
    ReadAndWrite<Service> readAndWrite = new ReadAndWrite<>();

    public static final String FILE_PATH = "C:\\Users\\admin\\OneDrive\\Desktop\\module2\\CaseStudyModule2\\src\\service.txt";

    static List<Service> services = new ReadAndWrite<Service>().readFromFile(FILE_PATH);
    Scanner nhap = new Scanner(System.in);

    public Service creatService(){
        int id;
        System.out.println("Nhập tên dịch vụ");
        String name = nhap.nextLine();
        System.out.println("Nhập giá dịch vụ");
        double price = Double.parseDouble(nhap.nextLine());
        id = services.size();
        Service service = new Service(id,name,price);
        return service;
    }

    public void addService(){
        Service service = creatService();
        services.add(service);
        readAndWrite.writeFile(FILE_PATH , services);

    }
    public void showService(){
        System.out.println("☆☆☆     Danh sách dịch vụ     ☆☆☆");
        for (Service ser: services){
            System.out.println(ser);
        }
    }

    public void deleteService(){
        System.out.println("Nhập id dịch vụ muốn xóa");
        int id = Integer.parseInt(nhap.nextLine()) ;
        int index = findIndexByIdService(id);
        if (index >=0 ){
            services.remove(index);
            System.out.println("☆☆☆    Đã xóa thành công    ☆☆☆");
        } else System.err.println("☆☆☆     Không tồn tại dịch vụ    ☆☆☆");
    }

    public void editService(){
        showService();
        System.out.println("Nhập id dịch vụ muốn sửa");
        int id = Integer.parseInt(nhap.nextLine()) ;
        int index = findIndexByIdService(id);
        if (index>=0){
            int choice = -1;
            do {
                System.out.println("Bạn muốn sửa gì nào");
                System.out.println("1. Thay đổi tên dịch vụ");
                System.out.println("2. Thay đổi giá dịch vụ");
                System.out.println("0. Thoát");
                System.out.println("Nhập lựa chọn");
                choice = Integer.parseInt(nhap.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập tên dịch vụ bạn muốn sửa");
                        String name1 = nhap.nextLine();
                        services.get(index).setName(name1);
                        System.out.println("☆☆☆     Bạn đã thay đổi thành công     ☆☆☆ ");
                        readAndWrite.writeFile(FILE_PATH , services);
                        break;
                    case 2:
                        System.out.println("Nhập giá dịch vụ bạn muốn sửa");
                        double price = Double.parseDouble(nhap.nextLine());
                        services.get(index).setPrice(price);
                        System.out.println("☆☆☆      Bạn đã thay đổi thành công      ☆☆☆");
                        readAndWrite.writeFile(FILE_PATH , services);
                        break;

                    case 0:
                        System.out.println("☆☆☆     Đã trở lại    ☆☆☆");
                        break;

                    default:
                        System.err.println("☆☆☆       Vui lòng nhập đúng danh mục     ☆☆☆");
                        break;
                }
            } while (choice != 0);
        }
    }


    public  int findIndexByIdService(int id){
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getId() == id){
                return i;
            }
        } return -1;

    }




    public void orderService(int indexComputer ){
        AccountView accountView1 = new AccountView();
        showService();
        System.out.println("Nhập id dịch vụ");
        int id = services.size();
        nhap.nextLine();
        int indexService = findIndexByIdService(id);
        System.out.println("Nhập tài khoản");
        String account = nhap.nextLine();
        int indexAccount = accountView1.checkIndexByAccount(account);
        if (indexService >= 0){
            accountView.addServiceToAccount(indexAccount,indexService);
            System.out.println("Thêm dịch vụ thành công");


        }


            }




    public void menuService(){
        int choice;
        do {
            System.out.println("                                                MENU");
            System.out.println("                                          1. Thêm dich vụ");
            System.out.println("                                          2. Xóa dich vụ");
            System.out.println("                                          3. Sửa dich vụ");
            System.out.println("                                          4. Hiển thị danh sách dich vụ");
            System.out.println("                                          0. Thoát");
            System.out.println("                                          Nhập lựa chọn");
            choice = Integer.parseInt(nhap.nextLine());
            switch (choice){
                case 1:
                    addService();
                    break;
                case 2:
                    deleteService();
                    break;
                case 3:
                    editService();
                    break;
                case 4:
                    showService();
                    break;
                case 0:
                    System.out.println("☆☆☆       Đã trở lại      ☆☆☆");
                    break;
                default:
                    System.err.println("☆☆☆       Vui lòng nhập đúng danh mục     ☆☆☆");
                    break;

            }
        } while (choice != 0);
    }



}
