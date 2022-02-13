import kotlin.random.Random

data class NPC(val name: String = "", val tarot: String, val reading: String, val gender: String, val race: String, val look: String) {
val status = when(Random.nextDouble()){
    in 0.0 .. 0.2 -> "Low"
    in 0.2 .. 0.8 -> "Neutral"
    else -> "High"
}
}

fun buildNPC(tarotDeck: Deck, genderDeck: Deck, raceDeck: Deck, exoticRaceDeck: Deck, looksDeck: Deck, namesDeck: Deck): NPC{
    val tarot = tarotDeck.draw()
    val gender = genderDeck.draw()
    val race = if(Random.nextFloat() > .1) raceDeck.drawAndReplace() else exoticRaceDeck.drawAndReplace()
    val look = looksDeck.draw()
    var names: String = "";
    for(i in 1..5) names += (namesDeck.draw().name + ", ")
    return NPC(name = names, tarot=
    tarot.name, reading=tarot.read(), gender = gender.name, race = race.name, look = look.name)
}