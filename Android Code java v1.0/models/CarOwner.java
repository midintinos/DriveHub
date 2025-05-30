package com.drivehub.models;

import java.util.ArrayList;
import java.util.List;

public class CarOwner extends User {
    private List<Car> cars = new ArrayList<>();

    public Car registerCar(Car car) {
        cars.add(car);
        return car;
    }

    private boolean isBanned = false;

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        this.isBanned = banned;
    }


    public void updateCarInfo(String carID, Car newData) {
        for (Car car : cars) {
            if (car.getCarID().equals(carID)) {
                car.updateInfo(newData);
            }
        }
    }

    public void approveBooking(Booking booking) {
        booking.updateStatus(Booking.Status.APPROVED);
    }

    public void rejectBooking(Booking booking) {
        booking.updateStatus(Booking.Status.REJECTED);
    }

    public List<Car> getCars() {
        return cars;
    }
}
