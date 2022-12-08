package com.dinesh.recyclerview.java.nested.rv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.recyclerview.R;

import java.util.List;

public class RvParentAdapter extends RecyclerView.Adapter<RvParentAdapter.MyViewHolder> {

    List<RvModel> rvModelList;

    public RvParentAdapter(List<RvModel> rvModelList) {
        this.rvModelList = rvModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.nested_rv2_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        RvModel rvModel = rvModelList.get(position);
        String sectionName = rvModel.getSectionName();
        List<String> items = rvModel.getSectionItems();

        holder.sectionNameTextView.setText(sectionName);

        RvChildAdapter rvChildAdapter = new RvChildAdapter(items);
        holder.childRecyclerView.setAdapter(rvChildAdapter);

    }

    @Override
    public int getItemCount() {
        return rvModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView sectionNameTextView;
        RecyclerView childRecyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sectionNameTextView = itemView.findViewById(R.id.sectionNameTextView);
            childRecyclerView = itemView.findViewById(R.id.childRecyclerView);
        }
    }
}