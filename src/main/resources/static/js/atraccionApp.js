var atraccionApp =( function (){
	
	
	
         var  mostrarAtracciones= function(){

            
            atraccionClient.getAtracciones(imprimirAtracciones);
        }
        
       var  imprimirAtracciones= function(atracciones){
                atracciones.map(function(atraccion){
                    var contenedor = "<div class=\"grid-1-5\"><h2>"+atraccion.tipo+"</h2><h3><span class=\"uppercase\">"+atraccion.nombre+"</span></h3> <p>Capacidad: "+atraccion.capacidad+"</p>    <p>Estatura minima: "+atraccion.estaturamin+"</p>   <p>Estatura maxima: "+atraccion.estaturamax+"</p>  <p>"+atraccion.descrpcion+"</p>  <a href=\"\" class=\"button\">Editar</a></div>";
			
			
			
                           
                    $("#tablaAtracciones").append(contenedor);

                })
            
        }
        
	

	
	return {
		mostrarAtracciones: mostrarAtracciones,
                imprimirAtracciones: imprimirAtracciones
	};
})();

