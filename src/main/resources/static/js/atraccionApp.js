var atraccionApp =( function (){
	
	
	
         var  mostrarAtracciones= function(){

            
            atraccionClient.getAtracciones(imprimirAtracciones);
        }
        
       var  imprimirAtracciones= function(atracciones){
                atracciones.map(function(atraccion){
                    var contenedor = "<div class=\"grid-1-5\"><h3><span class=\"uppercase\">"+atraccion.nombre+"</span></h3> <p>"+atraccion.descripcion+"</p><ul><li> Capacidad "+atraccion.capacidad+" personas</li><li> Duracion atraccion: "+atraccion.tiempo+" minutos</li></ul><a href=\"\" class=\"button\">Editar</a></div>"
                           
                    $("#tablaAtracciones").append(contenedor);

                })
            
        }
        
	

	
	return {
		mostrarAtracciones: mostrarAtracciones,
                imprimirAtracciones: imprimirAtracciones
	};
})();

