package sk.sandeep.retrofitappdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import sk.sandeep.retrofitappdemo.api.QuoteService
import sk.sandeep.retrofitappdemo.models.QuoteList

class QuoteRepository(private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList> get() = quotesLiveData

    suspend fun getQuotes(page: Int) {
        val result = quoteService.getQuotes(page)

        if (result?.body() != null) {
            quotesLiveData.postValue(result.body())
        }
    }
}