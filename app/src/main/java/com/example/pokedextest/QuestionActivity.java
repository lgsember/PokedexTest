package com.example.pokedextest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    TextView pregunta;
    RadioButton opcion1, opcion2, opcion3;
    Button confirmacion;
    String correcion = "", image = "";

    int score = 0;
    int numeroPregunta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pregunta = findViewById(R.id.pregunta);
        opcion1 = findViewById(R.id.opcion1);
        opcion2 = findViewById(R.id.opcion2);
        opcion3 = findViewById(R.id.opcion3);
        confirmacion = findViewById(R.id.submit_btn);

        confirmacion.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit_btn) {
            corregir();
        }
    }

    void preguntar(){
        if (numeroPregunta < Quiz.question.length) {
            pregunta.setText(Quiz.question[numeroPregunta]);
            opcion1.setText(Quiz.option[numeroPregunta][0]);
            opcion2.setText(Quiz.option[numeroPregunta][1]);
            opcion3.setText(Quiz.option[numeroPregunta][2]);
            numeroPregunta++;
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }

    private void corregir() {
        String respuesta = "";
        if (opcion1.isChecked()) {
            respuesta = opcion1.getText().toString();
        } else if (opcion2.isChecked()) {
            respuesta = opcion2.getText().toString();
        } else if (opcion3.isChecked()) {
            respuesta = opcion3.getText().toString();
        }

        if (respuesta.equals(Quiz.answer[numeroPregunta - 1])) {
            score++;
            correcion = "Respuesta Correcta!\nEs " + Quiz.answer[numeroPregunta - 1];
        } else {
            correcion = "Respuesta Incorrecta!\nLa respuesta correcta es " + Quiz.answer[numeroPregunta - 1];
        }

        image = Quiz.img[numeroPregunta - 1];

        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("correcion", correcion);
        intent.putExtra("image", image);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        preguntar();
    }

}