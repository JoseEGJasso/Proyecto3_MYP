package mx.unam.ciencias.proyecto3

/**
 * Clase abstracta Dibujo
 * De esta clase heredaran todas las clases de Dibujo y sen encargarán de relaizar los svg con de los árboles y las gráficas
 */
abstract class Dibujo {
    /**
     * Variable svg que todas las subclases heredaran y sobre ella se trabajará el contenido que tendrá el documento
     */
    protected var svg = "<svg width=\"largo\" height=\"alto\"" +" xmlns=\"http://www.w3.org/2000/svg\">"+"\n" + "<g>" + "\n"

    /**
     * Función que regresará una cadena con el cuerpo de un texto en svg junto con el elemento que se de a la función como texto
     * @param elemento el contenido que se desea tenga el texto
     * @return la cadena con el elemento como texto en svg
     */
    protected fun agregaElemento(elemento: String): String {
        var texto = "<text x=\"posicionx\" y = \"posiciony\" fill = \"silver\" font-weight = \"bold\" font-family =\"Arial Narrow\" font-size = \"20\" >elemento</text>"
        texto = texto.replace("elemento",elemento)
        return texto
    }

    /**
     * Clase abstracta dibuja que recibira la lista con los elementos que se desean dibujar en svg y regresará un string con el contenido
     * de todo el dibujo en svg
     * @param lista la lista con los elementos que se desean dibujar
     * @return un string con toda la información para graficar
     */
    public abstract  fun dibuja(lista : MutableList<Adaptador>):String

}