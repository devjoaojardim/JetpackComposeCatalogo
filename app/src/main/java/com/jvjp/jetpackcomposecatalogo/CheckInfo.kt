package com.jvjp.jetpackcomposecatalogo

data class CheckInfo(val title: String, var selected:Boolean = false, var onCheckedChange:(Boolean) -> Unit)