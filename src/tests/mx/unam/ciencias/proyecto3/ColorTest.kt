package mx.unam.ciencias.proyecto3

import mx.unam.ciencias.proyecto3.Colores

/**
 * Clase ColorTest
 * Esta clase probará que la clase Colores funcione de la manera planeada
 */
class ColorTest {
    /**
     * Función que probará que se lancé un IllegalArgumentExcpetion cuando el método colores reciba un número menor a 0 o mayor a 9
     */
    fun pruebaParametrosIncorrectos(){
        val prueba = Colores()
        try {
            prueba.colores(10)
            prueba.colores(-1)
        }
        catch(mayor : IllegalArgumentException  ) {
            assert(true)
        }
        catch(menor : IllegalArgumentException ){
            assert(true)
        }
    }

    /**
     * Función que probará que los colores que regresa el método colores sea el correcto según el número recibido
     */
    fun pruebaColorCorrecto(){
        val prueba = Colores()
        val colores = arrayOf("red","green","orange","yellow","blue","indigo","pink","coral","turquoise","lightblue")
        for (i in 0..9) {
            assert(prueba.colores(i) == colores.get(i))
        }
    }

}