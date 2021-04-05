package samyups.example.practice2.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import samyups.example.practice2.R
import samyups.example.practice2.ui.fire.FirebaseActivity
import samyups.example.practice2.util.MainApplication
import samyups.example.practice2.util.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val myAdapter = MainAdapter()
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as MainApplication).mainRepository)
    }
    lateinit private var mainDialogBox : MainDialogBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initUI()
    }

    private fun initRecyclerView() {
        main_recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
    }

    private fun initUI() {
        mainViewModel.getPokemonList.observe(this, Observer {
            myAdapter.update(it)
        })

        fab_add.setOnClickListener { showDialog() }
        firebasae_btn.setOnClickListener {
            val firebaseIntent = Intent(this, FirebaseActivity::class.java)
            startActivity(firebaseIntent)
        }
    }

    private fun showDialog() {
        mainDialogBox = MainDialogBox(mainViewModel)
        mainDialogBox.show(supportFragmentManager, "DialogBox")
    }
}