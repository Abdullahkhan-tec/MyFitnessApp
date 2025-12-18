package com.example.myfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MealActivity extends AppCompatActivity {

    LinearLayout cardGain, cardLoss, cardMaintain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        cardGain = findViewById(R.id.cardGain);
        cardLoss = findViewById(R.id.cardLoss);
        cardMaintain = findViewById(R.id.cardMaintain);

        // Receive BMI Category
        String bmiCategory = getIntent().getStringExtra("BMI_CATEGORY");

        if (bmiCategory == null) {
            Toast.makeText(this, "Please calculate BMI first", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Hide all cards first
        cardGain.setVisibility(LinearLayout.GONE);
        cardLoss.setVisibility(LinearLayout.GONE);
        cardMaintain.setVisibility(LinearLayout.GONE);

        // Show recommended meal only
        if (bmiCategory.equals("UNDERWEIGHT")) {
            cardGain.setVisibility(LinearLayout.VISIBLE);
            cardGain.setOnClickListener(v -> openMealDetail("GAIN"));

        } else if (bmiCategory.equals("NORMAL")) {
            cardMaintain.setVisibility(LinearLayout.VISIBLE);
            cardMaintain.setOnClickListener(v -> openMealDetail("MAINTAIN"));

        } else if (bmiCategory.equals("OVERWEIGHT") || bmiCategory.equals("OBESE")) {
            cardLoss.setVisibility(LinearLayout.VISIBLE);
            cardLoss.setOnClickListener(v -> openMealDetail("LOSS"));
        }
    }

    private void openMealDetail(String type) {
        Intent intent = new Intent(this, MealDetailActivity.class);
        intent.putExtra("MEAL_TYPE", type);
        startActivity(intent);
    }
}
