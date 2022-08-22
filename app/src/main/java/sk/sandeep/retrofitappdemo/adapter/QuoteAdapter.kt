package sk.sandeep.retrofitappdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import sk.sandeep.retrofitappdemo.R
import sk.sandeep.retrofitappdemo.models.Result

class QuoteAdapter : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {


    private val differCallback = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

     val differ = AsyncListDiffer(this, differCallback)

    class QuoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val author: TextView? = view.findViewById(R.id.tv_title1)
        private val content: TextView? = view.findViewById(R.id.tv_title2)
        fun bind(quote: Result) {
            author?.text = quote.author
            content?.text = quote.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_items, parent, false)

        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}