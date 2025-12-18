package com.example.myfitnessapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MealsDetailActivity extends AppCompatActivity {

    TextView tvMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        tvMeal = findViewById(R.id.tvMeal);

        String type = getIntent().getStringExtra("MEAL_TYPE");

        if (type == null) return;

        switch (type) {
            case "GAIN":
                tvMeal.setText(getGainMeal());
                break;

            case "LOSS":
                tvMeal.setText(getLossMeal());
                break;

            case "MAINTAIN":
                tvMeal.setText(getMaintainMeal());
                break;
        }
    }

    private String getGainMeal() {
        return "🍽 WEIGHT GAIN DIET\n\n" +
                "Breakfast:\n• Eggs + Brown Bread\n• Milk + Banana\n\n" +
                "Lunch:\n• Rice + Chicken\n• Yogurt\n\n" +
                "Dinner:\n• Roti + Meat\n• Salad\n\n" +
                "Snacks:\n• Nuts + Peanut Butter";
    }

    private String getLossMeal() {
        return "🥗 WEIGHT LOSS DIET\n\n" +
                "Breakfast:\n• Oats + Green Tea\n\n" +
                "Lunch:\n• Boiled Chicken\n• Vegetables\n\n" +
                "Dinner:\n• Salad + Soup\n\n" +
                "Avoid:\n• Sugar\n• Fast Food";
    }

    private String getMaintainMeal() {
        return "⚖️ MAINTENANCE DIET\n\n" +
                "Breakfast:\n• Eggs + Toast\n\n" +
                "Lunch:\n• Rice + Chicken\n\n" +
                "Dinner:\n• Roti + Vegetables\n\n" +
                "Snacks:\n• Fruits";
    }
}
