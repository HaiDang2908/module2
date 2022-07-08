package Model;

import java.time.LocalDateTime;

public class Turnover {
    private double money;
    private LocalDateTime time;


    public Turnover() {
    }

    public Turnover(double money, LocalDateTime time) {
        this.money = money;
        this.time = time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Turnover{" +
                "money=" + money +
                ", time=" + time +
                '}';
    }
}
