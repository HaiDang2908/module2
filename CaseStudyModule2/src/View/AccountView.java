package View;

import Model.Account;
import Model.Service;
import Service.AccountService;
import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountView {
    private List<Account> accounts = new ReadAndWrite<Account>().readFromFile(FILE_PATH);
   AccountService accountService = new AccountService();
   ReadAndWrite<Account> readAndWrite = new ReadAndWrite<>();
    public static final String FILE_PATH = "C:\\Users\\admin\\OneDrive\\Desktop\\module2\\CaseStudyModule2\\src\\account.txt";
    Scanner nhap = new Scanner(System.in);

    public List<Account> getAccounts(){
        return  accounts;
    }
    public void showAccount() {
        System.out.println("☆☆☆     Danh sách tài khoản    ☆☆☆");
//        System.out.println("Tài khoản Mật khẩu Tiền");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }


    public Account creatAccount() {
        System.out.println("☆☆☆       Nhập tài khoản       ☆☆☆");
        String account = nhap.nextLine();
        System.out.println("☆☆☆       Nhập mật khẩu        ☆☆☆");
        String password = nhap.nextLine();

        return new Account(account, password);
    }

    public void addAccount() {
            Account account = creatAccount();
            if (checkIndexByAccount(account.getAccount()) < 0){
                accounts.add(account);
                System.out.println("☆☆☆      Đăng ký thành công     ☆☆☆");
            } else System.err.println("☆☆☆    Tài khoản đã tồn tại     ☆☆☆\n       Vui lòng chọn tên khác");
            readAndWrite.writeFile(FILE_PATH , accounts);



    }


    public void editPassword( ) {
        System.out.println("☆☆☆       Nhập tài khoản      ☆☆☆");
        String account=nhap.nextLine();
        int index = checkIndexByAccount(account);
        if (index>0){
            System.out.println("☆☆☆      Nhập mật khẩu mới       ☆☆☆");
            accounts.get(index).setPassword(nhap.nextLine());
            System.out.println("☆☆☆    Bạn đã thay đổi thành công     ☆☆☆");
        }else System.err.println("☆☆☆     Không tồn tại tài khoản     ☆☆☆");
        readAndWrite.writeFile(FILE_PATH , accounts);

    }


    public void deleteAccount() {
        System.out.println("☆☆☆       Nhập tài khoản muốn xóa     ☆☆☆");
        showAccount();
        String account = nhap.nextLine();
        int id = checkIndexByAccount(account);
        accounts.remove(id);
        System.out.println("☆☆☆     Bạn đã xóa thành công     ☆☆☆");
    }

    public void addServiceToAccount(int indexAccount , int indexService){
        List<Service> services = new ArrayList<>();
        services.get(indexService);
        services.get(indexAccount).setId(indexService);
        double money = accounts.get(indexAccount).getMoney() - services.get(indexService).getPrice();
        accounts.get(indexAccount).setMoney(money);
    }


    public void addMoneyToAccount(){
        System.out.println("☆☆☆       Nhập tài khoản muốn thêm tiền      ☆☆☆");
        String account = nhap.nextLine();
        int index = checkIndexByAccount(account);
            if (index >= 0){
                System.out.println("☆☆☆      Nhập số tiền     ☆☆☆");
                double money = Double.parseDouble(nhap.nextLine());
                accounts.get(index).setMoney(accounts.get(index).getMoney()+money);
                System.out.println("☆☆☆     Nạp tiền thành công     ☆☆☆");
                readAndWrite.writeFile(FILE_PATH , accounts);
            } else System.err.println("☆☆☆     Không tồn tại tài khoản này     ☆☆☆\n              Vui lòng nhập lại");


    }


    public void menuAccount(){
        int choice;
        do {
            System.out.println("                        🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸    ");
            System.out.println("                        🌸☆🌸                    QUẢN LÝ TÀI KHOẢN                 🌸☆🌸            ");
            System.out.println("                        🌸☆🌸                1. Thêm tài khoản                     🌸☆🌸      ");
            System.out.println("                        🌸☆🌸                2. Xóa tài khoản                      🌸☆🌸           ");
            System.out.println("                        🌸☆🌸                3. Hiển thị danh sách tài khoản       🌸☆🌸                ");
            System.out.println("                        🌸☆🌸                4. Đổi mật khẩu                       🌸☆🌸                     ");
            System.out.println("                        🌸☆🌸                5. Nạp tiền vào tài khoản             🌸☆🌸                       ");
            System.out.println("                        🌸☆🌸                0. Thoát                              🌸☆🌸                        ");
            System.out.println("                        🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸 ");
            System.out.println("🌸☆🌸☆🌸              Nhập lựa chọn         🌸☆🌸☆🌸");
            choice= Integer.parseInt(nhap.nextLine());
            switch (choice){
                case 1:
                    addAccount();
                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    showAccount();
                    break;
                case 4:
                    editPassword();
                    break;
                case 5:
                    addMoneyToAccount();
                    break;
                case 0:
                    System.out.println("☆☆☆         Đã trở lại      ☆☆☆");
                default:
                    System.err.println("☆☆☆       Vui lòng nhập đúng danh mục      ☆☆☆");
            }

        } while (choice != 0);
    }

    public int checkIndexByAccount(String account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccount().equals(account)){
                return i;
            }
        }
        return -1;
    }
    public void gameLOL(){

    }
     public void gameFifa(){
    }
     public void gameBall(){
    }
     public void gameChicken(){
    }
     public void gameHuka(){
    }
     public void gameBoxing(){
    }


    public void menuGame(){
        int choice;
        do {
            System.out.println("                             🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                          ");
            System.out.println("                             🌸☆🌸☆🌸           1. Game Liên Minh Huyền Thoại        🌸☆🌸☆🌸                   ");
            System.out.println("                             🌸☆🌸☆🌸           2. Game Fifa                         🌸☆🌸☆🌸                   ");
            System.out.println("                             🌸☆🌸☆🌸           3. Game Đấu Vật                      🌸☆🌸☆🌸                ");
            System.out.println("                             🌸☆🌸☆🌸           4. Game Bắn Bóng                     🌸☆🌸☆🌸                   ");
            System.out.println("                             🌸☆🌸☆🌸           5. Game Bắn Gà                       🌸☆🌸☆🌸                      ");
            System.out.println("                             🌸☆🌸☆🌸           6. Game Chơi Đồ                      🌸☆🌸☆🌸                        ");
            System.out.println("                             🌸☆🌸☆🌸           0. Thoát                             🌸☆🌸☆🌸                          ");
            System.out.println("                             🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                                            ");
            System.out.println("🌸☆🌸☆🌸             Nhập lựa chọn                      🌸☆🌸☆🌸                             ");
            choice = Integer.parseInt(nhap.nextLine());
            switch (choice){
                case 1:
                    gameLOL();
                    break;
                case 2:
                    gameFifa();
                    break;
                case 3:
                    gameBoxing();
                    break;
                case 4:
                    gameBall();
                    break;
                case 5:
                    gameChicken();
                    break;
                case 6:
                    gameHuka();
                    break;
                case 0:
                    System.out.println("☆☆☆      Đã trở lại     ☆☆☆");
                    break;
                default:
                    System.err.println("☆☆☆      Vui lòng nhập đúng danh mục     ☆☆☆");
                    break;
            }
        } while (choice != 0 );

    }


    public void userLogin(){
        ServiceView serviceView = new ServiceView();
     ComputerView computerView = new ComputerView();
     int choice = -1;
     do {
         System.out.println("                                   🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸              ");
         System.out.println("                                   🌸☆🌸            MENU NGƯỜI DÙNG         🌸☆🌸        ");
         System.out.println("                                   🌸☆🌸             1. Chọn máy            🌸☆🌸             ");
         System.out.println("                                   🌸☆🌸             0. Thoát               🌸☆🌸                ");
         System.out.println("                                   🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸               ");
         System.out.println("🌸☆🌸             Nhập lựa chọn          🌸☆🌸                     ");
         choice = Integer.parseInt(nhap.nextLine());
         switch (choice) {
             case 1:
                 System.out.println("Chọn máy muốn chơi");
                 int id = Integer.parseInt(nhap.nextLine());
                 if (computerView.checkComputerIsOnline(id)) {
                     System.err.println("☆☆☆     Có người chơi rồi bạn nhé.Vui lòng chọn máy khác     ☆☆☆");
                     break;
                 }
                 int indexComputer = computerView.findIndexByIdComputer(id);
                 if (indexComputer >= 0) {
                     Account account = creatAccount();
                     if (loginAccount(account)) {


                     computerView.resetStatus(id);
                     int select;
                     do {
                         System.out.println("                                     🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                      ");
                         System.out.println("                                     🌸☆🌸              MENU MÁY              🌸☆🌸                      ");
                         System.out.println("                                     🌸☆🌸            1. Menu Game            🌸☆🌸            ");
                         System.out.println("                                     🌸☆🌸            2. Gọi dịch vụ          🌸☆🌸            ");
                         System.out.println("                                     🌸☆🌸            0. Thoát                🌸☆🌸                     ");
                         System.out.println("                                     🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                    ");
                         System.out.println("🌸☆🌸            Nhập lựa chọn           🌸☆🌸                        ");
                         select = Integer.parseInt(nhap.nextLine());
                         switch (select) {
                             case 1:
                                 menuGame();
                                 break;
                             case 2:
                                 serviceView.orderService(indexComputer);
                                 break;
                             case 0:
                                 System.out.println("☆☆☆       Đã trở lại      ☆☆☆");
                                 break;

                             default:
                                 System.err.println("☆☆☆      Vui lòng nhập đúng danh mục     ☆☆☆");
                                 break;
                         }
                     } while (select != 0);
                 } else System.err.println("☆☆☆      Tài khoản hoặc mật khẩu không đúng     ☆☆☆\n                  Vui lòng nhập lại");

                     break;

         }

                 default:
                 System.err.println("☆☆☆      Vui lòng nhập đúng danh mục     ☆☆☆");
                 break;
     }
     } while (choice != 0);
    }


    public int findIndexByLoginAccount(Account account){
        for (int i = 0; i < accounts.size(); i++) {
            if (account.getAccount().equals(accounts.get(i).getAccount())){
                return i;
            }

        } return -1;
    }



    public boolean loginAdmin(Account account) {
        if (account.getAccount().equals("admin") && account.getPassword().equals("admin")) {
            return true;
        }
        return false;
    }


    public boolean loginAccount(Account account) {

//        for (int i = 0; i < accounts.size(); i++) {
//            if (accounts.get(i).getAccount().equals(account.getAccount()) && accounts.get(i).getPassword().equals(account.getPassword())){
//                return i;
//            }
//
//        } return -1;
        for (Account acc : accounts) {
            if (acc.getAccount().equals(account.getAccount()) && acc.getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }


    public void menuLogin() {
        ComputerView computerView = new ComputerView();
        int choice = -1;
        do {
            System.out.println("                            🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                                                                                                            " );
            System.out.println("                            🌸☆🌸☆🌸                        MENU                               🌸☆🌸☆🌸          ");
            System.out.println("                            🌸☆🌸☆🌸                  1. Đăng nhập admin                       🌸☆🌸☆🌸                ");
            System.out.println("                            🌸☆🌸☆🌸                  2. Đăng nhập người dùng                  🌸☆🌸☆🌸               ");
            System.out.println("                            🌸☆🌸☆🌸                  0. Exit                                  🌸☆🌸☆🌸            ");
            System.out.println("                            🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸☆🌸                   ");
            System.out.println("🌸☆🌸☆🌸       Nhập lựa chọn      🌸☆🌸☆🌸                                                           ");
            choice = Integer.parseInt(nhap.nextLine());
            switch (choice) {
                case 1:
                    Account account = creatAccount();
                    if (loginAdmin(account)) {
                        computerView.menuComputer();

                    } else
                        System.err.println("☆☆☆     Tài khoản hoặc mật khẩu không đúng     ☆☆☆");
                    break;
                case 2:
                    userLogin();
                    break;
                case 0:
                    System.out.println("☆☆☆       Đã trở lại      ☆☆☆");
                    break;
                default:
                    System.err.println("☆☆☆      Vui lòng nhập đúng danh mục     ☆☆☆");
                    break;
            }
        } while (choice != 0);


    }
}
