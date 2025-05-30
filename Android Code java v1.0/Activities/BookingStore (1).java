package com.drivehub;

import com.drivehub.models.Booking;
import com.drivehub.models.Car;
import com.drivehub.BookingStore;

import java.util.ArrayList;
import java.util.List;

public class BookingStore {
    private static BookingStore instance;
    private final List<Booking> bookings;

    private BookingStore() {
        bookings = new ArrayList<>();
    }

    // Thread-safe singleton (προαιρετικό αλλά καλό)
    public static synchronized BookingStore getInstance() {
        if (instance == null) {
            instance = new BookingStore();
        }
        return instance;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings); // επιστρέφουμε αντίγραφο για ασφάλεια
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        for (Booking booking : bookings) {
            Car car = booking.getCar();
            if (!cars.contains(car)) {
                cars.add(car);
            }
        }
        return cars;
    }
}
