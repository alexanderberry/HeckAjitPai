package com.example.berry.heckajitpai

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), AsyncCallBackListener {
    override fun informStateChanged() {

    }
    private val validNamesRaw: ArrayList<String> = ArrayList<String>()
    private val baseUrl: String = "https://publicapi.fcc.gov/ecfs/"
    private val tag: String = "MainActivity: "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        validNamesRaw.add("submissiontype")
        validNamesRaw.add("confirmation_number")
        validNamesRaw.add("contact_email")
        validNamesRaw.add("addressentity")
        validNamesRaw.add("text_data")
        val gson: Gson = GsonBuilder()
                .setExclusionStrategies(object: ExclusionStrategy{
                    override fun shouldSkipField(f: FieldAttributes?): Boolean {
                        return f!!.name !in validNamesRaw
                    }
                    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
                .create()
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        val api: FilingSearchAPI = retrofit.create(FilingSearchAPI::class.java)
        val call: Call<List<Filing>> = api.getFilings("gM0QT1ioa6m1foa6A2fXINC70gBbsgYAb5E5BHKg", "Restoring Internet Freedom", "autocomplete_open", "Alexander Berry")
        call.enqueue(object: Callback<List<Filing>>{
            override fun onResponse(call: Call<List<Filing>>?, response: Response<List<Filing>>?) {
                Log.d(tag, "IT WORKED PT 2 FT KOTLIN " + response)
            }

            override fun onFailure(call: Call<List<Filing>>?, t: Throwable?) {
                Log.e("MainActivity: ", t?.message)
            }
        })
    }
}

interface AsyncCallBackListener {
    fun informStateChanged()
}
