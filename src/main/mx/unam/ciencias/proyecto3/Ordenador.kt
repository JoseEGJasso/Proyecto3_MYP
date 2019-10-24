package mx.unam.ciencias.proyecto3

/**
 * Clase que se encarga de ordenar las palabras detectadas en los archivos de acuerdo
 * a su recurrencia en el archivo
 * @param palabrasEnArchivo Diccionario de todas las palabras encontradas en los archivos
 */
class Ordenador(palabrasEnArchivo: MutableMap<String, Int>) {

    /* Lista de palabras convertidas en objeto Adaptador*/
    private var palabrasAdaptadas = mutableListOf<Adaptador>()

    /**
     * Constructor que recorre las llaves de palabrasEnArchivos y crea objetos Adaptador que va
     * añadiendo a una lista
     */
    init{
        val llaves = palabrasEnArchivo.iterator()
        while (llaves.hasNext()) {
            val palabra = llaves.next()
            palabrasAdaptadas.add(Adaptador(palabra.key, palabrasEnArchivo[palabra.key]))
        }
    }

    /**
     * Método que ordena la lista de objetos Adaptador
     * @return Lista ordenada de las palabras de mayor recurrencia a menor
     */
    fun ordena(): MutableList<Adaptador> {

        palabrasAdaptadas.sort()

        palabrasAdaptadas.reverse()

        return palabrasAdaptadas
    }
}