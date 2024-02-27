package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class segundaactividad extends AppCompatActivity {
    ListView listad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        listad = findViewById(R.id.listad);
        final String[] datos = new String[]{"AÑADIR DATOS","LISTAR DATOS","SALIR"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listad.setAdapter(adaptador);
        listad.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elemento =(String)datos[position];
                if(elemento.equals(datos[0])){
                    ContentValues values = new ContentValues();
                    values.put( FeedReaderContract.FeedEntry.NOMBRE, "carlos");
                    values.put( FeedReaderContract.FeedEntry.APELLIDO, "gullon");
                    long newRowId = db.insert(FeedReaderContract.FeedEntry.datospersonales, null, values);
                }
                else if(elemento.equals(datos[1])) {
                    Intent ej= new Intent(view.getContext(), MainActivity2.class);
                    startActivity(ej);
                }
                else if(elemento.equals(datos[2])){
                    Intent ej= new Intent(view.getContext(), MainActivity.class);
                    startActivity(ej);
                }
            }
        } );
    }
}