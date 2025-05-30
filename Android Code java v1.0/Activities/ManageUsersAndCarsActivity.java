package com.drivehub;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.UserAdminAdapter;
import com.drivehub.adapters.CarAdminAdapter;
import com.drivehub.models.Car;
import com.drivehub.models.CarOwner;
import com.drivehub.models.Renter;

import java.util.ArrayList;
import java.util.List;

public class ManageUsersAndCarsActivity extends AppCompatActivity {

    private RecyclerView usersRecyclerView, carsRecyclerView;
    private UserAdminAdapter userAdapter;
    private CarAdminAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_users_cars);

        usersRecyclerView = findViewById(R.id.usersRecyclerView);
        carsRecyclerView = findViewById(R.id.carsRecyclerView);

        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dummy/mock data
        List<Renter> renters = new ArrayList<>();
        renters.add(new Renter("r1", "Μαρία", "maria@test.com", "1234"));
        renters.add(new Renter("r2", "Γιώργος", "giorgos@test.com", "abcd"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1", "Toyota", "Corolla", "XX1234", null, 50.0, new CarOwner(), 0));
        cars.add(new Car("2", "BMW", "X5", "ZZ9999", null, 100.0, new CarOwner(), 0));

        userAdapter = new UserAdminAdapter(renters);
        carAdapter = new CarAdminAdapter(cars);

        usersRecyclerView.setAdapter(userAdapter);
        carsRecyclerView.setAdapter(carAdapter);
    }
}
