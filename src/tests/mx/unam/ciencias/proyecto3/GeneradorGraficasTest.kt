package mx.unam.ciencias.proyecto3

import java.io.File

/**
 * Clase encargado de probar la funcionalidad del metodo genera
 * de la clase GeneradorGraficas
 */
class GeneradorGraficasTest {

    private val lista = mutableListOf<Adaptador>()
    private val genGraficas:GeneradorGraficas
    private val error = Errores()

    /* Inicializador de las varibale a utilizar en el test*/
    init {
        lista.add(Adaptador("hola",3))
        lista.add(Adaptador("que",6))
        lista.add(Adaptador("hace",3))
        lista.add(Adaptador("amigo",2))
        lista.add(Adaptador("ahi",9))

        genGraficas = GeneradorGraficas(lista,23)
    }

    /**
     * Metodo test de genera, se crean algunos archivos y se verifica si existencias,
     * solo de esta manera se puede pasar el test. AL final de la ejecucion se eleiminan
     * los archivos creados para este test
     */
    fun generaTest() {

        genGraficas.genera("test", "./", error)

        val dir = File("./")

        val archivos = dir.listFiles()

        if (archivos == null){
            print("la cagaste con la ruta, no paso la prueba")
            return
        }

        var i = 0

        for (a in archivos){
            if (a.name == "testBarras.svg" || a.name == "testPastel.svg")
                i++
        }

        if (i == 2)
            println("pasó la prueba")
        else
            println("no pasó la prueba :(")

        val archivo1 = File("./testBarras.svg")
        val archivo2 = File("./testPastel.svg")

        if (archivo1.exists())
            archivo1.delete()
        if (archivo2.exists())
            archivo2.delete()
    }
}