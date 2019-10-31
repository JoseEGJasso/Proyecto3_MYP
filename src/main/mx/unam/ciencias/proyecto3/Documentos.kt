package mx.unam.ciencias.proyecto3

import java.text.Normalizer
import java.io.File

/**
 * Clase documentos que se encarga de leer los archivos recibidos
 * así como de contabilizar las palabras que los conforman
 */
class Documentos{

    /* Lista que guarda las palabras y su frecuencia en cada archivo recibido*/
    private var palabrasEnArchivos = mutableListOf<MutableMap<String,Int>>()

    /* Diccionario con los nombres de los archivos*/
    private var nombres = mutableMapOf<Int,String>()

    /**
     *Método que lee las rutas de los archivos y los lee
     *@param nombres una lista que contiene los nombres de los archivos
     *@param error para notificar de cualquier error que pueda surgir en el programa
     *@param directorio la ubicación en donde se deben construir los archivos
     */
    fun archivo(nombres: MutableList<String>,error: Errores, directorio: String){
        for (i in 0 until nombres.size) {

            var nombre = nombres[i]
            leerArchivo(nombre,error)

            if (nombre.contains("/"))
                nombre = quitaDireccion(nombre)
            this.nombres[i] = nombre
        }

        val generador = GeneradorArchivos(palabrasEnArchivos, this.nombres, directorio)
        generador.genera(error)
    }

    /**
     *Lee el archivo que recibe de parametro
     *@param ruta ruta del archivo a leer
     *@param error posible error que surga en la ejecucion del programa
     */
    private fun leerArchivo(ruta: String,error: Errores){

        val palabrasArchivo = mutableMapOf<String,Int>()
        val leeArchivo = File(ruta)
        val buffer = leeArchivo.bufferedReader()

        var lector = buffer.readLine()

        while (lector != null){
            corta(lector,palabrasArchivo)
            lector = buffer.readLine()
        }

        palabrasEnArchivos.add(palabrasArchivo)
    }

    /**
     *Método que regresa solo el nombre del acrhivo
     *@param ruta ruta del archivo
     *@return nombre del archivo de la ruta recibida
     */
    private fun quitaDireccion(ruta: String): String{
        val dir = ruta.split('/')

        return dir[dir.size-1]
    }

    /**
     *Método que agrega las palabras del acrhivo a un diccionario, y lleva el conteo de cada palabra
     *@param palabra palabra que se va a agregar
     *@param palabras diccionario donde se guardarán las palabras
     */
    private fun agregaPalabra(palabra: String, palabras: MutableMap<String,Int>) {
        if(palabra.isEmpty())
            return
        if(palabras.containsKey(palabra)) {
            palabras[palabra] = palabras[palabra]!!+1
            return
        }
        palabras[palabra] = 1

    }

    /**
     * Método recursivo que divide una linea en palabras por espacios y las agrega al
     * diccionario recibido
     * @param linea Cadena que se va dividir
     */
    private fun corta(linea: String,palabrasEnArchivos: MutableMap<String, Int>){
        if (linea.isEmpty())
            return

        val lineaPart = linea.trim()

        val palabras = lineaPart.split("\\s".toRegex())

        agregaPalabra(limpia(palabras[0]),palabrasEnArchivos)

        corta(lineaPart.substring(palabras[0].length,lineaPart.length),palabrasEnArchivos)

    }

    /**
     * Método que elimina acentos del String recibido
     * @param palb Cadena a la cual se le van a eliminar los acentos
     * @return Cadena recibida sin acentos
     */
    private fun limpia(palb: String): String {

        var palabraTemp = Normalizer.normalize(palb,Normalizer.Form.NFD).toLowerCase().replace(
                "[^\\p{ASCII}]".toRegex(), "")

        return palabraTemp.replace("\\p{Punct}+".toRegex(),"")
    }
}