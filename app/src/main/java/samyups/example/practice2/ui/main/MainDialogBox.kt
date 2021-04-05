package samyups.example.practice2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.main_dialog_box.view.*
import samyups.example.practice2.R
import samyups.example.practice2.data.Pokemon

class MainDialogBox(private val mainViewModel: MainViewModel) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val dialogView = inflater.inflate(R.layout.main_dialog_box, container, false)

        dialogView.main_dialog_cancel_button.setOnClickListener {
            dismiss()
        }

        dialogView.main_dialog_submit_button.setOnClickListener {
            val newPokeId = dialogView.add_poke_id_edittext.text.toString().toInt()
            val newPokeName = dialogView.add_poke_name_edittext.text.toString()
            val newPokeType = dialogView.add_poke_type_edittext.text.toString()
            val newPokemon = Pokemon(newPokeId, newPokeName, newPokeType)

            mainViewModel.addPokemon(newPokemon)
            dismiss()
        }
        return dialogView
    }



}
