package com.company.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        int num = 0;
        int hour = 0, min = 0, sec = 0;
        int time = 0;
        Workers worker1 = null;
        Workers worker2 = null;
        Workers worker3 = null;
        Clients clients = new Clients(0, 0);
        while (true) {
            choice = menu();
            switch (choice) {
                case 1:
                    System.out.println("Введите количество посетителей:");
                    num = getPosInt();
                    clients.setCount(num);
                    clients.setTime(0);
                    System.out.println("Введите время обслуживания 1 работника в с:");
                    worker1 = new Workers(getPosInt(), 0);
                    System.out.println("Введите время обслуживания 2 работника в с:");
                    worker2 = new Workers(getPosInt(), 0);
                    System.out.println("Введите время обслуживания 3 работника в с:");
                    worker3 = new Workers(getPosInt(), 0);
                    break;
                case 2:
                    Thread thread1 = new MyThread(worker1, clients);
                    Thread thread2 = new MyThread(worker2, clients);
                    Thread thread3 = new MyThread(worker3, clients);
                    thread1.start();
                    thread2.start();
                    thread3.start();
                    try {
                        thread1.join();
                        thread2.join();
                        thread3.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (worker1 != null && worker2 != null && worker3 != null) {
                        System.out.println("Первый работник обслужил посетителей: " + worker1.getCount() + "\nВторой работник " +
                                "обслужил посетителей: " + worker2.getCount() + "\nТретий работник обслужил посетителей: "
                                + worker3.getCount());
                        if (worker1.getCount() * worker1.getTime() > worker2.getCount() * worker2.getTime() &&
                                worker1.getCount() * worker1.getTime() > worker3.getCount() * worker3.getTime() ) {
                            time = worker1.getTime() * worker1.getCount();
                        }
                        else if (worker3.getCount() * worker3.getTime() > worker2.getCount() * worker2.getTime()) {
                            time = worker3.getTime()* worker3.getCount();
                        }
                        else time = worker2.getTime() * worker2.getCount();
                        hour = time / 3600;
                        min = (time - hour * 3600) / 60;
                        sec = time - (hour * 3600 + min * 60);
                        System.out.println("Время: " + hour + "ч " + min + "м " + sec + "с ");
                        try (FileWriter writer = new FileWriter("clients.txt", false)) {
                            String text = "Количество обслуженных клиентов: " + worker1.getCount() + " " + worker2.getCount() + " " +
                                    worker3.getCount() + "\n" + "Время: " + time + " секунд";
                            writer.write(text);
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    return;
            }
        }

    }

    public static int getPosInt() {
        int x = 0;
        while (true) {
            try {
                x = sc.nextInt();
                if (x < 1) {
                    System.out.println("Введите положительное число");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                sc.nextLine();
            }
        }
        return x;
    }

    public static int menu() {
        int x = 0;
        while (true) {
            System.out.println("1 - Ввести данные\n2 - Посчитать время и количество\n3 - Выход");
            x = getPosInt();

            if (x >= 1 && x <= 3) return x;
        }
    }

}