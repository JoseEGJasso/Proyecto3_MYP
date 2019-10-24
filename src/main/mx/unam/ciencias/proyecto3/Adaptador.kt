package mx.unam.ciencias.proyecto3

/**
 * Clase adaptador que nos servirá para almacenar las palabras y despues mostrarlas en los arboles con solo una letra
 * Implementa Comparable para poder ordenarlas con base a sus apariciones
 * Constructor que recibe:
 * @param palabra La palabra que aparece en el documento
 * @param apariciones el número de veces que aparece la palabra en el documento
 * @param letra la letra con la que será representada la palabra en los dibujos de árboles
 */
class Adaptador(palabra : String, apariciones : Int, letra : Char):Comparable<Adaptador> {
    /**
     * Variable privada que guardará la palabra
     */
    private var palabra : String = ""
    /**
     * Variable que guardará las repeticiones de la palabra en el archivo
     */
    private var apariciones : Int = 0
    /**
     * Variable privada que guardará la letra con la cual será representada la palabra en los árboles
     */
    private var letra : Char = ' '

    init {
        this.palabra = palabra
        this.apariciones = apariciones
        this.letra = letra
    }

    constructor(palabra : String, apariciones: Int):this(palabra,apariciones,' ')

    /**
     * Setter del atriubuto letra
     * @param letra la letra a la que se igualará el atributo letra
     */
    public fun setLetra(letra: Char){
        this.letra = letra
    }

    /**
     * Override de compareTo esto nos servirá para al momento de ordenar las palabras se ordene con base a su número de apariciones
     * @param other el adaptador con el cual se comparará
     * @return la diferencia entre las apariciones de este adaptador y de other
     */
    override fun compareTo(other: Adaptador): Int {
        return this.apariciones-other.apariciones
    }

    /**
     * Getter del atributo palabra
     * @return la palabra que guarda el adaptador
     */
    public fun getPalabra(): String {
        return this.palabra
    }

    /**
     * Getter del atributo Letra
     * @return la letra que representará a la palabra
     */
    public fun getLetra():Char{
        return this.letra
    }

    /**
     * Getter del atributo apariciones
     * @return las apariciones de la palabra
     */
    public fun getApariciones():Int{
        return this.apariciones
    }

    /**
     * Override de la función toString para que al momento de aparecer en los arboles aparezca la letra únicamente
     * @return la letra que representa la palabra en formato String
     */
    override fun toString(): String {
        return this.letra.toString()
    }
}