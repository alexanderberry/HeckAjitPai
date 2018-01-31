package com.example.berry.heckajitpai

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.filing_item.view.*

/**
 * Created by per6 on 1/31/18.
 */
class FilingsAdapter(context: Context, var filings: List<Filing>) : RecyclerView.Adapter<FilingsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.filing_item, parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = filings.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) = holder!!.bind(filings[position])

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bind(filing: Filing) = with(itemView){
            filer_name.text = filing.authors.get(0) as String
            filing_text.text = filing.text_data.substring(0,30) + "..."
            date_received.text = filing.date_received
            date_posted.text = filing.date_disseminated
        }
    }

}