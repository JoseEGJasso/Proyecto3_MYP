package mx.unam.ciencias.proyecto3

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
    private var datos  = Datos()

    init{
        this.archivos = archivos
        this.nombres = nombres
        this.directorio = directorio
    }
    /**
     *Función genera que se encargará de generar todos los archivos
     *@param error para notificar de cualquier error que pueda surgir en el programa
     */
    public fun genera (error : Errores){
        var i = 0
        archivos.forEach{
            var nombre = nombres.get(i++)
            creaArchivo(it, nombre.toString(),error)
        }
        creaIndice(error)
        creaCSS(error)
    }
    /**
     *Función genera archivo que genera el html de cada archivo
     *@param palabras las palabras del archivo
     *@param documento el nombre del archivo que se recibio
     *@param error para notificar de cualquier error que pueda surgir en el programa
     */
    private fun creaArchivo(palabras : MutableMap<String,Int> , documento : String, error : Errores){
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
     *Función que genéra el índice que tendrá una liga a cada documento html generado
     *@param error para notificar de cualquier error que pueda surgir en el programa
     */
    private fun creaIndice(error: Errores) {
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
     *Función limpia que regresará los nombres del archivo sin extensión
     *@param nombre el nombre a limpiar
     *@return limpio el nombre del archivo sin  extensión
     */
    private fun limpia(nombre: String): String {
        var limpio = ""
        for(i in 0..nombre.length){
            if(nombre[i] == '.'){
                break
            }
            limpio += nombre[i].toString()
        }
        return limpio
    }

    /**
     * Método que se encarga de generar el CSS de los HTML generados.
     * Mitad del CSS es generado por el método cssBody() y la otra
     * mitad por el método cssH1yh1()
     */
    private fun creaCSS(error: Errores){
        var contenido = cssBody() + cssH1yh1()
        val archivo = File(directorio+"/"+"estilo.css")

        try {
            archivo.bufferedWriter().use {
                escritor -> escritor.write(contenido)
            }
        } catch (e: IOException){
            error.errores(5)
        }
    }

    /**
     * Método que genera el CSS del cuerpo del HTML
     * @return cadena con el código CSS del cuerpo
     */
    private fun cssBody(): String{
        var body = "body{\n" +
                "    background-color: darkslategrey;\n" +
                "    background-image: url(https://images.wallpaperscraft.com/image/points_cubes_background_light_91691_1280x960.jpg);\n" +
                "}"

        body += "p{\n" +
                "    font-weight: bold;\n" +
                "    font-size: large;\n" +
                "    color: silver;\n" +
                "    font-family: \"Arial\", sans-serif;\n" +
                "    text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;\n" +
                "}"

        body += "a{\n" +
                "    color: yellow;\n" +
                "}"

        return body
    }

    /**
     * Método que genera el CSS de los títulos del HTML
     * @return cadena del código CSS de los totulos
     */
    private fun cssH1yh1(): String{
        var h1 = "\nh1{\n" +
                "    background-color: lightsteelblue;\n" +
                "    font-weight: bold;\n" +
                "    text-shadow: 1px 1px 3px black;\n" +
                "}"

        h1 += "H1{\n" +
                "    color: firebrick;\n" +
                "    background-color: lightsteelblue;\n" +
                "    text-align: center;\n" +
                "    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;\n" +
                "    text-shadow: 12px;\n" +
                "    font-style: italic;\n" +
                "    font-weight: bold;\n" +
                "}"

        return h1
    }

}

