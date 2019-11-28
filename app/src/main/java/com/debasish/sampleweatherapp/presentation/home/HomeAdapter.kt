package com.debasish.sampleweatherapp.presentation.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.debasish.sampleweatherapp.R
import com.debasish.sampleweatherapp.presentation.weather_report.WeatherDetailsActivity
import kotlinx.android.synthetic.main.holder_city.view.*


class HomeAdapter( var cityList: MutableList<VMCity>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate the layout file
        val happyHourProductView = LayoutInflater.from(parent.context).inflate(R.layout.holder_city, parent, false)
        return ViewHolder(happyHourProductView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(cityList[position], position)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(rule: VMCity, isActivated: Int) {
            itemView.mbCityName.text=rule.name
            itemView.mbCityName.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,WeatherDetailsActivity::class.java).putExtra("city_name",rule.name))
            }
        }

    }
}