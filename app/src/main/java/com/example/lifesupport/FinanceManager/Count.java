package com.example.lifesupport.FinanceManager;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Count {
    double money;
    String name;
    int type;
    int id;

    public int getId() {
        return id;
    }

    public Count(int id, int type, String name, double money ) {
        this.id=id;
        this.money = money;
        this.name = name;
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
