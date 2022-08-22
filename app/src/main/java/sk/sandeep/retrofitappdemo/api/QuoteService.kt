package sk.sandeep.retrofitappdemo.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sk.sandeep.retrofitappdemo.models.QuoteList

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuotes(
        @Query("page") page: Int
    ): Response<QuoteList>
}