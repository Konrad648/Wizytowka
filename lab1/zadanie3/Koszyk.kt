data class Produkt(val nazwa: String, val cena: Double, val ilosc: Int)

class Koszyk {
    private val produkty = mutableListOf<Produkt>()

    fun dodaj(produkt: Produkt) {
        produkty.add(produkt)
    }

    fun usun(nazwa: String) {
        produkty.removeAll { it.nazwa == nazwa }
    }

    fun suma(): Double {
        val razem = produkty.sumOf { it.cena * it.ilosc }
        return when {
            razem > 200 -> razem * 0.9   // rabat 10%
            else -> razem
        }
    }
}

fun main() {
    val koszyk = Koszyk()
    koszyk.dodaj(Produkt("Chleb", 5.0, 2))
    koszyk.dodaj(Produkt("Mleko", 4.5, 3))
    println("Suma: ${koszyk.suma()} zł")

    koszyk.dodaj(Produkt("Buty", 250.0, 1))
    println("Suma z butami: ${koszyk.suma()} zł")

    koszyk.usun("Buty")
    println("Suma po usunięciu butów: ${koszyk.suma()} zł")
}