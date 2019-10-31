package mx.unam.ciencias.proyecto3

import java.sql.DriverManager
import java.util.*

/**
 * Clase DibujoBarrasTest
 * Clase que se encargará de probar la clase DibujoBarras
 */
class DibujoBarrasTest {
    /**
     * Variable privada grafica que contiene los datos de una gráfica de barras en svg
     */
    private var grafica = "<svg width=\"1000\" height=\"1050\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g>\n" +
            "<rect x=\"0\" y=\"0\" width=\"3\" height=\"620\" style=\"fill:black\"/>\n" +
            "<rect x=\"0\" y=\"620\" width=\"500\" height=\"3\" style=\"fill:black\"/>\n" +
            "<rect x=\"3\" y=\"560\" width=\"111\" height=\"40\" style=\"fill:red\"/>\n" +
            "<rect x=\"0\" y=\"630\" width=\"30\" height=\"30\" style=\"fill:red\"/>\n" +
            "<text x=\"40\" y = \"650\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"test\" porcentaje del total de palabras: 22.22</text>\n" +
            "<rect x=\"3\" y=\"500\" width=\"55\" height=\"40\" style=\"fill:green\"/>\n" +
            "<rect x=\"0\" y=\"670\" width=\"30\" height=\"30\" style=\"fill:green\"/>\n" +
            "<text x=\"40\" y = \"690\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"se\" porcentaje del total de palabras: 11.11</text>\n" +
            "<rect x=\"3\" y=\"440\" width=\"55\" height=\"40\" style=\"fill:orange\"/>\n" +
            "<rect x=\"0\" y=\"710\" width=\"30\" height=\"30\" style=\"fill:orange\"/>\n" +
            "<text x=\"40\" y = \"730\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"barras\" porcentaje del total de palabras: 11.11</text>\n" +
            "<rect x=\"3\" y=\"380\" width=\"55\" height=\"40\" style=\"fill:yellow\"/>\n" +
            "<rect x=\"0\" y=\"750\" width=\"30\" height=\"30\" style=\"fill:yellow\"/>\n" +
            "<text x=\"40\" y = \"770\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"deberian\" porcentaje del total de palabras: 11.11</text>\n" +
            "<rect x=\"3\" y=\"320\" width=\"55\" height=\"40\" style=\"fill:blue\"/>\n" +
            "<rect x=\"0\" y=\"790\" width=\"30\" height=\"30\" style=\"fill:blue\"/>\n" +
            "<text x=\"40\" y = \"810\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"ver\" porcentaje del total de palabras: 11.11</text>\n" +
            "<rect x=\"3\" y=\"260\" width=\"55\" height=\"40\" style=\"fill:indigo\"/>\n" +
            "<rect x=\"0\" y=\"830\" width=\"30\" height=\"30\" style=\"fill:indigo\"/>\n" +
            "<text x=\"40\" y = \"850\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"las\" porcentaje del total de palabras: 11.11</text>\n" +
            "<rect x=\"3\" y=\"200\" width=\"55\" height=\"40\" style=\"fill:pink\"/>\n" +
            "<rect x=\"0\" y=\"870\" width=\"30\" height=\"30\" style=\"fill:pink\"/>\n" +
            "<text x=\"40\" y = \"890\" font-family =\"Times New Roman\" font-size = \"20\" >Palabra: \"como\" porcentaje del total de palabras: 11.11</text>\n" +
            "<rect x=\"3\" y=\"140\" width=\"55\" height=\"40\" style=\"fill:coral\"/>\n" +
            "<rect x=\"0\" y=\"910\" width=\"30\" height=\"30\" style=\"fill:coral\"/>\n" +
            "<text x=\"40\" y = \"930\" font-family =\"Times New Roman\" font-size = \"20\" >El resto de las palabras: 11.11</text>\n" +
            "</g>\n" +
            "</svg>\n"

    /**
     * Función que se encargará de tener probar que el dibujo que regresa la función dibuja de DibujoBarras sea igual al la variable gráfica en contenido
     */
    private fun pruebaDibuja(){
        val dibujoTest = DibujoBarras(8)
        val lista : MutableList<Adaptador> = ArrayList()
        lista.add(Adaptador("test",2,'A'))
        lista.add(Adaptador("se",1,'B'))
        lista.add(Adaptador("barras",1,'C'))
        lista.add(Adaptador("deberian",1,'D'))
        lista.add(Adaptador("ver",1,'E'))
        lista.add(Adaptador("las",1,'F'))
        lista.add(Adaptador("como",1,'G'))
        lista.add(Adaptador("de",1,'H'))
        var test = dibujoTest.dibuja(lista)
        grafica = grafica.replace("\n","")
        test = test.replace("\n","")
        if (test.equals(grafica)){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }
    }

    /**
     * Función que manda llamar los test de la clase
     */
    public fun test(){
        pruebaDibuja()
    }
}