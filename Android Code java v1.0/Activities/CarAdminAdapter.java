package com.drivehub.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.R;
import com.drivehub.models.Car;

import java.util.List;

public class CarAdminAdapter extends RecyclerView.Adapter<CarAdminAdapter.ViewHolder> {

    private final List<Car> carList;

    public CarAdminAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_admin_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carNameText.setText(car.getBrand() + " " + car.getModel());
        holder.plateText.setText(car.getPlateNumber());

        holder.visibleSwitch.setChecked(!car.isHidden());
        holder.visibleSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            car.setHidden(!isChecked); // αντιστρέφουμε
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView carNameText, plateText;
        Switch visibleSwitch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carNameText = itemView.findViewById(R.id.carNameText);
            plateText = itemView.findViewById(R.id.plateText);
            visibleSwitch = itemView.findViewById(R.id.visibleSwitch);
        }
    }
}
