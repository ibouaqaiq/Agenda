package com.example.issam.agenda.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.issam.agenda.R;
import com.example.issam.agenda.model.Persona;
import com.example.issam.agenda.view.MainActivity;
import com.example.issam.agenda.view.editUserActivity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


public class ContactAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    public ContactAdapter(List<Persona> personaList,Context context) {
        this.listaPersonas = personaList;
        this.context = context;
    }

    private List<Persona> listaPersonas = new ArrayList<>();

    Realm realm = Realm.getDefaultInstance();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Persona persona = listaPersonas.get(position);

        holder.nombre.setText(persona.getNom());
        holder.apellido.setText(persona.getCognoms());
        holder.edad.setText(persona.getEdad());

        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                persona.deleteFromRealm();
                realm.commitTransaction();
                notifyDataSetChanged();

            }
        });

        //jelou

        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,editUserActivity.class);
                intent.putExtra("persona",persona);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{

    TextView nombre;
    TextView apellido;
    TextView edad;

    ImageButton eliminar;
    Button editar;

    public ViewHolder(View itemView) {
        super(itemView);

        nombre = itemView.findViewById(R.id.nombre);
        apellido = itemView.findViewById(R.id.apellido);
        edad = itemView.findViewById(R.id.edad);

        eliminar = itemView.findViewById(R.id.borrar);
        editar = itemView.findViewById(R.id.editar);

    }
}














/*public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder>{
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

}*/
