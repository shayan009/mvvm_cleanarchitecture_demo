package com.debasish.sampleweatherapp.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.debasish.sampleweatherapp.MainApp
import com.debasish.sampleweatherapp.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainApp.appComponent.inject(this)
        rvCityList.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rvCityList.setHasFixedSize(false)
        initAdapter()
        addCity("London")
        ivAdd.setOnClickListener {
            showSheet()
        }

    }
    private fun showSheet(){
        val addCItySheet = AddCItySheet()
        addCItySheet.saveCity={
            it?.let { it1 -> addCity(it1) }
            addCItySheet.dismiss()
        }
        addCItySheet.show(supportFragmentManager, AddCItySheet::class.java.simpleName)

    }
        private fun addCity(city:String){
            if(adapter.cityList.size>0){
                var boolean=false
                adapter.cityList.forEach {
                    if(TextUtils.equals(it.name,city)){
                        adapter.cityList.add(it.id,VMCity(it.id,city,""))
                        boolean=true
                    }
                }
                if(!boolean){
                    adapter.cityList.add(VMCity(adapter.cityList.size,city,""))
                }
            }else{
                adapter.cityList.add(VMCity(0,city,""))
            }
adapter.notifyDataSetChanged()
        }
    private fun initAdapter() {
        val cityList= arrayListOf<VMCity>()
         adapter=HomeAdapter(cityList)
        rvCityList.adapter=adapter
    }
}
