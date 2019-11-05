var atraccionApp =( function (){
	
	
    var stompClient= null;
    

         var  mostrarAtracciones= function(){

            
            atraccionClient.getAtracciones(imprimirAtracciones,"Editar");
        }
        
        
        
         var  mostrarAtraccionesCliente= function(){

            
            atraccionClient.getAtracciones(imprimirAtracciones,"Hacer Fila");
        }
        
        var darAtraccionporId = function(id){
            atraccionClient.getAtraccion(cambiarEstado,id);

        }


        var cambiarEstado =function(atraccion){
            var estadoact = atraccion.activo;
            if (estadoact){
                atraccion.activo=false;
            } 
            else{
                atraccion.activo=true;
            }

            atraccionClient.changeState(atraccion);
        }
        
        
       var  imprimirAtracciones= function(atracciones,tipo){
                   if (tipo=="Editar"){
                       
                       var boton = " <a href=\"\" class=\"button\">"+tipo+"</a></div>"; 
                       if(atracciones){}
                       else{}
                   }
                else{
                    
                    var boton = " <a href=\"\" class=\"button\">"+tipo+"</a></div>"; 
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
                            var activo="<span style=\"color:green;font-weight:bold\">Abierta</span></br>";
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
            
            
    
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                
                stompClient.subscribe('/atraccion/estado', function (eventbody) {

                    
                    
                });
                
                
            });
    
        };
	
	return {
		mostrarAtracciones: mostrarAtracciones,
                imprimirAtracciones: imprimirAtracciones,
                mostrarAtraccionesCliente: mostrarAtraccionesCliente,
                darAtraccionporId: darAtraccionporId
	};
})();

