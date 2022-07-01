package com.example.prova2bimestre;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MediaActivity extends AppCompatActivity {

    private EditText txtNota1, txtNota2;
    private TextView tvMedia;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        tvMedia = findViewById(R.id.tvMedia);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(view -> {
            double nota1 = Double.parseDouble(txtNota1.getText().toString());
            double nota2 = Double.parseDouble(txtNota2.getText().toString());
            double media = (nota1 + nota2) / 2;
            tvMedia.setText(String.format(Locale.getDefault(), "%.2f", media));
        });
    }
}