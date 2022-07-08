package Model;

import java.io.Serializable;

public class Account implements Serializable {
    private String account;
    private String password;
    private double money;


    public Account() {
    }

    public Account(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Account(String account, String password , double money) {
        this.account = account;
        this.password = password;
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
