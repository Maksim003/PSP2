package com.company.task1;

public class MyThread extends Thread {

    Workers workers;
    Clients clients;

    public MyThread(Workers workers, Clients clients) {
        this.workers = workers;
        this.clients = clients;
    }

    public void run() {
        while (true) {
            if (clients.getCount() == 0) {
                break;
            }
            clients.serveClients();
            workers.countClients();
            try {
                Thread.sleep(workers.getTime() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
