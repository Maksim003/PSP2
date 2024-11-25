package com.company.task1;

public class Clients {
    private int count;
    private int time;

    public Clients(int count, int time) {
        this.count = count;
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public synchronized void serveClients() {
        this.count -= 1;
    }

}
