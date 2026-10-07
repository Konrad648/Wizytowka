
data class Student(
    val imie: String,
    val punkty: Int,
    val email: String?,   // może być null
    val grupa: String
)

// funkcja rozszerzająca (wymagana w zadaniu)
fun Student.czyZaliczyl() = punkty >= 50

fun ocena(punkty: Int): Double = when {
    punkty >= 90 -> 5.0
    punkty >= 80 -> 4.5
    punkty >= 70 -> 4.0
    punkty >= 60 -> 3.5
    punkty >= 50 -> 3.0
    else -> 2.0
}

fun main() {
    val studenci = listOf(
        Student("Ala", 92, "ala@student.pl", "INIS5_PR1.1"),
        Student("Bartek", 71, null, "INIS5_PR1.1"),
        Student("Celina", 48, "celina@student.pl", "INIS5_PR1.2"),
        Student("Darek", 65, "darek@student.pl", "INIS5_PR1.2")
    )

    // null-safety: ?: podaje wartość domyślną
    for (s in studenci) {
        val mail = s.email ?: "brak e-maila"
        println("${s.imie} ${s.punkty} pkt → ocena ${ocena(s.punkty)} ($mail)")
    }

    // filter używa funkcji rozszerzającej
    val zaliczyli = studenci.filter { it.czyZaliczyl() }.map { it.imie }
    println("Zaliczyli: $zaliczyli")

    // groupBy + średnia w każdej grupie
    val grupy = studenci.groupBy { it.grupa }
    for ((nazwa, lista) in grupy) {
        val srednia = lista.map { it.punkty }.average()
        println("Grupa $nazwa: średnia ${"%.1f".format(srednia)} pkt")
    }
}
