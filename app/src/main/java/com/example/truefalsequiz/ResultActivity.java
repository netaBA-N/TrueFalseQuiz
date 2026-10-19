package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvResult = findViewById(R.id.tvResult);
        LinearLayout main = findViewById(R.id.main);
        TextView tvExplain = findViewById(R.id.tvExplain);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNex = findViewById(R.id.btnNex);

        Intent intent = getIntent();
        boolean isCorrect = intent.getBooleanExtra("isCorrect", false);
        String where = intent.getStringExtra("Q");

        // 1. קודם כל מטפלים בהצגה/הסתרה של הכפתור לפי המקור (Mignam m-2)
        if ("2".equals(where)) {
            btnNex.setVisibility(View.GONE);
        } else {
            btnNex.setVisibility(View.VISIBLE); // מומלץ להחזיר לנראות אם מגיעים ממסך אחר
        }

        // 2. לאחר מכן מטפלים בעיצוב ובטקסטים לפי נכון או לא נכון
        if (isCorrect) {
            tvResult.setText("צדקת!");
            main.setBackgroundColor(getColor(R.color.screen_bgTr));
            tvExplain.setText("נכון ביבי באמת נורא!");
        } else {
            tvResult.setText("טעית...");
            main.setBackgroundColor(getColor(R.color.screen_bgFa));
            tvExplain.setText("נסה שוב... תחשוב על כל הזוועות שקראו בשביעי וזה שהוא עדיין הראש");
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, SecQActivity.class);
                startActivity(intent);
            }
        });

    }
}