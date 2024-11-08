package Jogador

import Classes.Classes
import Classes.Mago
import Raca.*


class Jogador {
    val Nome: String
    val Raca:Racas
    val Classe:Classes
    val HabilidadePlayer:Habilidade
    var Vida:Int =10
    var Nivel:Int = 1
    var Xp:Float =0.0f

    constructor(nome:String, habilidade: Habilidade,racas: String,classes: String){
        this.Nome = nome
        this.Classe  = atributiClasse(classes)
        this.Raca = atribuirRaca(racas)
        var arrayRaca: Array<Int>
        arrayRaca = this.Raca.HabilidadeRaca()
        habilidade.atualizarHabilidade(arrayRaca)
        this.HabilidadePlayer = habilidade
        Vida = HabilidadePlayer.Calcvida(Vida)
    }
    fun exibirplayer(){
        println()
        println("Nome: "+this.Nome)
        println()

        print("Raça: ")
        this.Raca.definirRaca()
        println()
        println()
        print("Classe: ")
        this.Classe.definirClasse()
        println()
        println()
        println("Habilidades:")
        this.HabilidadePlayer.exibir()

        println()
        println("Pontos de Vida: "+this.Vida)
        println()
        println("Nivel: "+ this.Nivel)
    }
    fun atribuirRaca(nome: String):Racas{
        var raca : Racas = Humano()

        when(nome){
            "Alto Elfo" ->{raca = Alto_Elfo()}
            "Anão" ->{raca = Anao()}
            "Draconato" ->{raca = Draconato()}
            "Drow" ->{raca = Drow()}
            "Elfo" ->{raca = Elfo()}
            "Gnomo" ->{raca = Gnomo()}
            "Halfing" ->{raca = Halfling()}
            "Humano" ->{raca = Humano()}
            "Meio Elfo" ->{raca = Meio_Elfo()}
            "Meio Orc" ->{raca = Meio_Orc()}
        }
        return raca
    }
    fun atributiClasse(nome: String):Classes{
        var classe : Classes = Mago()
        return classe
    }
    fun retornar_habilidade():Array<Int>{
        val habil = this.HabilidadePlayer.retornarHabilidade()
        return habil
    }
}
