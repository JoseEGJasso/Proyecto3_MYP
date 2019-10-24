package mx.unam.ciencias.proyecto3

import java.io.IOException
import java.io.FileWriter
import java.io.BufferedWriter
import java.io.File

/**
 * Clase que genera los valores de las graficas de barras y pastel mediante
 * los datos obtenidos de los archivos de entrada
 * @param palabrasOrdenadas lista de las palabras ordenadas de los archivos de entrada
 * @param total cantidad total de palabras en los archivos
 */
class GeneradorGraficas(palabrasOrdenadas: MutableList<Adaptador>,private var total: Int){

    /* Lista de las 10 palabras mas repetidas */
    private var palabrasFrecuentes = mutableListOf<Adaptador>()

    /* Objeto dibujo para crear las graficas correspondientes */
    private var dibujo = null

    /**
     * Constructor que añade a una lista las 10 palabras mas frecuentes así como el resto de
     * palabras en los archivos
     */
    init {
        var j = 0
        for (pal in palabrasOrdenadas) {
            if (j++ == 9)
                break
            total -= pal.getApariciones()
            palabrasFrecuentes.add(pal)
        }
        if (palabrasOrdenadas.size >= 10)
            palabrasFrecuentes.add(Adaptador("Resto", total))
    }

    /**
     *
     */
    fun genera(nombre:String,directorio: String,error: Errores){
        generaBarras(nombre,directorio,total,error)
        generaPastel(nombre,directorio,total,error)
    }

    /**
     * Genera un archivo .sgv de una grafica de barras dibujada por la clase dibujo
     * @param nombre el nombre del archivo de entrada
     * @param directorio ruta del directorio donde se van a guardar los archivos
     * @param total cantidad de palabras diferentes detectadaas en los archivos de entrada
     * @param error objeto que recibe que tipo de error e imprime un mensaje de acuerdo al error
     */
    private fun generaBarras(nombre: String, directorio: String, total: Int, error: Errores) {
        dibujo = DibujoBarras(total)
        val barras = File(directorio + "/" + nombre + "Barras.svg")
        val contenido = dibujo.dibuja(lista)
        try {
            barras.createNewFile()
            val bw = BufferedWriter(FileWriter(barras))
            bw.write(contenido)
            bw.close()
        } catch (io: IOException) {
            error.errores(5)
        }

    }

    /**
     * Genera un archivo .svg con las gráficas de pastel
     * @param nombre el nombre del archivo de entrada
     * @param directorio ruta del directorio donde se van a guardar los archivos
     * @param total cantidad de palabras diferentes detectadaas en los archivos de entrada
     * @param error objeto que recibe que tipo de error e imprime un mensaje de acuerdo al error
     */
    private fun generaPastel(nombre: String, directorio: String, total: Int, error: Errores) {
        dibujo = DibujoPastel(total.toDouble())
        val pastel = File(directorio + "/" + nombre + "Pastel.svg")
        val contenido = dibujo.dibuja(lista)
        try {
            pastel.createNewFile()
            val bw = BufferedWriter(FileWriter(pastel))
            bw.write(contenido)
            bw.close()
        } catch (io: IOException) {
            error.errores(5)
        }

    }


}