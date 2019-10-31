package mx.unam.ciencias.proyecto3

import java.sql.DriverManager
import java.util.*
/**
 * Clase DibujoArbolRojinegroTest
 * Clase que se encargará de probar a la clase DibvyjoArbolRojinegro
 */
class DibujoArbolRojinegroTest {
    /**
     * Variable privada árbol que servirá para probar que la función dibuja de DibujaArbolRojinegro es correcto
     */
    private var arbol = "<circle cx=\"750\" cy=\"22\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"black\"></circle>\n" +
            "<text x=\"746\" y = \"25\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"white\">D</text>\n" +
            "<circle cx=\"375\" cy=\"122\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"red\"></circle>\n" +
            "<text x=\"371\" y = \"125\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"black\">F</text>\n" +
            "<line x1=\"750\" y1=\"38\" x2=\"375\" y2=\"106\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"188\" cy=\"222\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"black\"></circle>\n" +
            "<text x=\"184\" y = \"225\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"white\">H</text>\n" +
            "<line x1=\"375\" y1=\"138\" x2=\"188\" y2=\"206\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"95\" cy=\"322\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"red\"></circle>\n" +
            "<text x=\"91\" y = \"325\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"black\">I</text>\n" +
            "<line x1=\"188\" y1=\"238\" x2=\"95\" y2=\"306\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"281\" cy=\"322\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"red\"></circle>\n" +
            "<text x=\"277\" y = \"325\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"black\">G</text>\n" +
            "<line x1=\"188\" y1=\"238\" x2=\"281\" y2=\"306\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"562\" cy=\"222\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"black\"></circle>\n" +
            "<text x=\"558\" y = \"225\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"white\">E</text>\n" +
            "<line x1=\"375\" y1=\"138\" x2=\"562\" y2=\"206\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"1125\" cy=\"122\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"red\"></circle>\n" +
            "<text x=\"1121\" y = \"125\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"black\">B</text>\n" +
            "<line x1=\"750\" y1=\"38\" x2=\"1125\" y2=\"106\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"938\" cy=\"222\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"black\"></circle>\n" +
            "<text x=\"934\" y = \"225\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"white\">C</text>\n" +
            "<line x1=\"1125\" y1=\"138\" x2=\"938\" y2=\"206\" style=\"stroke:#000; stroke-width:3\"></line>\n" +
            "<circle cx=\"1312\" cy=\"222\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"black\"></circle>\n" +
            "<text x=\"1308\" y = \"225\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"white\">A</text>\n" +
            "<line x1=\"1125\" y1=\"138\" x2=\"1312\" y2=\"206\" style=\"stroke:#000; stroke-width:3\"></line>"
    /**
     * Función que se encargará de llamar a la funcion dibuja de DibujoArbolRojinegro y comprobar que el string que regresa es correcto
     */
        private fun pruebaDibuja(){
            val dibujoTest = DibujoArbolRojinegro()
            val lista : MutableList<Adaptador> = ArrayList()
            lista.add(Adaptador("test",2,'A'))
            lista.add(Adaptador("de",2,'B'))
            lista.add(Adaptador("la",1,'C'))
            lista.add(Adaptador("se",1,'D'))
            lista.add(Adaptador("grafica",1,'E'))
            lista.add(Adaptador("ver",1,'F'))
            lista.add(Adaptador("como",1,'G'))
            lista.add(Adaptador("rojinegro",1,'H'))
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