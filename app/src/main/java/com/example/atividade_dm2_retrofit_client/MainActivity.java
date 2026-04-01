package com.example.atividade_dm2_retrofit_client;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario;
    Button btnPesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);

        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                RepoFragment repoFragment = RepoFragment.newInstance(etUsuario.getText().toString());
                fragmentTransaction.replace(R.id.fragmentContainerView, repoFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}