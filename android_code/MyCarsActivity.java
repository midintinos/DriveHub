package com.drivehub;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyCarsActivity extends AppCompatActivity {

    private RecyclerView myCarsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cars);

        myCarsRecycler = findViewById(R.id.myCarsRecycler);
        myCarsRecycler.setLayoutManager(new LinearLayoutManager(this));

        // Reuse CarAdapter
        CarAdapter adapter = new CarAdapter(RegisterCarActivity.carList);
        myCarsRecycler.setAdapter(adapter);
    }
}
