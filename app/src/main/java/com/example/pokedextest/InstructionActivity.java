package com.example.pokedextest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InstructionActivity extends AppCompatActivity {

    TextView message;
    ImageButton readyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_instruction);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        message = findViewById(R.id.message);
        readyButton = findViewById(R.id.readyButton);

        Intent intent = getIntent();
        String nombreJugador = intent.getStringExtra("nombre");
        String mensaje = "Hola, entrenador " + nombreJugador + "!\n¿estás listo para embarcarte en el mundo de Pokémon?\nPara comprobarlo, responde correctamente el nombre de cada Pokémon según su descripción en la PokeDex.";

        message.setText(mensaje);

        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructionActivity.this, QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

