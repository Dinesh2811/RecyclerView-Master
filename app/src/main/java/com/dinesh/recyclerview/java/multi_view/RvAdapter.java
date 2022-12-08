package com.dinesh.recyclerview.java.multi_view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dinesh.recyclerview.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    List<RvModel> rvModelList = new ArrayList<>();
    RvInterface rvInterface;

    public RvAdapter(List<RvModel> rvModelList, RvInterface rvInterface) {
        this.rvModelList = rvModelList;
        this.rvInterface = rvInterface;
    }

    public RvAdapter(List<RvModel> rvModelList) {
        this.rvModelList = rvModelList;
    }

    public RvAdapter() {
    }

    @Override
    public int getItemViewType(int position) {
//        if (rvModelList.get(position).name.toLowerCase().contains("User 2")) {
        if (position % 4 != 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View view = layoutInflater.inflate(R.layout.rv_list, parent, false);
            return new MyViewHolderOne(view);
        } else {
            View view = layoutInflater.inflate(R.layout.rv_list_two, parent, false);
            return new MyViewHolderTwo(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        if (rvModelList.get(position).name.toLowerCase().contains("User 2")) {
        if (position % 4 != 0) {
            MyViewHolderOne viewHolderOne = (MyViewHolderOne) holder;
            viewHolderOne.tv_name.setText(rvModelList.get(position).name);
            viewHolderOne.tv_position.setText(String.valueOf(position));
            Glide.with(viewHolderOne.itemView.getContext())
                    .load("https://loremflickr.com/20" + position + "/20" + position + "/dog")
                    .placeholder(rvModelList.get(position).profilePic)
                    .error(R.drawable.ic_launcher_background)
                    .circleCrop()
                    .into(viewHolderOne.iv_profilePic);
        } else {
            MyViewHolderTwo viewHolderTwo = (MyViewHolderTwo) holder;
            Glide.with(viewHolderTwo.itemView.getContext())
                    .load("https://loremflickr.com/70" + position + "/10" + position + "/dog")
                    .placeholder(rvModelList.get(position).profilePic)
                    .error(R.drawable.ic_launcher_background)
                    .into(viewHolderTwo.iv_bannerPic);
        }
    }

    @Override
    public int getItemCount() {
        return rvModelList.size();
    }

    public class MyViewHolderOne extends RecyclerView.ViewHolder {
        ImageView iv_profilePic;
        TextView tv_name, tv_position;

        public MyViewHolderOne(@NonNull View itemView) {
            super(itemView);
            iv_profilePic = itemView.findViewById(R.id.iv_profilePic);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_position = itemView.findViewById(R.id.tv_position);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolderOne: AdapterPosition -> " + getBindingAdapterPosition());
                rvInterface.onItemClick(v, getBindingAdapterPosition());
            });
        }
    }


    public class MyViewHolderTwo extends RecyclerView.ViewHolder {
        ImageView iv_bannerPic;

        public MyViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            iv_bannerPic = itemView.findViewById(R.id.iv_bannerPic);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolderTwo: AdapterPosition -> " + getBindingAdapterPosition());
                rvInterface.onItemClick(v, getBindingAdapterPosition());
            });
        }
    }

}
