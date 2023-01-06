package com.dinesh.recyclerview.root

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.recyclerview.R

class RvParentAdapter(var rvParentModelList: List<RvParentModel>, private val listener: RvParentInterface) : RecyclerView.Adapter<RvParentAdapter.MyViewHolder>(), RvChildInterface {
    private val TAG = "log_" + RvParentAdapter::class.java.name.split(RvParentAdapter::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvCardView: CardView = itemView.findViewById(R.id.rvCardView)
        val tvPackageName : TextView = itemView.findViewById(R.id.tvPackageName)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.childRecyclerView)

        init {
            val itemClickListener = View.OnClickListener {
                listener.onParentItemClick(it, bindingAdapterPosition)
                val isExpandable: Boolean = rvParentModelList[bindingAdapterPosition].isExpandable
                childRecyclerView.visibility = if (!isExpandable) View.VISIBLE else View.GONE
                rvParentModelList[bindingAdapterPosition].isExpandable = !rvParentModelList[bindingAdapterPosition].isExpandable
            }
            rvCardView.setOnClickListener(itemClickListener)
            tvPackageName.setOnClickListener(itemClickListener)
        }
    }

    fun setFilteredList(mList: List<RvParentModel>){
        this.rvParentModelList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.root_rv_list , parent , false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rvChildAdapter = RvChildAdapter(rvParentModelList[position].rvChildModel,this@RvParentAdapter,position)
        holder.childRecyclerView.adapter = rvChildAdapter
        holder.tvPackageName.text = rvParentModelList[position].packageName

    }

    override fun getItemCount(): Int {
        return rvParentModelList.size
    }

    override fun onChildItemClick(parentPosition: Int, view: View?, position: Int) {
        Log.e(TAG, "onItemClick: ${rvParentModelList[parentPosition].rvChildModel[position].className}")
    }
}



/*


class RvAdapter(var rvModelList: List<RvModel>, private val listener: RvInterface) : RecyclerView.Adapter<RvAdapter.MyViewHolder>(), RvInterface {
    private val TAG = "log_" + RvAdapter::class.java.name.split(RvAdapter::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPackageName : TextView = itemView.findViewById(R.id.tvPackageName)
        val tvClassName : TextView = itemView.findViewById(R.id.tvClassName)
        val tvVersion : TextView = itemView.findViewById(R.id.tvVersion)
        val tvDescription : TextView = itemView.findViewById(R.id.tvDescription)
        val rvCardView: CardView = itemView.findViewById(R.id.rvCardView)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.childRecyclerView)

        init {
            val itemClickListener = View.OnClickListener {
                listener.onItemClick(it, bindingAdapterPosition)
            }
            rvCardView.setOnClickListener(itemClickListener)
            tvPackageName.setOnClickListener(itemClickListener)
            tvClassName.setOnClickListener(itemClickListener)
            tvVersion.setOnClickListener(itemClickListener)
            tvDescription.setOnClickListener(itemClickListener)
//            tvDescription.setOnClickListener {
//                val isExpandable: Boolean = rvModelList[adapterPosition].isExpandable
//                tvDescription.visibility = if (!isExpandable) View.VISIBLE else View.GONE
//                rvModelList[adapterPosition].isExpandable = !rvModelList[adapterPosition].isExpandable
//            }


            val itemLongClickListener = View.OnLongClickListener {
                val isExpandable: Boolean = rvModelList[bindingAdapterPosition].isExpandable
                tvDescription.visibility = if (!isExpandable) View.VISIBLE else View.GONE
                rvModelList[bindingAdapterPosition].isExpandable = !rvModelList[bindingAdapterPosition].isExpandable
                true
            }

            rvCardView.setOnLongClickListener(itemLongClickListener)
            tvPackageName.setOnLongClickListener(itemLongClickListener)
            tvClassName.setOnLongClickListener(itemLongClickListener)
            tvVersion.setOnLongClickListener(itemLongClickListener)
            tvDescription.setOnLongClickListener(itemLongClickListener)
        }
    }

    fun setFilteredList(mList: List<RvModel>){
        this.rvModelList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.root_rv_list , parent , false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.tvPackageName.text = rvModelList[position].className.name
//        holder.tvClassName.text = rvModelList[position].className.simpleName
//        holder.tvVersion.text = rvModelList[position].version.toString()
//        holder.tvDescription.text = rvModelList[position].description


//        val rvChildAdapter = RvChildAdapter(rvModelList[position].rvChildModel,this@RvAdapter)
        val rvChildAdapter = RvChildAdapter(rvModelList[position].rvChildModel,this@RvAdapter,position)
        holder.childRecyclerView.adapter = rvChildAdapter
        holder.tvPackageName.text = rvModelList[position].packageName

    }

    override fun getItemCount(): Int {
        return rvModelList.size
    }

    override fun onItemClick(view: View?, position: Int) {
//
    }

    override fun onChildItemClick(parentPosition: Int, view: View?, position: Int) {
        Log.e(TAG, "onItemClick: ${position}")
        Log.e(TAG, "onItemClick: ${rvModelList[parentPosition]}")
    }
}


 */