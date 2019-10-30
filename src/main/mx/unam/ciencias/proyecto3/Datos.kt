package mx.unam.ciencias.proyecto3

/**
 * Clase que se encarga de conectar la información obtenida de los archivos y las gráficas
 * que se muestran el el HTML generado
 */
class Datos: HTML() {
    /**
     * Método general para crear el archivo html con todas las graficas e informacion correspondiente
     * @param palabras Lista ordenada de palabras encontradas en los archivos
     * @param nombre nombre de los archivos generados
     * @param directorio ruta donde se van a crear los archivos
     * @param error objeto que lanza errores si los hay
     */
    fun html(palabras: MutableMap<String, Int>, nombre: String, directorio: String, error: Errores): String {
        if (palabras.isEmpty())
            return ""
        val ordenador = Ordenador(palabras)
        val ordenado = ordenador.ordena()
        val total = sacaTotal(palabras)
        val generador = GeneradorArboles(ordenado)
        val generadorG = GeneradorGraficas(ordenado, total)
        generador.genera(limpia(nombre), directorio, error)
        generadorG.genera(limpia(nombre), directorio, error)
        agregaNombre(limpia(nombre) + ".html")
        agregaTitulo("Palabras en $nombre y sus apariciones")
        HTML += "\n" + "<body>" + "\n"
        val llaves = palabras.iterator()
        while (llaves.hasNext()) {
            val palabra = llaves.next()
            val a = if (palabras[palabra.key] == 1) "vez" else " veces"
            agregaParrafo("La palabra \" ${palabra.key} \" aparece: ${palabras[palabra.key]} $a")
        }
        agregaTitulo("Gráfica de Barras")
        agregaObjeto("data=\"" + limpia(nombre) + "Barras.svg\" " + "type=\"image/svg+xml\"")
        agregaTitulo("Gráfica de Pastel")
        agregaObjeto("data=\"" + limpia(nombre) + "Pastel.svg\" " + "type=\"image/svg+xml\"")
        agregaTitulo("Árboles Rojinegros y AVL")
        val arboles = generador.getLista()
        for (a in arboles) {
            agregaParrafo("La letra " + a.getLetra() + " es la palabra: " + a.getPalabra())
        }
        agregaTitulo("Árbol Rojinegro")
        agregaObjeto("data=\"" + limpia(nombre) + "Rojinegro.svg\" " + "type=\"image/svg+xml\"")
        agregaTitulo("Árbol AVL")
        agregaObjeto("data=\"" + limpia(nombre) + "AVL.svg\" " + "type=\"image/svg+xml\"")
        HTML += "</body>" + "\n" + "</html>"
        return HTML
    }

    /**
     * Obtiene el total de palabras en los archivos
     * @param palabras diccionario con las palabras y su frecuencia
     */
    private fun sacaTotal (palabras: MutableMap<String, Int>): Int{
        var total = 0
        for (i in palabras)
            total += i.value
        return total
    }

    /**
     *
     */
    private fun limpia (nombre: String): String{
        var limpio = ""
        for (i in nombre.indices) {
            if (nombre[i] == '.')
                break
            limpio += nombre[i]
        }
        return limpio
    }
}
