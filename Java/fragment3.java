/*
Fragment 3 java file that handles behind the scenes interactions.



*/


package com.example.project;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText id ;
    private  EditText titre ;
    private Button delete,update,insert ;
    private  Controleur c ;

    public fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment3 newInstance(String param1, String param2) {
        fragment3 fragment = new fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
        id = (EditText) v.findViewById(R.id.id_input2);
        titre = (EditText) v.findViewById(R.id.titre_input2);
        update =(Button) v.findViewById(R.id.update);
        delete =(Button) v.findViewById(R.id.delete);
        insert = (Button) v.findViewById(R.id.insert) ;

        c= new Controleur(getActivity());
        c.open();
        ;

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idstr = id.getText().toString();
                String titrestr = titre.getText().toString();

                try {
                    Livre l = new Livre(Integer.parseInt(idstr),titrestr) ;
                    boolean ok = c.update(l);
                    if(ok == true){
                        Toast.makeText(getActivity(),"Modification Termine",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getActivity(),"Livre non trouvee",Toast.LENGTH_LONG).show();

                    }
                }
                catch (Exception e){

                    Toast.makeText(getActivity(),"ID n'est pas entier",Toast.LENGTH_LONG).show();

                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idstr = id.getText().toString();

                    boolean ok = c.delete(idstr);
                    if(ok == true){
                        Toast.makeText(getActivity(),"Livre Supprimé",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getActivity(),"Livre non trouvee",Toast.LENGTH_LONG).show();

                    }

            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idstr = id.getText().toString();
                String titrestr = titre.getText().toString();

                if (titrestr.equals("")) {
                    Toast.makeText(getActivity(),"Titre Vide",Toast.LENGTH_LONG).show();
                    return;}

                try {
                    Livre l = new Livre(Integer.parseInt(idstr),titrestr) ;
                    boolean ok = c.insert(l);
                    if(ok == true){
                        Toast.makeText(getActivity(),"Insertion Termine",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getActivity(),"Impossible d'inserer cette valeur",Toast.LENGTH_LONG).show();

                    }
                }
                catch (Exception e){

                    Toast.makeText(getActivity(),"ID n'est pas entier",Toast.LENGTH_LONG).show();

                }
            }
        });

        return v ;
    }
}