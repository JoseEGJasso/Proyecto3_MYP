package mx.unam.ciencias.proyecto3

import kotlin.system.exitProcess

/**
 * Clase que regula los errores que puede haber en el programa
 */
class Errores {
    /**
     * Método que organiza los posibles errores de ejecución, imprime el error en pantalla y termina la ejecución del programa
     * @param error numero correspondiente al error
     */
    fun errores(error: Int) {
        when(error){
            1 -> println("El uso del programa es el siguiente: \"java -jar target/proyecto3.jar -o directorio " +
                    "archivo1, archivo2, archivo 3\" no has usado la bandera \"-o\" antes del nombre de la carpeta en " +
                    "donde se guardarán los archivos")

            2 -> println("El uso del programa es : \"java -jar target/proyecto3.jar  -o directorio\" siendo " +
                    "directorio el nombre deseado de la carpet donde se pondrán los archios ó una dirección en memoria " +
                    "terminando con el nombre deseado para la carpeta que estara en la dirección brindada")

            3 -> println("No encuentro el archuvo que me brinadste, verifica si lo has creado o si me diste " +
                    "bien la ruta de acceso")

            4 -> println("El nombre que me diste despues de la bandera \"-o\" es un archivo")

            5 -> println("Algo salío mal, revisa que tenga los permisos necesaríos para crear y leer archivos")

            else -> println("Ese error no está dentro de la lista posibles errores. Intenata ejecutar de nuevo el programa")
        }

        exitProcess(status = 0)
    }
}