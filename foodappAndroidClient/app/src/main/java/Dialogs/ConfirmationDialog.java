package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.hajar.foodapp.R;

public class ConfirmationDialog extends AppCompatDialogFragment {

    private EditText adresse_livraison;
    private EditText nom_livraison;
    private EditText prenom_livraison;
    private EditText tel_livraison;
    private ConfirmationDialogListener listener;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_confirmcommand, null);


        builder.setView(view)
                .setTitle("Confirmation")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ship", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String prenom= prenom_livraison.getText().toString();
                        String nom=nom_livraison.getText().toString();
                        String adresse=adresse_livraison.getText().toString();
                        String tel=tel_livraison.getText().toString();
                        listener.applyTexts(prenom,nom,adresse,tel);
                    }
                });
        adresse_livraison = view.findViewById(R.id.adresse_livraison);
        nom_livraison = view.findViewById(R.id.nom_livraison);
        prenom_livraison = view.findViewById(R.id.prenom_livraison);
        tel_livraison = view.findViewById(R.id.tel_livraison);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ConfirmationDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement confirmationDialogListener");
        }
    }

    public interface ConfirmationDialogListener {
        void applyTexts(String prenom,String nom,String adresse,String tel);
    }
}
