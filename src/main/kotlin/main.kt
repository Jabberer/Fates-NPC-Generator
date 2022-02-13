import com.github.doyaaaaaken.kotlincsv.*
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File
    lateinit var namesDeck: Deck
    lateinit var tarotDeck: Deck
    lateinit var genderDeck: Deck
    lateinit var looksDeck: Deck
    lateinit var raceDeck: Deck
    lateinit var exoticRaceDeck: Deck
fun main(args: Array<String>) {
    tarotDeck = buildTarotDeck("tarot.csv")
    genderDeck = buildGenericDeck("gender.csv")
    raceDeck = buildGenericDeck("races.csv")
    exoticRaceDeck = buildGenericDeck("races_exotic.csv")
    looksDeck = buildGenericDeck("looks.csv")
    namesDeck = buildGenericDeck("names.csv")
    println("Welcome to Fates NPC Genertaor v.01" +
            "\nTo generate a new NPC just hit Enter" +
            "\nTo exit the program hit ESC or type 'exit'\n")
    while(true) {
        val input = readLine()
        if(input == "exit") break
        val npc = buildNPC(tarotDeck, genderDeck, raceDeck, exoticRaceDeck, looksDeck, namesDeck)
        println("Name: " + npc.name + "\nRace: " + npc.race + "\nGender: " + npc.gender + "\nTarot: " + npc.tarot + "\nReading: " + npc.reading + "\nLook: " + npc.look +"\nStatus:" + npc.status +"\n------------------------")
    }
    }
