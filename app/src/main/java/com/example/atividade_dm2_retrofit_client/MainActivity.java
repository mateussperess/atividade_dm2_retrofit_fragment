package com.example.atividade_dm2_retrofit_client;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario;
    Button btnPesquisar;
    private String login;

    private ImageView ivOwnerAvatar;
    private TextView txtOwnerName;
    private TextView txtOwnerUrl;
    private TextView txtOwnerContributions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);

        txtOwnerName = findViewById(R.id.txtOwnerName);
        ivOwnerAvatar = findViewById(R.id.ivOwnerAvatar);
        txtOwnerUrl = findViewById(R.id.txtOwnerUrl);

        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOwnerData(etUsuario.getText().toString());
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                RepoFragment repoFragment = RepoFragment.newInstance(etUsuario.getText().toString());
                fragmentTransaction.replace(R.id.fragmentContainerView, repoFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void getOwnerData(String username) {
        Call<Owner> call = RetrofitClient.getInstance().getMyApi().getOwnerByUsername(username);
        call.enqueue(new Callback<Owner>() {
            @Override
            public void onResponse(Call<Owner> call, Response<Owner> response) {
                if (response.body() == null || !response.isSuccessful()) {
                    return;
                }
                Owner owner = response.body();
                txtOwnerName.setText(owner.getName());
                txtOwnerUrl.setText(owner.getHtmlUrl());
                Picasso.get().load(owner.getAvatarUrl()).into(ivOwnerAvatar);

                MainActivity.this.login = owner.getLogin();
                Log.d("SUCCES_GET_LOGIN", "Login coletado com sucesso: " + owner.getLogin().toString());
            }

            @Override
            public void onFailure(Call<Owner> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ocorreu um erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ERROR_OWNER", "Problema: " + t.getMessage() + " - " + t.getStackTrace());
            }
        });
    }
}