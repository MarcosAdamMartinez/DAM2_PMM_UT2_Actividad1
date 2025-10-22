package com.example.dam2_pmm_ut2_actividad1_marcos_martinez_ouhabi;

import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void mandarEmail(View view){

        EditText direccionT = findViewById(R.id.recipiente);
        String direccion = direccionT.getText().toString();
        EditText asuntoT = findViewById(R.id.asunto);
        String asunto = asuntoT.getText().toString();
        EditText mensajeT = findViewById(R.id.mensaje);
        String mensaje = mensajeT.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + direccion +
                        "?subject=" + Uri.encode(asunto) +
                        "&body=" + Uri.encode(mensaje)));
        startActivity(intent);
    }

}