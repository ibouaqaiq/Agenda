package com.example.issam.agenda.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.issam.agenda.R;
import com.example.issam.agenda.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder>{
    private List<Persona> listaPersonas = new ArrayList<>();

    public ContactAdapter(List<Persona> personaList) {
        this.listaPersonas = personaList;
    }


    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.MyViewHolder holder, int position) {
        Persona persona = listaPersonas.get(position);
        holder.nombre.setText(persona.getNom());
        holder.apellido.setText(persona.getCognoms());
        holder.edad.setText(persona.getEdad());

    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nombre, apellido, edad;
        public MyViewHolder(View view) {
            super(view);
            nombre = view.findViewById(R.id.nombre);
            apellido = view.findViewById(R.id.apellido);
            edad = view.findViewById(R.id.edad);
        }
    }

}
