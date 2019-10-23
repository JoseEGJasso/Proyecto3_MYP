package mx.unam.ciencias.proyecto3
/**
 *Clase Indice que se encargará de generar el contendio del indice
 *Construcor que recibira un diccionario de nombres
 *@param nombres diccionario de nombres que usaremos para igualar nuestro diccionario
 */
class Indice(nombres : MutableMap<Int,String>) : HTML() {
    /**
    *Diccionario de nombres donde se guardaran los nombres que recibe el programa
    */
    private val nombres : MutableMap<Int,String>

    init {
        this.nombres = nombres
    }
    /**
     *Método html que se encargará de generar el contenido dentro del índice
     *@param archivos archivos las palabras dentro de cada archivo
     *@return el contenido dentro del índice
     */
    fun html(archivos: MutableList<MutableMap<String,Int>>): String {
        agregaNombre("Índice")
        agregaTitulo("Índice de documentos")
        abreCuerpo()
        val rango = nombres.size-1
        for(i in 0..rango){
            var nombre = nombres.get(i)
            var total = "número de palabras" + sacaTotal(archivos.get(i))
            if (nombre != null) {
                agregaLiga(limpia(nombre)+".html",nombre,total)
            }
        }
        cierraCuerpo()
        HTML += "\n" +"</html>"
        return  HTML
    }
    /**
     *Método para agregar las referencías a los archivos que se recibieron de entrada
     *@param liga el archivo al que se hace referencia
     *@param archivo al que se hace referencia
     *@param número total de palabras dentro de cada archivo
     */
    fun agregaLiga(liga: String, nombre: String, total:String) {
        agregaParrafo("<a href=\"" + liga +"\">" + nombre + "</a>"+total)
    }
    /**
     *Método saca total que se encarga de contar el número total de palabras en cada archivo
     *@param palabras las palabras dentro de cada archivo
     *@return total el total de palabras dentro del archivo
     */
    fun sacaTotal(palabras: MutableMap<String,Int>): String {
        var total = 0
        for(palabra in palabras.values){
            total += palabra
        }
        return total.toString()
    }
    /**
     *Método limpia que regresará los nombres del archivo sin extensión
     *@param nombre el nombre a limpiar
     *@return limpio el nombre del archivo sin  extensión
     */
    fun limpia(nombre: String): String {
        var limpio = ""
        var rango = nombre.length-1
        for(i in 0..rango){
            if(nombre[i] == '.'){
                break
            }
            limpio += nombre[i].toString()
        }
        return limpio
    }

}