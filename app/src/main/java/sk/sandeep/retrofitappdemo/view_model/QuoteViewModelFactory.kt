package sk.sandeep.retrofitappdemo.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sk.sandeep.retrofitappdemo.repository.QuoteRepository

class QuoteViewModelFactory(
    private val repository: QuoteRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(repository) as T
    }
}