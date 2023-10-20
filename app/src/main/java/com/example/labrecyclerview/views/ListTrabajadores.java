package com.example.labrecyclerview.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.models.Trabajador;
import com.example.labrecyclerview.repositories.TrabajadorRespository;
import com.example.labrecyclerview.services.ServiceLocator;
import com.example.labrecyclerview.views.adapters.TrabajadorAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListTrabajadores extends AppCompatActivity implements  TrabajadorAdapter.OnItemClickListener{

    private TrabajadorAdapter personaAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trabajadores);

        TrabajadorRespository dbSource = ServiceLocator.getInstance().getDBSource();
        List<Trabajador> listaTrabajadores = dbSource.getAllListTrabajadores();

        // Configurando adaptador
        personaAdapter = new TrabajadorAdapter((ArrayList<Trabajador>) listaTrabajadores, ListTrabajadores.this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.rcvTrabajadores);
        recyclerView.setAdapter(personaAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        TextView title = findViewById(R.id.toolbar_title);
        ImageView leftIcon = findViewById(R.id.left_icon);
        title.setText("Lista Trabajadores");
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListTrabajadores.this, MainActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onItemClick(Trabajador persona) {
        Toast.makeText(this, "Esta es un prueba", Toast.LENGTH_SHORT).show();
    }
}