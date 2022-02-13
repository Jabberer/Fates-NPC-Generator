import kotlin.random.Random

data class Card(val name: String, val meaning: Pair<String, String> = Pair("","")){
    fun read(): String{
        return if(Random.nextBoolean()) meaning.first else meaning.second
    }
    }