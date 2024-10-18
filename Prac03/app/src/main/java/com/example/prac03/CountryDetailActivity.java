package com.example.prac03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CountryDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        ImageView flagImageView = findViewById(R.id.flagImageView);
        TextView nationTextView = findViewById(R.id.nationTextView);
        TextView capitalTextView = findViewById(R.id.capitalTextView);
        TextView populationTextView = findViewById(R.id.populationTextView);
        TextView areaTextView = findViewById(R.id.areaTextView);
        TextView densityTextView = findViewById(R.id.densityTextView);
        TextView worldShareTextView = findViewById(R.id.worldShareTextView);

        // Nhận dữ liệu từ intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("country")) {
            Country country = (Country) intent.getSerializableExtra("country");

            // Hiển thị thông tin chi tiết quốc gia
            flagImageView.setImageResource(country.getFlagResourceId());
            nationTextView.setText("Nation: " + country.getName());
            capitalTextView.setText("Capital: " + country.getCapital());
            populationTextView.setText("Population: " + country.getPopulation());
            areaTextView.setText("Area: " + country.getArea());
            densityTextView.setText("Density: " + country.getDensity());
            worldShareTextView.setText("World Share: " + country.getWorldShare());
        }
    }
}
