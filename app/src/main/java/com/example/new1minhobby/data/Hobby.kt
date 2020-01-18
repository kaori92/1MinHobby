package com.example.new1minhobby.data

data class Hobby (
    val id: Int,
    val name: String,
    val category: String,
    val time: String,
    val price: String,
    val description: String,
    val benefits: String
){
    fun getBenefits(): List<String> {
        return benefits.split("#")
    }
}