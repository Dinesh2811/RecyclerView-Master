package com.dinesh.recyclerview.java.search;

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

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> implements Filterable {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    List<RvModel> rvModelList = new ArrayList<>();
    RvInterface rvInterface;

    List<RvModel> rvModelListAll;

    public RvAdapter(List<RvModel> rvModelList, RvInterface rvInterface) {
        this.rvModelList = rvModelList;
        this.rvInterface = rvInterface;


        rvModelListAll = new ArrayList<>();
        rvModelListAll.addAll(rvModelList);
    }
//    public RvAdapter(List<RvModel> rvModelList, RvInterface rvInterface) {
//        this.rvModelList = rvModelList;
//        this.rvInterface = rvInterface;
//    }

    public RvAdapter(List<RvModel> rvModelList) {
        this.rvModelList = rvModelList;
    }

    public RvAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.iv_profilePic.setImageResource(rvModelList.get(position).profilePic);
        holder.tv_name.setText(rvModelList.get(position).name);
        holder.tv_position.setText(String.valueOf(position));

        Glide.with(holder.itemView.getContext())
//                .load("https://wallpapers.com/images/high/minimalist-green-android-logo-xmvp2a4zfaq70rlt.jpg")
                .load("https://loremflickr.com/20"+position+"/20"+position+"/dog")
                .placeholder(rvModelList.get(position).profilePic)
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(holder.iv_profilePic);
    }

    @Override
    public int getItemCount() {
        return rvModelList.size();
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    public Filter myFilter = new Filter() {

        //Automatic on background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<RvModel> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(rvModelListAll);
            } else {
                for (RvModel rvModel: rvModelListAll) {
//                    if (rvModel.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                    if (rvModel.name.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(rvModel);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        //Automatic on UI thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            rvModelList.clear();
            rvModelList.addAll((Collection<? extends RvModel>) filterResults.values);
//            rvModelList.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();
        }
    };


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_profilePic;
        TextView tv_name,tv_position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profilePic = itemView.findViewById(R.id.iv_profilePic);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_position = itemView.findViewById(R.id.tv_position);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolder: AdapterPosition -> " + getBindingAdapterPosition());
                rvInterface.onItemClick(v,getBindingAdapterPosition());
            });
        }
    }

}
