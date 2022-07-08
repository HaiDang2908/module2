package Model;

import java.io.Serializable;

public class Computer implements Serializable {
    private String name;
    private int id;
    private double money;
    private double date;
    private boolean status;
    private long startTime;
    private long endTime;

    private long moneyOnHour = 5000;

    public Computer() {
    }

    public Computer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Computer(String name, int id, double money, double date, boolean status, long startTime, long endTime, long moneyOnHour) {
        this.name = name;
        this.id = id;
        this.money = money;
        this.date = date;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.moneyOnHour = moneyOnHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getMoneyOnHour() {
        return moneyOnHour;
    }

    public void setMoneyOnHour(long moneyOnHour) {
        this.moneyOnHour = moneyOnHour;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", money=" + money +
                ", date=" + date +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", moneyOnHour=" + moneyOnHour +
                '}';
    }
}
