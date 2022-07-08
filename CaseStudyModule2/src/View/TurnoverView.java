package View;

import Model.Turnover;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

public class TurnoverView {
    ArrayList<Turnover> turnovers = new ArrayList<>();
    Scanner nhap = new Scanner(System.in);


    public void showAll(){
        double sum = 0;
        System.out.println("Tên máy ");

    }

    public void turnoverByDay(){

    }

    public void turnoverByMonth(){

    }

    public void turnoverByYear(){

    }

    public void showTurnoverByYearMonthDay(){
        int choice = -1;
        do {
            System.out.println("MENU HIỂN THỊ DOANH THU THEO NGÀY THÁNG NĂM");
            System.out.println("1. HIỂN THỊ DOANH THU THEO NGÀY");
            System.out.println("2. HIỂN THỊ DOANH THU THEO THÁNG");
            System.out.println("3. HIỂN THỊ DOANH THU THEO NĂM");
            System.out.println("0. THOÁT");
            System.out.println("Nhập lựa chọn");
            choice = Integer.parseInt(nhap.nextLine());
            switch (choice){
                case 1:
                    turnoverByDay();
                    break;
                case 2:
                    turnoverByMonth();
                    break;
                case 3:
                    turnoverByYear();
                    break;
            }

        }  while ( choice != 0);
    }
}
