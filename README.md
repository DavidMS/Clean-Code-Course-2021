# Task List &nbsp;

Este es un ejemplo de código obsesionado con primitivos.

Un *primitivo* es cualquier concepto de naturaleza técnica, que no es relevante para el dominio de su negocio. Esto incluye números enteros, caracteres, cadenas y colecciones (listas, conjuntos, mapas, etc.), pero también cosas como hilos, readers, writers, analizadores, excepciones y cualquier otra cosa que se centre exclusivamente en cuestiones técnicas. Por el contrario, los conceptos de negocio de este proyecto, "tarea", "proyecto", etc. deben considerarse parte de su *modelo de dominio*. El modelo de dominio es el idioma del negocio en el que opera, y usarlo en su código base lo ayuda a evitar hablar diferentes idiomas, lo que lo ayuda a evitar malentendidos. En nuestra experiencia, los malentendidos son la principal causa de errores.

## Ejercicio

Intente implementar las siguientes características, refactorizando primitivas sobre la marcha. Intente no implementar ningún comportamiento nuevo hasta que el código que está a punto de cambiar se haya refactorizado por completo para eliminar las primitivas, es decir, **_Solo refactorice el código que está a punto de cambiar y luego realice el cambio. No refactorice el código no relacionado._**

Un conjunto de criterios para identificar cuándo se han eliminado las primitivas es permitir solo las primitivas en las listas de parámetros del constructor y como variables locales y campos privados. No deben pasarse a métodos ni devolverse desde métodos. La única excepción es el verdadero código de infraestructura: código que se comunica con el terminal, la red, la base de datos, etc. La infraestructura requiere serialización a primitivas, pero debe tratarse como un caso especial. Incluso podría considerar su infraestructura como un dominio separado, de naturaleza técnica, en el que las primitivas *son* el dominio.

Debería intentar ajustar las pruebas al comportamiento que está refactorizando. Al principio, estas serán en su mayoría pruebas del sistema de alto nivel, pero debería encontrarse escribiendo más pruebas unitarias a medida que avanza.

### Características

1. Deadlines
    1. Asigne a cada tarea una fecha límite opcional con el comando `deadline <ID> <date>`.
    2. Muestre todas las tareas que vencen hoy con el comando `today`.
2. IDs Personalizados
    1. Permita que el usuario especifique un identificador que no sea un número.
    2. No permitir espacios y caracteres especiales del ID.
3. Borrado
    1. Permita que los usuarios eliminen tareas con el comando `delete <ID>`.
4. Vistas
    1. Vea las tareas por fecha con el comando `ver por fecha`.
    2. Vea las tareas por fecha límite con el comando `ver por fecha límite`.
    3. No elimine la funcionalidad que permite a los usuarios ver tareas por proyecto, pero cambie el comando a `ver por proyecto`.

### Consideraciones y Aproximaciones

Piense en * atracción de comportamiento *.Muy a menudo, puede reducir la cantidad de comportamiento que se basa en primitivas del mundo exterior (a diferencia de las primitivas internas almacenadas como campos privados o locales) simplemente moviendo el comportamiento a un* objeto de valor * que contiene las primitivas. Si no tiene un objeto de valor, cree uno. Estos objetos de valor se conocen como * atractores de comportamiento * porque una vez creados, hacen que sea mucho más obvio dónde debe vivir el comportamiento.

Un principio relacionado es considerar el tipo de objeto que ha creado. ¿Es un objeto de valor verdadero (o *registro*), que simplemente consiste en métodos `getFoo` que devuelven sus primitivas internas (para ser utilizadas solo con infraestructura, por supuesto), o es un objeto con comportamiento? Si es lo último, debe evitar exponer cualquier estado interno en absoluto. El primero no debe contener ningún comportamiento. Tratar algo como un registro y un objeto generalmente conduce al desastre.

Su enfoque dependerá de si aprende hacia un estilo funcional u orientado a objetos para modelar su dominio. Ambos fomentan la encapsulación, pero las técnicas de * ocultación de información * generalmente solo se usan en código orientado a objetos. También difieren en el enfoque utilizado para extraer el comportamiento; La programación funcional a menudo trabaja con conjuntos cerrados de comportamiento a través de * uniones etiquetadas *, mientras que en el código orientado a objetos, usamos *polimorfismo* para lograr los mismos fines de una manera abierta y extensible.

Separe sus comandos y consultas. Dile a un objeto que haga algo o pregúntale sobre algo, pero no hagas ambas cosas.

Por último, considere los principios S.O.L.I.D. al refactorizar:

* Trate de dividir grandes porciones de comportamiento en pequeños, cada uno con una única responsabilidad.
* Piense en las dimensiones en las que debería ser fácil ampliar la aplicación.
* No sorprenda a sus "llamadores". Ajústese a la interfaz.
* Separe el comportamiento según las necesidades.
* Dependa de abstracciones.