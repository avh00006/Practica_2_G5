package es.ujaen.git.Practica1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Subclase que extiende de Fragment.
 * @param ARG_PARAM1 primer parametro
 * @param ARG_PARAM2 segundo parametro
 * @param mUser almacenara el nombre de usuario
 * @param mPuerto almacenara el puerto
 */

public class AuthFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";


    private String mUser;
    //private String mPuerto;

    private Registro mRegistro = new Registro("","","",0);


    private EditText user = null;
    //private EditText puert = null;



    public AuthFragment() {
        // Required empty public constructor
    }

    /**
     * Crea una nueva instancia de este fragmento usando los parametros
     * proporcionados.
     *
     * @param user Parametro nombre de usuario.
     * @param puerto Parametro puerto de comunicaciones.
     * @return Devuelve una nueva instancia del fragmento AuthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthFragment newInstance(String user,String puerto) {
        AuthFragment fragment = new AuthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, user);
        //args.putString(ARG_PARAM2,puerto);
        fragment.setArguments(args);
        return fragment;
    }


    /**
     *El sistema llama a este método al crear el fragmento
     * @param savedInstanceState parametro que muestra el estado actual
     * @param mUser se le asigna el valor creado por la nueva instancia
     * @param mPuerto se le asigna el valor creado por la nueva instancia
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUser = getArguments().getString(ARG_PARAM1);
        //mPuerto = getArguments().getString(ARG_PARAM2);;
        mRegistro.setmUser(mUser);
        //mRegistro.setmPuerto(Integer.parseInt(mPuerto));



    }

    /**
     * El sistema llama este método cuando se necesita dibujar
     * la interfaz de usuario del fragmento la primera vez
     * @param inflater infla la vista
     * @param container es el contenedor padre
     * @param savedInstanceState recibe los datos almacenados tras un recreado de la actividad
     * @return devuelve el fragmento creado
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if(savedInstanceState!=null){
            Toast.makeText(getActivity(),"Cambio de configuración",Toast.LENGTH_SHORT).show();


        }

        /**Infla el layout para este fragmento*/
        View fragmento = inflater.inflate(R.layout.form, container, false);

        /**Identificamos los elementos EditText y los almacenamos*/
        user = (EditText)fragmento.findViewById(R.id.user2);
        //puert = (EditText)fragmento.findViewById(R.id.puerto);
        /**Se guardan los datos en los elementos EditText*/
        //mPuerto=""+mRegistro.getmPort();
        user.setText(mRegistro.getmUser());
        //puert.setText(mPuerto);

        return fragmento;


    }


}
