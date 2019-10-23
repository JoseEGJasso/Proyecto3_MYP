package mx.unam.ciencias.proyecto3

import java.io.File

/**
 * Clase que se encarga de lo referente a el ingreso de datos y la creación de archivos
 */
class Lector {
    /**
     * Ruta donde se guardarán los archivos generados
     */
    private var directorio = ""

    /**
     * POSIBLE MEJORA: CREAR UNA CARPETA EN LA RUTA DIRECTORIO QUE CONTENGA LOS ARCHIVOS GENERADOS Y
     *                 SI YA EXISTE UNA CARPETA CON ESE NOMBRE, CREAR UNA CON UN NOMBRE LIGERAMENTE
     *                 MODIFICADO
     * Método que recibe los argumentos ingresados y lee las posibles rutas de archivos así como la
     * existencia de la bandera -o con su respectiva ruta
     * @param args los argumentos de entrada
     */
    fun lee(args: Array<String>) {
        val error = Errores()
        val doc = Documentos()
        var listaDeRutas = mutableListOf<String>()
        var banderaDirectorio = false

        for (param in args) {
            if (param == "-o") {
                rutaCarpeta(args, args.indexOf(param), error)
                banderaDirectorio = true
                continue
            }
            if (banderaDirectorio) {
                banderaDirectorio = false
                continue
            }

            listaDeRutas.add(param)
        }

        creaCarpeta(error)

        if (directorio == "")
            error.errores(1)
        doc.archivo(listaDeRutas, error, directorio)
    }

    /**
     * Método que guarda la dirección donde se desean guardar los archivos creados.
     * @param args lista de argumentos donde está la direccion de la carpeta
     * @param indice indice de la bandera -o en los argumentos
     * @param error objeto que lanza mensajes de error si los hay
     */
    private fun rutaCarpeta(args: Array<String>, indice: Int, error: Errores) {
        try {
            directorio = args[indice + 1]
        } catch (e: IndexOutOfBoundsException) {
            error.errores(2)
        }

    }

    /**
     * Método que crea la carpeta donde se van a crear los archivos generados por el programa
     * @param error objeto que lanza mensajes de error si los hay
     */
    private fun creaCarpeta(error: Errores) {
        val carpeta = File(directorio)

        if (carpeta.exists() && carpeta.isFile)
            error.errores(4)
        if (carpeta.exists() && carpeta.isDirectory) {
            eliminaCarpeta(carpeta)
            carpeta.mkdir()
            return
        }
        if (!carpeta.exists())
            carpeta.mkdirs()
    }

    /**
     * Método recursivo que borrará todos los archivos dentro de una carpeta y la misma carpeta
     * @param archivo el archivo a borrar
     */
    private fun eliminaCarpeta(archivo: File) {
        if (!archivo.exists())
            return
        if (archivo.isDirectory)
            for (f in archivo.listFiles()!!)
                eliminaCarpeta(f)
        archivo.delete()
    }
}