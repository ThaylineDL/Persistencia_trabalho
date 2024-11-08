package br.com.thayline.sono

import Jogador.Habilidade
import Jogador.Jogador
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import database.Personagem
import database.PersonagemAdapter
import database.PersonagemViewModel

class MainActivity : AppCompatActivity() {

    private val personagemViewModel: PersonagemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuração do RecyclerView e Adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = PersonagemAdapter(
            onEditClick = { personagem -> editarPersonagem(personagem) },
            onDeleteClick = { personagem -> deletarPersonagem(personagem) }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observa a lista de personagens e atualiza o RecyclerView
        personagemViewModel.todosPersonagens.observe(this, Observer { personagens ->
            personagens?.let { adapter.submitList(it) }
        })

        // Referências para os campos de entrada e botão
        val etNome: EditText = findViewById(R.id.etNome)
        val etClasse: EditText = findViewById(R.id.etClasse)
        val etNivel: EditText = findViewById(R.id.etNivel)
        val etRaca: EditText = findViewById(R.id.etRaca)
        val etForca: EditText = findViewById(R.id.etForca)
        val etDestreza: EditText = findViewById(R.id.etDestreza)
        val etConstituicao: EditText = findViewById(R.id.etConstituicao)
        val etInteligencia: EditText = findViewById(R.id.etInteligencia)
        val etSabedoria: EditText = findViewById(R.id.etSabedoria)
        val etCarisma: EditText = findViewById(R.id.etCarisma)
        val btnAddPersonagem: Button = findViewById(R.id.btnAddPersonagem)

        // Configuração do botão para adicionar novo personagem
        btnAddPersonagem.setOnClickListener {
            val nome = etNome.text.toString()
            val classe = etClasse.text.toString()
            val nivel = etNivel.text.toString().toIntOrNull() ?: 0
            val raca = etRaca.text.toString()
            val forca = etForca.text.toString().toIntOrNull() ?: 0
            val destreza = etDestreza.text.toString().toIntOrNull() ?: 0
            val constituicao = etConstituicao.text.toString().toIntOrNull() ?: 0
            val inteligencia = etInteligencia.text.toString().toIntOrNull() ?: 0
            val sabedoria = etSabedoria.text.toString().toIntOrNull() ?: 0
            val carisma = etCarisma.text.toString().toIntOrNull() ?: 0

            val habilidade = Habilidade(forca, destreza, constituicao, inteligencia, sabedoria, carisma)
            val personagem = Jogador(nome, habilidade, classe, raca)

            val habil = personagem.retornar_habilidade()
            if (nome.isNotEmpty() && classe.isNotEmpty() && raca.isNotEmpty()) {
                val personagem = Personagem(
                    nome = nome,
                    classe = classe,
                    nivel = nivel,
                    raca = raca,
                    forca = habil[0],
                    destreza = habil[1],
                    constituicao = habil[2],
                    inteligencia = habil[3],
                    sabedoria = habil[4],
                    carisma = habil[5]
                )
                personagemViewModel.inserir(personagem)

                // Limpa os campos de entrada após a inserção
                etNome.text.clear()
                etClasse.text.clear()
                etNivel.text.clear()
                etRaca.text.clear()
                etForca.text.clear()
                etDestreza.text.clear()
                etConstituicao.text.clear()
                etInteligencia.text.clear()
                etSabedoria.text.clear()
                etCarisma.text.clear()
            }
        }
    }

    // Função para editar um personagem
    private fun editarPersonagem(personagem: Personagem) {
        // Preenche os campos com os dados do personagem selecionado para edição
        findViewById<EditText>(R.id.etNome).setText(personagem.nome)
        findViewById<EditText>(R.id.etClasse).setText(personagem.classe)
        findViewById<EditText>(R.id.etNivel).setText(personagem.nivel.toString())
        findViewById<EditText>(R.id.etRaca).setText(personagem.raca)
        findViewById<EditText>(R.id.etForca).setText(personagem.forca.toString())
        findViewById<EditText>(R.id.etDestreza).setText(personagem.destreza.toString())
        findViewById<EditText>(R.id.etConstituicao).setText(personagem.constituicao.toString())
        findViewById<EditText>(R.id.etInteligencia).setText(personagem.inteligencia.toString())
        findViewById<EditText>(R.id.etSabedoria).setText(personagem.sabedoria.toString())
        findViewById<EditText>(R.id.etCarisma).setText(personagem.carisma.toString())

        // Botão de salvar as alterações
        findViewById<Button>(R.id.btnAddPersonagem).setOnClickListener {
            val nome = findViewById<EditText>(R.id.etNome).text.toString()
            val classe = findViewById<EditText>(R.id.etClasse).text.toString()
            val nivel = findViewById<EditText>(R.id.etNivel).text.toString().toIntOrNull() ?: 0
            val raca = findViewById<EditText>(R.id.etRaca).text.toString()
            val forca = findViewById<EditText>(R.id.etForca).text.toString().toIntOrNull() ?: 0
            val destreza = findViewById<EditText>(R.id.etDestreza).text.toString().toIntOrNull() ?: 0
            val constituicao = findViewById<EditText>(R.id.etConstituicao).text.toString().toIntOrNull() ?: 0
            val inteligencia = findViewById<EditText>(R.id.etInteligencia).text.toString().toIntOrNull() ?: 0
            val sabedoria = findViewById<EditText>(R.id.etSabedoria).text.toString().toIntOrNull() ?: 0
            val carisma = findViewById<EditText>(R.id.etCarisma).text.toString().toIntOrNull() ?: 0

            val personagemAtualizado = personagem.copy(
                nome = nome,
                classe = classe,
                nivel = nivel,
                raca = raca,
                forca = forca,
                destreza = destreza,
                constituicao = constituicao,
                inteligencia = inteligencia,
                sabedoria = sabedoria,
                carisma = carisma
            )

            personagemViewModel.atualizar(personagemAtualizado)
        }
    }

    // Função para deletar um personagem
    private fun deletarPersonagem(personagem: Personagem) {
        personagemViewModel.deletar(personagem)
    }
}
