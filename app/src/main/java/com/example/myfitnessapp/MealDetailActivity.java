package com.example.myfitnessapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MealDetailActivity extends AppCompatActivity {

    TextView tvBreakfast, tvLunch, tvDinner, tvSnacks, tvMealTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        tvMealTitle = findViewById(R.id.tvMealTitle);
        tvBreakfast = findViewById(R.id.tvBreakfast);
        tvLunch = findViewById(R.id.tvLunch);
        tvDinner = findViewById(R.id.tvDinner);
        tvSnacks = findViewById(R.id.tvSnacks);

        String type = getIntent().getStringExtra("MEAL_TYPE");
        if (type == null) return;

        switch (type) {
            case "GAIN":
                tvMealTitle.setText("Weight Gain Plan");
                setGainMeal();
                break;

            case "LOSS":
                tvMealTitle.setText("Weight Loss Plan");
                setLossMeal();
                break;

            case "MAINTAIN":
                tvMealTitle.setText("Maintenance Plan");
                setMaintainMeal();
                break;
        }
    }

    private void setGainMeal() {
        tvBreakfast.setText("• Eggs + Brown Bread\n• Milk + Banana");
        tvLunch.setText("• Rice + Chicken\n• Yogurt");
        tvDinner.setText("• Roti + Meat\n• Salad");
        tvSnacks.setText("• Nuts + Peanut Butter");
    }

    private void setLossMeal() {
        tvBreakfast.setText("• Oats + Green Tea");
        tvLunch.setText("• Boiled Chicken\n• Vegetables");
        tvDinner.setText("• Salad + Soup");
        tvSnacks.setText("• Avoid Sugar & Fast Food");
    }

    private void setMaintainMeal() {
        tvBreakfast.setText("• Eggs + Toast");
        tvLunch.setText("• Rice + Chicken");
        tvDinner.setText("• Roti + Vegetables");
        tvSnacks.setText("• Fruits");
    }
}
