package com.example.akshay.customdialogsendinginfoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener{
    TextView tvUserName;
    TextView tvPassword;
    Button btnOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvPassword = (TextView) findViewById(R.id.tvUserPassword);
        btnOpenDialog = (Button) findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }

    @Override
    public void applyTexts(String userName, String password) {
        tvUserName.setText(userName);
        tvPassword.setText(password);
    }
}
