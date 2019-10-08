var tiqueteApp =( function (){
	
	
	
         var  mostrarTiquetes= function(){

            
            tiqueteClient.getTiquetes(imprimirTiquetes);
        }
        
       var  imprimirTiquetes= function(tiquetes){
                tiquetes.map(function(tiquete){
                    var contenedor = "<tr><td class=\"lalign\">"+tiquete.id+"</td>  <td>"+ tiquete.tipo+"</td>  <td>"+ tiquete.fecha+"</td>  <td>"+ tiquete.valido+"</td> <td>"+ tiquete.usuario+"</td> </tr>";
                                           
                                            
			
		
                           
                    $("#keywords tbody").append(contenedor);

                })
            
        }
        
	

	
	return {
		mostrarTiquetes: mostrarTiquetes,
                imprimirTiquetes: imprimirTiquetes
	};
})();


