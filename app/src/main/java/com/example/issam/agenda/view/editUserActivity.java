package com.example.issam.agenda.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.issam.agenda.R;
import com.example.issam.agenda.model.Persona;

import io.realm.Realm;

public class editUserActivity extends AppCompatActivity {
    EditText addnombre, addapellido, addedad;
    Button addfinish;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        Intent intent = getIntent();

        final Persona persona = intent.getParcelableExtra("persona");

        realm = Realm.getDefaultInstance();

        addnombre = findViewById(R.id.addnombre);
        addapellido = findViewById(R.id.addapellido);
        addedad = findViewById(R.id.addedad);
        addfinish = findViewById(R.id.addfinish);


        addnombre.setText(persona.getNom());
        addapellido.setText(persona.getCognoms());
        addedad.setText(persona.getEdad());



        addfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//hola
                persona.setNom(addnombre.getText().toString());
                persona.setCognoms(addapellido.getText().toString());
                persona.setEdad(addedad.getText().toString());

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(persona);
                realm.commitTransaction();


                onBackPressed();


            }
        });
    }
}
