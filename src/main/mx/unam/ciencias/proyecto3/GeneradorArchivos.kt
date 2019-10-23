package mx.unam.ciencias.proyecto3

import mx.unam.ciencias.proyecto3.*

import java.io.File

import java.io.IOException
/**
 *Clase Generador Archivos que se encargará de generar los archivos html de cada archivo recibido con sus respectivos svg
 *Constructor que igualará sus atributos con los recibidos
 *@param archivos una lista de diccionarios con las palabras de cada archivo y sus repeticiones
 *@param nombres un diccionario con los nombres de los archivos recibidos
 *@param directorio la dirección en donde se crearán los archivos generados por el programa
*/
class GeneradorArchivos(archivos : MutableList<MutableMap<String,Int>>, nombres : MutableMap<Int,String>, directorio : String){
    /**
     *String directorio que tendrá la dirección de donde deben crearse los archivos
     */
    private val directorio : String
    /**
     *Lista archivos que tendrá las palbras con sus repeticiones de cada archivo
     */
    private val archivos : MutableList<MutableMap<String,Int>>
    /**
     *Diccionario de nombres que tiene los nombres de los archivos recibidos
     */
    private val nombres : MutableMap<Int,String>
    /**
     *Variable datos que creará todo el contenido dentro del html de cada archivo
     */
    private var datos : Datos = null

    init{
        this.archivos = archivos
        this.nombres = nombres
        this.directorio = directorio
    }
    /**
     *Método genera que se encargará de generar todos los archivos
     *@param error para notificar de cualquier error que pueda surgir en el programa
     */
    fun genera (error : Errores){
        var i = 0
        archivos.forEach{
            var nombre = nombres.get(i++)
            creaArchivo(it, nombre.toString(),error)
        }
        creaIndice(error)
    }
    /**
     *Método genera archivo que genera el html de cada archivo
     *@param palabras las palabras del archivo
     *@param documento el nombre del archivo que se recibio
     *@param error para notificar de cualquier error que pueda surgir en el programa
     */
    fun creaArchivo(palabras : MutableMap<String,Int> , documento : String, error : Errores){
        datos = Datos()
        var nombre  = File(directorio + "/" + limpia(documento) + ".html")
        var contenido = datos.html(palabras,documento,directorio,error)
        try{
            nombre.createNewFile()
            nombre.bufferedWriter().use { out ->
            out.write(contenido)
            }
            
        }catch(archivo : IOException){
            error.errores(5)
        }
    }
    /**
     *Método que genéra el índice que tendrá una liga a cada documento html generado
     *@param error para notificar de cualquier error que pueda surgir en el programa
     */
    fun creaIndice(error: Errores) {
        val ind = Indice(nombres)
        val indice = File(directorio+"/"+"index.html")
        val contenido = ind.html(archivos)
        try{
            indice.createNewFile()
            indice.bufferedWriter().use { out ->
                out.write(contenido)
            }

        }catch(archivo : IOException){
            error.errores(5)
        }
    }
    /**
     *Método limpia que regresará los nombres del archivo sin extensión
     *@param nombre el nombre a limpiar
     *@return limpio el nombre del archivo sin  extensión
     */
    fun limpia(nombre: String): String {
        var limpio = ""
        for(i in 0..nombre.length){
            if(nombre[i] == '.'){
                break
            }
            limpio += nombre[i].toString()
        }
        return limpio
    }
}

