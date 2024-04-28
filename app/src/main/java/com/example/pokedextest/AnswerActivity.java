package com.example.pokedextest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnswerActivity extends AppCompatActivity {

    TextView correctionText;
    Button continueButton;
    ImageView pkmnImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_answer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        correctionText = findViewById(R.id.correctionText);
        continueButton = findViewById(R.id.continueButton);
        pkmnImg = findViewById(R.id.pkmnImg);

        String correcion = getIntent().getStringExtra("correcion");
        String image = getIntent().getStringExtra("image");

        int imageId = getResources().getIdentifier(image, "drawable", getPackageName());
        pkmnImg.setImageResource(imageId);

        correctionText.setText(correcion);

        continueButton.setOnClickListener(v -> seguir());
    }

    private void seguir() {
        finish();
    }

}