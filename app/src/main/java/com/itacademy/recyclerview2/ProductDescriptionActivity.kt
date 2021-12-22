package com.itacademy.recyclerview2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itacademy.recyclerview2.cart.Cart
import com.itacademy.recyclerview2.models.CartProduct
import com.itacademy.recyclerview2.models.Product

class ProductDescriptionActivity : AppCompatActivity() {


    lateinit var product: Product

    lateinit var title: TextView
    lateinit var image: ImageView
    lateinit var description: TextView
    lateinit var button: Button
    lateinit var addCartBtn: Button
    lateinit var minus: Button
    lateinit var plus: Button
    lateinit var cartBtn: FloatingActionButton

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_description)
        title = findViewById(R.id.title)
        image = findViewById(R.id.image)
        description = findViewById(R.id.description)
        button = findViewById(R.id.button)
        addCartBtn = findViewById(R.id.addCartBtn)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.plus)
        cartBtn = findViewById(R.id.cartBtn)
        product = intent.getSerializableExtra("product") as Product
        button.setOnClickListener {
            for (prod in Cart.addedProducts){
                Log.d("CART", "Корзина: Название продукта: ${prod.product.name} кол-во: ${prod.amount}")
            }

        }

        minus.setOnClickListener {
            if (counter <= 0) return@setOnClickListener
            counter--
            addCartBtn.text = "Добавить в коризну (${counter}) "
        }
        plus.setOnClickListener {
            counter++
            addCartBtn.text = "Добавить в коризну (${counter})"
        }
        cartBtn.setOnClickListener {

        }
        title.text = product.name
        description.text = product.description

        Glide.with(this).load(product.image).centerCrop().into(image)
    }

    fun addProduct(product: Product) {
        if (counter <= 0) return
        val cartProduct = CartProduct(product, counter)
        if (Cart.addedProducts.isEmpty()) {
            Cart.addedProducts.add(cartProduct)
            Log.d("CART", "Cart.addedProducts.add(product)")
        } else {
            if (!Cart.addedProducts.contains(cartProduct)) {
                Cart.addedProducts.add(cartProduct)
                Log.d("CART", "Добавить")
            } else {
                Log.d("CART", "Такой продукт уже есть")
            }
        }
    }
}