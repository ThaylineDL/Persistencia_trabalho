package database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonagemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inserir(personagem: Personagem) : Long

    @Update
    suspend fun atualizar(personagem: Personagem)

    @Delete
    suspend fun deletar(personagem: Personagem)

    @Query("SELECT * FROM personagem_table ORDER BY nome ASC")
    fun listarPersonagens(): LiveData<List<Personagem>>
}
