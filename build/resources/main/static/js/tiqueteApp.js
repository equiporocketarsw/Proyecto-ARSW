var tiqueteApp =( function (){
	
    

        var  numerodeTiquetes= function(){

            
            tiqueteClient.getTiquetes(imprimirnumTiquetes);
        }
        
        var  imprimirnumTiquetes= function(tiquetes){
            var contador=0;
            tiquetes.map(function(tiquete){
                var currentUser = sessionStorage.getItem('currentUser');
                var ticketUser = tiquete.usuario;
                
                if (currentUser==ticketUser){
                    contador=contador+1;
                }
                
            })
            document.getElementById('numtiquetes').innerHTML = contador;
            document.getElementById('currentUser').innerHTML = sessionStorage.getItem('currentUser');
        
    }

	
         var  mostrarTiquetes= function(){

            
            tiqueteClient.getTiquetes(imprimirTiquetes);
        }
        
       var  imprimirTiquetes= function(tiquetes){
           $("#keywords tbody tr").remove(); 
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
            if (tiquete.usuario==null){
                if(tiquete.valido){
                    var user = sessionStorage.getItem('currentUser');

                    tiquete.usuario=user;
                    tiqueteClient.asignarTiqueteaUsuario(tiquete);
                }else{
                    alert("El tiquete "+tiquete.id+" no es valido");
                }
                
            }
            else{
                alert("El tiquete "+tiquete.id+" ya esta asignado");
                
            }
        }

        
        var AgregarTiquetes = function(){
            
            var numero = null;
            var tipo = null;
            numero = $('#numeroTiquetes').val();
            tipo = $('#TipoTiquetes').val();
            for (var i=0; i<numero; i++){
                var tiquete = {"id":null,"tipo":tipo,"fecha":null,"valido":true,"usuario":null};
                tiqueteClient.crearTiquete(tiquete).then(mostrarTiquetes);
            }
            
        }
        
	

	
	return {
		mostrarTiquetes: mostrarTiquetes,
                imprimirTiquetes: imprimirTiquetes,
                asignarTiquetes: asignarTiquetes,
                numerodeTiquetes: numerodeTiquetes,
                AgregarTiquetes: AgregarTiquetes
	};
})();


