package com.drivehub;

import com.drivehub.models.Booking;
import com.drivehub.models.Car;

import java.util.ArrayList;
import java.util.List;

public class BookingStore {
    private static BookingStore instance;
    private List<Booking> bookings;

    private BookingStore() {
        bookings = new ArrayList<>();
    }

    public static BookingStore getInstance() {
        if (instance == null) {
            instance = new BookingStore();
        }
        return instance;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    // ✅ Αυτό προσθέτεις για να διορθωθεί το σφάλμα:
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        for (Booking booking : bookings) {
            if (!cars.contains(booking.getCar())) {
                cars.add(booking.getCar());
            }
        }
        return cars;
    }
}
