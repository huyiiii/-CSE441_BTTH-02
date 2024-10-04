package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    private EditText hoTenEditText;
    private EditText diemTichLuyEditText;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        hoTenEditText = findViewById(R.id.name);
        diemTichLuyEditText = findViewById(R.id.gpa);
        submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered data
                String hoTen = hoTenEditText.getText().toString();
                float diemTichLuy = Float.parseFloat(diemTichLuyEditText.getText().toString());

                // Send the data back to the parent activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("hoTen", hoTen);
                resultIntent.putExtra("diemTichLuy", diemTichLuy);
                setResult(RESULT_OK, resultIntent);
                finish();  // Close the child activity
            }
        });

    }

}
