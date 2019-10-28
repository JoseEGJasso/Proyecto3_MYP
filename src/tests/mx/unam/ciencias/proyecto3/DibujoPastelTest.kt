package mx.unam.ciencias.proyecto3

import java.sql.DriverManager.println
import java.util.*

/**
 * Clase DibujoPastelTest
 * Clase que se encargará de probar la clase DibujoBarras
 */
class DibujoPastelTest {
    /**
     * Variable privada grafica que contiene los datos de una gráfica de pastel en svg
     */
    private var grafica = "<svg width=\"1000\" height=\"900\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g>\n" +
            "<circle cx=\"200.0\" cy=\"200.0\" r=\"150.0\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"></circle>\n" +
            "<circle cx=\"200.0\" cy=\"200.0\" r=\"150.0\" stroke=\"black\" stroke-width=\"1\" fill=\"coral\"></circle>\n" +
            "<rect x=\"0\" y=\"710\" width=\"30\" height=\"30\" style=\"fill:coral\"/>\n" +
            "<text x=\"40\" y = \"730\" font-family =\"Times New Roman\" font-size = \"20\" >El resto de las palabras: 11.11</text>\n" +
            "<path d=\"M200.0,200.0 L350.0,200.0 A150.0,150.0 0 0, 1  226.04722665003956,347.72116295183116 z\" fill=\"red\"/>\n" +
            "<path d=\"M200.0,200.0 L226.04722665003956,347.72116295183116 A150.0,150.0 0 0, 1  125.00000000000003,329.9038105676658 z\" fill=\"green\"/>\n" +
            "<path d=\"M200.0,200.0 L125.00000000000003,329.9038105676658 A150.0,150.0 0 0, 1  59.04610688211375,251.30302149885034 z\" fill=\"orange\"/>\n" +
            "<path d=\"M200.0,200.0 L59.04610688211375,251.30302149885034 A150.0,150.0 0 0, 1  59.04610688211375,148.69697850114972 z\" fill=\"yellow\"/>\n" +
            "<path d=\"M200.0,200.0 L59.04610688211375,148.69697850114972 A150.0,150.0 0 0, 1  124.99999999999993,70.09618943233423 z\" fill=\"blue\"/>\n" +
            "<path d=\"M200.0,200.0 L124.99999999999993,70.09618943233423 A150.0,150.0 0 0, 1  226.0472266500395,52.27883704816878 z\" fill=\"indigo\"/>\n" +
            "<path d=\"M200.0,200.0 L226.0472266500395,52.27883704816878 A150.0,150.0 0 0, 1  314.90666646784666,103.58185854701907 z\" fill=\"pink\"/>\n" +
            "\n" +
            "<rect x=\"0\" y=\"430\" width=\"30\" height=\"30\" style=\"fill:red\"/>\n" +
            "<rect x=\"0\" y=\"470\" width=\"30\" height=\"30\" style=\"fill:green\"/>\n" +
            "<rect x=\"0\" y=\"510\" width=\"30\" height=\"30\" style=\"fill:orange\"/>\n" +
            "<rect x=\"0\" y=\"550\" width=\"30\" height=\"30\" style=\"fill:yellow\"/>\n" +
            "<rect x=\"0\" y=\"590\" width=\"30\" height=\"30\" style=\"fill:blue\"/>\n" +
            "<rect x=\"0\" y=\"630\" width=\"30\" height=\"30\" style=\"fill:indigo\"/>\n" +
            "<rect x=\"0\" y=\"670\" width=\"30\" height=\"30\" style=\"fill:pink\"/>\n" +
            "\n" +
            "<text x=\"40\" y = \"450\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"test\" porcentaje del total de palabras: 22.22</text>\n" +
            "<text x=\"40\" y = \"490\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"se\" porcentaje del total de palabras: 11.11</text>\n" +
            "<text x=\"40\" y = \"530\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"pastel\" porcentaje del total de palabras: 11.11</text>\n" +
            "<text x=\"40\" y = \"570\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"el\" porcentaje del total de palabras: 11.11</text>\n" +
            "<text x=\"40\" y = \"610\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"ver\" porcentaje del total de palabras: 11.11</text>\n" +
            "<text x=\"40\" y = \"650\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"como\" porcentaje del total de palabras: 11.11</text>\n" +
            "<text x=\"40\" y = \"690\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"deberia\" porcentaje del total de palabras: 11.11</text>\n" +
            "</g>\n" +
            "</svg>\n"

    /**
     * Función que se encargará de tener probar que el dibujo que regresa la función dibuja de DibujoPastel sea igual al la variable gráfica en contenido
     */
    private fun pruebaDibuja(){
        val dibujoTest = DibujoPastel(8)
        val lista : MutableList<Adaptador> = ArrayList()
        lista.add(Adaptador("test",2,'A'))
        lista.add(Adaptador("se",1,'B'))
        lista.add(Adaptador("pastel",1,'C'))
        lista.add(Adaptador("el",1,'D'))
        lista.add(Adaptador("ver",1,'E'))
        lista.add(Adaptador("como",1,'F'))
        lista.add(Adaptador("deberia",1,'G'))
        lista.add(Adaptador("de",1,'H'))
        var test = dibujoTest.dibuja(lista)
       grafica = grafica.replace("\n","")
        test = test.replace("\n","")
        if (test.equals(grafica)){
            println("Prueba pasada")
        }else{
            println("Prueba no pasada")
        }
    }

    /**
     * Función que manda llamar los test de la clase
     */
    public fun test(){
        pruebaDibuja()
    }
}