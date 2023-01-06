package com.dinesh.recyclerview.java.basic;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class RvMain extends AppCompatActivity implements RvInterface {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    List<RvModel> rvModelList = new ArrayList<>();
    RvAdapter rvAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: " );
        setContentView(R.layout.rv_main);
        recyclerView = findViewById(R.id.recyclerView);

        //Sample Model Data
        for (int i = 0; i < 25; i++) {
            rvModelList.add(new RvModel(R.drawable.ic_launcher_foreground, "User " + (i + 1), false));
        }

        rvAdapter = new RvAdapter(rvModelList, RvMain.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(rvAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(TAG, "onItemClick: position -> " + position);
//        Intent intent = new Intent(this, NewLayout.class);
//        intent.putExtra("NAME", rvModelList.get(position).name);
//        startActivity(intent);

        /* ---- NewLayout.class ----
//        String movieName = getIntent().getStringExtra("NAME");
         */
    }
}



