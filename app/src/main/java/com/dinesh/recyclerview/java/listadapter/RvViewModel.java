package com.dinesh.recyclerview.java.listadapter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RvViewModel extends ViewModel {

    private static final String TAG = "MovieViewModel";
    private MutableLiveData<List<RvModel>> mutableLiveData;

    public LiveData<List<RvModel>> getMovieList() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            initMovieList();
        }
        return mutableLiveData;
    }

    private void initMovieList() {
        List<RvModel> JMovieList = new ArrayList<>();
        JMovieList.add(new RvModel("Captain America", "8"));
        JMovieList.add(new RvModel("Iron Man", "7"));
        JMovieList.add(new RvModel("Thor", "6"));
        mutableLiveData.setValue(JMovieList);
    }

    public void deleteMovie(int position) {
        if (mutableLiveData.getValue() != null) {
            List<RvModel> JMovieList = new ArrayList<>(mutableLiveData.getValue());
            JMovieList.remove(position);
            mutableLiveData.setValue(JMovieList);
        }
    }

    public void addMovie(RvModel JMovie) {
        if (mutableLiveData.getValue() != null) {
            List<RvModel> JMovieList = new ArrayList<>(mutableLiveData.getValue());
            JMovieList.add(JMovie);
            mutableLiveData.setValue(JMovieList);
        }
    }

    public void updateMovie(RvModel newJMovie, int position) {
        if (mutableLiveData.getValue() != null) {
            List<RvModel> JMovieList = new ArrayList<>(mutableLiveData.getValue());
            JMovieList.remove(position);
            JMovieList.add(position, newJMovie);
            mutableLiveData.setValue(JMovieList);
        }
    }

}