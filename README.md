# CHILLPARK
## ARSW 2019-2
## Descripcion:
Nuestra aplicación busca resolver el problema de los largos tiempos de espera en los parques de diversiones, dando la posibilidad de que los usuarios hagan cola en una atracción de manera virtual, con lo cual no debe quedarse en una cola real esperando por su turno, y pueden hacer otras actividades en el parque de diversiones, aprovechando el máximo tiempo posible en su estadía por el parque.

## Autores: 
 Santiago Vega Romero, David Eduardo Caycedo Moyano y Miguel Armando Sanchez Guluma

## Enlace heroku: https://chillpark.herokuapp.com

## Analisis de calidad de código en Codacy: https://app.codacy.com/manual/svega99/Proyecto-ARSW/dashboard

# Arquitectura de la app

## Diagrama de Clases

![Diagrama de clases](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/clases.png)

## Diagrama Entidad relación 

![Diagrama de clases](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/basededatos.PNG)

## Diagrama de casos de uso

![Diagrama de casos de uso](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uso.PNG)



# Intrucciones de uso:
## La app cuenta con dos tipos de usuario, una persona natural y el administrador.
## Como persona natural:
 Como persona natural, primero que todo desde la página principal puedes o crear una cuenta o acceder en una existente, ya al entrar en la cuenta podemos fijar una cantidad n de boletos a ese usuario, de modo que pueden hacer fila mas de una persona por un usuario, esto para grupos de amigos, o familias. Al hacer lo anterior, se podra revisar las diferentes atracciones que hay en el parque, con sus respectivos tiempos de espera y obviamente el poder hacer fila en la atraccion; ademas de añadir boletos que faltaron o cerrar sesión.

## Como administrador:
 Como administrador, ya tendras una cuenta con permisos, la cual al acceder puede añadir n tiquetes que seran validos para ese dia, ademas de modificar las atracciones y su disponibilidad, asi como añadir nuevas.
 
 # Atributos no funcionales:
 Estos atributos son los que definiran las caracteristicas generales, restricciones y limitaciones de nuestra app.
 
 ## Disponibilidad:
 
  **Escenario:** 
 
1. **Source:** 
2. **Stimulus:**
3. **Artifact:**
4. **Enviroment:**
5. **Response:**
6. **Response Measure:**

**Escenario:** 
 
1. **Source:**
2. **Stimulus:**
3. **Artifact:**
4. **Enviroment:**
5. **Response:**
6. **Response Measure:**

![google](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/google.PNG)
![edge](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/edge.PNG)
![firefox](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/mozilla.PNG)
![opera](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/opera.PNG)
![smart](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/smart.jpg)


 ## Rendimiento:
 
 **Escenario:** 
 
1. **Source:**
2. **Stimulus:**
3. **Artifact:**
4. **Enviroment:**
5. **Response:**
6. **Response Measure:**

**Escenario:** 
 
1. **Source:**
2. **Stimulus:**
3. **Artifact:**
4. **Enviroment:**
5. **Response:**
6. **Response Measure:**
 
 
 ## Usabilidad:
 
**Escenario:** Cliente ingresando a fila
 
1. **Source:** Cliente final
2. **Stimulus:** Cliente ingresando  a una fila.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicación bajo coindiciones normales.
5. **Response:** El cliente se añade a la fila.
6. **Response Measure:** El cliente es capaz de seleccionar la atracción e introducir la cantidad de personas que van hacer fila con tan solo dos clicks, una vez se encuentre en la pantalla principal. 

 [Vista Escenario Cliente](http://damien.pobel.fr/post/youtube-video-github/)
 
 [Vista Escenario Administrador](http://damien.pobel.fr/post/youtube-video-github/)

 **Escenario:** Varios clientes entrando y saliendo de las filas mientras el administrador puede cerrar una atracción.
 
1. **Source:** Cliente final, administrador.
2. **Stimulus:** Clientes entrando y saliendo de las filas, administrador cerrado atracciones.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicación bajo coindiciones normales.
5. **Response:** El numero de personas en fila cambia, algunas atracciones se cierran.
6. **Response Measure:** Tanto el cliente como el administrador son capaces de ver el numero de personas en fila cambiar y si una atracción es cerrada en menos de 1 segundo desde la pantalla principal, sin dar un solo click ni actualizar la aplicación.

[Vista Escenario](https://raw.githubusercontent.com/equiporocketarsw/Proyecto-ARSW/master/img/Usabilidad2.webm)
 
 ## Escalabilidad:
 
**Escenario:** 
 
1. **Source:**
2. **Stimulus:**
3. **Artifact:**
4. **Enviroment:**
5. **Response:**
6. **Response Measure:**

**Escenario:** 
 
1. **Source:**
2. **Stimulus:**
3. **Artifact:**
4. **Enviroment:**
5. **Response:**
6. **Response Measure:**


