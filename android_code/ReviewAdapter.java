package com.drivehub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.drivehub.R;
import com.drivehub.models.Review;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<Review> reviewList;

    public ReviewAdapter(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_item, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviewList.get(position);

        if (review.isFlagged()) {
            holder.commentText.setText("⚠️ Το σχόλιο δεν εμφανίζεται λόγω ακατάλληλου περιεχομένου.");
            holder.renterNameText.setText("Ανώνυμος Χρήστης");
        } else {
            holder.commentText.setText(review.getComment());
            holder.renterNameText.setText(review.getRenter().getName());
        }

        holder.ratingText.setText("Βαθμολογία: " + review.getRating() + "/5");
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView renterNameText, commentText, ratingText;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            renterNameText = itemView.findViewById(R.id.renterNameText);
            commentText = itemView.findViewById(R.id.commentText);
            ratingText = itemView.findViewById(R.id.ratingText);
        }
    }
}
