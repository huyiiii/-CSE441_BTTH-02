package com.example.prac02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private EditText idEditText, nameEditText, dateOfBirthEditText, salaryEditText;
    private TextView employeeInfoTextView, messageTextView;
    private Button submitButton;
    private EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liên kết với view
        idEditText = findViewById(R.id.idEditText);
        nameEditText = findViewById(R.id.nameEditText);
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);
        salaryEditText = findViewById(R.id.salaryEditText);
        employeeInfoTextView = findViewById(R.id.employeeInfoTextView);
        messageTextView = findViewById(R.id.messageTextView);
        submitButton = findViewById(R.id.submitButton);

        // Khởi tạo ViewModel
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        // Quan sát sự thay đổi của dữ liệu nhân viên
        employeeViewModel.getEmployeeData().observe(this, employee -> {
            // Hiển thị thông tin nhân viên
            String info = "ID: " + employee.getId() + "\n" +
                    "Tên: " + employee.getName() + "\n" +
                    "Ngày sinh: " + employee.getDateOfBirth() + "\n" +
                    "Lương: " + employee.getSalary();
            employeeInfoTextView.setText(info);
        });

        // Quan sát thông báo
        employeeViewModel.getMessage().observe(this, message -> {
            messageTextView.setText(message);
        });

        // Xử lý sự kiện nhấn nút submit
        submitButton.setOnClickListener(v -> {
            String id = idEditText.getText().toString();
            String name = nameEditText.getText().toString();
            String dateOfBirth = dateOfBirthEditText.getText().toString();
            double salary = Double.parseDouble(salaryEditText.getText().toString());

            // Cập nhật thông tin nhân viên trong ViewModel
            employeeViewModel.setEmployeeData(id, name, dateOfBirth, salary);
        });
    }
}