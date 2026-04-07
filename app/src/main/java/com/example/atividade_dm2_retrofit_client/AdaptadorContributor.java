package com.example.atividade_dm2_retrofit_client;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorContributor extends RecyclerView.Adapter<AdaptadorContributor.ViewHolder> {
    List<Contributor> contributors;

    public AdaptadorContributor(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtLogin;
        final TextView txtUrl;
        final TextView txtContributions;
        final ImageView ivContributorAvatar;


        public ViewHolder(View view) {
            super(view);
            this.ivContributorAvatar = (ImageView) view.findViewById(R.id.ivContributorAvatar);
            this.txtLogin = (TextView) view.findViewById(R.id.txtLogin);
            this.txtUrl = (TextView) view.findViewById(R.id.txtUrl);
            this.txtContributions = (TextView) view.findViewById(R.id.txtContributions);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contributor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contributor contributor = contributors.get(position);

        Picasso.get().load(contributor.getAvatar_url()).into(holder.ivContributorAvatar);
        holder.txtLogin.setText(contributor.getLogin());
        holder.txtUrl.setText(contributor.getHtml_url());
        holder.txtContributions.setText("Contributions: " + contributor.getContributions());
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }
}
