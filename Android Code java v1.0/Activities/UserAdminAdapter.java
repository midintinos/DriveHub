package com.drivehub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.R;
import com.drivehub.models.Renter;

import java.util.List;

public class UserAdminAdapter extends RecyclerView.Adapter<UserAdminAdapter.ViewHolder> {

    private final List<Renter> renterList;

    public UserAdminAdapter(List<Renter> renterList) {
        this.renterList = renterList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_admin_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Renter renter = renterList.get(position);
        holder.usernameText.setText(renter.getName());
        holder.emailText.setText(renter.getEmail());

        holder.activeSwitch.setChecked(renter.isActive());
        holder.activeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            renter.setActive(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return renterList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView usernameText, emailText;
        Switch activeSwitch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameText = itemView.findViewById(R.id.usernameText);
            emailText = itemView.findViewById(R.id.emailText);
            activeSwitch = itemView.findViewById(R.id.activeSwitch);
        }
    }
}
