# Problema Roles main 

Acá tenemos un problema de accesos y de diseño.

Según lo que establecimos, deberíamos tener algún tipo de intermediario
entre el main (acá!) y lo que será las interfaces de administrador.
Esto es porque en nuestros dos puntos de entrada necesitamos correr el mismo
codigo (la interfaz!). No encapsularlo sería reutilizacion de codigo, y un dolor
de cabeza para mantener. (para hacer un pequeño cambio en la interfaz, habría que cambiar
cosas en varios lugares a la vez)

        =====================
        El problema
        =====================
        Ese menú de administrador debería estar vinculado a un administrador mediante una relación de TIENE-UN o
        HAS-A. Pero se me ocurrió, ese administrador (mediante al que accedemos via una interfaz, no la intefaz misma!)
        ¿No debería tener un Zoologico tambien?

        Si no queremos hablarle al zoologico ni manejar su estado, deberíamos tener un zoologico dentro de admin.
        Es raro.
        Pero también necesitamos un administrador en zoologico, así podemos iniciar sesión en un zoologico creado.

        Sería un diagrama así.

            -----                -------
            |Zoo|  <-----------> |admin|
            -----                -------
                                    ^
                                    |
                                    |
                                -------------
                                |controlador|
                                |Admin      |
                                -------------


        nota al parrafo: todos estos problemas van a ser los mismos con el resto de roles, mamadera

        =====================
        La solución
        =====================
        Con controlador admin:
            1) lo prendemos fuego y establecemos un único punto de entrada (posiblemente lo mejor)
            2) implementamos esta clase (fea), y cerramos toda esa complejidad bajo llave (con mayor flexibilidad
                                                                                           frente a posibles cambios)

        Con la relacion bidireccional entre zoo y admin
            1) Eliminamos Admin de Zoo, guardamos los dos objetos en un archivo y hardcodeamos el menú de administrador
               para que se acceda si coinciden esas credenciales

                admin TIENE-UN zoologico
             -----              -------
            |Zoo|  <----------- |admin|
            -----               -------

            2) Mantener dos referencias entrecruzadas, sabiendo a la noche, antes de dormir, que cualquier cosa que nos
               pueda pasar la merecemos
         