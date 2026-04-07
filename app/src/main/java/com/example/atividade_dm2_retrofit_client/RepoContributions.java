package com.example.atividade_dm2_retrofit_client;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoContributions extends AppCompatActivity {
    RecyclerView rvContributors;
    TextView txtEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repo_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvContributors = findViewById(R.id.rvContributors);
        txtEmpty = findViewById(R.id.txtEmpty);

        String owner = getIntent().getStringExtra("owner");
        String repoName = getIntent().getStringExtra("repoName");
        getContributors(owner, repoName);
    }

    private void getContributors(String owner, String repoName) {
        Call<List<Contributor>> call = RetrofitClient.getInstance().getMyApi().getRepoContributors(owner, repoName);
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                List<Contributor> contributors = response.body();

                if (contributors == null || contributors.isEmpty()) {
                    txtEmpty.setVisibility(TextView.VISIBLE);
                    return;
                }
                rvContributors.setLayoutManager(new LinearLayoutManager(RepoContributions.this));
                rvContributors.setAdapter(new AdaptadorContributor(contributors));
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}