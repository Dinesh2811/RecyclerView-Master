package com.dinesh.recyclerview.java;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.dinesh.recyclerview.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RvMain extends AppCompatActivity implements RvInterface {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    List<RvModel> rvModelList = new ArrayList<>();
    RvAdapter rvAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_main);
        recyclerView = findViewById(R.id.recyclerView);

        //Sample Model Data
        for (int i = 0; i < 25; i++) {
            rvModelList.add(new RvModel(R.drawable.ic_launcher_foreground, "User " + (i + 1), false));
//            rvModelList.add(new RvModel(R.drawable.ic_baseline_drag_handle_24,"User "+i,false));
        }

        rvAdapter = new RvAdapter(rvModelList, RvMain.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(rvAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //  Refresh RecyclerView
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                for (int i = 28; i < 33; i++) {
                    rvModelList.add(new RvModel(R.drawable.ic_launcher_foreground, "User " + (i + 1), false));
                }

                rvAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        //  Drag and Re-Order RecyclerView
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        //  Search Filter for RecyclerView
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rvAdapter.getFilter().filter(newText);
                return false;
            }
        });

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


    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP |
            ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getBindingAdapterPosition();
            int toPosition = target.getBindingAdapterPosition();
            Log.d(TAG, "onMove: fromPosition -> " + fromPosition);
            Log.e(TAG, "onMove: toPosition -> " + toPosition);
            Collections.swap(rvModelList, fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Log.d(TAG, "onSwiped: " );
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setBackgroundColor(getResources().getColor(R.color.white));
//        ImageView searchClose = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
//        searchClose.setImageResource(R.drawable.ic_baseline_drag_handle_24);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rvAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

}
