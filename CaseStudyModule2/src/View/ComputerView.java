package View;

import Model.Computer;
import Service.AccountService;
import com.sun.media.sound.AiffFileReader;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.BindingIDFactory;
import io.ReadAndWrite;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerView {
    AccountView accountView = new AccountView();
    ServiceView serviceView = new ServiceView();
    ReadAndWrite<Computer> readAndWrite = new ReadAndWrite<>();
    public static final String FILE_PATH = "C:\\Users\\admin\\OneDrive\\Desktop\\module2\\CaseStudyModule2\\src\\computer.txt";
    static List<Computer> computers = new ReadAndWrite<Computer>().readFromFile(FILE_PATH);

    Scanner nhap = new Scanner(System.in);


    public Computer creatComputer(){
        int id;
            System.out.println("Nhập tên máy");
            String name = nhap.nextLine();
            id = computers.size();
       return new Computer(name,id);
    }


    public void addComputer(){
        Computer computer1 = creatComputer();
        computers.add(computer1);
        readAndWrite.writeFile(FILE_PATH , computers);

    }

    public void showComputerList(){
        System.out.println("☆☆☆     Danh sách máy    ☆☆☆");
        for (Computer com: computers){
            System.out.println(com);
        }
    }
    public void resetStatus(int id){
        for (Computer computer: computers ) {
            if(id == computer.getId()){
                computer.setStatus(true);
            }
        }
    }

    public boolean checkComputerIsOnline(int id){
        for (Computer computer: computers ) {
            if(id == computer.getId()){
                return computer.isStatus();
            }
        }
        return true;

    }

    public void checkComputerIsOffline(){

    }

    public boolean checkStatus(boolean status){
        for (Computer com : computers){

        } return false;
    }
    public void editComputer(){
        showComputerList();
        System.out.println("Nhập id máy muốn sửa");
        int id = Integer.parseInt(nhap.nextLine());
        int index = findIndexByIdComputer(id);
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getId() == index ){
                System.out.println("Nhập tên máy bạn muốn thay đổi");
                String name = nhap.nextLine();
                computers.get(i).setName(name);
                System.out.println("☆☆☆     Bạn đã thay đổi thành công     ☆☆☆");

            } else System.err.println("☆☆☆     Không tồn tại id máy     ☆☆☆");
            readAndWrite.writeFile(FILE_PATH , computers);
        }
    }



    public void deleteComputer(){
        System.out.println("Nhập id máy muốn xóa");
        int id = Integer.parseInt(nhap.nextLine());
        int index = findIndexByIdComputer(id);
        if (index >= 0){
            computers.remove(index);
            System.out.println("☆☆☆      Đã xóa thành công        ☆☆☆");
        }else System.err.println("☆☆☆     Không tồn tại id máy    ☆☆☆");

    }

    public int findIndexByIdComputer(int  id){
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    public void pay(){
        System.out.println("Nhập id máy cần tính tiền");
        int id = Integer.parseInt(nhap.nextLine());
      if (checkComputerIsOnline(id)){
          while (true){
              int indexComputer = findIndexByIdComputer(id);
              if (computers.get(indexComputer).isStatus()){
                  double money = ((computers.get(indexComputer).getEndTime()) - (computers.get(indexComputer).getStartTime())) * computers.get(indexComputer).getMoney();
                  System.out.println(money);




              }
          }
      }

    }

    public void addServiceToCustomer(){
        System.out.println("Nhập id dịch vụ để thêm cho khách");
        int id = Integer.parseInt(nhap.nextLine());
        int index = findIndexByIdComputer(id);
        if (index >= 0){

        }

    }

    public void menuPay(){
        int choice = -1;
        do {
            System.out.println("                                  🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                            ");
            System.out.println("                                  🌸☆🌸          THANH TOÁN TIỀN CHO KHÁCH          🌸☆🌸                             ");
            System.out.println("                                  🌸☆🌸             1. Tính tiền                    🌸☆🌸                               ");
            System.out.println("                                  🌸☆🌸             2. Thêm dịch vụ cho khách       🌸☆🌸                               ");
            System.out.println("                                  🌸☆🌸             0. Thoát                        🌸☆🌸                            ");
            System.out.println("                                  🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                          ");
            System.out.println("🌸☆🌸             Nhập lựa chọn                   🌸☆🌸                             ");
            choice = Integer.parseInt(nhap.nextLine());
            switch (choice){
                case 1:
                    pay();
                    break;
                case 2:
                    addServiceToCustomer();
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


    public void menuComputer(){
        int choice;
        do {
            System.out.println("                              🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸              ");
            System.out.println("                              🌸☆🌸☆🌸                         QUẢN LÝ ADMIN                     🌸☆🌸☆🌸                  ");
            System.out.println("                              🌸☆🌸☆🌸                   1. Hiển thị danh sách máy               🌸☆🌸☆🌸                  ");
            System.out.println("                              🌸☆🌸☆🌸                   2. Thêm 1 máy mới vào danh sách         🌸☆🌸☆🌸                      ");
            System.out.println("                              🌸☆🌸☆🌸                   3. Sửa thông tin của máy                🌸☆🌸☆🌸                      ");
            System.out.println("                              🌸☆🌸☆🌸                   4. Xóa 1 máy khỏi danh sách             🌸☆🌸☆🌸                       ");
            System.out.println("                              🌸☆🌸☆🌸                   5. Dịch vụ                              🌸☆🌸☆🌸                       ");
            System.out.println("                              🌸☆🌸☆🌸                   6. Quản lý tài khoản đăng nhập          🌸☆🌸☆🌸                        ");
            System.out.println("                              🌸☆🌸☆🌸                   7. Tính tiền                            🌸☆🌸☆🌸                     ");
            System.out.println("                              🌸☆🌸☆🌸                     0. Thoát                              🌸☆🌸☆🌸                          ");
            System.out.println("                              🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸            ");
            System.out.println("🌸☆🌸☆🌸       Nhập lựa chọn       🌸☆🌸☆🌸");
            choice = Integer.parseInt(nhap.nextLine());
            switch (choice){
                case 1:
                   showComputerList();
                   break;
                case 2:
                    addComputer();
                    break;
                case 3:
                    editComputer();
                    break;
                case 4:
                    deleteComputer();
                    break;
                case 5:
                   serviceView.menuService();
                    break;
                case 6:
                    accountView.menuAccount();
                    break;
                case 7:
                    menuPay();
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
