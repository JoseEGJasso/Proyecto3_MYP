package mx.unam.ciencias.proyecto3

/**
 * Clase HTML
 * Esta clase será de la cual hereden todas las clases que deban crear un documento HTML y contendrá los métodos
 * para agregar los elementos básicos de cualquier documento HTML
 */
open class HTML {

    protected var HTML : String = "<!DOCTYPE html>" + "\n" +"<html>"+"\n" + "<head>" + "\n" + "<title>nombre</title>" +"\n" +" <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">"+ "\n" + "</head>"


    /**
     * Función agregaNombre que agregará el título en el metadata el documento sustituyendo la palabra nombre en el String HTML
     * @param nombre es un string con el nombre que se desea poner el HTML
     */
    protected fun agregaNombre(nombre : String){
        HTML = HTML.replace("nombre",nombre)
    }

    /**
     * Función abreCuerpo que pondrá la etiqueta que abre el segmento de cuerpo en el HTML
     */
    protected fun abreCuerpo(){
        HTML += "<body>" + "\n"
    }

    /**
     * Función cierraCuerpo que pondrá la etiqueta que cierre el segmento de cuerpo en el HTML
     */
    protected fun cierraCuerpo(){
        HTML += "\n" + "</body>"
    }

    /**
     * Función agregaTitulo que se encargará de poner un titulo siempre de tipo h1 al HTML
     * @param titulo un string del titulo que se desea agregar
     */
    protected fun agregaTitulo(titulo:String){
        HTML += "<h1>" + titulo + "</h1>"
    }

    /**
     * Función que se encargará de poner un parrafo al documento HTML
     * @param contenido un string con lo que se desea poner en el párrafo
     */
    protected fun agregaParrafo(contenido: String) {
        HTML += "<p>" + contenido + "</p>" + "\n"
    }

    protected fun agregaObjeto(objeto : String){
        HTML += "<object " + objeto+"></object>"
    }
}