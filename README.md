# CHILLPARK
## ARSW 2019-2
## Descripción
Nuestra aplicación busca resolver el problema de los largos tiempos de espera en los parques de diversiones, dando la posibilidad de que los usuarios hagan cola en una atracción de manera virtual, con lo cual no debe quedarse en una cola real esperando por su turno, y pueden hacer otras actividades en el parque de diversiones, aprovechando el máximo tiempo posible en su estadía por el parque.

## Autores

 [Miguel Armando Sanchez Guluma](https://github.com/MiguelASG)
 
 [Santiago Vega Romero](https://github.com/svega99)


## Enlace heroku

[![Heroku](https://camo.githubusercontent.com/be46aee4f8d55e322c3e7db60ea23a4deb5427c9/68747470733a2f2f6865726f6b752d62616467652e6865726f6b756170702e636f6d2f3f6170703d6865726f6b752d6261646765)](https://chillpark.herokuapp.com)

## Analisis de calidad de código en Codacy
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c42353620eed40daaf4102f82214411e)](https://app.codacy.com/manual/svega99/Proyecto-ARSW/dashboard)


# Arquitectura de la app

## Diagrama de despliegue 

![Diagrama de despliegue](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/despliegue.PNG)

## Diagrama de componentes

![Diagrama de componentes](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/componentes.PNG)

## Diagrama de Clases

![Diagrama de clases](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/clases.png)

## Diagrama Entidad relación 

![Diagrama de clases](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/basededatos.PNG)

## Diagrama de casos de uso

![Diagrama de casos de uso](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uso.PNG)



# Intrucciones de uso
## La app cuenta con dos tipos de usuario, una persona natural y el administrador
## Como persona natural

En el siguiente video podemos ver de forma simple y detallada las funcionalidades que puede usar cualquier persona.

![tutorial de usuario](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/tutouser.gif)

## Como administrador
 Como administrador, ya tendras una cuenta con permisos, la cual al acceder puede añadir n tiquetes que seran validos para ese dia, ademas de modificar las atracciones y su disponibilidad, asi como añadir nuevas.
 
 # Atributos no funcionales
 Estos atributos son los que definiran las caracteristicas generales, restricciones y limitaciones de nuestra app.
 
 ## Disponibilidad
 
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


 ## Rendimiento
 
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
 
 
 ## Usabilidad
 
**Escenario:** Cliente ingresando a fila
 
1. **Source:** Cliente final
2. **Stimulus:** Cliente ingresando  a una fila.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicación bajo coindiciones normales.
5. **Response:** El cliente se añade a la fila.
6. **Response Measure:** El cliente es capaz de seleccionar la atracción e introducir la cantidad de personas que van hacer fila con tan solo dos clicks, una vez se encuentre en la pantalla principal. 

 [Vista Escenario Cliente](https://drive.google.com/open?id=1ocUApz1_g9pCkgjeHKFdaZOaQac7DZgv)
 
 [Vista Escenario Administrador](https://drive.google.com/open?id=1xhHUD6E1S8mfT0YMUudBNvkKtG0aTgle)

 **Escenario:** Varios clientes entrando y saliendo de las filas mientras el administrador puede cerrar una atracción.
 
1. **Source:** Cliente final, administrador.
2. **Stimulus:** Clientes entrando y saliendo de las filas, administrador cerrado atracciones.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicación bajo coindiciones normales.
5. **Response:** El numero de personas en fila cambia, algunas atracciones se cierran.
6. **Response Measure:** Tanto el cliente como el administrador son capaces de ver el numero de personas en fila cambiar y si una atracción es cerrada en menos de 1 segundo desde la pantalla principal, sin dar un solo click ni actualizar la aplicación.

[Vista Escenario](https://drive.google.com/open?id=1DpN5uJvdw-dvXoyal2p5oFk7O3eRC3hN)
 
 ## Escalabilidad
 
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


