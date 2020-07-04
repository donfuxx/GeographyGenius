import java.io.File
import java.io.FileInputStream
import java.util.*

object Secrets {
    const val GOOGLE_MAPS_DEBUG_KEY = "GOOGLE_MAPS_DEBUG_KEY"

    val googleMapsDebugKey: String = secretsProperties().getProperty(GOOGLE_MAPS_DEBUG_KEY)

    private fun secretsProperties(): Properties {
        val filename = "secrets.properties"
        val file = File(filename)
        if (!file.exists()) {
            throw Error("You need to prepare a file called $filename in the project root directory.\n" +
                    "and contain the GOOGLE_MAPS_DEBUG_KEY key.\n" +
                    "the content of the file should look something like:\n\n" +
                    "(project root)$ cat $filename\n" +
                    "$GOOGLE_MAPS_DEBUG_KEY=abcde123253\n")
        }
        val properties = Properties()
        properties.load(FileInputStream(file))
        return properties
    }
}