package com.example.myfitnessapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MealDetailActivity extends AppCompatActivity {

    TextView tvTitle, tvPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvPlan = findViewById(R.id.tvPlan);

        String type = getIntent().getStringExtra("MEAL_TYPE");

        if (type == null) return;

        switch (type) {
            case "GAIN":
                tvTitle.setText("Weight Gain Plan");
                tvPlan.setText(getGainPlan());
                break;
            case "LOSS":
                tvTitle.setText("Weight Loss Plan");
                tvPlan.setText(getLossPlan());
                break;
            case "MAINTAIN":
                tvTitle.setText("Maintenance Plan");
                tvPlan.setText(getMaintainPlan());
                break;
        }
    }

    private String getGainPlan() {
        return "🍗 WEIGHT GAIN PLAN\n\n" +
                "Breakfast:\n• Oats with milk\n• Banana\n• Peanut butter\n\n" +
                "Lunch:\n• Rice\n• Grilled chicken\n• Yogurt\n\n" +
                "Dinner:\n• Eggs (3)\n• Brown bread\n\n" +
                "Daily Calories:\n• ~2800 kcal/day";
    }

    private String getLossPlan() {
        return "🥗 WEIGHT LOSS PLAN\n\n" +
                "Breakfast:\n• Fruits bowl\n• Green tea\n\n" +
                "Lunch:\n• Mixed vegetable salad\n• Grilled fish\n\n" +
                "Dinner:\n• Vegetable soup\n• Boiled vegetables\n\n" +
                "Daily Calories:\n• ~1800 kcal/day";
    }

    private String getMaintainPlan() {
        return "⚖️ MAINTENANCE PLAN\n\n" +
                "Breakfast:\n• Eggs (2)\n• Brown toast\n\n" +
                "Lunch:\n• Chapati\n• Chicken curry\n• Salad\n\n" +
                "Dinner:\n• Rice\n• Vegetables\n\n" +
                "Daily Calories:\n• ~2200 kcal/day";
    }
}
