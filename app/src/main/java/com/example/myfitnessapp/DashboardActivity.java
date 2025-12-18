package com.example.myfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout bmiCard, workoutCard, mealCard, progressCard, tipsCard, supplementCard;
    String bmiCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bmiCard = findViewById(R.id.cardBMI);
        workoutCard = findViewById(R.id.cardWorkout);
        mealCard = findViewById(R.id.cardMeal);
        progressCard = findViewById(R.id.cardProgress);
        tipsCard = findViewById(R.id.cardTips);
        supplementCard = findViewById(R.id.cardSupplements);

        bmiCategory = getIntent().getStringExtra("BMI_CATEGORY");

        bmiCard.setOnClickListener(v ->
                startActivity(new Intent(this, BmiActivity.class))
        );

        workoutCard.setOnClickListener(v -> openWithBMI(WorkoutActivity.class));
        mealCard.setOnClickListener(v -> openWithBMI(MealActivity.class));
        supplementCard.setOnClickListener(v -> openWithBMI(SupplementActivity.class));

        progressCard.setOnClickListener(v ->
                startActivity(new Intent(this, ProgressTrackerActivity.class))
        );

        tipsCard.setOnClickListener(v -> {
            Intent i = new Intent(this, TipsActivity.class);
            i.putExtra("BMI_CATEGORY", bmiCategory);
            startActivity(i);
        });
    }

    private void openWithBMI(Class<?> cls) {
        if (bmiCategory == null) {
            Toast.makeText(this, "Please calculate BMI first", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent i = new Intent(this, cls);
        i.putExtra("BMI_CATEGORY", bmiCategory);
        startActivity(i);
    }
}
