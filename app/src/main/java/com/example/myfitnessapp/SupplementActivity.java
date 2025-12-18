package com.example.myfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class SupplementActivity extends AppCompatActivity {

    LinearLayout cardWhey, cardMass, cardCreatine, cardFat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplement);

        cardWhey = findViewById(R.id.cardWhey);
        cardMass = findViewById(R.id.cardMass);
        cardCreatine = findViewById(R.id.cardCreatine);
        cardFat = findViewById(R.id.cardFat);

        String bmi = getIntent().getStringExtra("BMI_CATEGORY");

        // Hide all first
        cardWhey.setVisibility(LinearLayout.GONE);
        cardMass.setVisibility(LinearLayout.GONE);
        cardCreatine.setVisibility(LinearLayout.GONE);
        cardFat.setVisibility(LinearLayout.GONE);

        if (bmi == null) return;

        if (bmi.equals("UNDERWEIGHT")) {
            cardWhey.setVisibility(LinearLayout.VISIBLE);
            cardMass.setVisibility(LinearLayout.VISIBLE);
            cardCreatine.setVisibility(LinearLayout.VISIBLE);

        } else if (bmi.equals("NORMAL")) {
            cardWhey.setVisibility(LinearLayout.VISIBLE);
            cardCreatine.setVisibility(LinearLayout.VISIBLE);

        } else {
            cardFat.setVisibility(LinearLayout.VISIBLE);
        }

        cardWhey.setOnClickListener(v -> openDetail("WHEY"));
        cardMass.setOnClickListener(v -> openDetail("MASS"));
        cardCreatine.setOnClickListener(v -> openDetail("CREATINE"));
        cardFat.setOnClickListener(v -> openDetail("FAT"));
    }

    private void openDetail(String type) {
        Intent intent = new Intent(this, SupplementDetaiActivity.class);
        intent.putExtra("SUPPLEMENT_TYPE", type);
        startActivity(intent);
    }
}
