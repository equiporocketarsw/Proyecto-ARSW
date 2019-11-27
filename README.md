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
 
En nuestro caso la disponibilidad definira los medios y el tiempo, donde la app sera accesible, por ejemplo, nuestra app, va en diferentes navegadores, tales como google crhome, microsoft edge, firefox y opera. ademas de ser compatible con smartphones.

![google](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/google.PNG)
![edge](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/edge.PNG)
![firefox](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/mozilla.PNG)
![opera](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/opera.PNG)
![smart](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/smart.jpg)


 ## Rendimiento:
 
 En el rendimiento mediremos cuanta cpu consume nuestra app.
 
 ## Usabilidad:
 
 En la usabilidad, el como funciona la app, lo facil que es, lo accesible y bien fundamentada, para ser amigable y facil para el usuario
 final.
 
 ## Escalabilidad:
 
 En la escalabilidad veremos lo dificil o facil que seria implementar nuevas funcionalidades y hacer cambios en la app.
