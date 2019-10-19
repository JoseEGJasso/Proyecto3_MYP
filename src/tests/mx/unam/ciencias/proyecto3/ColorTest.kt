package src.tests.mx.unam.ciencias.proyecto3

import src.main.mx.unam.ciencias.proyecto3.Colores

class ColorTest {
    @Test
    fun pruebaParametrosIncorrectos(): Unit {
        val prueba = Colores()
        try {
            prueba.colores(10)
            prueba.colores(-1)
        }
        catch(IllegalArgumentException mayor) {
            assertTrue(true)
        }
        catch(IllegalArgumentException menor){
            assertTrue(true)
        }
    }
    fun pruebaColorCorrecto(): Unit {
        val prueba = Colores()
        val colores = arrayOf("red","green","orange","yellow","blue","indigo","pink","coral","turquoise","lightblue")
        for (i in 0..9) {
            assertTrue(prueba.colores(i) == colores.get(i))
        }
    }

}