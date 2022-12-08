package com.dinesh.recyclerview.java.listadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.recyclerview.R;

public class RvAdapter extends ListAdapter<RvModel, RvAdapter.MovieViewHolder> {

    RvInterface rvInterface;

    protected RvAdapter(@NonNull DiffUtil.ItemCallback<RvModel> diffCallback, RvInterface rvInterface) {
        super(diffCallback);
        this.rvInterface = rvInterface;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listadapter_rv_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        RvModel rvModel = getItem(position);
        holder.bind(rvModel);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieViewHolder";
        TextView nameTextView, ratingTextView;
        ImageButton deleteButton;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextview);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rvInterface.onDelete(getAdapterPosition());
                }
            });
        }

        public void bind(RvModel JMovie) {
            nameTextView.setText(JMovie.getName());
            ratingTextView.setText(JMovie.getRating());
        }
    }

    interface RvInterface {
        public void onDelete(int position);
    }
}