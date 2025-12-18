package com.example.myfitnessapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SupplementDetaiActivity extends AppCompatActivity {

    ImageView imgSupplement;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ✅ FIXED layout name
        setContentView(R.layout.activity_supplement_detai);

        imgSupplement = findViewById(R.id.imgSupplement);
        tvInfo = findViewById(R.id.tvInfo);

        String type = getIntent().getStringExtra("SUPPLEMENT_TYPE");

        if (type == null) return;

        switch (type) {
            case "WHEY":
                imgSupplement.setImageResource(R.drawable.whey_protien);
                tvInfo.setText(
                        "Whey Protein\n\n" +
                                "✔ Builds lean muscle\n" +
                                "✔ Fast absorption\n" +
                                "✔ Take after workout"
                );
                break;

            case "MASS":
                imgSupplement.setImageResource(R.drawable.mass_gainer);
                tvInfo.setText(
                        "Mass Gainer\n\n" +
                                "✔ High calories\n" +
                                "✔ Weight gain support\n" +
                                "✔ Use twice daily"
                );
                break;

            case "CREATINE":
                imgSupplement.setImageResource(R.drawable.creatine);
                tvInfo.setText(
                        "Creatine\n\n" +
                                "✔ Strength & power\n" +
                                "✔ Improves performance\n" +
                                "✔ Take before workout"
                );
                break;

            case "FAT":
                imgSupplement.setImageResource(R.drawable.fat_burner);
                tvInfo.setText(
                        "Fat Burner\n\n" +
                                "✔ Boosts metabolism\n" +
                                "✔ Enhances fat loss\n" +
                                "✔ Take before cardio"
                );
                break;
        }
    }
}
