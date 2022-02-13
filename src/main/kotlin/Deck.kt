import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File
import kotlin.random.Random

class Deck(private val cards: ArrayList<Card>) {
    private val drawn = ArrayList<Card>()
    fun draw(): Card {
        cards.shuffle()
        val card = cards[0]
        cards.removeAt(0)
        drawn.add(card)
        return card
    }

    fun drawAndReplace(): Card {
    cards.shuffle()
    return cards[0]
}

    fun reset(){
        cards.addAll(drawn)
        drawn.clear()
    }
}

fun buildTarotDeck(path: String): Deck{
    val file = object {}.javaClass.getResource(path).readText()
    val cardList = ArrayList(csvReader().readAll(file).map {
        Card(it[1],Pair(it[2],it[3]))
    })
    return Deck(cardList)
}

fun buildGenericDeck(path: String): Deck{
    val file = object {}.javaClass.getResource(path).readText()
    val cardList = ArrayList(csvReader().readAll(file).map {
        Card(it[0])
    })
    return Deck(cardList)
}