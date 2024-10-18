package com.example.prac03;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo danh sách quốc gia
        countryList = new ArrayList<>();
        countryList.add(new Country("India", "New Delhi", "1,428.6 million", "2,973,190 Km²", "481 people/Km²", "17.76 %", R.drawable.ic_launcher_background));
        countryList.add(new Country("China", "Beijing", "1,412.4 million", "9,596,961 Km²", "153 people/Km²", "17.32 %", R.drawable.ic_launcher_background));
        // Thêm nhiều quốc gia khác vào danh sách...

        // Khởi tạo adapter
        countryAdapter = new CountryAdapter(countryList, country -> {
            // Sự kiện khi nhấn vào một quốc gia
            Intent intent = new Intent(MainActivity.this, CountryDetailActivity.class);
            intent.putExtra("country", country);
            startActivity(intent);
        });

        // Đặt adapter cho RecyclerView
        recyclerView.setAdapter(countryAdapter);
    }
}
