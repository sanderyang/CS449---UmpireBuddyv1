package com.example.umpirebuddy_yang;

public class AppVariables {
    private int count = 0;
    private int count2 = 0;

    public int getCount() {
        return this.count;
    }

    public int getCount2() {
        return this.count2;
    }

    public void addToCount() {
        this.count++;
    }

    public void addToCount2() {
        this.count2++;
    }

    public void setCount(int num) {
        this.count = num;
    }

    public void setCount2(int num) {
        this.count2 = num;
    }
}
