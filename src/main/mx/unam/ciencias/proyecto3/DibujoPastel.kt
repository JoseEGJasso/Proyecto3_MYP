package mx.unam.ciencias.proyecto3
/**
 * Dibujo pastel
 * Esta clase hereda de la clase abstracta dibujo y se encargará de dibujar la gráfica de pastel con sus respectivos datos
 * Constructor de la clase que recibe el total de palabras
 * @param total un int con el núnmero total de palabras
 */
class DibujoPastel(total : Int) : Dibujo() {
    /**
     * Variable privada que guardará el total de palabras sobre el cual se hará la gráfica
     */
    private val total : Int
    /**
     * Variable privada que guardará el radio del circulo sobre el cual se grafica
     */
    private val radio : Double = 150.0
    /**
     * Variable que guardará la coordenada en el eje x del punto donde se ubicará el origen del radio
     */
    private val cx : Double = 200.0
    /**
     * Variable que guardará la coordenada en el eje y del punto donde se ubicará el origen del radio
     */
    private val cy : Double = 200.0
    /**
     * Variable que guardará el grado final en donde se graficó
     */
    private var gradoFinal : Int = 0

    init {
        svg = svg.replace("alto","900")
        svg = svg.replace("largo","1000")
        this.total = total
    }
    /**
     * Override del método abstracto dibujo de dibujo, este recibe una lista de Adaptdores y regresará un String con el contenido
     * de la gráfica en svg
     * @param lista la lista de adaptadores con las palabras, sus repeticiones y la letra con la cual será representada
     * @return el string con la gráfica hecha en svg
     */
    public override fun dibuja(lista: MutableList<Adaptador>): String {
        val colores = Colores()
        creaCirculo()
        var i = 0
        var gajos = ""
        var cuadros = ""
        var textos = ""
        var ultimo = Adaptador("",0)
        for(adaptador in lista){
            if(i.equals(lista.size-1)){
                ultimo = adaptador
                break
            }
            val color = colores.colores(i)
            var grado = sacaGrado(adaptador.getApariciones())
            var porcentaje = sacaPorcentaje(adaptador.getApariciones())
            gajos += creaGajo(this.gradoFinal,grado+this.gradoFinal,color) + "\n"
            this.gradoFinal += grado
            cuadros += agregaCuadrado(i,color)
            textos += agregaTexto(i++,"Palabra: \"" +  adaptador.getPalabra() + "\" porcentaje del total de palabras: " + porcentaje)
        }
        creaFondo(i,colores.colores(i),"El resto de las palabras :" + sacaPorcentaje(ultimo.getApariciones()))
        svg += gajos + "\n" + cuadros + "\n" + textos + "\n" + "</g>" + "\n" + "</svg>"
        return svg
    }

    /**
     * Método que crea un circulo del último color que regresa la clase colores y sobre el cual se pondran los demás gajos
     * @param i el número de palabra que se encuentra graficando actualmente
     * @param colores el color que corresponde a esta palabra
     * @contenido lo que dirá la descripción de esta palábra
     */
    private fun creaFondo(i : Int, color : String, contenido : String){
        var circulo =  "<circle cx=\"posx\" cy=\"posy\" r=\"rad\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"></circle>"
        circulo = circulo.replace("posx",cx.toString())
        circulo = circulo.replace("posy",cy.toString())
        circulo = circulo.replace("rad",radio.toString())
        circulo = circulo.replace("white",color)
        val cuadrado = agregaCuadrado(i,color)
        val texto = agregaTexto(i,contenido)
        svg += circulo + "\n" + cuadrado + "\n" + texto + "\n"
    }
    /**
     * Función que sacará el porcentaje de cuantas veces aparece una palabra en el documento con base a el total de
     * apariciones
     * @param apariciones las veces que aparece la palabra en el documento
     * @return el porcentaje de apariciones de la palabra en formato String
     */
    private fun sacaPorcentaje(apariciones: Int): String {
        var porcentaje = ((apariciones*100)/total).toString()
        if(porcentaje.length>6)
            porcentaje = porcentaje.subSequence(0,5).toString()
        return porcentaje
    }

    /**
     * Función que creará el contorno del circulo sobre el cual se dibujará el porcentaje de aparición de cada palabra
     */
    private fun creaCirculo(){
        var circulo = "<circle cx=\"posx\" cy=\"posy\" r=\"rad\" stroke=\"black\" stroke-width=\"1\" fill=\"white\"></circle>"
        circulo = circulo.replace("posx",cx.toString())
        circulo = circulo.replace("posy",cy.toString())
        circulo = circulo.replace("rad",radio.toString())
        svg += circulo + "\n"
    }

    /**
     * Función que sacará el grado que ocupará la palbra sobre el circulo según su número de apariciones
     * @param apariciones el número de veces que aparce la palabre en el documento
     * @return el grado que debe ocupar la palabra en la gráfica
     */
    private fun sacaGrado(apariciones: Int): Int {
        val grado = (apariciones*360)/total
        return grado.toInt()

    }

    /**
     * Función que dubujara el gajo con los grados y el color que recibe
     * @param gradoInicial el grado donde iniciara el gajo
     * @param gradoFinal el grado donde hasta donde llegará el gajo
     * @param color el color del cual se pintará el gajo
     * @return el gajo en svg
     */
    private fun creaGajo(gradoInicial: Int, gradoFinal: Int,color : String): String {
        if(gradoFinal-gradoInicial >= 270){
            val primerGajo = creaGajo(gradoInicial,180,color)
            val segundoGajo = creaGajo(180,gradoFinal,color)
            return primerGajo + "\n" + segundoGajo
        }
        var gajo = "<path d=\"contenido\" fill=\"color\"/>"
        val xInicial = cx + radio * Math.cos((Math.PI/180)*gradoInicial)
        val yInicial = cy + radio * Math.sin((Math.PI/180)*gradoInicial)
        val xFinal = cx + radio * Math.cos((Math.PI/180)*gradoFinal)
        val yFinal = cy + radio * Math.sin((Math.PI/180)*gradoFinal)
        val d = "M" + cx +","+cy+" L" + xInicial +","+yInicial+" A"+radio+","+radio+" 0 0, 1 "+" "+xFinal+","+yFinal+ " z"
        gajo = gajo.replace("contenido",d)
        gajo = gajo.replace("color",color)
        return gajo
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
        val y = 430 + 40*numero
        cuadrado = cuadrado.replace("posicion",y.toString())
        cuadrado = cuadrado.replace("color",color)
        return cuadrado
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
        val y = 450 + 40*numero
        texto = texto.replace("posiciony",y.toString())
        return texto
    }

}