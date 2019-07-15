package com.infoland.nytimesmostpopular

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created adapter to bind news feed data with views
 */
class NewsFeedAdapter(val list:ArrayList<NewsFeed>):RecyclerView.Adapter<NewsFeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: NewsFeedAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindItems(data : NewsFeed){
            val title:TextView = itemView.findViewById(R.id.title)
            val author:TextView = itemView.findViewById(R.id.byline)
            val publishedDate:TextView = itemView.findViewById(R.id.published_date)
                title.text = data.title
                author.text = data.byline
                publishedDate.text = data.publishedDate

            //set the onclick listener for the singlt list item
            itemView.setOnClickListener({
                Log.e("ItemClicked", data.title)
            })
        }

    }
}
