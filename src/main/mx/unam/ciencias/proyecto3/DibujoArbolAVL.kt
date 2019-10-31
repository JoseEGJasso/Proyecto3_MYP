package mx.unam.ciencias.proyecto3
/**
 * Clase DibujoArbolAVL
 * Esta clase se encargará de recibir una lista con adaptadores y regresar el svg de como se vería esa lista si fuera un
 * árbol AVL
 */
class DibujoArbolAVL : DibujoArbol() {
    /**
     * Variable privada que será el árbol a el cual se le agregarán los elementos de la lista y con el cual se hará la
     * gráfica
     */
    private val arbol = ArbolAVL<Adaptador>()

    /**
     * Función que se encargará de regresar el svg del árbol AVL de la lista que recibe
     * @param lista la lista de adaptadores que se transformará en árbol AVL
     * @return la lista graficada como árbol AVL en svg
     */
    override fun dibuja(lista: MutableList<Adaptador>): String {
        pasarLista(lista)
        val altura = arbol.altura()*100 + 100
        if(altura<= 40) {
            return ""
        }
        val largo = (arbol.getElementos()+1)/2)*100+40
        svg = svg.replace("alto",altura.toString())
        svg = svg.replace("largo",largo.toString())
        val circulos = raiz(arbol.raiz(),largo/2,largo)
        svg += circulos +"\n" + "</g>" + "\n"+"</svg>"
        return svg
    }
    /**
     * Funcíon que se encargará de agregar los elementos de la lista que recibe al árbol AVL
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
     override fun raiz(raiz : VerticeArbolBinario<Adaptador>, posicion : Int, largo: Int ): String{
        var circulo = "<circle cx=\"posx\" cy=\"32\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>"
        circulo = circulo.replace("posx",posicion.toString())
        circulo += "\n" + texto(raiz.get().toString(),posicion,32)
        if(raiz.hayIzquierdo()){
            circulo += circulos(1,largo,raiz.izquierdo(),posicion,32,false)
        }
        if(raiz.hayDerecho()){
            circulo += circulos(1,largo,raiz.derecho(),posicion,32,true)
        }
        circulo += "\n" + balance(raiz,posicion,32)
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
    override fun circulos(altura: Int, largo: Int, ver: VerticeArbolBinario<Adaptador>, xPadre: Int, yPadre: Int, derecho: Boolean): String {
        if(ver.get().equals(null)){
            return ""
        }
        var circulo = "\n" + "<circle cx=\"posx\" cy=\"22\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"color\"></circle>"
        val y = 32 + (100*altura)
        var x = 0
        if(derecho){
            x = xPadre + (largo/Math.pow(2.0,((ver.profundidad()+1).toDouble())).toInt())
        }else{
            x = xPadre - (largo/Math.pow(2.0,((ver.profundidad()+1).toDouble())).toInt())
        }
        circulo = circulo.replace("posx",x.toString())
        circulo = circulo.replace("posy",y.toString())
        circulo += "\n"+texto(ver.get().toString(),x,y)
        circulo += "\n" +linea(xPadre,yPadre,x,y)
        if(ver.hayIzquierdo()){
            circulo += circulos(altura+1,largo,ver.izquierdo(),x,y,false)
        }else{
            circulo += circulos(altura+1,largo,ver.derecho(),x,y,true)
        }
        circulo+= "\n"+ balance(ver,x,y)
        return circulo
    }

    /**
     * Función que se encargará de devolver el balance en formato svg
     * @param ver el vértice al cual se le quiere sacar el balance
     * @param x la posición del vertice en el eje x
     * @param y la posición del vertice en el eje y
     * @return el balance del vertice en svg
     */
    private fun balance(ver :  VerticeArbolBinario<Adaptador>, x : Int, y : Int) : String{
        var balance = "<text x=\"posicionx\" y = \"posiciony\" font-family =\"Times New Roman\" font-size = \"11\" >alt/bal</text>"
        balance = balance.replace("posicionx",(x+20).toString())
        balance = balance.replace("posiciony",(y-10).toString())
        balance= balance.replace("alt",ver.altura().toString())
        balance= balance.replace("bal",balance(ver).toString())
        return balance
    }

    /**
     * Función que se encargará de sacar el balance de un vertice
     * @param ver el vértice al cual se le sacará el balance
     * @return el balance del vertice
     */
    private fun balance(ver :  VerticeArbolBinario<Adaptador>) : Int{
        if(!ver.hayIzquierdo() && !ver.hayDerecho()){
            return 0
        }
        if(!ver.hayIzquierdo()){
            return ((-1)-ver.derecho().altura())
        }
        if(!ver.hayDerecho()){
            return (ver.izquierdo().altura()+1)
        }
        return (ver.izquierdo().altura()-ver.derecho().altura())
    }

}