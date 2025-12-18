package com.example.myfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout bmiCard, workoutCard, mealCard;
    String bmiCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bmiCard = findViewById(R.id.cardBMI);
        workoutCard = findViewById(R.id.cardWorkout);
        mealCard = findViewById(R.id.cardMeal);

        // Receive BMI Category
        bmiCategory = getIntent().getStringExtra("BMI_CATEGORY");

        bmiCard.setOnClickListener(v ->
                startActivity(new Intent(DashboardActivity.this, BmiActivity.class))
        );

        workoutCard.setOnClickListener(v -> {
            if (bmiCategory == null) {
                Toast.makeText(this, "Please calculate BMI first", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(DashboardActivity.this, WorkoutActivity.class);
            intent.putExtra("BMI_CATEGORY", bmiCategory);
            startActivity(intent);
        });

        mealCard.setOnClickListener(v -> {
            if (bmiCategory == null) {
                Toast.makeText(this, "Please calculate BMI first", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(DashboardActivity.this, MealActivity.class);
            intent.putExtra("BMI_CATEGORY", bmiCategory);
            startActivity(intent);
        });
    }
}
