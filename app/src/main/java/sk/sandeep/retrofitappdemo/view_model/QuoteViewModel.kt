package sk.sandeep.retrofitappdemo.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sk.sandeep.retrofitappdemo.models.QuoteList
import sk.sandeep.retrofitappdemo.repository.QuoteRepository

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes:LiveData<QuoteList>
    get() =repository.quotes
}