package samyups.example.practice2.data

import com.google.firebase.database.Exclude

data class Pokemon2(
        @Exclude val id: Int = 0,
        val name: String = "",
        val type: String = "",
)