package mx.unam.ciencias.proyecto3

/**
 * Clase abstracta DibujoArbol
 * De esta clase heredarán las clases que dibujan árboles binarios y se encargarán de regresar en svg un árbol creado
 * a partir de una lista de elementos que reciban
 */
abstract  class DibujoArbol : Dibujo() {
    /**
     *Función abstracta que implementarán las clases que hereden de DibujoArbol
     */
    protected abstract fun pasarLista(lista : MutableList<Adaptador>)

    /**
     * Función que recibirá la raiz del árbol a graficar y apartir de esta ir graficando todo el arbol
     * @param raiz la raiz del arbol a graficar
     * @param posicion la posción en x que tendrá la raiz
     * @param largo el largo que tendra el documento svg
     * @return todos los vértices en svg
     */
    protected open fun raiz(raiz : VerticeArbolBinario<Adaptador>, posicion : Int, largo : Int):String{
        var circulo = "<circle cx=\"posx\" cy=\"22\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>"
        circulo = circulo.replace("posx",posicion.toString())
        circulo += "\n" + texto(raiz.get().toString(),posicion,22)
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
    protected open fun circulos(altura : Int, largo : Int, ver : VerticeArbolBinario<Adaptador>,xPadre : Int, yPadre : Int , derecho : Boolean):String{
        if(ver.get().equals(null)){
            return ""
        }
        var circulo = "\n"+"<circle cx=\"posx\" cy=\"posy\" r=\"16\" stroke=\"black\" stroke-width=\"3\" fill=\"white\"></circle>"
        val y = 22 + (100*altura)
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
        return circulo
    }

    /**
     * Función que se encargará de poner los textos necesarios en svg
     * @param elemento lo que se debe poner
     * @param x la coordenada que tendrá en x
     * @param y la coordenada que tendrá en y
     * @return el contenido en svg
     */
    protected fun texto(elemento : String, x : Int, y : Int):String{
        var texto = agregaElemento(elemento)

        texto = texto.replace("20","11")
        if(elemento.length<3){
            texto = texto.replace("posicionx",(x-4).toString())
        }else{
            texto = texto.replace("posicionx",(x-6).toString())
        }

        texto = texto.replace("posiciony",(y+3).toString())

        return texto
    }

    /**
     * Función que se encargará de dibujar la linea que une al vertice padre con el vertice hijo
     * @param xPadre las coordenadas del vertice padre en el eje x
     * @param ypadre las coordenadas del vertice padre en el eje y
     * @param x las coordenadas del vertice en el eje x
     * @param y las coordenadas del vertice en el eje y
     */
    protected fun linea(xPadre : Int, yPadre: Int, x : Int, y : Int):String{
        var linea = "<line x1=\"xp\" y1=\"yp\" x2=\"xh\" y2=\"yh\" style=\"stroke:#000; stroke-width:3\"></line>"
        linea = linea.replace("xp",xPadre.toString())
        linea = linea.replace("xh",x.toString())
        linea = linea.replace("yp",(yPadre+16).toString())
        linea = linea.replace("yh",(y-16).toString())
        return linea
    }
}