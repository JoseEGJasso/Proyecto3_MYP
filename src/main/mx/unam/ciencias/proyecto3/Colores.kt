package src.main.mx.unam.ciencias.proyecto3

/**
 * Clase colores
 * Esta clase solo contiene un método y sirve para regresar un el nombre de un  color que HTML tenga registrado
 *
 */
class Colores {
    /**
     * Este método recibe un entero y regresa un String de un color que HTML tiene registrado
     *  @param colorDeseado el int que dará el usuario pidiendo un número
     *  @return  un String con el nombre de un color registrado en HTML
     *  @throws IllegalArgumentExcpetion si da un numero menor a 0 o mayor a 9
     */
    fun colores(colorDeseado: Int): String {
        if(colorDeseado<0 || colorDeseado>9){
            throw IllegalArgumentException("Solo contamos con 10 colores, dame un número del 0 al 9 y te regresaré uno")
        }
        var color = ""
        when(colorDeseado){
            0 -> color = "red"
            1 -> color = "green"
            2 -> color = "orange"
            3 -> color = "yellow"
            4 -> color = "blue"
            5 -> color = "indigo"
            6 -> color = "pink"
            7 -> color = "coral"
            8 -> color = "turquoise"
            9 -> color = "lightblue"
        }
        return color
    }
}