package com.dinesh.recyclerview.root

import com.dinesh.recyclerview.java.basic.RvMain
import com.dinesh.recyclerview.kotlin.search.MainActivity

object RvData {

     fun rvList(): ArrayList<RvParentModel> {
         return parentList(ArrayList())
    }

    private fun parentList(rvParentModelList: ArrayList<RvParentModel>): ArrayList<RvParentModel> {
        rvParentModelList.add(RvParentModel("Java", childList1(ArrayList())))
        rvParentModelList.add(RvParentModel("Kotlin", childList2(ArrayList())))

        return rvParentModelList
    }

    private fun childList1(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
        rvChildModelList.add(RvChildModel(Class.forName(RvMain::class.java.name), "Basic Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.search.RvMain::class.java.name), "Search Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.reorder.RvMain::class.java.name), "Drag & Re-Order Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.refresh.RvMain::class.java.name), "Refresh Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.multi_select.RvMain::class.java.name), "Multi Select Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.multi_view.RvMain::class.java.name), "MultiView Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.nested.rv2.RvMain::class.java.name), "Nested Recycler View"))

        return rvChildModelList
    }
    
    private fun childList2(rvChildModelList: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
        rvChildModelList.add(RvChildModel(Class.forName(MainActivity::class.java.name), "Search Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.expand.MainActivity::class.java.name), "Expand Recycler View"))
        rvChildModelList.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.diffutill.MainActivity::class.java.name), "Diffutill Recycler View"))

        return rvChildModelList
    }

}


/*

class DataManager {

    fun getRvParentModelList(): ArrayList<RvParentModel> {
        val list_1 = ArrayList<RvChildModel>()
        val list_2 = ArrayList<RvChildModel>()
        val rvParentModelList = ArrayList<RvParentModel>()

        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.basic.RvMain::class.java.name),"Basic Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.search.RvMain::class.java.name),"Search Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.reorder.RvMain::class.java.name),"Drag & Re-Order Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.refresh.RvMain::class.java.name),"Refresh Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.multi_view.RvMain::class.java.name),"MultiView Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.nested.rv2.RvMain::class.java.name),"Nested Recycler View"))

        rvParentModelList.add(RvParentModel( "Java",  list_1 ))


        list_2.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.search.MainActivity::class.java.name),"Search Recycler View"))
        list_2.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.expand.MainActivity::class.java.name),"Expand Recycler View"))
        list_2.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.diffutill.MainActivity::class.java.name),"Diffutill Recycler View"))

        rvParentModelList.add(RvParentModel( "Kotlin",  list_2 ))

        return rvParentModelList
    }
}

 */


/*

val dataManager = DataManager()
val rvParentModelList = dataManager.getRvParentModelList()

 */








/*



object RvData {

     fun rvList(): ArrayList<RvParentModel> {
         val list_1 = ArrayList<RvChildModel>()
         val list_2 = ArrayList<RvChildModel>()
         val rvParentModelList = ArrayList<RvParentModel>()



         rvParentModelList.add(RvParentModel( "Java",  x(ArrayList<RvChildModel>()) ))


        list_2.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.search.MainActivity::class.java.name),"Search Recycler View"))
        list_2.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.expand.MainActivity::class.java.name),"Expand Recycler View"))
        list_2.add(RvChildModel(Class.forName(com.dinesh.recyclerview.kotlin.diffutill.MainActivity::class.java.name),"Diffutill Recycler View"))

        rvParentModelList.add(RvParentModel( "Kotlin",  list_2 ))

        return rvParentModelList
    }

    private fun x(list_1: ArrayList<RvChildModel>): ArrayList<RvChildModel> {
        list_1.add(RvChildModel(Class.forName(RvMain::class.java.name), "Basic Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.search.RvMain::class.java.name), "Search Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.reorder.RvMain::class.java.name), "Drag & Re-Order Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.refresh.RvMain::class.java.name), "Refresh Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.multi_view.RvMain::class.java.name), "MultiView Recycler View"))
        list_1.add(RvChildModel(Class.forName(com.dinesh.recyclerview.java.nested.rv2.RvMain::class.java.name), "Nested Recycler View"))

        return list_1
    }
}



 */