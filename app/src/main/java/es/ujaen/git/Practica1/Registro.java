package es.ujaen.git.Practica1;


/**
 * Clase pública registro, donde se encuentra el constructor de los datos usados para hacer el login además de los métodos para llamarlos
 */


public class Registro {
    /**
     * Inicializamos las variables. Para inicializar el puerto usamos una constante estática.
     */
    public static final int SERVICE_PORT=6000;
    protected String mUser="user";
    protected String mPass="";
    protected String mIP="127.0.0.1";
    protected int mPor=SERVICE_PORT;

    /**
     * Constructor de los datos necesarios
     * @param user Nombre de usuario
     * @param pass Contraseña
     * @param IP Dominio
     * @param port Puerto
     */
    public Registro(String user,String pass,String IP,int port){
        this.mUser = user;
        this.mPass = pass;
        this.mIP = IP;
        this.mPor = port;


    }

    /**
     * Devuelve el usuario
     * @return Usuario
     */
    public String getmUser(){

        return mUser;
    }


    /**
     * Devuelve la contraseña
     * @return Contraseña
     */
    public String getmPass(){

        return mPass;
    }

    /**
     * Devuelve el puerto
     * @return Puerto
     */

    public int getmPort(){
        return mPor;
    }


    /**
     * Inicializa el usuario
     * @param mUser Usuario
     */
    public void setmUser(String mUser) {
        this.mUser = mUser;
    }


    /**
     * Inicializa la contraseña
     * @param mPass Contraseña
     */
    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    /**
     * Inicializa el puerto
     * @param mPor Puerto
     */

    public void setmPuerto(int mPor) {
        this.mPor = mPor;
    }


}

