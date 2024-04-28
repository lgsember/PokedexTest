package com.example.pokedextest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView score;
    TextView resultBody;
    Button exitButton;

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

        score = findViewById(R.id.score);
        resultBody = findViewById(R.id.resultBody);
        exitButton = findViewById(R.id.exitButton);

        int puntos = getIntent().getIntExtra("score", 0);

        if (puntos == 0){
            score.setText("No obtuviste ningún punto!");
            resultBody.setText("Quizás deberías conocer un poco más sobre los Pokémon si quieres convertirte en un entrenador.");
        } else if(puntos > 4) {
            score.setText("Muy bien! Obtuviste " + puntos + " puntos!");
            resultBody.setText("¡Ah, sí! Estás en el camino correcto para convertirte en un maestro Pokémon. ¡Buena suerte en tu viaje!");
        } else {
            score.setText("Obtuviste " + puntos + " puntos.");
            resultBody.setText("Parece que estás listo para tu viaje, pero lleva algunos repelentes, por si acaso.");
        }

        exitButton.setOnClickListener(v -> finish());

    }

}