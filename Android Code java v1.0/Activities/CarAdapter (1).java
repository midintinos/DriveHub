package com.drivehub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.models.Car;

import android.content.Intent;


import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> carList;

    public CarAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carName.setText(car.getBrand() + " " + car.getModel());
        holder.carPrice.setText("€" + car.getPrice() + "/ημέρα");
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CarDetailsActivity.class);
            intent.putExtra("brand", car.getBrand());
            intent.putExtra("model", car.getModel());
            intent.putExtra("plate", car.getPlateNumber());
            intent.putExtra("price", car.getPrice());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder {
        TextView carName, carPrice;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.carName);
            carPrice = itemView.findViewById(R.id.carPrice);
        }
    }
}
