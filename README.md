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
 
 Nuestra app, apenas consume recursos en donde este siendo ejecutada.
 
 ![cpu](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/cpu.PNG)
 ![cpu2](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/cpu2.PNG)
 
 
 ## Usabilidad:
 
 En la usabilidad, definimos el como funciona la app, lo facil que es, lo accesible y bien fundamentada, para ser amigable y facil para   el usuario final.
 
 Primero que todo queda claro que hay dos tipos de usuarios, el administrador y el usuario natural, el cual debe entrar con su nombre de usuario y contraseña, en caso de no tenerla, un usuario puede crearse de manera sencilla.
 
 ![sesion](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti0.PNG)
 
 ![crearsesion](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti.PNG)
 
 al ingresar como administrador, este puede de manera muy sencilla, ver y filtrar los tiquetes que estan activos o que lo estuvieron, crear nuevos tiquetes solo indicando cuantos y de que tipo. Ademas de habilitar o deshabilitar la disponibilidad de una atraccion, lo cual directamente afectara en las colas, haciendo que quienes hicieran cola en ese momento salgan de la cola; tambien se puede modificar toda la atraccion entera si se requiere.
 ![admtiquetes](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti2.PNG)
 ![admatraccion](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti3.PNG)
 
 Como usuario, al ingresar puede inscribir uno o mas tiquetes relacionados al mismo usuario, y paso siguiente entrar al menu principal del usuario.
 
 ![ingtiquetes](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti4.PNG)
 
 En el menu principal el usuario tendra la posibilidad de ver cuantos boletos tiene asignados, volver al menu anterior para agregar mas tiquetes, cerrar sesion, ver el estado de las atracciones y hacer fila.
 
 ![menuuser](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti5.PNG)
 ![atraccionuser](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti6.PNG)
 
 al hacer fila puede inlcuir a todos los boletos que tiene relacionados o simplemente los que sean necesarios.
 
 ![fila](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/uti7.PNG)
 
 ## Escalabilidad:
 
Al estar desplegado en Heroku esto nos permite que la aplicación pueda ser escalable verticalmente aumentando la capacidad de los dynos:

![escalabilidadvertical](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/escalable1.jpg)

O escalable horizontalmente añadiendo mas "Add-ons":

![escalabilidadhorizontal](https://github.com/equiporocketarsw/Proyecto-ARSW/blob/master/img/escalable2.jpg)


