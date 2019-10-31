package mx.unam.ciencias.proyecto3

/**
 * Clase DibujoArbolRojinegro
 * Esta clase se encargará de recibir una lista con adaptadores y regresar el svg de como se vería esa lista si fuera un
 * árbol rojinegro
 */
class DibujoArbolRojinegro : DibujoArbol() {
    /**
     * Variable privada que será el árbol a el cual se le agregarán los elementos de la lista y con el cual se hará la
     * gráfica
     */
    private val arbol = ArbolRojinegro<Adaptador>()

    /**
     * Función que se encargará de regresar el svg del árbol rojinegro de la lista que recibe
     * @param lista la lista de adaptadores que se transformará en árbol rojinegro
     * @return la lista graficada como árbol rojinegro en svg
     */
    override fun dibuja(lista: MutableList<Adaptador>): String {
        pasarLista(lista)
        var altura = arbol.altura()
        if(altura == -1){
            return ""
        }
        altura = altura*100 + 60
        val largo = ((arbol.getElementos()+1)/2)*100+1000
        svg = svg.replace("alto",altura.toString())
        svg = svg.replace("largo",largo.toString())
        var circulos = raiz(arbol.raiz(),largo/2,largo)
        svg = circulos + "\n" + "</g>" + "\n" + "</svg>"
        return svg
    }

    /**
     * Funcíon que se encargará de agregar los elementos de la lista que recibe al árbol rojinegro
     * @param lista la lista de adaptadores que se agregará a el árbol
     */
    override fun pasarLista(lista: MutableList<Adaptador>) {
       for (adaptador in lista){
           arbol.agrega(adaptador)
       }
    }

    /**
     * Función que recibirá la raiz del árbol a graficar y apartir de esta ir graficando todo el arbol
     * @param raiz la raiz del arbol a graficar
     * @param posicion la posción en x que tendrá la raiz
     * @param largo el largo que tendra el documento svg
     * @return todos los vértices en svg
     */
    override protected fun raiz(raiz : VerticeArbolBinario<Adaptador>, posicion : Int, largo : Int):String{
        var circulo = "<circle cx=\"posx\" cy=\"22\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"black\"></circle>"
        circulo = circulo.replace("posx",posicion.toString())
        circulo += "\n" + texto(raiz.get().toString(),posicion,22,true)
        if(raiz.hayIzquierdo()){
            circulo += circulos(1,largo,raiz.izquierdo(),posicion,22,false)
        }else if(raiz.hayDerecho()) {
            circulo += circulos(1, largo, raiz.derecho(), posicion, 22, true)
        }
        return circulo
    }

    /**
     *Función circulos que recibe un vértice de arbol y graficará recursivamente todo el árbol, tambien recibe otros datos para graficar correctamente el vértice
     * @param altura la altura que tiene el vértice actualmente
     * @param largo el largo del documento del svg
     * @param ver el vértice que se esta graficando
     * @param xPadre las coordenadas en x del vértice padre
     * @param yPadre las coordenadas en y del vértice padre
     * @param derecho booleano que indica si el vértice que se esta graficando actualmente es derecho o izquierdo
     * @return los vértices con todos sus elementos en svg
     */
    override protected fun circulos(altura: Int, largo: Int, ver: VerticeArbolBinario<Adaptador>, xPadre: Int, yPadre: Int, derecho: Boolean): String {
        if(ver.get().equals(null)){
            return ""
        }
        var esNegro = false
        var circulo = "\n" + "<circle cx=\"posx\" cy=\"22\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"color\"></circle>"
        if (arbol.getColor(ver) == Color.ROJO){
            circulo = circulo.replace("color","red")
        }else{
            circulo = circulo.replace("color","black")
            esNegro = true
        }
        val y = 22 + (100*altura)
        var x = 0
        if(derecho){
            x = xPadre + (largo/Math.pow(2.0,((ver.profundidad()+1).toDouble())).toInt())
        }else{
            x = xPadre - (largo/Math.pow(2.0,((ver.profundidad()+1).toDouble())).toInt())
        }
        circulo = circulo.replace("posx",x.toString())
        circulo = circulo.replace("posy",y.toString())
        circulo += "\n"+texto(ver.get().toString(),x,y,esNegro)
        circulo += "\n" +linea(xPadre,yPadre,x,y)
        if(ver.hayIzquierdo()){
            circulo += circulos(altura+1,largo,ver.izquierdo(),x,y,false)
        }else{
            circulo += circulos(altura+1,largo,ver.derecho(),x,y,true)
        }
        return circulo
    }
    /**
     * Función que se encargará de poner los textos necesarios en svg
     * @param elemento lo que se debe poner
     * @param x la coordenada que tendrá en x
     * @param y la coordenada que tendrá en y
     * @param esNegro un booleano que dirá si el vertice en donde graficará tiene fondo negro
     * @return el contenido en svg
     */
    private fun texto(elemento : String, x : Int, y : Int, esNegro: Boolean) : String{
        var texto = "<text x=\"posicionx\" y = \"posiciony\" font-family =\"Times New Roman\" font-size = \"11\" fill=\"color\">elemento</text>"
        texto = texto.replace("elemento",elemento)
        if(elemento.length <3){
            texto = texto.replace("posicionx",(x-4).toString())
        }else{
            texto = texto.replace("posicionx",(x-6).toString())
        }
        if(esNegro) {
            texto = texto.replace("color", "white")
        }else {
            texto = texto.replace("color", "black")
        }
        texto = texto.replace("posiciony",(y+3).toString())
        return texto
    }
}