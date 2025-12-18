package com.example.myfitnessapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity {

    TextView tvWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        tvWorkout = findViewById(R.id.tvWorkout);

        // Receive BMI Category
        String bmiCategory = getIntent().getStringExtra("BMI_CATEGORY");

        if (bmiCategory == null) {
            tvWorkout.setText("No BMI data found.\nPlease calculate BMI first.");
            return;
        }

        switch (bmiCategory) {
            case "UNDERWEIGHT":
                tvWorkout.setText(getMuscleGainWorkout());
                break;

            case "NORMAL":
                tvWorkout.setText(getBalancedWorkout());
                break;

            case "OVERWEIGHT":
            case "OBESE":
                tvWorkout.setText(getFatLossWorkout());
                break;
        }
    }

    private String getMuscleGainWorkout() {
        return " MUSCLE GAIN WORKOUT\n\n" +
                "Warm-up:\n• Jumping Jacks – 5 min\n\n" +
                "Exercises:\n" +
                "• Push-ups – 4 x 12\n" +
                "• Squats – 4 x 15\n" +
                "• Pull-ups – 3 x 8\n" +
                "• Dumbbell Press – 3 x 12\n\n" +
                "Rest: 60 seconds\n\n" +
                "Workout Days: 5 days/week";
    }

    private String getBalancedWorkout() {
        return "⚖ BALANCED WORKOUT\n\n" +
                "Warm-up:\n• Brisk Walking – 5 min\n\n" +
                "Exercises:\n" +
                "• Push-ups – 3 x 10\n" +
                "• Squats – 3 x 12\n" +
                "• Plank – 3 x 30 sec\n" +
                "• Light Jogging – 15 min\n\n" +
                "Workout Days: 4 days/week";
    }

    private String getFatLossWorkout() {
        return " FAT LOSS WORKOUT\n\n" +
                "Warm-up:\n• Skipping – 5 min\n\n" +
                "Exercises:\n" +
                "• Jogging – 30 min\n" +
                "• Mountain Climbers – 3 x 20\n" +
                "• Plank – 3 x 1 min\n" +
                "• Jump Squats – 3 x 15\n\n" +
                "Workout Days: 6 days/week";
    }
}
