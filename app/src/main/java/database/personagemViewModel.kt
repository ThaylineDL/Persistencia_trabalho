package database

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PersonagemViewModel(application: Application) : AndroidViewModel(application) {

    private val personagemDao: PersonagemDao = AppDatabase.getDatabase(application).personagemDao()

    val todosPersonagens: LiveData<List<Personagem>> = personagemDao.listarPersonagens()

    fun inserir(personagem: Personagem) = viewModelScope.launch {
        personagemDao.inserir(personagem)
    }

    fun atualizar(personagem: Personagem) = viewModelScope.launch {
        personagemDao.atualizar(personagem)
    }

    fun deletar(personagem: Personagem) = viewModelScope.launch {
        personagemDao.deletar(personagem)
    }
}
