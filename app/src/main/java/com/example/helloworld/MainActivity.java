package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;

    //Aquí he estado haciendo pruebas para comprender el cicli de vida 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TAG cicloVida","Ciclovida: onCreate");
        //Hay que hacerle el casting porque la variable texto espera un TextView
        texto = (TextView)findViewById(R.id.textoEvento);

        //Con esta opcion nos obliga a implementar la clase
        texto.setOnClickListener(this);
        /*
            OPCION PARA TRATAR CON EL EVENTO ONCLICK

            texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Has hecho click en el texto", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("TAG cicloVida","Ciclovida: onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("TAG cicloVida","Ciclovida: onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("TAG cicloVida","Ciclovida: onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("TAG cicloVida","Ciclovida: onStop");
    }

    @Override
    public void onClick(View view) {
        //Recogemos el id para saber desde donde se ha lanzado el evento
        int id = view.getId();
        if(id == R.id.textoEvento) {
            Toast.makeText(MainActivity.this, "Has hecho click en el texto", Toast.LENGTH_SHORT).show();
        }
    }
   /*
   OPCIÓN PARA TRATAR EL EVENTO ONCLICK
    android:onClick="initSecActivity"   PONIENDO EL EVENTO ONCLICK EN LA ACTIVIDAD CREAMOS EL METODO E IMPRIMIMOS UN MENSAJE AL HACER CLICL
    public void initSecActivity(View view) {
        Toast.makeText(this, "Has hecho click en el texto", Toast.LENGTH_SHORT).show();
    }*/
}
