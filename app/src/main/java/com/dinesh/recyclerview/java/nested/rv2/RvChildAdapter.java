package com.dinesh.recyclerview.java.nested.rv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.recyclerview.R;

import java.util.List;

public class RvChildAdapter extends RecyclerView.Adapter<RvChildAdapter.ViewHolder> {

    List<String> items;

    public RvChildAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.nested_rv2_child_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTextView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
    }
}