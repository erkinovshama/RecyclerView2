package com.itacademy.recyclerview2.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itacademy.recyclerview2.ProductDescriptionActivity
import com.itacademy.recyclerview2.R
import com.itacademy.recyclerview2.models.Product

class CartAdapter(private val array: ArrayList<Product>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productName: TextView = view.findViewById(R.id.productName)
        val image: ImageView = view.findViewById(R.id.imageView)
        val price: TextView = view.findViewById(R.id.price)
        val amount: TextView = view.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.productName.text = item.name
        Glide.with(holder.itemView).load(item.image).placeholder(R.drawable.ic_launcher_foreground).into(holder.image)
        holder.amount.text = item.amount.toString()
        holder.price.text = item.price.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDescriptionActivity::class.java)
            intent.putExtra("product", item)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return array.size
    }
}