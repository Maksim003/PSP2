package com.company.task2;

import java.util.concurrent.TimeUnit;

public class Place {
    private int id_place;
    private int id_parking;

    public Place(int id_place, int id_parking) {
        this.id_place = id_place;
        this.id_parking = id_parking;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public int getId_parking() {
        return id_parking;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking;
    }

    public void waitPlace() {
        try {
            TimeUnit.MILLISECONDS.sleep((long) ((Math.random() + 1.3)  * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
