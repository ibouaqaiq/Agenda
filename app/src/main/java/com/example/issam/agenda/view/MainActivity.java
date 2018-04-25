package com.example.issam.agenda.view;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.issam.agenda.R;
import com.example.issam.agenda.adapter.ContactAdapter;
import com.example.issam.agenda.model.Persona;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private ContactAdapter cAdapter;
    ImageButton addContact;
    private Realm realm;
    public RealmResults<Persona> pipol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        realm = Realm.getDefaultInstance();

        pipol=realm.where(Persona.class).findAll();

        addContact = findViewById(R.id.addContact);

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddUserActivity.class));
            }



        });


        recyclerView = findViewById(R.id.recycler_view);

        cAdapter = new ContactAdapter(pipol,getApplicationContext());

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);




    }

    @Override
    protected void onResume() {
        super.onResume();

        cAdapter.notifyDataSetChanged();


    }





}



