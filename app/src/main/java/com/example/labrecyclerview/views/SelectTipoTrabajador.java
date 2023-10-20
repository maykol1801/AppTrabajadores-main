package com.example.labrecyclerview.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.labrecyclerview.R;

public class SelectTipoTrabajador extends AppCompatActivity {

    private Button btnSiguiente;
    private RadioGroup rgTrabajadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tipo_trabajador);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        rgTrabajadores = findViewById(R.id.rgTrabajadores);
        ((RadioButton)rgTrabajadores.getChildAt(0)).setChecked(true);

        btnSiguiente.setOnClickListener(v -> {
            RadioButton selectedRadioButton = findViewById(rgTrabajadores.getCheckedRadioButtonId());
            boolean idSelected = selectedRadioButton.getText().toString().contains("hora");
            finish();
            startActivity(new Intent(SelectTipoTrabajador.this, idSelected ? AgregarTrabajadorHora.class : AgregarTrabajadorCompleto.class ));
        });

        TextView title = findViewById(R.id.toolbar_title);
        ImageView leftIcon = findViewById(R.id.left_icon);
        title.setText("Tipo de Trabajador");
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectTipoTrabajador.this, MainActivity.class));
                finish();
            }
        });
    }


}