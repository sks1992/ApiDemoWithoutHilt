package sk.sandeep.retrofitappdemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sk.sandeep.retrofitappdemo.util.BASE_URL

object RetrofitInstance {

    //get an instance of retrofit
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}