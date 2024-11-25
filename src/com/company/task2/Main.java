package com.company.task2;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static long timeout = 1500;

    public static void main(String[] args) {
        Place place1_1 = new Place(1, 1);
        Place place2_1 = new Place(2, 1);
        Place place3_1 = new Place(3, 1);
        Place place4_1 = new Place(4, 1);
        Place place5_1 = new Place(5, 1);
        Place place1_2 = new Place(1, 2);
        Place place2_2 = new Place(2, 2);
        Place place3_2 = new Place(3, 2);
        ConcurrentLinkedQueue<Place> places1 = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedQueue<Place> places2 = new ConcurrentLinkedQueue<>();
        places1.add(place1_1);
        places1.add(place2_1);
        places1.add(place3_1);
        places1.add(place4_1);
        places1.add(place5_1);
        places2.add(place1_2);
        places2.add(place2_2);
        places2.add(place3_2);
        Parking parking1 = new Parking(places1,1);
        Parking parking2 = new Parking(places2,2);
        ArrayList<Parking> parkings = new ArrayList<>(2);
        parkings.add(parking1);
        parkings.add(parking2);
        OfficeOfParking officeOfParking = new OfficeOfParking(parkings);
        for (int i = 0; i < 10; i++) {
            Car car = new Car(officeOfParking, i + 1);
            car.start();
        }

    }
}
