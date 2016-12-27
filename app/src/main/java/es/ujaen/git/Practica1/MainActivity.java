package es.ujaen.git.Practica1;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Clase principal que inicia el programa (la actividad principal)
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Método que crea el layout inicial
     * @param savedInstanceState recibe los datos almacenados
     * //@param fm crea el fragmento
     * //@param ft añade el fragmento
     * //@param f almacena el fragmento en el contenedor main_frame
     * //@param au creamos un objeto AuthFragment
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        android.support.v4.app.Fragment f = fm.findFragmentById(R.id.main_frame);




        /**Guardamos los datos para no perderlos cuando cambia la configuración
        */
        if(f==null){

            AuthFragment au = AuthFragment.newInstance("Juan","6000");
            /**Se añade el fragmento a la vista*/
            ft.add(R.id.main_frame,au);
            /**Se añade a la pila de procesos*/
            ft.addToBackStack(null);

        }
        /**Para que la transacción se lleve a cabo es necesario esta ejecución*/
        ft.commit();

    }


    /**
     * Método que cambia a otra actividad donde se muestra informacion de la práctica
     * @param view es el objeto de la vista
     * //@param Intent in crea una intención para cambiar de actividad
     */
    public void ejecutar_info (View view){
        Intent in = new Intent(this,InfoClase.class);

        startActivity(in);

    }


    /**
     * Método que cambia a otra actividad
     * @param view es el objeto de la vista
     * //@param i crea una intención para cambiar de actividad
     */
    public void Autenticacion(View view){

        /**Identificamos los elementos EditText y los almacenamos*/
        final EditText txtNombre = (EditText)findViewById(R.id.user2);
        //final EditText txtPuerto = (EditText)findViewById(R.id.puerto);

        Intent i = new Intent(this, Autenticado.class);

        /**Pasamos parametros a la nueva actividad de tipo (nombre,valor)*/
        i.putExtra("Nombre", txtNombre.getText().toString());
        //i.putExtra("Puerto",txtPuerto.getText().toString());

        /**Añadimos los datos a la clase*/
        i.setClass(MainActivity.this,Autenticado.class);
        startActivity(i);

    }


    /**Método que cambia a la actividad de autenticación
     *
     * @param view es el objeto de la vista
     */
    public void  Plogeo(View view){
        Intent pl = new Intent(this,Logeo.class);

        startActivity(pl);

    }








}
