package Jogador

class Habilidade {
    var Forca:Int
    var Destreza:Int
    var Constituicao:Int
    var Inteligencia:Int
    var Sabedoria:Int
    var Carisma:Int

    constructor(forc:Int,dest:Int,const:Int,inte:Int,sabe:Int,cari:Int){
        var pontos:Int = 0
        var pontosAt:Int = 0
        this.Forca = 0
        this.Destreza = 0
        this.Constituicao = 0
        this.Inteligencia = 0
        this.Sabedoria = 0
        this.Carisma = 0
        var cust:Int = 27


        for (i in 0..6) {
            when (i) {
                1 -> pontos = forc
                2 -> pontos = dest
                3 -> pontos = const
                4 -> pontos = inte
                5 -> pontos = sabe
                6 -> pontos = cari
            }
            if(pontos > cust){
                pontos = 0
            }
            //para pontos maiores que os custos maiores, deixamos em 9
            else if (pontos > 9){
                pontos = 9
            }
            when (pontos){
                0 -> pontosAt = 8
                1 -> pontosAt = 9
                2 -> pontosAt = 10
                3 -> pontosAt = 11
                4 -> pontosAt = 12
                5 -> pontosAt = 13
                7 -> pontosAt = 14
                9 -> pontosAt = 15
            }

            when (i){
                1 -> {
                    cust = cust - pontos
                    this.Forca = pontosAt
                }
                2 -> {
                    cust = cust - pontos
                    this.Destreza = pontosAt
                }
                3 -> {
                    cust = cust - pontos
                    this.Constituicao = pontosAt
                }
                4 -> {
                    cust = cust - pontos
                    this.Inteligencia = pontosAt
                }
                5 -> {
                    cust = cust - pontos
                    this.Sabedoria = pontosAt
                }
                6 -> {
                    cust = cust - pontos
                    this.Carisma = pontosAt
                }
            }

        }

    }

    fun exibir(){
        println("Força " + this.Forca)
        println("Destreza "+ this.Destreza)
        println("Cosntituição "+this.Constituicao)
        println("Inteligencia "+ this.Inteligencia)
        println("Sabedoria "+this.Sabedoria)
        println("Carisma "+this.Carisma)
    }

    fun atualizarHabilidade(hab:Array<Int>){
        var forc =hab[0]
        var dest = hab[1]
        var const = hab[2]
        var inte = hab[3]
        var sabe = hab[4]
        var cari = hab[5]

        this.Forca = Forca + forc
        this.Destreza = Destreza + dest
        this.Constituicao = Constituicao + const
        this.Inteligencia = Inteligencia + inte
        this.Sabedoria = Sabedoria + sabe
        this.Carisma = Carisma + cari
    }

    fun Calcvida(vida:Int) : Int{


       var pont : Int = 0
        when(this.Constituicao){
            1 -> pont=vida-5
            2,3 ->pont=vida-4
            4,5->pont=vida-3
            6,7 ->pont=vida-2
            8,9 ->pont=vida-1
            10,11->pont=vida+0
            12,13 ->pont=vida+1
            14,15 ->pont=vida+2
            16,17 ->pont=vida+3
            18,19 ->pont=vida+4
            20,21 ->pont=vida+5
            22,23 ->pont=vida+6
            24,25 ->pont=vida+7
            26,27 ->pont=vida+8
            28,29 ->pont=vida+9
            30 ->pont=vida+10
        }

        return pont
    }

    fun retornarHabilidade():Array<Int>{
        return arrayOf(this.Forca, this.Destreza, this.Constituicao, this.Inteligencia, this.Sabedoria, this.Carisma)
    }



}




