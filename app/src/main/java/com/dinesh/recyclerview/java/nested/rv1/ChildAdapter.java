package com.dinesh.recyclerview.java.nested.rv1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dinesh.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.MyViewHolder> {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    List<ChildModelClass> childModelClassList;
    public int parentRvPosition;
    RvClickInterface rvClickInterface;

    List<ParentModelClass> parentModelClassList = new ArrayList<>();


    public ChildAdapter(List<ChildModelClass> childModelClassList, int parentRvPosition, RvClickInterface rvClickInterface) {
        this.childModelClassList = childModelClassList;
        this.parentRvPosition = parentRvPosition;
        this.rvClickInterface = rvClickInterface;
    }

    public ChildAdapter(List<ChildModelClass> childModelClassList, int parentRvPosition) {
        this.childModelClassList = childModelClassList;
        this.parentRvPosition = parentRvPosition;
    }

    public ChildAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_rv_child_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(holder.iv_child_image)
                .load(childModelClassList.get(position).imgUrl).
                into(holder.iv_child_image);
    }

    @Override
    public int getItemCount() {
        return childModelClassList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_child_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_child_image = itemView.findViewById(R.id.iv_child_item);

//            Child OnClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    rvClickInterface.onItemClick(v, getAdapterPosition());

                    //Position of Parent Rv is passed inside the Child Adapter
                    Log.i(TAG, " Child OnClickListener: parentRvPosition = " + parentRvPosition);

                    /***
                     * //Both are same
                     * Log.e(TAG, "onClick: "+RvData.getRvData().getRvDataList().get(parentRvPosition).childModelClassList.get(getAdapterPosition()).getImgUrl);
                     * Log.e(TAG, "onClick: "+childModelClassList.get(getAdapterPosition()).getImgUrl);
                     ***/

                    Log.i(TAG, "onClick: ParentTitle ->" +RvData.getRvData().getRvDataList().get(parentRvPosition).getTitle() );
                    Log.i(TAG, "onClick: ImgUrl ->" +childModelClassList.get(getAdapterPosition()).getImgUrl() );
//                    Intent intent = new Intent(v.getContext(), NewActivity.class);
//                    intent.putExtra("Title", RvData.getRvData().getRvDataList().get(parentRvPosition).getTitle());
//                    intent.putExtra("ImgUrl", childModelClassList.get(getAdapterPosition()).getImgUrl());
//                    v.getContext().startActivity(intent);
                }
            });
        }
    }


}