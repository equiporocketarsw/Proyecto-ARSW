var atraccionApp =( function (){
	
	
    var stompClient= null;
    var estado;
    var atraccionActual=null;
    

         var  mostrarAtracciones= function(){

            
            atraccionClient.getAtracciones(imprimirAtracciones,"Editar");
            estado="Admin";
        }
        
        
        
         var  mostrarAtraccionesCliente= function(){

            
            atraccionClient.getAtracciones(imprimirAtracciones,"Hacer Fila");
            estado="Cliente";
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
                if (n==""){

                }
                else{
                    atraccion.nombre = n;
                }
                if (c==""){

                }
                else{
                    atraccion.capacidad = c;
                }
                if (t==""){

                }
                else{
                    atraccion.tiempo = t;
                }
                if (a==""){

                }
                else{
                    atraccion.activo = a;
                }
                if (d==""){

                }
                else{
                    atraccion.descrpcion = d;
                }
                if (emx==""){

                }
                else{
                    atraccion.estaturamax = emx;
                }
                if (emn==""){

                }
                else{
                    atraccion.estaturamin = emn;
                }
                if (tp==""){

                }
                else{
                    atraccion.tipo = tp;
                }               
                atraccionClient.changeState(atraccion);
            }
     
            stompClient.send('/atraccion/estado'+estado, {}, JSON.stringify(atraccion));
            stompClient.send('/atraccion/estadoCliente', {}, JSON.stringify(atraccion));
        }
        
        
       var  imprimirAtracciones= function(atracciones,tipo){
            $("#tablaAtracciones div").remove(); 

                   if (tipo=="Editar"){
                       
                       var boton = " <a href=\"editarAtraccion.html\" class=\"button\">"+tipo+"</a></div>"; 
                       
                   }
                else{
                    
                    var boton = " <a href=\"javascript:atraccionApp.hacerFila()\" class=\"button\">"+tipo+"</a></div>"; 
                }
           
                atracciones.map(function(atraccion){
                    if (tipo=="Editar"){
                       
                        if(atraccion.activo){
                            var activo="<label class=\"switch\"> <input id=\""+atraccion.id+"\" onclick=\"atraccionApp.darAtraccionporId("+atraccion.id+")\" type=\"checkbox\" checked> <span class=\"slider round\"></span> </label> </br>"
                        }
                        else{
                            var activo="<label class=\"switch\"> <input id=\""+atraccion.id+"\" onclick=\"atraccionApp.darAtraccionporId("+atraccion.id+")\" type=\"checkbox\"> <span class=\"slider round\"></span> </label> </br>"
                        }
                    }
                    else{
                        if(atraccion.activo){
                            var activo="<span style=\"color:green;font-weight:bold\"> Abierta </span></br>";
             
                            boton = " <a href=\"javascript:atraccionApp.hacerFila("+atraccion.id+")\" class=\"button\">"+tipo+"</a></div>"; 
                        }
                        else{
                            var activo="<span style=\"color:red;font-weight:bold\">Cerrada</span></br>";
                            boton = " <a class=\"button\">"+tipo+"</a></div>"; 
                        }
                         
                    }
                    
                    var contenedor = "<div class=\"grid-1-5\"><h2>"+atraccion.tipo+"</h2><h3>"+activo+"<span class=\"uppercase\">"+atraccion.nombre+"</span></h3> <p>Capacidad: "+atraccion.capacidad+" personas</p>  <p>Duración: "+atraccion.tiempo+" minutos</p>  <p>Estatura minima: "+atraccion.estaturamin+"</p>   <p>Estatura maxima: "+atraccion.estaturamax+"</p>  <p>"+atraccion.descrpcion+"</p> "+boton ;
			
                           
                    $("#tablaAtracciones").append(contenedor);

                })
            
        }
        
        
	
        var connectAndSubscribe = function () {
            console.info('Connecting to WS...');
            var socket = new SockJS('/stompendpoint');
            
            stompClient = Stomp.over(socket);
            
            

            localStorage.setItem("stompClient",stompClient);
    
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                
                stompClient.subscribe('/atraccion/estado'+estado, function (eventbody) {
                   
                    if (estado=="Admin"){
                        mostrarAtracciones();
                    }
                    else if (estado="Cliente"){
                        mostrarAtraccionesCliente();
                    }
                    
                    
                });
                
                
            });
    
        };

        var hacerFila=function(atraccion){
            sessionStorage.setItem("atraccion",atraccion);
            location.href = "/fila.html";
        }
    
        
        var atraccionActual= function(){
            document.getElementById('currentAtraccion').innerHTML = sessionStorage.getItem('atraccion');

        }
	return {
		        mostrarAtracciones: mostrarAtracciones,
                imprimirAtracciones: imprimirAtracciones,
                mostrarAtraccionesCliente: mostrarAtraccionesCliente,
                darAtraccionporId: darAtraccionporId,
                editarAtracccion: editarAtracccion,
                connectAndSubscribe: connectAndSubscribe,
                hacerFila: hacerFila,
                atraccionActual: atraccionActual
	};
})();

