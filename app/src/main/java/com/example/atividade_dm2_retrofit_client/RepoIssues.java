package com.example.atividade_dm2_retrofit_client;

import android.os.Bundle;
import android.util.Log;
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

public class RepoIssues extends AppCompatActivity {
    RecyclerView rvIssues;
    TextView txtEmpty;
    TextView txtRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repo_issues);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvIssues = findViewById(R.id.rvIssues);
        txtEmpty = findViewById(R.id.txtEmptyIssues);
        txtRepo = findViewById(R.id.txtRepo);

        String owner = getIntent().getStringExtra("owner");
        String repoName = getIntent().getStringExtra("repoName");

        txtRepo.setText(repoName);
        getIssues(owner, repoName);
    }

    private void getIssues(String owner, String repoName) {
        Log.d("ISSUES_REQUEST", "owner=" + owner + " | repo=" + repoName);
        Call<List<Issue>> call = RetrofitClient.getInstance().getMyApi().getRepoIssues(owner, repoName);
        call.enqueue(new Callback<List<Issue>>() {
            @Override
            public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                List<Issue> issues = response.body();
//                try {
//                    String raw = response.errorBody() != null
//                            ? response.errorBody().string()
//                            : "sem errorBody";
//                    Log.d("RAW_ERROR", raw);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

//                Log.d("RAW_CODE", String.valueOf(response.code()));
//                Log.d("RAW_HEADERS", response.headers().toString());

                // kkkkkk passei horas debugando pra descobrir que o problema erra o id da issue, que tinha
                // colocado como int e deveria ser Long, dado o tamanho do ID ...

                if (issues == null || issues.isEmpty()) {
                    txtEmpty.setVisibility(TextView.VISIBLE);
                    return;
                }

                if (issues != null) {
                    for (Issue issue : issues) {
                        Log.d("ISSUE_ITEM", "title=" + issue.getTitle() + " | state=" + issue.getState());
                    }
                }
                rvIssues.setLayoutManager(new LinearLayoutManager(RepoIssues.this));
                rvIssues.setAdapter(new AdaptadorIssue(issues));
            }

            @Override
            public void onFailure(Call<List<Issue>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}