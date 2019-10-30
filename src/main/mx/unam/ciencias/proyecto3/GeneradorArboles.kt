package mx.unam.ciencias.proyecto3

import java.io.File

/**
 * Clase que se encarga de generar los arboles rojinegro y AVL de la recurrencia de las
 * palabras en el o los archivos de entrada
 * @param palabras Lista de palabras ordenadas por recurrencia
 */
class GeneradorArboles{

    /* Lista de las palabras más repetidas*/
    private val lista = mutableListOf<Adaptador>()

    /* Objeto dibujo que crea el diseño de los arboles*/
    private lateinit var dibujo: Dibujo

    /**
     * Constructor que recibe una lista ordenada y asigna las palabras
     * más repetidas en los archivos
     * @param listaOrdenada lista de palabras ordenadas por repeticion
     */
    constructor(listaOrdenada: MutableList<Adaptador>){
        var i = 65
        var j = 0
        for (a in listaOrdenada) {
            if (j++ == 15)
                break
            a.setLetra(i++.toChar())
            lista.add(a)
        }
    }

    /**
     * Método que genera los arboles AVL y Rojinegro de la información
     * de los archivos recibidos
     * @param nombre nombre de los archivos a crear
     * @param directorio ruta donde se van a crear los archivos
     * @param error objeto que lanza errores si los existen
     */
    fun genera(nombre: String, directorio: String, error: Errores) {
        generaRojinegro(nombre, directorio, error)
        generaAVL(nombre, directorio, error)
    }

    /**
     * Método que regresa las lista de las palabras más repetidas
     * @return lista de palabras ordenadas
     */
    fun getLista(): MutableList<Adaptador> {
        return lista
    }

    /**
     * Método que genera el archivo referente a un arbol rojinegro de los datos
     * @param nombre nombre de los archivos generados
     * @param directorio ruta de generacion de los archivos
     * @param error objeto que lanza errores si los hay
     */
    private fun generaRojinegro(nombre: String, directorio: String, error: Errores) {
        dibujo = DibujoArbolRojinegro()
        val rojinegro = File(directorio + "/" + nombre + "Rojinegro.svg")
        val contenido = dibujo.dibuja(lista)
        try {
            rojinegro.createNewFile()

            rojinegro.bufferedWriter().use { escritor ->
                escritor.write(contenido)
            }
        } catch (io: Exception) {
            error.errores(5)
        }
    }

    /**
     * Método que genera el archivo referente a un arbol AVL de los datos
     * @param nombre nombre de los archivos generados
     * @param directorio ruta de generacion de los archivos
     * @param error objeto que lanza errores si los hay
     */
    private fun generaAVL(nombre: String, directorio: String, error: Errores) {
        dibujo = DibujoArbolAVL()
        val avl = File(directorio + "/" + nombre + "AVL.svg")
        val contenido = dibujo.dibuja(lista)
        try {
            avl.createNewFile()

            avl.bufferedWriter().use { escritor ->
                escritor.write(contenido)
            }

        } catch (io: Exception) {
            error.errores(5)
        }
    }
}