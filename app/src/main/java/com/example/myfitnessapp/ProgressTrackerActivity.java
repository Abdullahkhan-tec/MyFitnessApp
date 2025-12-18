package com.example.myfitnessapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ProgressTrackerActivity extends AppCompatActivity {

    EditText etWeight, etWorkout;
    Button btnAddLog;
    LinearLayout logsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_tracker);

        etWeight = findViewById(R.id.etWeight);
        etWorkout = findViewById(R.id.etWorkout);
        btnAddLog = findViewById(R.id.btnAddLog);
        logsContainer = findViewById(R.id.logsContainer);

        btnAddLog.setOnClickListener(v -> addLog());
    }

    private void addLog() {
        String weight = etWeight.getText().toString();
        String workout = etWorkout.getText().toString();

        if(weight.isEmpty() || workout.isEmpty()) {
            Toast.makeText(this, "Enter weight and workout", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a log TextView dynamically
        TextView log = new TextView(this);
        log.setText("Weight: " + weight + " kg\nWorkout: " + workout);
        log.setPadding(16,16,16,16);
        log.setBackgroundResource(R.drawable.card_background);
        log.setTextColor(getResources().getColor(android.R.color.black));
        log.setTextSize(16);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0,0,0,16);
        log.setLayoutParams(params);

        logsContainer.addView(log);

        etWeight.setText("");
        etWorkout.setText("");
    }
}
