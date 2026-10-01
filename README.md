# Paradigmas-y-lenguaje-de-programaci-n-AE2-Maven


TP1  AE2 - Evolución de Arquitectura Orientada a Objetos (Maven Project)
Asignatura: Paradigmas y Lenguajes de Programación II
Carrera: Ingeniería en Sistemas de Información
Estudiante: Máximo Lautaro Márquez
 
 
 Descripción del Proyecto
Este repositorio contiene la evolución de la aplicación TP1 hacia la Actividad Evaluativa 2 (AE2), adaptada y estructurada como un proyecto Maven.
El objetivo principal de esta entrega es consolidar el diseño orientado a objetos en Java mediante la aplicación rigurosa de principios de abstracción, polimorfismo, uso de múltiples interfaces, criterios de ordenamiento avanzados, excepciones del dominio y persistencia desacoplada con archivos en disco.
 
 
 Requisitos de la AE2 Implementados:
 
1. Polimorfismo y Clase Abstracta (⁠com.example.Personas⁠):
 Refactorización de la clase base ⁠Persona⁠ a clase ⁠abstract⁠.
 Método abstracto ⁠obtenerTipo()⁠ sobreescrito de forma polimórfica en ⁠Cliente⁠, ⁠Empleado⁠ y ⁠Proveedor⁠.
2. Múltiples Interfaces (⁠com.example.Transacciones⁠):
 ⁠Facturable⁠: Define el contrato para el cálculo de totales económicos.
 ⁠Imprimible⁠: Define el contrato para obtener resúmenes en texto.
 La clase ⁠OfertaComercial⁠ implementa ambas interfaces simultáneamente.
3. Criterios de Ordenamiento (⁠com.example.Catalogo⁠):
 Orden Natural: La clase ⁠Producto⁠ implementa ⁠Comparable<Producto>⁠ para ordenar elementos por su precio (de menor a mayor).
 Orden Alternativo: Implementación de ⁠ProductoPorNombreComparator⁠ mediante ⁠Comparator<Producto>⁠ para ordenar alfabéticamente por nombre.
4. Excepción del Dominio (⁠com.example.Transacciones⁠):
Creación de ⁠OfertaSinItemsException⁠ para prevenir y capturar de forma controlada el cálculo de ofertas comerciales sin productos ni servicios.
5. Persistencia e Infraestructura (⁠com.example.Repositorio⁠):
 Implementación de ⁠FacturaRepository⁠ aplicando el Principio de Responsabilidad Única (SRP) para escribir y leer los resúmenes en un archivo físico de disco (⁠datos_resumenes.txt⁠).

 Compilación y Ejecución con Maven

Para compilar y ejecutar el proyecto mediante la consola de comandos de Windows (CMD o Terminal):

A) Posicionarse en el directorio del proyecto Maven (⁠demo⁠): cd demo

B) Limpiar y compilar el proyecto con Maven: mvn clean compile

C) Ejecutar la clase principal mediante Maven: mvn exec:java -Dexec.mainClass="com.example.Main"

(Alternativamente, dentro de Visual Studio Code, se puede ejecutar haciendo clic derecho sobre la clase ⁠Main.java⁠ y seleccionando Run).


 Salida Esperada en Consola
Al ejecutar el programa, el ⁠Main⁠ integrador realiza la demostración secuencial de todos los requerimientos:
 1. Polimorfismo: Recorrido de una lista ⁠List<Persona>⁠ resolviendo dinámicamente la subclase concreta (⁠Cliente⁠, ⁠Empleado⁠, ⁠Proveedor⁠).
 2. Ordenamiento: Muestra la lista de productos ordenada por precio (⁠Comparable⁠) y posteriormente ordenada por nombre (⁠Comparator⁠).
 3. Excepciones: Captura controlada del bloque ⁠try-catch⁠ con ⁠OfertaSinItemsException⁠ al procesar una oferta vacía.
 4. Persistencia: Generación física del archivo ⁠datos_resumenes.txt⁠ y lectura inmediata de su contenido por consola.
