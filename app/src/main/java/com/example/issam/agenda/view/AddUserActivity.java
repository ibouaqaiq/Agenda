package com.example.issam.agenda.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.issam.agenda.R;
import com.example.issam.agenda.adapter.ContactAdapter;
import com.example.issam.agenda.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class AddUserActivity extends AppCompatActivity {

    EditText addnombre, addapellido, addedad;
    Button addfinish;
    Persona contacto = new Persona();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        addnombre = findViewById(R.id.addnombre);
        addapellido = findViewById(R.id.addapellido);
        addedad = findViewById(R.id.addedad);
        addfinish = findViewById(R.id.addfinish);


        contacto.setNom(addnombre.getText().toString());
        contacto.setCognoms(addapellido.getText().toString());
        contacto.setEdad(addedad.getText().toString());

        addfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();


            }
        });


    }
}
