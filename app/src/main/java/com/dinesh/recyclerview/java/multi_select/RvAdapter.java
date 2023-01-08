package com.dinesh.recyclerview.java.multi_select;

import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dinesh.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * RvAdapter
 */


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private final String TAG = "log_" + RvAdapter.class.getName().split(RvAdapter.class.getName().split("\\.")[2] + ".")[1];

    private List<RvModel> rvModelList;
    private RvInterface rvInterface;
    private ActionMode actionMode;
    private RvMain rvMain;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public RvAdapter(List<RvModel> rvModelList, RvInterface rvInterface, RvMain rvMain) {
        this.rvModelList = rvModelList;
        this.rvInterface = rvInterface;
        this.rvMain = rvMain;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.iv_profilePic.setImageResource(rvModelList.get(position).profilePic);
        holder.tv_name.setText(rvModelList.get(position).name);
        holder.tv_position.setText(String.valueOf(position));
        holder.checkBox.setChecked(getSelectedItems().contains(position));
        holder.checkBox.setVisibility(getSelectedItems().contains(position) ? View.VISIBLE : View.GONE);

        Glide.with(holder.itemView.getContext())
//                .load("https://wallpapers.com/images/high/minimalist-green-android-logo-xmvp2a4zfaq70rlt.jpg")
                .load("https://loremflickr.com/20" + position + "/20" + position + "/dog")
                .placeholder(rvModelList.get(position).profilePic)
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(holder.iv_profilePic);
    }

    @Override
    public int getItemCount() {
        return rvModelList.size();
    }

    public void remove(int position) {
        rvModelList.remove(position);
        notifyItemRemoved(position);
    }

    public void clearSelection() {
        selectedItems.clear();
        actionMode = null;
        notifyDataSetChanged();
    }

    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView iv_profilePic;
        TextView tv_name, tv_position;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profilePic = itemView.findViewById(R.id.iv_profilePic);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_position = itemView.findViewById(R.id.tv_position);
            checkBox = itemView.findViewById(R.id.check_box);

            iv_profilePic.setOnClickListener(this);
            tv_name.setOnClickListener(this);
            tv_position.setOnClickListener(this);
            checkBox.setOnClickListener(this);
            itemView.setOnClickListener(this);

            iv_profilePic.setOnLongClickListener(this);
            tv_name.setOnLongClickListener(this);
            tv_position.setOnLongClickListener(this);
            checkBox.setOnLongClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (actionMode != null) {
                toggleSelection(getAdapterPosition());
            } else {
                rvInterface.onItemClick(view, getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (actionMode == null) {
                actionMode = rvMain.startActionMode(rvMain);
            }
            toggleSelection(getAdapterPosition());
            return true;
        }
    }

    private void toggleSelection(int position) {
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position);
        } else {
            selectedItems.put(position, true);
        }
        notifyItemChanged(position);
        int count = getSelectedItemCount();
        if (count == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(count + " items selected");
            actionMode.invalidate();
        }
    }
}



//
//public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
//    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];
//
//    List<RvModel> rvModelList = new ArrayList<>();
//    RvInterface rvInterface;
//    private SparseBooleanArray selectedItems = new SparseBooleanArray();
//    private ActionMode actionMode;
//    private RvMain rvMain;
//
//    public RvAdapter(List<RvModel> rvModelList, RvInterface rvInterface, RvMain rvMain) {
//        this.rvModelList = rvModelList;
//        this.rvInterface = rvInterface;
//        this.rvMain = rvMain;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.iv_profilePic.setImageResource(rvModelList.get(position).profilePic);
//        holder.tv_name.setText(rvModelList.get(position).name);
//        holder.tv_position.setText(String.valueOf(position));
//
//        Glide.with(holder.itemView.getContext())
////                .load("https://wallpapers.com/images/high/minimalist-green-android-logo-xmvp2a4zfaq70rlt.jpg")
//                .load("https://loremflickr.com/20" + position + "/20" + position + "/dog")
//                .placeholder(rvModelList.get(position).profilePic)
//                .error(R.drawable.ic_launcher_background)
//                .circleCrop()
//                .into(holder.iv_profilePic);
//
//        holder.itemView.setBackgroundColor(selectedItems.get(position, false) ? Color.BLACK : Color.WHITE);
//    }
//
//    @Override
//    public int getItemCount() {
//        return rvModelList.size();
//    }
//
//    public void toggleSelection(int position) {
//        if (selectedItems.get(position, false)) {
//            selectedItems.delete(position);
//        } else {
//            selectedItems.put(position, true);
//        }
//        notifyItemChanged(position);
//    }
//
//    public void clearSelection() {
//        selectedItems.clear();
//        notifyDataSetChanged();
//    }
//
//    public int getSelectedItemCount() {
//        return selectedItems.size();
//    }
//
//    public List<Integer> getSelectedItems() {
//        List<Integer> items = new ArrayList<>(selectedItems.size());
//        for (int i = 0; i < selectedItems.size(); i++) {
//            items.add(selectedItems.keyAt(i));
//        }
//        return items;
//    }
//
//    public void remove(int position) {
//        // Define the remove method here
//        rvModelList.remove(position);
//        notifyItemRemoved(position);
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv_profilePic;
//        TextView tv_name, tv_position;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            iv_profilePic = itemView.findViewById(R.id.iv_profilePic);
//            tv_name = itemView.findViewById(R.id.tv_name);
//            tv_position = itemView.findViewById(R.id.tv_position);
//
//            itemView.setOnClickListener(v -> {
//                Log.d(TAG, "MyViewHolder: getBindingAdapterPosition -> " + getAdapterPosition());
//                rvInterface.onItemClick(v, getAdapterPosition());
//
//
//                rvMain.startActionMode(rvMain);
//                // Start the action mode here
//                actionMode = ((AppCompatActivity) v.getContext()).startActionMode(rvMain);
//                toggleSelection(getAdapterPosition());
//
//            });
//
//        }
//    }
//
//}







/*


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    List<RvModel> rvModelList = new ArrayList<>();
    RvInterface rvInterface;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private ActionMode actionMode;
    private RvMain rvMain;

    public RvAdapter(List<RvModel> rvModelList, RvInterface rvInterface, RvMain rvMain) {
        this.rvModelList = rvModelList;
        this.rvInterface = rvInterface;
        this.rvMain = rvMain;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.iv_profilePic.setImageResource(rvModelList.get(position).profilePic);
        holder.tv_name.setText(rvModelList.get(position).name);
        holder.tv_position.setText(String.valueOf(position));

        Glide.with(holder.itemView.getContext())
//                .load("https://wallpapers.com/images/high/minimalist-green-android-logo-xmvp2a4zfaq70rlt.jpg")
                .load("https://loremflickr.com/20" + position + "/20" + position + "/dog")
                .placeholder(rvModelList.get(position).profilePic)
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .into(holder.iv_profilePic);

        holder.itemView.setBackgroundColor(selectedItems.get(position, false) ? Color.BLACK : Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return rvModelList.size();
    }

    public void toggleSelection(int position) {
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position);
        } else {
            selectedItems.put(position, true);
        }
        notifyItemChanged(position);
    }

    public void clearSelection() {
        selectedItems.clear();
        notifyDataSetChanged();
    }

    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

    public void remove(int position) {
        // Define the remove method here
        rvModelList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profilePic;
        TextView tv_name, tv_position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profilePic = itemView.findViewById(R.id.iv_profilePic);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_position = itemView.findViewById(R.id.tv_position);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "MyViewHolder: getBindingAdapterPosition -> " + getAdapterPosition());
                rvInterface.onItemClick(v, getAdapterPosition());


                rvMain.startActionMode(rvMain);
                // Start the action mode here
                actionMode = ((AppCompatActivity) v.getContext()).startActionMode(rvMain);
                toggleSelection(getAdapterPosition());

            });

        }
    }

}
*/
