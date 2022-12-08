package com.dinesh.recyclerview.java.listadapter;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.recyclerview.R;

import java.util.List;
import java.util.Random;

public class RvMain extends AppCompatActivity implements RvAdapter.RvInterface {

    private static final String TAG = "MainActivity";
    private RvAdapter rvAdapter;
    private RvViewModel rvViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listadapter_rv_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvAdapter = new RvAdapter( RvModel.itemCallback , this);
        recyclerView.setAdapter(rvAdapter);

        rvViewModel = new ViewModelProvider(this).get(RvViewModel.class);
        rvViewModel.getMovieList().observe(this, new Observer<List<RvModel>>() {
            @Override
            public void onChanged(List<RvModel> JMovies) {
                rvAdapter.submitList(JMovies);
            }
        });

    }

    public void addItem(View view) {
        RvModel JMovie = new RvModel("Avenger's", "9");
        rvViewModel.addMovie(JMovie);
    }

    public void updateItem(View view) {
        int randomPostion = new Random().nextInt(rvAdapter.getItemCount());
        RvModel JMovie = rvAdapter.getCurrentList().get(randomPostion);

        RvModel updateJMovie = new RvModel(JMovie.getName(), JMovie.getRating());
        updateJMovie.setId(JMovie.getId());
        updateJMovie.setName(JMovie.getName() + " :updated");

        rvViewModel.updateMovie(updateJMovie, randomPostion);
    }

    @Override
    public void onDelete(int position) {
        rvViewModel.deleteMovie(position);
    }
}