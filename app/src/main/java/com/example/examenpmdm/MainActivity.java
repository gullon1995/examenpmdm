package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        usuario = findViewById( R.id.LoginUser );
        password = findViewById( R.id.LoginPasswd );

        Button pasar = findViewById( R.id.button );
        pasar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioIng=usuario.getText().toString();
                String contraIng=password.getText().toString();
                if(usuarioIng.equals("ADMIN")&&contraIng.equals("1234")){
                    Intent ej= new Intent(v.getContext(), segundaactividad.class);
                    startActivity(ej);
                }else{
                    CharSequence text = "USUARIO/CONTRASEÑA INCORRECTOS";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(MainActivity.this, text, duration);
                    toast.show();
                }
            }
        } );
    }
}