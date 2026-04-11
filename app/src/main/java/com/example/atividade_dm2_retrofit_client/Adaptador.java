package com.example.atividade_dm2_retrofit_client;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>{
    ArrayList<Repo> repos;

    public Adaptador(ArrayList<Repo> repos) {
        this.repos = repos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtNomeRepo;
        final TextView txtUrlRepo;
        final Button btnRepoContributions;
        final Button btnRepoIssues;

        public ViewHolder(View view) {
            super(view);
            this.txtNomeRepo = (TextView) view.findViewById(R.id.txtNomeRepo);
            this.txtUrlRepo = (TextView) view.findViewById(R.id.txtUrlRepo);
            this.btnRepoContributions = (Button) view.findViewById(R.id.btnRepoContributions);
            this.btnRepoIssues = (Button) view.findViewById(R.id.btnRepoIssues);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = repos.get(position);
        holder.txtNomeRepo.setText(repo.getName());
        holder.txtUrlRepo.setText(repo.getUrl());

        holder.btnRepoContributions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repoContributionsIntent = new Intent(v.getContext(), RepoContributions.class);
                repoContributionsIntent.putExtra("owner", repo.getOwner().getLogin());
                repoContributionsIntent.putExtra("repoName", repo.getName());
                v.getContext().startActivity(repoContributionsIntent);
            }
        });

        holder.btnRepoIssues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repoIssuesIntent = new Intent(v.getContext(), RepoIssues.class);
                repoIssuesIntent.putExtra("owner", repo.getOwner().getLogin());
                repoIssuesIntent.putExtra("repoName", repo.getName());
                v.getContext().startActivity(repoIssuesIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }
}
