package com.example.atividade_dm2_retrofit_client;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        public ViewHolder(View view) {
            super(view);
            this.txtNomeRepo = (TextView) view.findViewById(R.id.txtNomeRepo);
            this.txtUrlRepo = (TextView) view.findViewById(R.id.txtUrlRepo);
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
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }
}
