package samyups.example.practice2.ui.fire

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_firebase.*
import kotlinx.android.synthetic.main.activity_main.*
import samyups.example.practice2.R
import samyups.example.practice2.data.Pokemon
import samyups.example.practice2.data.Pokemon2
import samyups.example.practice2.ui.main.MainActivity
import samyups.example.practice2.ui.main.MainViewModel
import samyups.example.practice2.util.*
import java.util.*

class FirebaseActivity: AppCompatActivity() {


    private val myAdapter = FireAdapter()

    private lateinit var fireDialogBox: FireDialogBox
    private var firebaseDatabase= FirebaseDatabase.getInstance()


    private lateinit var mPokemon : Pokemon2

    private val viewModel: FireViewModel by viewModels {
        FireViewModelFactory((application as MainApplication).fireRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)
        initRecyclerView()
        initUI()

        //Get Dataa
        getData().addListenerForSingleValueEvent(
                ValueListenerAdapter {
                    mPokemon = it.asPokemon2()!!
                    var pokeList : List<Pokemon2> = emptyList()
                    pokeList += mPokemon
                    myAdapter.update(pokeList)
                }
        )

    }

    private fun initRecyclerView() {
        fire_recyclerView.apply {
            layoutManager = LinearLayoutManager(this@FirebaseActivity)
            adapter = myAdapter
        }
    }

    private fun initUI() {
        to_main_act_btn.setOnClickListener {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        fireb_add_fab.setOnClickListener { showDialogBox() }
    }

    private fun showDialogBox() {
        fireDialogBox = FireDialogBox(firebaseDatabase)
        fireDialogBox.show(supportFragmentManager, "DialogBox")
    }

    private fun getData() : DatabaseReference = viewModel.getData()
}