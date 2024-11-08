package database

// PersonagemAdapter.kt
// PersonagemAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.thayline.sono.R

class PersonagemAdapter(
    private val onEditClick: (Personagem) -> Unit,
    private val onDeleteClick: (Personagem) -> Unit
) : ListAdapter<Personagem, PersonagemAdapter.PersonagemViewHolder>(PersonagemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personagem, parent, false)
        return PersonagemViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonagemViewHolder, position: Int) {
        val personagem = getItem(position)
        holder.bind(personagem)
    }

    inner class PersonagemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomeTextView: TextView = itemView.findViewById(R.id.nomeTextView)
        private val classeTextView: TextView = itemView.findViewById(R.id.classeTextView)
        private val nivelTextView: TextView = itemView.findViewById(R.id.nivelTextView)
        private val raca: TextView = itemView.findViewById(R.id.id_raca)
        private val forca: TextView = itemView.findViewById(R.id.id_forca)
        private val destreza: TextView = itemView.findViewById(R.id.id_destreza)
        private val constituicao: TextView = itemView.findViewById(R.id.id_constituicao)
        private val inteligencia: TextView = itemView.findViewById(R.id.id_inteligencia)
        private val sabedoria: TextView = itemView.findViewById(R.id.id_sabedoria)
        private val carisma: TextView = itemView.findViewById(R.id.id_carisma)
        private val btnEdit: Button = itemView.findViewById(R.id.id_Editar)
        private val btnDelete: Button = itemView.findViewById(R.id.id_deletar)

        fun bind(personagem: Personagem) {
            nomeTextView.text = personagem.nome
            classeTextView.text = "CLA:" + personagem.classe
            nivelTextView.text = "Nível: ${personagem.nivel}"
            raca.text = "RAC:" + personagem.raca
            forca.text = "FOR:" + personagem.forca.toString()
            destreza.text = "DES:" + personagem.destreza.toString()
            constituicao.text = "CON:" + personagem.constituicao.toString()
            inteligencia.text = "INT:" + personagem.inteligencia.toString()
            sabedoria.text = "SAB:" + personagem.sabedoria.toString()
            carisma.text = "CAR:" + personagem.carisma.toString()

            // Ações para os botões de editar e deletar
            btnEdit.setOnClickListener {
                onEditClick(personagem)
            }

            btnDelete.setOnClickListener {
                onDeleteClick(personagem)
            }
        }
    }

    class PersonagemDiffCallback : DiffUtil.ItemCallback<Personagem>() {
        override fun areItemsTheSame(oldItem: Personagem, newItem: Personagem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Personagem, newItem: Personagem): Boolean {
            return oldItem == newItem
        }
    }
}
