package com.example.akshay.customdialogsendinginfoactivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText etUserName;
    private EditText etUserPassword;
    ExampleDialogListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null,false);

        etUserName = (EditText) view.findViewById(R.id.etUserName);
        etUserPassword = (EditText) view.findViewById(R.id.etUserPassword);


        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String userName = etUserName.getText().toString();
                String password = etUserPassword.getText().toString();
                listener.applyTexts(userName,password);

            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement example dialog listener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String userName,String password);
    }
}
