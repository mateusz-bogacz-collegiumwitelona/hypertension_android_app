import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.Scanner

object Main {
    var systolic = 0
    var diastolic = 0
    var pulse = 0

    @JvmStatic
    fun main(args: Array<String>) {
        dataToFile()
    }

    fun printData(): String {
        val sc = Scanner(System.`in`)

        println("Podaj ciśnienie górne:")
        systolic = sc.nextInt()

        println("Podaj ciśnienie dolne: ")
        diastolic = sc.nextInt()

        println("Podaj puls: ")
        pulse = sc.nextInt()
        val data = "$systolic/$diastolic Puls: $pulse"

        println(data)
        sc.close()

        return data
    }

    private fun map(): Int {
        return diastolic + ((systolic - diastolic) / 3)
    }

   /*

   I must thing about this

   fun getInfo(): String {
        val map = map()

        return when {
            map > 120 -> "Stage 2 Hypertension"
            map in 107..120 -> "Stage 1 Hypertension"
            map in 94..106 -> "Prehypertension"
            map in 71..93 -> "Normal"
            else -> "Hypotension"
        }
    }
    */

    fun dataToFile() {
        val text = printData()
        val pathToFile = "test.txt"
        val file = File(pathToFile)
        var newFile = false

        try {
            if (!file.exists()) {
                newFile = file.createNewFile()
                if (newFile) {
                    println("Plik został utworzony: $pathToFile")
                }
            }

            FileWriter(pathToFile, true).use { writer ->
                writer.write("$text\n")
                println("Tekst został zapisany do pliku")
            }
        } catch (e: IOException) {
            println("Wystąpił błąd pliku")
            e.printStackTrace()
        }
    }
}
