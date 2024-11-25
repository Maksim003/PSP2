package com.company.task2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    private ConcurrentLinkedQueue<Place> places;
    public int id_parking;
    public Semaphore semaphore;

    public Parking(ConcurrentLinkedQueue<Place> places, int id_parking) {
        this.places = places;
        semaphore = new Semaphore(places.size(), true);
        this.id_parking = id_parking;
    }

    public ConcurrentLinkedQueue<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ConcurrentLinkedQueue<Place> places) {
        this.places = places;
    }

    public int getId_parking() {
        return id_parking;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking;
    }

    public Place bookPlace() {
        Place place = null;
        try {
            if (semaphore.tryAcquire(Main.timeout, TimeUnit.MILLISECONDS)) {
                place = places.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return place;
    }

    public void releasePlace(Place place) {
        places.add(place);
        semaphore.release();
    }
}
