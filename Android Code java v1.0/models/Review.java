package com.drivehub.models;

public class Review {
    private Renter renter;
    private String comment;
    private int rating; // από 1 έως 5
    private boolean isFlagged;
    private String flaggedReason;

    public Review(Renter renter, String comment, int rating) {
        this.renter = renter;
        this.comment = comment;
        this.rating = rating;
        this.isFlagged = false;

        // Αυτόματος έλεγχος για προσβλητικό περιεχόμενο
        if (containsInappropriateLanguage()) {
            flagAsInappropriate("Ακατάλληλη γλώσσα στο σχόλιο");
        }
    }

    public Renter getRenter() {
        return renter;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public String getFlaggedReason() {
        return flaggedReason;
    }

    public void flagAsInappropriate(String reason) {
        this.isFlagged = true;
        this.flaggedReason = reason;
    }

    public boolean containsInappropriateLanguage() {
        String lower = comment.toLowerCase();
        // Εδώ μπορείς να προσθέσεις όσες λέξεις θες
        return lower.contains("βρισιά") || lower.contains("προσβλητικό") || lower.contains("ανάρμοστο");
    }
}
