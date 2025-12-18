package com.example.myfitnessapp;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TipsActivity extends AppCompatActivity {

    LinearLayout tipsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        tipsContainer = findViewById(R.id.tipsContainer);

        String bmiCategory = getIntent().getStringExtra("BMI_CATEGORY");
        if(bmiCategory == null) bmiCategory = "NORMAL";

        String[] tips = getTips(bmiCategory);
        for(String tip : tips){
            TextView tv = new TextView(this);
            tv.setText("• " + tip);
            tv.setTextColor(getResources().getColor(android.R.color.black));
            tv.setTextSize(16);
            tv.setPadding(16,16,16,16);
            tv.setBackgroundResource(R.drawable.card_background);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0,0,0,16);
            tv.setLayoutParams(params);

            tipsContainer.addView(tv);
        }
    }

    private String[] getTips(String bmiCategory){
        switch(bmiCategory){
            case "UNDERWEIGHT":
                return new String[]{
                        "Eat more protein-rich foods",
                        "Include nuts and seeds in diet",
                        "Do strength training 3-4 times/week",
                        "Avoid skipping meals"
                };
            case "OVERWEIGHT":
            case "OBESE":
                return new String[]{
                        "Reduce sugar and processed foods",
                        "Exercise at least 30 mins daily",
                        "Include more vegetables and fruits",
                        "Stay hydrated"
                };
            default:
                return new String[]{
                        "Maintain a balanced diet",
                        "Exercise regularly",
                        "Monitor BMI monthly",
                        "Stay consistent"
                };
        }
    }
}
