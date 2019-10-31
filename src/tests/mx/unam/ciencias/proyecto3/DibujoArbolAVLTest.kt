package mx.unam.ciencias.proyecto3

import java.sql.DriverManager
import java.util.*

/**
 * Clase DibujoArbolAVLTest
 * Clase que se encargará de probar a la clase DibvyjoArbolAVL
 */
class DibujoArbolAVLTest {
    /**
     * Variable privada árbol que servirá para probar que la función dibuja de DibujaArbolAVL es correcto
     */
    private var arbol = "<svg width=\"540\" height=\"400\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g>\n" +
            "<circle cx=\"270\" cy=\"32\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"266\" y = \"35\" font-family =\"Times New Roman\" font-size = \"11\" >D</text>\n" +
            "<circle cx=\"135\" cy=\"132\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"131\" y = \"135\" font-family =\"Times New Roman\" font-size = \"11\" >F</text>\n" +
            "<line x1=\"270\" y1=\"48\" x2=\"135\" y2=\"116\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"68\" cy=\"232\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"64\" y = \"235\" font-family =\"Times New Roman\" font-size = \"11\" >H</text>\n" +
            "<line x1=\"135\" y1=\"148\" x2=\"68\" y2=\"216\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"35\" cy=\"332\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"31\" y = \"335\" font-family =\"Times New Roman\" font-size = \"11\" >I</text>\n" +
            "<line x1=\"68\" y1=\"248\" x2=\"35\" y2=\"316\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<text x=\"55\" y = \"322\" font-family =\"Times New Roman\" font-size = \"11\" >0/0</text>\n" +
            "<circle cx=\"101\" cy=\"332\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"97\" y = \"335\" font-family =\"Times New Roman\" font-size = \"11\" >G</text>\n" +
            "<line x1=\"68\" y1=\"248\" x2=\"101\" y2=\"316\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<text x=\"121\" y = \"322\" font-family =\"Times New Roman\" font-size = \"11\" >0/0</text>\n" +
            "<text x=\"88\" y = \"222\" font-family =\"Times New Roman\" font-size = \"11\" >1/0</text>\n" +
            "<circle cx=\"202\" cy=\"232\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"198\" y = \"235\" font-family =\"Times New Roman\" font-size = \"11\" >E</text>\n" +
            "<line x1=\"135\" y1=\"148\" x2=\"202\" y2=\"216\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<text x=\"222\" y = \"222\" font-family =\"Times New Roman\" font-size = \"11\" >0/0</text>\n" +
            "<text x=\"155\" y = \"122\" font-family =\"Times New Roman\" font-size = \"11\" >2/1</text>\n" +
            "<circle cx=\"405\" cy=\"132\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"401\" y = \"135\" font-family =\"Times New Roman\" font-size = \"11\" >B</text>\n" +
            "<line x1=\"270\" y1=\"48\" x2=\"405\" y2=\"116\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"338\" cy=\"232\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"334\" y = \"235\" font-family =\"Times New Roman\" font-size = \"11\" >C</text>\n" +
            "<line x1=\"405\" y1=\"148\" x2=\"338\" y2=\"216\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<text x=\"358\" y = \"222\" font-family =\"Times New Roman\" font-size = \"11\" >0/0</text>\n" +
            "<circle cx=\"472\" cy=\"232\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>\n" +
            "<text x=\"468\" y = \"235\" font-family =\"Times New Roman\" font-size = \"11\" >A</text>\n" +
            "<line x1=\"405\" y1=\"148\" x2=\"472\" y2=\"216\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<text x=\"492\" y = \"222\" font-family =\"Times New Roman\" font-size = \"11\" >0/0</text>\n" +
            "<text x=\"425\" y = \"122\" font-family =\"Times New Roman\" font-size = \"11\" >1/0</text>\n" +
            "<text x=\"290\" y = \"22\" font-family =\"Times New Roman\" font-size = \"11\" >3/1</text>\n" +
            "</g>\n" +
            "</svg>\n"

    /**
     * Función que se encargará de llamar a la funcion dibuja de DibujoArbolAVL y comprobar que el string que regresa es correcto
     */
    private fun pruebaDibuja(){
        val dibujoTest = DibujoArbolRojinegro()
        val lista : MutableList<Adaptador> = ArrayList()
        lista.add(Adaptador("test",2,'A'))
        lista.add(Adaptador("de",2,'B'))
        lista.add(Adaptador("la",1,'C'))
        lista.add(Adaptador("avl",1,'D'))
        lista.add(Adaptador("se",1,'E'))
        lista.add(Adaptador("grafica",1,'F'))
        lista.add(Adaptador("ver",1,'G'))
        lista.add(Adaptador("como",1,'H'))
        lista.add(Adaptador("debe",1,'I'))
        var test = dibujoTest.dibuja(lista)
        arbol = arbol.replace("\n","")
        test = test.replace("\n","")
        if(test.equals(arbol)){
            DriverManager.println("Prueba pasda")
        }else{
            DriverManager.println("Prueba no pasada")
        }
    }

    /**
     * Función que se encargará de llamar a todos los test en la clase
     */
    public fun test(){
        pruebaDibuja()
    }
}