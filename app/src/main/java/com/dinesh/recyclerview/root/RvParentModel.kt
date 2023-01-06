package com.dinesh.recyclerview.root

data class RvParentModel(
    var packageName: String = "Root",
    var rvChildModel: List<RvChildModel>,
    var isExpandable: Boolean = false
)


