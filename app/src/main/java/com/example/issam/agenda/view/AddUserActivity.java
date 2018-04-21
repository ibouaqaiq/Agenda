package com.example.issam.agenda.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.issam.agenda.R;

public class AddUserActivity extends AppCompatActivity {

    EditText addnombre, addapellido, addedad;
    Button addfinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        addnombre = findViewById(R.id.addnombre);
        addapellido = findViewById(R.id.addapellido);
        addedad = findViewById(R.id.addedad);
        addfinish = findViewById(R.id.addfinish);
    }
}
