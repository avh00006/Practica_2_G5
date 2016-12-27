package es.ujaen.git.Practica1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

/**Clase utilizada si la autenticación se ha realizado correctamente
 *
 */
public class SharedPrefsActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "SESION";

    /**Método que crea el layout para la operación del servicio
     * @param savedInstanceState recibe los datos almacenados
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);

    }

}
