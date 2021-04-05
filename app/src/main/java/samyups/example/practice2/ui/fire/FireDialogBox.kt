package samyups.example.practice2.ui.fire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.main_dialog_box.view.*
import samyups.example.practice2.R
import samyups.example.practice2.data.Pokemon

class FireDialogBox(private val firebaseDatabase: FirebaseDatabase) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val dialogView = inflater.inflate(R.layout.main_dialog_box, container, false)

        val db = firebaseDatabase.reference

        dialogView.main_dialog_cancel_button.setOnClickListener {
            dismiss()
        }

        dialogView.main_dialog_submit_button.setOnClickListener {
            val newPokeId = dialogView.add_poke_id_edittext.text.toString().toInt()
            val newPokeName = dialogView.add_poke_name_edittext.text.toString()
            val newPokeType = dialogView.add_poke_type_edittext.text.toString()

            val newPokemon = Pokemon(newPokeId, newPokeName, newPokeType)

            db.child(newPokeId!!.toString()).setValue(newPokemon)
            dismiss()
        }
        return dialogView
    }
}
