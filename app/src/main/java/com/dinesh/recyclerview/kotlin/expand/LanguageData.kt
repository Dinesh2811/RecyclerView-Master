package com.dinesh.recyclerview.kotlin.expand


data class LanguageData(
    val title: String,
    val logo: Int,
    val desc: String,
    var isExpandable: Boolean = false
)