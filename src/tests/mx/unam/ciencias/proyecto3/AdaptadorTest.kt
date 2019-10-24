package mx.unam.ciencias.proyecto3

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
        assert(test.getPalabra().equals("prueba"))
    }

    /**
     * Función que probará que el getter del atributo Letra funcione correctamente
     */
    public fun pruebaGetLetra(){
        assert(test.getLetra().equals('A'))
    }

    /**
     * Función que probará que el getter del atributo apariciones funcione correctamente
     */
    public fun pruebaGetApariciones(){
        assert(test.getApariciones().equals(6))
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
        assert(test.getLetra().equals(' '))
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
        assert(test.compareTo(menor)>0)
        assert(test.compareTo(mayor)<0)
        assert(test.compareTo(igual).equals(0))
    }

    /**
     * Función que probará que el toString del Adaptador funcione al regrese la variable letra como String
     */
    public fun pruebaToString(){
        test.setLetra('A')
        assert(test.toString().equals("A"))
    }
}