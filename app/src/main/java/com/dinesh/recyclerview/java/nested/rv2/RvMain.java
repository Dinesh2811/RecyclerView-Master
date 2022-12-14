package com.dinesh.recyclerview.java.nested.rv2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class RvMain extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    List<RvModel> rvModelList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_rv2_main);
        Log.i(TAG, "onCreate: " );

        initData();

        recyclerView = findViewById(R.id.recyclerView);
        RvParentAdapter HMainRecyclerAdapter = new RvParentAdapter(rvModelList);
        recyclerView.setAdapter(HMainRecyclerAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initData() {

        String sectionOneName = "Action";
        List<String> sectionOneItems = new ArrayList<>();
        sectionOneItems.add("Captain America");
        sectionOneItems.add("Iron Man");
        sectionOneItems.add("Endgame");

        String sectionTwoName = "Adventure";
        List<String> sectionTwoItems = new ArrayList<>();
        sectionTwoItems.add("Pirates of the Caribbean");
        sectionTwoItems.add("King Kong");
        sectionTwoItems.add("Life of Pie");

        String sectionThreeName = "Epic";
        List<String> sectionThreeItems = new ArrayList<>();
        sectionThreeItems.add("Titanic");
        sectionThreeItems.add("Gandhi");
        sectionThreeItems.add("Ben-Hur");

        String sectionFourName = "War";
        List<String> sectionFourItems = new ArrayList<>();
        sectionFourItems.add("Saving Private Ryan");
        sectionFourItems.add("1917");
        sectionFourItems.add("Valkyrie");
        sectionFourItems.add("The Hurt Locker");

        rvModelList.add(new RvModel(sectionOneName, sectionOneItems));
        rvModelList.add(new RvModel(sectionTwoName, sectionTwoItems));
        rvModelList.add(new RvModel(sectionThreeName, sectionThreeItems));
        rvModelList.add(new RvModel(sectionFourName, sectionFourItems));

        Log.d(TAG, "initData: " + rvModelList);
    }
}