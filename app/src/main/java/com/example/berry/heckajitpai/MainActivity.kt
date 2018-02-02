package com.example.berry.heckajitpai

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG: String = "MainActivity "
class MainActivity : AppCompatActivity(), AsyncCallBackListener {
    override fun informStateChanged() {

    }
    private val baseUrl: String = "https://publicapi.fcc.gov/ecfs/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filingAdapter = FilingsAdapter(this, arrayListOf(), object: OnItemClickListener{
            override fun onItemClick(item: Filing) {

            }

        })

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = filingAdapter
        val gson: Gson = GsonBuilder()
                .setExclusionStrategies(object: ExclusionStrategy {
                    override fun shouldSkipField(f: FieldAttributes?): Boolean {
                        return f!!.name.contains("description")
                    }
                    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                        return false
                    }
                })
                .create()
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        val api: FilingSearchAPI = retrofit.create(FilingSearchAPI::class.java)
        val call: Call<Filings> = api.getFilings("gM0QT1ioa6m1foa6A2fXINC70gBbsgYAb5E5BHKg", "Restoring Internet Freedom", "autocomplete_open", "Alexander Berry")
        call.enqueue(object: Callback<Filings>{
            override fun onResponse(call: Call<Filings>?, response: Response<Filings>?) {
                Log.d(TAG, "IT WORKED PT 2 FT KOTLIN " + response)
                Log.d(TAG, response!!.body()!!.filings.get(0).text_data)
                filingAdapter.filings = response.body()!!.filings
                filingAdapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<Filings>?, t: Throwable?) {
                Log.e("MainActivity: ", t?.message)
                for(stackTrace:StackTraceElement in t?.stackTrace!!){
                    Log.e(TAG, stackTrace.toString())
                }
            }
        })
    }
}

interface AsyncCallBackListener {
    fun informStateChanged()
}
