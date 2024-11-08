package Raca

class Gnomo : Racas{
    override fun definirRaca() {
        print("Gnomo")
    }

    override fun HabilidadeRaca(): Array<Int> {
        //1-Forca 2-Destreza 3-Constituicao 4-Inteligencia 5-Sabedoria 6- Carisma
        return arrayOf(0,0,0,2,0,0)
    }
}