package sk.sandeep.retrofitappdemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sk.sandeep.retrofitappdemo.R
import sk.sandeep.retrofitappdemo.adapter.QuoteAdapter
import sk.sandeep.retrofitappdemo.api.QuoteService
import sk.sandeep.retrofitappdemo.api.RetrofitInstance
import sk.sandeep.retrofitappdemo.repository.QuoteRepository
import sk.sandeep.retrofitappdemo.view_model.QuoteViewModel
import sk.sandeep.retrofitappdemo.view_model.QuoteViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var quoteViewModel: QuoteViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var quoteAdapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_quote)
        val quoteService = RetrofitInstance.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        quoteViewModel = ViewModelProvider(
            this,
            QuoteViewModelFactory(repository)
        )[QuoteViewModel::class.java]

        initiateRecyclerView()

        quoteViewModel.quotes.observe(this) {
            quoteAdapter.differ.submitList(it.results.toList())
        }
    }

    private fun initiateRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        quoteAdapter = QuoteAdapter()
        recyclerView.adapter = quoteAdapter
    }
}