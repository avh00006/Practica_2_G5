package es.ujaen.git.Practica1;

/**
 * Created by Francisco on 27/12/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

import static es.ujaen.git.Practica1.Logeo.expiracion;
import static es.ujaen.git.Practica1.Logeo.expire;
import static es.ujaen.git.Practica1.Logeo.id;
import static es.ujaen.git.Practica1.Logeo.sesion;

/**Clase utilizada para la tarea asíncrona
 *
 */
public class MiTareaAsincrona extends AsyncTask<InetSocketAddress, Void, String> implements Protocolo {


    private Context context;
    private String usuario;
    private String contraseña;

    /**Constructor utilizado para instanciar la clase
     *
     * @param context Le pasamos el contexto de la actividad "Logeo"
     * @param usuario Recogemos el usuario de la actividad "Logeo"
     * @param contraseña Recogemos la contraseña de la actividad "Logeo"
     */
    MiTareaAsincrona (Context context,String usuario,String contraseña){

        this.context = context;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }


    /**Sobreescribimos el método para realizar la comunicación
     *
     * @param arg0 Parámetro utilizado para recoger los datos de entrada
     * @return Devuelve un String con la sesión de comunicación
     */
    @Override
    protected String doInBackground(InetSocketAddress... arg0) {

        Socket cli = null;
        String entrada=null;



        try{

            cli=new Socket();
            cli.connect(arg0[0]);
            BufferedReader is = new BufferedReader(new InputStreamReader(cli.getInputStream()));
            DataOutputStream flujo = new DataOutputStream(cli.getOutputStream());
            entrada=is.readLine();
            String user = USER +SP+usuario+CRLF;
            flujo.write(user.getBytes());
            entrada=is.readLine();
            String pass = PASS+SP+contraseña+CRLF;
            flujo.write(pass.getBytes());
            entrada=is.readLine();

            if(entrada.equals("ERROR")||entrada.equals("ERROR Usuario o clave incorrectos")){

                sesion=null;


            }else{

                sesion=entrada;




            }

            String salir = QUIT + CRLF;
            flujo.write(salir.getBytes());
            //entrada=is.readLine();
            flujo.flush();
        }catch(IOException ex){

            System.out.println("Error en el cliente"+ex.getMessage());
            entrada = "IOException: " + ex.toString();
        }

        return sesion;

    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }

    @Override
    protected void onPreExecute() {

    }

    /**Sobreescribimos el método para mostrar el resultado de la comunicación
     *
     * @param result En este parámetro guardamos la sesión de comunicación
     */
    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result);
        SharedPreferences.Editor edit = context.getSharedPreferences(Logeo.PREFERENCE,context.MODE_PRIVATE).edit();


        if(sesion!=null){


            String[] arraySesion = sesion.split("&");
            id =  arraySesion[0];
            Logeo.expiracion =  arraySesion[1];
            expire = expiracion.substring(8);
            edit.putString(Logeo.PREFERENCE1, id);
            edit.putString(Logeo.PREFERENCE2, expire );
            edit.commit();

            Intent i = new Intent(context, SharedPrefsActivity.class);
            i.putExtra(Logeo.PREFERENCE1, id.toString());
            i.putExtra(Logeo.PREFERENCE2, expire.toString());
            i.setClass(context,SharedPrefsActivity.class);
            context.startActivity(i);


        }else{

            Toast toast1 =
                    Toast.makeText(context.getApplicationContext(),
                            "Usuario y/o contraseña incorrecta", Toast.LENGTH_SHORT);
            toast1.show();

        }

    }

    @Override
    protected void onCancelled() {

    }
}
