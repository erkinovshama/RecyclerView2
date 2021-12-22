package com.itacademy.recyclerview2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.recyclerview2.adapters.ProductAdapter
import com.itacademy.recyclerview2.models.Product

class MainActivity : AppCompatActivity() {
    val listProduct = arrayListOf<Product>()
    lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView2 = findViewById(R.id.recyclerView2)
        listProduct.add(
            Product(1,"GUCCI neochen'",
                "https://irecommend.ru/sites/default/files/product-images/1883775/tfMZ4nBbcFT9BnLrWXIeg.jpg",
            500.0,99,"Gucci barsetka")
        )
        listProduct.add(
            Product(2, "Louis Vuitton toje",
                "https://blog.luxxy.com/wp-content/uploads/2019/12/2f59ad964b2bf0e686c6ff2a1765b8d0.jpg",
                350.0,99,"louis parawa")
        )
        listProduct.add(
            Product(3, "Chanel fignya luchwe abibas",
                "https://focus.ua/static/storage/thumbs/920x465/7/03/4dd1795f-08142a2d0b93c63473bdab4c3c2d4037.jpg?v=9569_1",
                400.0,99,"ne pokupaite Chanel"))
        recyclerView2.adapter = ProductAdapter(listProduct)
    }
}