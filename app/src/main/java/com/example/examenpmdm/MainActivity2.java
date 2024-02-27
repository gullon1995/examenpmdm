package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main5 );

        FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        TextView tx = findViewById( R.id.TEXTO );
        String almacen = "";
        String consultatotal = "SELECT * FROM datospersonales ";
        Cursor cursor = db.rawQuery("SELECT * FROM "+FeedReaderContract.FeedEntry.datospersonales, null);
        cursor.moveToFirst();
        String nombre = cursor.getString(1);
        String apellido = cursor.getString(2);
        tx.setText("Nombre: "+nombre+", Apellido: "+apellido);
        cursor.close();

        Button atras = findViewById( R.id.buttonatras );
        atras.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ej= new Intent(v.getContext(), segundaactividad.class);
                startActivity(ej);
            }
        } );
        Button salir = findViewById( R.id.buttonsalir );
        salir.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ej= new Intent(v.getContext(), MainActivity.class);
                startActivity(ej);
            }
        } );

    }
}