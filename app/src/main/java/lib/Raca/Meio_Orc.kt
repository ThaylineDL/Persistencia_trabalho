package Raca

class Meio_Orc : Racas {
    override fun definirRaca() {
        print("Meio-Orc")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(2,0,1,0,0,0)
    }

}