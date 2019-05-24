
package com.example.taller_4.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taller_4.R
import com.example.taller_4.Models.Libro
import kotlinx.android.synthetic.main.book_cardview.view.*

class LibroAdapter(var items : List<Libro>, val clickListener : (Libro) -> Unit) : RecyclerView.Adapter<LibroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.book_cardview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Libro,clickListener: (Libro) -> Unit) = with(itemView) {
            tv_title_book.text = item.Titulo
            this.setOnClickListener{clickListener(item)}

        }
    }
}
