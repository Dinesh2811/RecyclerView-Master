package com.dinesh.recyclerview.java.nested.rv1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class RvMain extends AppCompatActivity implements RvClickInterface {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    RecyclerView recyclerView;
    ParentAdapter parentAdapter;
    List<ParentModelClass> parentModelClassList = new ArrayList<>();
    List<ChildModelClass> childModelClassList = new ArrayList<>();


    List<ChildModelClass> favList = new ArrayList<>();
    List<ChildModelClass> recentList = new ArrayList<>();
    List<ChildModelClass> latestList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_rv_main);
        recyclerView = findViewById(R.id.rv_parent);

//        for (int i = 0; i < 50; i++) {
//            latestList.add(new ChildModelClass("https://picsum.photos/" + (i + 250)));
//            recentList.add(new ChildModelClass("https://picsum.photos/" + (i + 300)));
//            favList.add(new ChildModelClass("https://picsum.photos/" + (i + 350)));
//        }
//
//        parentModelClassList.add(new ParentModelClass("Latest Movies", latestList));
//        parentModelClassList.add(new ParentModelClass("Recent Movies", recentList));
//        parentModelClassList.add(new ParentModelClass("Favorite Movies", favList));
//        parentAdapter = new ParentAdapter(parentModelClassList, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(parentAdapter);


        parentAdapter = new ParentAdapter(RvData.getRvData().getRvDataList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(parentAdapter);

    }

    //    Parent onOnClickListener (using Interface)
    @Override
    public void onItemClick(View view, int position) {
//        Log.i(TAG, "Parent OnClickListener: parentRvPosition = " + position);
    }
}