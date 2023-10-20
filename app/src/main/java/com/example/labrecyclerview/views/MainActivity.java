package com.example.labrecyclerview.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.labrecyclerview.R;
import com.example.labrecyclerview.databinding.ActivityLoginBinding;
import com.example.labrecyclerview.databinding.ActivityMainBinding;
import com.example.labrecyclerview.models.Trabajador;
import com.example.labrecyclerview.repositories.TrabajadorRespository;
import com.example.labrecyclerview.services.ServiceLocator;
import com.example.labrecyclerview.views.adapters.TrabajadorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAcerca;
    private Button btnMostrar;
    private Button btnAgregarTrabajador;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        btnAcerca = findViewById(R.id.btnAcerca);
        btnAgregarTrabajador = findViewById(R.id.btnAgregarTrabajador);
        btnMostrar = findViewById(R.id.btnMostrar);

        binding.btnAgregarTrabajador.setOnClickListener(v -> {
            showLoadingAgTrabajador();
        });

        binding.btnMostrar.setOnClickListener(v -> {
            showLoadingMostrar();
        });

        // Configurando evento click del boton
        binding.btnAcerca.setOnClickListener(v -> {
            showLoadingAcercade();
        });

        TextView title = findViewById(R.id.toolbar_title);
        ImageView leftIcon = findViewById(R.id.left_icon);
        leftIcon.setVisibility(View.GONE);
        title.setText("MainActivity");
    }

    // Procedimiento que permite mostrar una animacion mientras carga la siguiente pantalla
    private void showLoadingAcercade(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        // Crear un ProgressBar circular indeterminado (plantilla predefinida por Android).
        // ProgressBar progressBar = new ProgressBar(LoginActivity.this);
        // progressBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // Aca utilizamos la plantilla personalizada que se creo en el archivo progressbar.xml
        View progressBar = getLayoutInflater().inflate(R.layout.progressbar, null);
        // Agregar el ProgressBar al diseño del AlertDialog.
        builder.setView(progressBar);
        // Creacion del alertdialog
        final AlertDialog dialog = builder.create();
        // Mostrar alerta
        dialog.show();
        new Handler().postDelayed(() -> {
            try {
                if (dialog.isShowing()) {
                    startActivity(new Intent(MainActivity.this, AcercaDe.class));
                    dialog.dismiss();
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 2000); // 2000 milisegundos
    }

    // Procedimiento que permite mostrar una animacion mientras carga la siguiente pantalla
    private void showLoadingAgTrabajador(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        // Crear un ProgressBar circular indeterminado (plantilla predefinida por Android).
        // ProgressBar progressBar = new ProgressBar(LoginActivity.this);
        // progressBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // Aca utilizamos la plantilla personalizada que se creo en el archivo progressbar.xml
        View progressBar = getLayoutInflater().inflate(R.layout.progressbar, null);
        // Agregar el ProgressBar al diseño del AlertDialog.
        builder.setView(progressBar);
        // Creacion del alertdialog
        final AlertDialog dialog = builder.create();
        // Mostrar alerta
        dialog.show();
        new Handler().postDelayed(() -> {
            try {
                if (dialog.isShowing()) {
                    startActivity(new Intent(MainActivity.this, SelectTipoTrabajador.class));
                    dialog.dismiss();
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 2000); // 2000 milisegundos
    }

    // Procedimiento que permite mostrar una animacion mientras carga la siguiente pantalla
    private void showLoadingMostrar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        // Crear un ProgressBar circular indeterminado (plantilla predefinida por Android).
        // ProgressBar progressBar = new ProgressBar(LoginActivity.this);
        // progressBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // Aca utilizamos la plantilla personalizada que se creo en el archivo progressbar.xml
        View progressBar = getLayoutInflater().inflate(R.layout.progressbar, null);
        // Agregar el ProgressBar al diseño del AlertDialog.
        builder.setView(progressBar);
        // Creacion del alertdialog
        final AlertDialog dialog = builder.create();
        // Mostrar alerta
        dialog.show();
        new Handler().postDelayed(() -> {
            try {
                if (dialog.isShowing()) {
                    startActivity(new Intent(MainActivity.this, ListTrabajadores.class));
                    dialog.dismiss();
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 2000); // 3000 milisegundos
    }
}