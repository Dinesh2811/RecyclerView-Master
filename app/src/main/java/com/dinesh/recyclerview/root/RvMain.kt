package com.dinesh.recyclerview.root

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.recyclerview.R
import com.dinesh.recyclerview.root.RvData.rvList
import java.util.*
import kotlin.collections.ArrayList


class RvMain : AppCompatActivity(), RvParentInterface {
    private val TAG = "log_" + RvMain::class.java.name.split(RvMain::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

    private lateinit var rvParentAdapter: RvParentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_rv_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        rvParentAdapter = RvParentAdapter(rvList(), this@RvMain)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = rvParentAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = findMatchingParent(query, rvList())
            if (filteredList.isEmpty()) {
                Log.e(TAG, "filterList: No Data found")
                rvParentAdapter.setFilteredList(emptyList())
            } else {
                rvParentAdapter.setFilteredList(filteredList)
            }
        }
    }

    private fun findMatchingParent(query: String, list: List<RvParentModel>): ArrayList<RvParentModel> {
        val matchingParents = ArrayList<RvParentModel>()
        for (parent in list) {
            for (child in parent.rvChildModel) {
                if (child.title.contains(query, ignoreCase = true)) {
                    if (!matchingParents.contains(parent)) {
                        matchingParents.add(parent)
                    }
                    break
                }
            }
        }
        return matchingParents
    }

    override fun onParentItemClick(view: View?, position: Int) {
//        if (view != null) {
//            when(view.id){
//                R.id.tvPackageName -> Log.d(TAG, "onItemClick: tvPackageName")
//                R.id.tvClassName -> Log.d(TAG, "onItemClick: tvClassName")
//                R.id.tvVersion -> Log.d(TAG, "onItemClick: tvVersion")
//                R.id.rvCardView -> Log.d(TAG, "onItemClick: rvCardView")
//                else -> Log.e(TAG, "onItemClick: else")
//            }
//        }

        Log.d(TAG, "onItemClick: ${rvList()[position].packageName}")
    }
}


