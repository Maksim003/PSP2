package com.company.task2;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class OfficeOfParking {
    private ArrayList<Parking> parkings;
    private final ReentrantLock lock = new ReentrantLock();

    public OfficeOfParking(ArrayList<Parking> parkings) {
        this.parkings = parkings;
    }

    public ArrayList<Parking> getParkings() {
        return parkings;
    }

    public void setParkings(ArrayList<Parking> parkings) {
        this.parkings = parkings;
    }

    public Place bookPlaceOfParking() {
        Place place = null;
        for (Parking parking : parkings) {
            place = parking.bookPlace();
            if (place != null) {
                return place;
            }
        }
        return place;
    }

    public boolean releasePlaceOfParking(Place place) {
        boolean isRelease = false;
        if (lock.tryLock()) {
            for (Parking parking: parkings) {
                if (place.getId_parking() == parking.getId_parking()) {
                    parking.releasePlace(place);
                }
            }
            isRelease = true;
            lock.unlock();
        }
        return isRelease;
    }
}
