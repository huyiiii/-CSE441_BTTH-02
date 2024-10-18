package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel; // Add this import

public class EmployeeViewModel extends ViewModel { // Extend ViewModel
    private final MutableLiveData<Employee> employeeData = new MutableLiveData<>();
    private final MutableLiveData<String> message = new MutableLiveData<>();

    // Khởi tạo dữ liệu mặc định
    public EmployeeViewModel() {
        // Nhân viên chưa có thông tin
        employeeData.setValue(new Employee("", "", "", 0.0));
        message.setValue("Thông tin nhân viên chưa đầy đủ.");
    }

    // Trả về thông tin nhân viên
    public LiveData<Employee> getEmployeeData() {
        return employeeData;
    }

    // Trả về thông báo
    public LiveData<String> getMessage() {
        return message;
    }

    // Cập nhật thông tin nhân viên
    public void setEmployeeData(String id, String name, String dateOfBirth, double salary) {
        Employee employee = new Employee(id, name, dateOfBirth, salary);
        employeeData.setValue(employee);

        // Kiểm tra nếu thông tin không đầy đủ
        if (employee.isComplete()) {
            message.setValue("Thông tin nhân viên đầy đủ.");
        } else {
            message.setValue("Thông tin nhân viên chưa đầy đủ.");
        }
    }

    // Cập nhật thông báo
    public void setMessage(String msg) {
        message.setValue(msg);
    }
}
