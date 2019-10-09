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
        
        
        var asignarTiquetes = function(){
            var numT = Module.getC();

            for (var i = 0; i < numT; i++) {
                   var idTiq = $('#input_'+i).val();
                   tiqueteClient.getTiquete(asignarAUsuario,idTiq);
                
              };    
        }
        
        var asignarAUsuario = function(tiquete){
            
            var user = localStorage.getItem('currentUser');
         
            tiquete.usuario=user;
            tiqueteClient.asignarTiqueteaUsuario(tiquete);
        }

        /*
        var AgregarTiquetes = function(){
            var numero = null;
            var tipo = null;
            numero = document.getElementByName("numeroTiquetes").val;
            tipo = document.getElementByName("TipoTiquetes").val;
            for (var i=0; i<numero; i++){
                tiqueteClient.crearTiquete(tipo);
            }
        }*/
        
	

	
	return {
		mostrarTiquetes: mostrarTiquetes,
                imprimirTiquetes: imprimirTiquetes,
                asignarTiquetes: asignarTiquetes
	};
})();


