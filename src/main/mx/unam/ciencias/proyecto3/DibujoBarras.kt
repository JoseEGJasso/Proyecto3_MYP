package mx.unam.ciencias.proyecto3

/**
 * Dibujo barras
 * Esta clase hereda de la clase abstracta dibujo y se encargará de dibujar la gráfica de barras con sus respectivos datos
 * Constructor de la clase que recibe el total de palabras
 * @param total un int con el núnmero total de palabras
 */
class DibujoBarras(total : Int) : Dibujo(){
    /**
     * Variable privada que guardará el total de palabras sobre el cual se hará la gráfica
     */
    private val total : Int

    init {
        svg = svg.replace("alto","1050")
        svg = svg.replace("largo","1000")
        svg += "<rect x=\"0\" y=\"0\" width=\"3\" height=\"620\" style=\"fill:black\"/>" +"\n" + "<rect x=\"0\" y=\"620\" width=\"500\" height=\"3\" style=\"fill:black\"/>" + "\n"
        this.total = total
    }

    /**
     * Override del método abstracto dibujo de dibujo, este recibe una lista de Adaptdores y regresará un String con el contenido
     * de la gráfica en svg
     * @param lista la lista de adaptadores con las palabras, sus repeticiones y la letra con la cual será representada
     * @return el string con la grafica hecha en svg
     */
    public override fun dibuja(lista: MutableList<Adaptador>): String {
        val colores = Colores()
        var i = 0
        for(adaptador in lista){
            val ancho = sacaAncho(adaptador.getApariciones())
            val porcentaje = sacaPorcentaje(adaptador.getApariciones().toDouble())
            val color = colores.colores(i)
            val barra = agregaRectangulo(i,color,ancho)
            val cuadrado = agregaCuadrado(i,color)
            var texto = ""
            val rango= lista.size-1
            if(i != rango)
                texto = agregaTexto(i++,"Palabra: \"" + adaptador.getPalabra() + "\" porcentaje del total de palabras: " + porcentaje)
            else
                texto = agregaTexto(i++,"El resto de palabras: " + porcentaje)
            svg += barra + "\n" + cuadrado + "\n" + texto + "\n"
        }
        svg += "</g>" +"\n" + "</svg>"
        return svg
    }

    /**
     * Función que sacará el ancho del rectangulo con base a su número de apariciones en el documento, 100%
     * equivale a un ancho de 500
     * @param apariciones el número de apariciones que tiene la palabra
     * @return el ancho del porcentaje de sus apariciones en formato String
     */
    private fun sacaAncho(apariciones: Int): Int {
        var ancho = (apariciones*500)/total
        return   ancho.toInt()
    }

    /**
     * Función que sacará el porcentaje de cuantas veces aparece una palabra en el documento con base a el total de
     * apariciones
     * @param apariciones las veces que aparece la palabra en el documento
     * @return el porcentaje de apariciones de la palabra en formato String
     */
    private fun sacaPorcentaje(apariciones: Double): String {
        var porcentaje = ((apariciones*100)/total).toString()
        if(porcentaje.length>6)
            porcentaje = porcentaje.subSequence(0,5).toString()
        return porcentaje
    }

    /**
     * Función que regresará un string con un rectangulo en svg con el color que le corresponda según la palabra y la
     * posición según el número de palabra en la que nos encontremos
     * @param numero el número de palabra que se encuentra graficando actualmente
     * @param color el color del que se pintara el cuadrado
     * @return el cuadrado en svg
     */
    private fun agregaCuadrado(numero : Int, color: String): String {
        var cuadrado = "<rect x=\"0\" y=\"posicion\" width=\"30\" height=\"30\" style=\"fill:color\"/>"
        val y = 630 + 40*numero
        cuadrado = cuadrado.replace("posicion",y.toString())
        cuadrado = cuadrado.replace("color",color)
        return cuadrado
    }

    /**
     * Función que regreserá un string con un rectangulo en svg con el color que le corresponda según la palabra y la
     * posición según el número de palabra en el que nos encontremos
     * @param numero el número de palabra que se encuentra graficando actualmente
     * @param color el color del que se pintara el cuadrado
     * @param ancho el ancho que tendrá el cuadrado según su número de apariciones
     * @return el rectangulo en svg
     */
    private fun agregaRectangulo(numero : Int, color : String, ancho : Int):String {
        var rectangulo = "<rect x=\"3\" y=\"posicion\" width=\"tamaño\" height=\"40\" style=\"fill:color\"/>"
        rectangulo = rectangulo.replace("color",color)
        val y = 560-60*numero
        rectangulo = rectangulo.replace("posicion",y.toString())
        rectangulo = rectangulo.replace("tamaño",ancho.toString())
        return rectangulo
    }

    /**
     * Función que regresará el texto que pone la palabra y su porcentaje de apariciones a lado de cada cuadrado
     * @param numero el numero que se encuentra graficando actualmente
     * @param contendio lo que dirá el texto
     * @return el texto deseado en svg
     */
    private fun agregaTexto(numero: Int, contenido: String): String {
        var texto = agregaElemento(contenido)
        texto = texto.replace("posicionx","40")
        val y = 650 + 40*numero
        texto = texto.replace("posiciony",y.toString())
        return texto
    }
}