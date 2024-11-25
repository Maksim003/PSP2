package com.company.task2;

public class Car extends Thread {

    OfficeOfParking officeOfParking;

    public Car(OfficeOfParking officeOfParking, int num) {
        super("" + num);
        this.officeOfParking = officeOfParking;
    }

    public void run() {
        Place place = null;
        System.out.println("Машина " + Thread.currentThread().getName() + " приехала");
        while (place == null) {
            place = officeOfParking.bookPlaceOfParking();
        }
        System.out.println("Машина " + Thread.currentThread().getName() + " заняла " + place.getId_place() +" место" +
                " на парковке " + place.getId_parking());
        place.waitPlace();
        while (true){
            if(officeOfParking.releasePlaceOfParking(place)){
                break;
            }
        }

        System.out.println("Машина " + Thread.currentThread().getName() + " уехала");
    }

}
