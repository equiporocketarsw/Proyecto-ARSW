![logo](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/logo.png)
## Descripción
Nuestra aplicación busca resolver el problema de los largos tiempos de espera en los parques de diversiones, dando la posibilidad de que los usuarios hagan cola en una atracción de manera virtual, con lo cual no debe quedarse en una cola real esperando por su turno, y pueden hacer otras actividades en el parque de diversiones, aprovechando el máximo tiempo posible en su estadía por el parque.

![logo](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/salitre.PNG)
![logo](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/fila.PNG)

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

Se tiene facilidad y simpleza para la persona natural, esto para no agoviar al usuario, en el siguiente video podemos ver lo que este usuario puede hacer en la app:

![tutorial de usuario](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/tutouser.gif)

## Como administrador
 Como administrador, ya tendras una cuenta con permisos, la cual al acceder puede añadir n tiquetes que seran validos para ese dia, ademas de modificar las atracciones y su disponibilidad, asi como añadir nuevas.
 
 # Atributos no funcionales
 Estos atributos son los que definiran las caracteristicas generales, restricciones y limitaciones de nuestra app.
 
 ## Disponibilidad
 
 **Escenario:** Ingresar a la aplicacion desde navegador en computador de mesa y celular en coindiciones normales.
 
1. **Source:** Usuario final.
2. **Stimulus:** Ingresar a la aplicación.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicacion bajo coindiciones normales
5. **Response:** Se visualizan las atracciones normalmente.
6. **Response Measure:** Las atracciones y demas funcionalidades se cargan en un tiempo promedio de 1 segundo.

[Vista Escenario Computador](https://drive.google.com/open?id=1b_odim5Vmme60oNosCEbTQGyatT3_flp)

[Vista Escenario Celular](https://drive.google.com/open?id=1LR1lqVUe3hDMH4YRT4DrGywLq68LeZ04)
 
  **Escenario:** Ingresar a la aplicacion desde navegador en computador de mesa y celular en coindiciones de estres.
 
1. **Source:** Usuario final
2. **Stimulus:** Ingresar a la aplicación y ver atracciones disponibles
3. **Artifact:** Frontend, Backend.
4. **Enviroment:** Aplicación bajo coindiciones de estres.
5. **Response:** Se visualizan las atracciones normalmente.
6. **Response Measure:** Las atracciones y demas funcionalidades se siguen cargando en un tiempo promedio de 1 segundo.

[Vista Escenario Computador](https://drive.google.com/open?id=1pPakcBv-675J27pk3r5FR_o2qCcirH0Y)

[Vista Escenario Celular](https://drive.google.com/open?id=1LGwPgnp9Uy_tJoUZAFhGKUfxVFY-HtlU)

 ## Rendimiento
 
 **Escenario:** Administrador cerrando atracción
 
1. **Source:** Administrador.
2. **Stimulus:** Cerrar atracción.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicacion bajo coindiciones normales.
5. **Response:** El usuario ahora ve la atracción cerrada.
6. **Response Measure:** El cambio en la atracción se realiza en menos de un 1 segundo.

[Vista Escenario](https://drive.google.com/open?id=1E8nnYgq7pk17_P5rgcOmJ2ldJ9gIfhzb)

**Escenario:** Usuario entrando a fila.
 
1. **Source:** Usuario final.
2. **Stimulus:** Ingresar a la fila de una atracción.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicacion bajo coindiciones normales.
5. **Response:** Los demás usuario ven como el numero de personas en la fila cambia.
6. **Response Measure:**  El cambio en la atracción se realiza en menos de un 1 segundo.

 [Vista Escenario](https://drive.google.com/open?id=1ePgPgb8SFL858nOIG5Y95Hs9LUthqiQF)
 
 ## Usabilidad
 
**Escenario:** Cliente ingresando a fila
 
1. **Source:** Cliente final
2. **Stimulus:** Cliente ingresando  a una fila.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicación bajo coindiciones normales.
5. **Response:** El cliente se añade a la fila.
6. **Response Measure:** El cliente es capaz de seleccionar la atracción e introducir la cantidad de personas que van hacer fila con tan solo dos clicks, una vez se encuentre en la pantalla principal. 

[Vista Escenario](https://drive.google.com/open?id=1DpN5uJvdw-dvXoyal2p5oFk7O3eRC3hN)

 **Escenario:** Varios clientes entrando y saliendo de las filas mientras el administrador puede cerrar una atracción.
 
1. **Source:** Cliente final, administrador.
2. **Stimulus:** Clientes entrando y saliendo de las filas, administrador cerrado atracciones.
3. **Artifact:** Frontend, Backend, base de datos.
4. **Enviroment:** Aplicación bajo coindiciones normales.
5. **Response:** El numero de personas en fila cambia, algunas atracciones se cierran.
6. **Response Measure:** Tanto el cliente como el administrador son capaces de ver el numero de personas en fila cambiar y si una atracción es cerrada sin dar un solo click ni actualizar la aplicación.


 [Vista Escenario Cliente](https://drive.google.com/open?id=1ocUApz1_g9pCkgjeHKFdaZOaQac7DZgv)
 
 [Vista Escenario Administrador](https://drive.google.com/open?id=1xhHUD6E1S8mfT0YMUudBNvkKtG0aTgle)
 
 ## Escalabilidad
 
**Escenario:** Escabilidad vertical

1. **Source:** Usuarios finales
2. **Stimulus:** Sobrecarga de usuarios finales
3. **Artifact:** Heroku
4. **Enviroment:** Aplicación bajo coindiciones de estres.
5. **Response:** Dependiendo de la carga que reciba la aplicación se cambiara el tipo de dyno que se esta usando Adept Scale.
6. **Response Measure:** El tiempo de respuesta seguira siendo el mismo de un segundo aproximadamente sin importar la carga que se reciba.

Dynos disponibles:

![Dynos](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/escabilidad1.PNG)

Caracteristicas de cada dyno:

![Dynos](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/escabilidadTodos.PNG)

Add-on que permite la escabilidad automatica:

![Dynos](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/escabilidad3.PNG)

**Escenario:** Escabilidad horizontal

1. **Source:** Usuarios finales
2. **Stimulus:** Sobrecarga de usuarios finales
3. **Artifact:** Heroku
4. **Enviroment:** Aplicación bajo coindiciones de estres.
5. **Response:** Para distribuir mejor la carga se aumnetaran la cantidad de dynos.
6. **Response Measure:** El tiempo de respuesta seguira siendo el mismo de un segundo aproximadamente sin importar la carga que se reciba.

![Dynos](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/escabilidadh.PNG)


