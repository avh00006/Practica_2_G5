package es.ujaen.git.Practica1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Clase pública Autenticado usada para el saludo una vez el usuario se ha autenticado.
 */

public class  Autenticado extends Activity{

    /**
     * Usamos el método onCreate ya que iniciamos una nueva actividad con una interfaz grafica para mostrar el saludo, el cual se compone de los parámetros de nombre y el puerto.
     */
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        /**
         * Llamamos a la vista de autenticado donde mostraremos las variables de autor y puerto a través de dos textView
         */
        setContentView(R.layout.autenticado);

        TextView txtSaludo = (TextView)findViewById(R.id.txtAuth);

        TextView txtPort = (TextView)findViewById(R.id.txtPort);
        Bundle b = this.getIntent().getExtras();
        txtSaludo.setText("Usuario: "+b.getString("Nombre"));
        txtPort.setText("Puerto: "+b.getString("Puerto"));


    }
}
