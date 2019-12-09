var atraccionApp =( function (){
	
	
    var stompClient= null;
    var estado;
    var atraccionActual=null;
    
  

         var  mostrarAtracciones= function(){

            
            atraccionClient.getAtracciones(imprimirAtracciones,"Editar");
            estado="Admin";
            sessionStorage.setItem("estadoFilas","no");

        }

        var mostrarEditar= function(){
            atraccionClient.getAtraccion(imprimirEditar, id, "todo");
            estado="Admin";
            sessionStorage.setItem("estadoFilas","no");
        }
        
        
        
        var  mostrarAtraccionesCliente= function(){
            atraccionClient.getAtracciones(imprimirAtracciones,"Hacer Fila");
            estado="Cliente";
            sessionStorage.setItem("estadoFilas","no");
        }

        var mostrarAtraccionesFilas = function(){
            user = sessionStorage.getItem('currentUser');
            colaClient.getColasByUsuario(user,imprimirAtracciones,"Salir de la Fila");
            estado="Filas";
            sessionStorage.setItem("estadoFilas","yes");

        }
        


        var darAtraccionporId = function(id){
            atraccionClient.getAtraccion(cambiarEstado,id,"estado");

        }

       var editarAtracccion = function(id){
            atraccionClient.getAtraccion(cambiarEstado,id,"todo");
       }


        var cambiarEstado =function(atraccion,tipo){
            if (tipo=="estado"){
                var estadoact = atraccion.activo;
                if (estadoact){
                    atraccion.activo=false;
                    
                    colaClient.deleteColasByAtraccion(atraccion.id);

                } 
                else{
                    atraccion.activo=true;
                }

                atraccionClient.changeState(atraccion);
            }
            else{
                var n = $('#nombre').val();
                var c = $('#capacidad').val();
                var t = $('#tiempo').val();
                var a = $('#activo').val();
                var d = $('#descripcion').val();
                var emx = $('#estaturamax').val();
                var emn = $('#estaturamin').val();
                var tp = $('#tipo').val();
                atraccion.nombre = n;
                atraccion.capacidad = c;
                atraccion.tiempo = t;
                atraccion.activo = a;
                atraccion.descrpcion = d;
                atraccion.estaturamax = emx;
                atraccion.estaturamin = emn;
                atraccion.tipo = tp;
                atraccionClient.changeState(atraccion);
            }
     
            stompClient.send('/atraccion/estadoAdmin', {}, JSON.stringify(atraccion));
            stompClient.send('/atraccion/estadoCliente', {}, JSON.stringify(atraccion));
            stompClient.send('/atraccion/estadoFilas', {}, JSON.stringify(atraccion));
        }
        
       

       var  imprimirAtracciones= function(atracciones,tipo){
            $("#tablaAtracciones div").remove(); 

                   if (tipo=="Editar"){
                       
                       var boton = " <a href=\"editarAtraccion.html\" class=\"button\">"+tipo+"</a></div>"; 
                       
                   }
                else if (tipo=="Hacer Fila"){
                    
                    var boton = " <a href=\"javascript:atraccionApp.hacerFila()\" class=\"button\">"+tipo+"</a></div>"; 
                }
                else{
                    var boton = " <a href=\"javascript:atraccionApp.salirFila()\" class=\"button\">"+tipo+"</a></div>"; 
                }
           
                atracciones.map(function(atraccion){
                    
                    //personasEnFila=personasEnFila.length;
                    if (tipo=="Editar"){
                       
                        if(atraccion.activo){
                            var activo="<label class=\"switch\"> <input id=\""+atraccion.id+"\" onclick=\"atraccionApp.darAtraccionporId("+atraccion.id+")\" type=\"checkbox\" checked> <span class=\"slider round\"></span> </label> </br>"
                        }
                        else{
                            var activo="<label class=\"switch\"> <input id=\""+atraccion.id+"\" onclick=\"atraccionApp.darAtraccionporId("+atraccion.id+")\" type=\"checkbox\"> <span class=\"slider round\"></span> </label> </br>"
                        }
                    }
                    else if (tipo=="Hacer Fila"){
                        if(atraccion.activo){
                            var activo="<span style=\"color:green;font-weight:bold\"> Abierta </span></br>";
             
                            boton = " <a href=\"javascript:atraccionApp.hacerFila("+atraccion.id+")\" class=\"button\">"+tipo+"</a></div>"; 
                        }
                        else{
                            var activo="<span style=\"color:red;font-weight:bold\">Cerrada</span></br>";
                            boton = " <a class=\"button\">"+tipo+"</a></div>"; 
                        }
                         
                    }
                    else{
                        var activo="<span style=\"color:green;font-weight:bold\"> Abierta </span></br>";
             
                        boton = " <a href=\"javascript:atraccionApp.salirFila("+atraccion.id+")\" class=\"button\">"+tipo+"</a></div>";
                    }
                    
                    colaClient.getColasByAtraccion(atraccion,activo,boton,imprimirPersonasEnfila);

                    //var contenedor = "<div class=\"grid-1-5\"><h2>"+atraccion.tipo+"</h2><h3>"+activo+"<span class=\"uppercase\">"+atraccion.nombre+"</span></h3> <p>Capacidad: "+atraccion.capacidad+" personas</p> <p>Personas en fila: "+personasEnFila+" personas</p> <p>Duración: "+atraccion.tiempo+" minutos</p>  <p>Estatura minima: "+atraccion.estaturamin+"</p>   <p>Estatura maxima: "+atraccion.estaturamax+"</p>  <p>"+atraccion.descrpcion+"</p> "+boton ;
			
                           
                    //$("#tablaAtracciones").append(contenedor);

                })
            
        }

        var imprimirPersonasEnfila = function(atraccion,tiquetes,activo,boton){
            var personasEnFila = tiquetes.length;

            var contenedor = "<div class=\"grid-1-5\"><h2>"+atraccion.tipo+"</h2><h3>"+activo+"<span class=\"uppercase\">"+atraccion.nombre+"</span></h3> <p style=\"color:blue;font-weight:bold\">Personas en fila: "+personasEnFila+"</p> <p>Capacidad: "+atraccion.capacidad+" personas</p>  <p>Duración: "+atraccion.tiempo+" minutos</p>  <p>Estatura minima: "+atraccion.estaturamin+"</p>   <p>Estatura maxima: "+atraccion.estaturamax+"</p>  <p>"+atraccion.descrpcion+"</p> "+boton ;
			
                           
            $("#tablaAtracciones").append(contenedor);

        } 


        var imprimirEditar= function(atraccion, id, tipo){
            $("#editarAtracciones div").remove(); 
                
                
                atraccion.map(function(atraccion){
                    var nom = "<input class=\"inputtype\" id=\"nom\" type=\"text\" placeholder=\""+atraccion.nombre+"\" /> ";
                    var cap = "<input class=\"inputtype\" id=\"cap\" type=\"number\" placeholder=\""+atraccion.capacidad+"\" />";
                    var tie = "<input class=\"inputtype\" id=\"tie\" type=\"number\" placeholder=\""+atraccion.tiempo+"\" />";
                    var descr = "<input class=\"inputtype\" id=\"descr\" type=\"text\" placeholder=\""+atraccion.descrpcion+"\" />";
                    var estamax = "input class=\"inputtype\" id=\"estamax\" type=\"text\" placeholder=\""+atraccion.estaturamax+"\" />";
                    var estamin = "<input class=\"inputtype\" id=\"estamin\" type=\"text\" placeholder=\""+atraccion.estaturamin+"\" />";
                    var tip = "<input class=\"inputtype\" id=\"tip\" type=\"text\" placeholder=\""+atraccion.tipo+"\" />"; 
                    var conte = "<div class=\"wrapper\">"+nom+bot+cap+tie+descr+estamax+estamin+tip+bot+"</div>";
                    var bot = " <a href=\"adminMain.html\"  class=\"button\">Aceptar</a></div>";
                    $("#editarAtracciones").append(conte);
                })
            
        }
        
        
	
        var connectAndSubscribe = function () {
            console.info('Connecting to WS...');
            var socket = new SockJS('/stompendpoint');
            
            stompClient = Stomp.over(socket);
            
            
    
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                
                stompClient.subscribe('/atraccion/estado'+estado, function (eventbody) {

                    var at = (JSON.parse(eventbody.body));

                    var fila=sessionStorage.getItem('fila');
                   if (fila=="Haciendo" && at.id==sessionStorage.getItem('atraccion')){
                        if (at.activo==false){
                            alert("Lo sentimos: La atraccion se acaba de cerrar");
                        }
                        location.href = "/main.html";
                    }
                   
                    if (estado=="Admin"){
                        mostrarAtracciones();
                    }
                    else if (estado=="Cliente"){
                        mostrarAtraccionesCliente();
                    }else if (estado=="Filas"){
                        mostrarAtraccionesFilas();
                    }

                    
                    
                });
                
                
            });
    
        };

        var hacerFila=function(atraccion){
            sessionStorage.setItem("fila","Haciendo");
 
            sessionStorage.setItem("atraccion",atraccion);
            location.href = "/fila.html";
        }
        

        var salirFila=function(atraccion){
 
            user = sessionStorage.getItem('currentUser');
            colaClient.deleteColasByAtraccionAndUser(atraccion,user);
            stompClient.send('/atraccion/estadoAdmin', {}, JSON.stringify(atraccion));
            stompClient.send('/atraccion/estadoCliente', {}, JSON.stringify(atraccion));
            stompClient.send('/atraccion/estadoFilas', {}, JSON.stringify(atraccion));
            
        }
        
        var atraccionActual= function(){
            atraccionClient.getAtraccion(imprimirAtraccion,sessionStorage.getItem('atraccion'),"estado");
            

        }

        var imprimirAtraccion=function(atraccion,tipo){
            document.getElementById('currentAtraccion').innerHTML = atraccion.nombre;
            sessionStorage.setItem("Objetoatraccion",atraccion);
        }

	return {
                mostrarAtracciones: mostrarAtracciones,
                mostrarEditar: mostrarEditar,
                imprimirAtracciones: imprimirAtracciones,
                imprimirEditar: imprimirEditar,
                mostrarAtraccionesCliente: mostrarAtraccionesCliente,
                darAtraccionporId: darAtraccionporId,
                editarAtracccion: editarAtracccion,
                connectAndSubscribe: connectAndSubscribe,
                hacerFila: hacerFila,
                atraccionActual: atraccionActual,
                mostrarAtraccionesFilas: mostrarAtraccionesFilas,
                salirFila: salirFila
	};
})();

