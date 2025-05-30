package com.drivehub.models;

public class Dispute {
    private String disputeID;
    private String description;
    private Booking booking;
    private Renter openedBy;
    private Admin resolvedBy;

    public Dispute(String description, Booking booking, Renter openedBy) {
        this.description = description;
        this.booking = booking;
        this.openedBy = openedBy;
    }

    public void resolve(String resolutionText, Admin admin) {
        this.resolvedBy = admin;
        // Μπορείς να αποθηκεύσεις και το resolutionText αν θέλεις
    }

    public Booking getBooking() {
        return booking;
    }

    public Renter getOpenedBy() {
        return openedBy;
    }
}
