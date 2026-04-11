package com.example.atividade_dm2_retrofit_client;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorIssue extends RecyclerView.Adapter<AdaptadorIssue.ViewHolder> {
    List<Issue> issues;

    public AdaptadorIssue(List<Issue> issues) {
        this.issues = issues;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtTitle;
        final TextView txtBody;
        final TextView txtStatus;

        public ViewHolder(View view) {
            super(view);
            this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            this.txtBody = (TextView) view.findViewById(R.id.txtBody);
            this.txtStatus = (TextView) view.findViewById(R.id.txtStatus);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_issue, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Issue issue = issues.get(position);
        holder.txtTitle.setText("#" + issue.getNumber() + " — " + issue.getTitle());
        holder.txtBody.setText(issue.getBody() != null ? issue.getBody() : "Sem descrição.");
        holder.txtStatus.setText(issue.getState());
    }

    @Override
    public int getItemCount() {
        return issues.size();
    }
}
