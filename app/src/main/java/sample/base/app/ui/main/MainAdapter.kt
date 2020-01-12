package sample.base.app.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*
import sample.base.app.R
import sample.base.app.data.model.Article
import sample.base.app.data.model.X

class MainAdapter(var items : List<X>) : RecyclerView.Adapter<MainAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder
            = NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: X){

            itemView.tv_title.text = weather.main.pressure.toString()
            itemView.tv_desc.text = weather.main.humidity.toString()
        }
    }
}