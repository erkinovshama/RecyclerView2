package com.itacademy.recyclerview2.models

import java.io.Serializable

//Модель продукта магазина
data class Product(
    var id: Int,
    var name: String,
    var image: String,
    var price: Double,
    var amount: Int,
    var description: String
) : Serializable
