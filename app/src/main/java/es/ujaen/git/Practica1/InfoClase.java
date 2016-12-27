package es.ujaen.git.Practica1;

import android.app.Activity;
import android.os.Bundle;

/**
 * Clase pública InfoClase usada para iniciar una nueva actividad con interfaz gráfica para mostrar la información de la práctica
 */
public class InfoClase extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
    }




}