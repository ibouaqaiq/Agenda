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

        System.out.println(persona.getNom());


        realm = Realm.getDefaultInstance();


        addnombre = findViewById(R.id.editNombre);
        addapellido = findViewById(R.id.editApellido);
        addedad = findViewById(R.id.editEdad);
        addfinish = findViewById(R.id.confirm);


        addnombre.setText(persona.getNom());
        addapellido.setText(persona.getCognoms());
        addedad.setText(String.valueOf(persona.getEdad()));



        addfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                persona.setNom(addnombre.getText().toString());
                persona.setCognoms(addapellido.getText().toString());
                persona.setEdad(Integer.parseInt(addedad.getText().toString()));
                persona.setNacimiento(persona.getEdad());

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(persona);
                realm.commitTransaction();


                onBackPressed();


            }
        });
    }
}
