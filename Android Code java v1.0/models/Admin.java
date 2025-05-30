package com.drivehub.models;

import java.util.List;

public class Admin extends User {

    public void manageUsers(List<User> users) {
        // Λογική για εμφάνιση/διαχείριση χρηστών
    }

    public void blockUser(String userID) {
        // Λογική για μπλοκάρισμα χρήστη
    }

    public List<String> viewReports() {
        return List.of("Sample Report");
    }

    public void resolveDispute(Dispute dispute, String resolutionText) {
        dispute.resolve(resolutionText, this);
    }
}
