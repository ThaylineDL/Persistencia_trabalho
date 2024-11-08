package database

import androidx.room.Entity

import androidx.room.PrimaryKey

@Entity(tableName = "personagem_table")
data class Personagem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val classe: String,
    val nivel: Int = 0,
    val raca: String,
    val forca: Int = 0,
    val destreza: Int = 0,
    val constituicao: Int = 0,
    val inteligencia: Int = 0,
    val sabedoria: Int = 0,
    val carisma: Int = 0,
)

