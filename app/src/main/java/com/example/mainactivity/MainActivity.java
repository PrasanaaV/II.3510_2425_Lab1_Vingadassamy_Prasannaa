package com.example.mainactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private float textSize = 16f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editText = findViewById(R.id.editText);
        Button buttonUpdate = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        Button buttonChangeColor = findViewById(R.id.buttonChangeColor);
        Button buttonChangeSize = findViewById(R.id.buttonChangeSize);

        buttonUpdate.setOnClickListener(v -> {
            String userInput = editText.getText().toString();
            textView.setText(userInput);
        });

        buttonChangeColor.setOnClickListener(v -> {
            int currentColor = textView.getCurrentTextColor();
            if (currentColor == Color.parseColor("#FFDD2C00")) {
                textView.setTextColor(Color.BLUE);
            } else {
                textView.setTextColor(Color.parseColor("#FFDD2C00"));
            }
        });

        buttonChangeSize.setOnClickListener(v -> {
            textSize += 4f;
            if (textSize > 32f) {
                textSize = 16f;
            }
            textView.setTextSize(textSize);
        });
    }
}