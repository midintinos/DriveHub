package com.drivehub;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.models.Booking;
import com.drivehub.models.Booking.Status;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    private final List<Booking> bookingList;
    private final boolean isAdmin;

    public BookingAdapter(List<Booking> bookingList, boolean isAdmin) {
        this.bookingList = bookingList;
        this.isAdmin = isAdmin;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking_list_item, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        Booking booking = bookingList.get(position);

        // Εμφάνιση πληροφοριών
        holder.carInfo.setText(booking.getCar().getBrand() + " " + booking.getCar().getModel());
        holder.dates.setText("Από " + booking.getStartDate() + " έως " + booking.getEndDate());
        holder.statusText.setText("Κατάσταση: " + booking.getStatus().name());

        // Ακύρωση από Renter
        if (booking.getStatus() == Status.PENDING && !isAdmin) {
            holder.cancelBtn.setVisibility(View.VISIBLE);
            holder.cancelBtn.setOnClickListener(v -> {
                booking.updateStatus(Status.CANCELLED);
                notifyItemChanged(position);
                Toast.makeText(v.getContext(), "Η κράτηση ακυρώθηκε", Toast.LENGTH_SHORT).show();
            });
        } else {
            holder.cancelBtn.setVisibility(View.GONE);
        }

        // Δυνατότητες Admin (Έγκριση / Απόρριψη)
        if (isAdmin && booking.getStatus() == Status.PENDING) {
            holder.approveBtn.setVisibility(View.VISIBLE);
            holder.rejectBtn.setVisibility(View.VISIBLE);

            holder.approveBtn.setOnClickListener(v -> {
                booking.updateStatus(Status.APPROVED);
                notifyItemChanged(position);
                Toast.makeText(v.getContext(), "Έγκριση κράτησης", Toast.LENGTH_SHORT).show();
            });

            holder.rejectBtn.setOnClickListener(v -> {
                booking.updateStatus(Status.REJECTED);
                notifyItemChanged(position);
                Toast.makeText(v.getContext(), "Απόρριψη κράτησης", Toast.LENGTH_SHORT).show();
            });
        } else {
            holder.approveBtn.setVisibility(View.GONE);
            holder.rejectBtn.setVisibility(View.GONE);
        }

        // Αναφορά Διαφωνίας (Dispute)
        holder.disputeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), RaiseDisputeActivity.class);
            intent.putExtra("bookingIndex", position);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    static class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView carInfo, dates, statusText;
        Button cancelBtn, approveBtn, rejectBtn, disputeBtn;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            carInfo = itemView.findViewById(R.id.carInfoText);
            dates = itemView.findViewById(R.id.datesText);
            statusText = itemView.findViewById(R.id.statusText);
            cancelBtn = itemView.findViewById(R.id.cancelBtn);
            approveBtn = itemView.findViewById(R.id.approveBtn);
            rejectBtn = itemView.findViewById(R.id.rejectBtn);
            disputeBtn = itemView.findViewById(R.id.disputeBtn);
        }
    }
}
