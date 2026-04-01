package com.example.atividade_dm2_retrofit_client;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RepoFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class RepoFragment extends Fragment {
    ListView repoListView;
    Context context;

    private String username;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_USERNAME = "username";

    // TODO: Rename and change types of parameters
    private String mParam1;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param username Parameter 1.
     * @return A new instance of fragment RepoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RepoFragment newInstance(String username) {
        RepoFragment fragment = new RepoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    public RepoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(ARG_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        repoListView = view.findViewById(R.id.repoListView);

        context = requireContext();
        getUserRepo(context);
    }

    private void getUserRepo(Context context) {
        Call<List<Repo>> call = RetrofitClient.getInstance().getMyApi().getUserRepos(this.username);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repoList = response.body();
                String[] repos = new String[repoList.size()];
                for (int i = 0; i < repos.length; i++) {
                    repos[i] = repoList.get(i).getUrl();
                }

                ArrayAdapter<String> repoAdapter = new ArrayAdapter<>(
                        context.getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        repos
                );

                repoListView.setAdapter(repoAdapter);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(context, "Ocorreu um erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}