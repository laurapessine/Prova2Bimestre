package com.example.prova2bimestre;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opCalcularMedia:
                Intent intent = new Intent(getApplicationContext(), MediaActivity.class);
                startActivity(intent);
                return true;
            case R.id.opFinalizarApp:
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("FECHANDO O APP");
                dialogo.setMessage("Deseja mesmo fechar o app?");
                dialogo.setPositiveButton("Fechar o app", new EscutadorDialogoOK());
                dialogo.setNegativeButton("Cancelar", new EscutadorDialogoCancela());
                dialogo.setCancelable(false);
                dialogo.create();
                dialogo.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class EscutadorDialogoOK implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
            Toast.makeText(getApplicationContext(), "Saindo...", Toast.LENGTH_LONG).show();
        }
    }

    public class EscutadorDialogoCancela implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Toast.makeText(getApplicationContext(), "Cancelando...", Toast.LENGTH_SHORT).show();
        }
    }
}