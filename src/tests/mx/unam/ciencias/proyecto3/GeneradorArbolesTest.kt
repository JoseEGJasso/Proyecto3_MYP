package mx.unam.ciencias.proyecto3

import java.io.File

/**
 * Clase encargado de probar la funcionalidad del metodo genera
 * de la clase GeneradorArboles
 */
class GeneradorArbolesTest {

    private var genArbol: GeneradorArboles? = null
    private val error = Errores()

    /* Inicializador de las varibale a utilizar en el test*/
    init {
        val lista = mutableListOf<Adaptador>()

        lista.add(Adaptador("hola",3))
        lista.add(Adaptador("perro",51))
        lista.add(Adaptador("gato",7))
        lista.add(Adaptador("koala",4))
        lista.add(Adaptador("tigre",1))
        lista.add(Adaptador("julio",87))

        genArbol = GeneradorArboles(lista)

    }

    /**
     * Metodo test de genera, se crean algunos archivos y se verifica si existencias,
     * solo de esta manera se puede pasar el test. AL final de la ejecucion se eleiminan
     * los archivos creados para este test
     */
    fun generaTest() {

        genArbol?.genera("test", "./", error)

        val dir = File("./")

        val archivos = dir.listFiles()

        if (archivos == null){
            print("la cagaste con la ruta")
            return
        }

        var i = 0

        for (a in archivos){
            if (a.name == "testRojinegro.svg" || a.name == "testAVL.svg")
                i++
        }

        if (i == 2)
            println("pasó la prueba")

        val archivo1 = File("./testRojinegro.svg")
        val archivo2 = File("./testAVL.svg")

        if (archivo1.exists())
            archivo1.delete()
        if (archivo2.exists())
            archivo2.delete()
    }
}
