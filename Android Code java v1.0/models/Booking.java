package com.drivehub.models;

public class Booking {
    public enum Status {
        PENDING, APPROVED, REJECTED, CANCELLED, COMPLETED
    }

    private String bookingID;
    private String startDate;
    private String endDate;
    private Car car;
    private Renter renter;
    private Status status;
    private Dispute dispute;

    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public Booking(Car car, Renter renter, String startDate, String endDate) {
        this.car = car;
        this.renter = renter;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = Status.PENDING;
        this.bookingID = generateBookingID(); // Μπορείς να το αντικαταστήσεις με UUID αν θέλεις
    }

    private String generateBookingID() {
        return "BK" + System.currentTimeMillis(); // Απλό ID
    }

    public double calculateTotal() {
        return car.getPrice(); // Μπορείς να προσθέσεις λογική πολλαπλασιασμού με τις μέρες
    }

    public void cancel(String reason) {
        this.status = Status.CANCELLED;
        // Optionally αποθήκευσε το reason
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }

    public void setDispute(Dispute dispute) {
        this.dispute = dispute;
    }

    // === ✅ Getters ===

    public String getBookingID() {
        return bookingID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Car getCar() {
        return car;
    }

    public Renter getRenter() {
        return renter;
    }

    public Status getStatus() {
        return status;
    }

    public Dispute getDispute() {
        return dispute;
    }
}
