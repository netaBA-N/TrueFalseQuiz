package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecQActivity extends AppCompatActivity {
    boolean correctAnswer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_qua);

        Button btnTrue = findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = true;

                boolean isCorrect = (userAnswer == correctAnswer);

                Intent intent = new Intent(SecQActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", "ככה");

                startActivity(intent);
            }
        });
        Button BtnFalse = findViewById(R.id.btnFalse);
        BtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;

                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                Intent intent = new Intent(SecQActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("Q","2");
                startActivity(intent);
            }
        });

        }
}