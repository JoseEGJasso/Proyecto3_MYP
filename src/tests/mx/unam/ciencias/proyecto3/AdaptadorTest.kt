package mx.unam.ciencias.proyecto3

import java.sql.DriverManager

/**
 * Clase AdaptadorTest
 * se encargará de probar que los métodos de la clase Adaptador cumplan la funcion deseada
 */
class AdaptadorTest {
    /**
     * Variable test que será un adaptador y sibre la cual se harán las pruebas
     */
    private var test = Adaptador("prueba",6,'A')

    /**
     * Función que probará que el getter del atributo palabra funcione correctamente
     */
    public fun pruebaGetPalabra(){
        if(test.getPalabra().equals("prueba")){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }
    }

    /**
     * Función que probará que el getter del atributo Letra funcione correctamente
     */
    public fun pruebaGetLetra(){
        if(test.getLetra().equals('A')){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }
    }

    /**
     * Función que probará que el getter del atributo apariciones funcione correctamente
     */
    public fun pruebaGetApariciones(){
        if(test.getApariciones().equals(6)){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }

    }

    /**
     * Función que probará que el constructor de la clase funcione correctamente asignado los valores esperados
     */
    public fun pruebaConstructor(){
        pruebaGetPalabra()
        pruebaGetLetra()
        pruebaGetApariciones()
    }

    /**
     * Función que probará que el constructor secundario de la clase asigne los valores correctamente(solo asigna apariciones y palabra)
     */
    public fun pruebaConstuctorSecundario(){
        test = Adaptador("prueba",6)
        pruebaGetPalabra()
        pruebaGetApariciones()
        if(test.getLetra().equals(' ')){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }

    }

    /**
     * Función que probará que el setter de letra funcione correctamente
     */
    public fun pruebaSetLetra(){
        test.setLetra('B')
    }

    /**
     * Función que probará que el compareTo funcione al regresar un número mayor a cero si recibe un adaptador con mayor número
     * de apariciones, uno menor a cero si recibe un adaptador con mayor número de apariciones y finalmente un cero si recibe
     * un adaptador con el mismo número de apariciones
     */
    public fun pruebaCompareTo(){
        var menor = Adaptador("prueba",4,'A')
        var mayor = Adaptador("prueba",8,'A')
        var igual = Adaptador("prueba",6,'A')
        if(test.compareTo(menor)>0){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }
        if(test.compareTo(mayor)<0){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }
        if(test.compareTo(igual).equals(0)){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }

    }

    /**
     * Función que probará que el toString del Adaptador funcione al regrese la variable letra como String
     */
    public fun pruebaToString(){
        test.setLetra('A')
        if(test.toString().equals("A")){
            DriverManager.println("Prueba pasada")
        }else{
            DriverManager.println("Prueba no pasada")
        }

    }
}