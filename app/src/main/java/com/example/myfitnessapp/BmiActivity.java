package com.example.myfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class BmiActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> calculateBMI());
    }

    private void calculateBMI() {

        if (etHeight.getText().toString().isEmpty() ||
                etWeight.getText().toString().isEmpty()) {

            Toast.makeText(this, "Please enter height & weight", Toast.LENGTH_SHORT).show();
            return;
        }

        double heightCm = Double.parseDouble(etHeight.getText().toString());
        double weightKg = Double.parseDouble(etWeight.getText().toString());

        double heightM = heightCm / 100;
        double bmi = weightKg / (heightM * heightM);

        String bmiCategory;

        if (bmi < 18.5) {
            bmiCategory = "UNDERWEIGHT";
        } else if (bmi < 25) {
            bmiCategory = "NORMAL";
        } else if (bmi < 30) {
            bmiCategory = "OVERWEIGHT";
        } else {
            bmiCategory = "OBESE";
        }

        tvResult.setText(
                "BMI: " + String.format("%.2f", bmi) +
                        "\nCategory: " + bmiCategory
        );

        // 🔁 PASS BMI CATEGORY TO DASHBOARD
        Intent intent = new Intent(BmiActivity.this, DashboardActivity.class);
        intent.putExtra("BMI_CATEGORY", bmiCategory);
        startActivity(intent);
    }
}
