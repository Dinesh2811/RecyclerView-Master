package com.dinesh.recyclerview.root

data class RvChildModel(
//    val className: Class<*> = Class.forName(Class_2::class.java.name),
    val className: Class<*>,
    var title: String = "Title not defined",
    var description: String = "Yet to add description for RvChildModel",
    var version: Float = 2.0f,
    var isExpandable: Boolean = false
)
