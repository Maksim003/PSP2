package com.company.task1;

public class Workers {

    private int time;
    private int count;


    public Workers(int time, int count) {
        this.time = time;
        this.count = count;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void countClients() {
        this.count += 1;
    }
}
