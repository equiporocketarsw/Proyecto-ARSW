var tiqueteApp =( function (){
	
    var c=0;

        var  numerodeTiquetes= function(){

            
            tiqueteClient.getTiquetes(imprimirnumTiquetes);
        }
        
        var changeDisplay = function(){
            var idSearch = document.getElementById("idSearch").checked;

            var input = document.getElementById("idABuscar");


            var userSearch = document.getElementById("userSearch").checked;

            var input1 = document.getElementById("userAsign");

            var flitrotext = document.getElementById("filtros");
            var flitro1 = document.getElementById("fecha");
            var flitro2 = document.getElementById("tipo");
            var flitro3 = document.getElementById("Valido");
            var user = document.getElementById("userABuscar");


            if (idSearch){
                input.style.display = "block";
                input1.style.display = "none";

                flitrotext.style.display = "none";
                flitro1.style.display = "none";
                flitro2.style.display = "none";
                flitro3.style.display = "none";
                user.style.display = "none";


            }
            else if (userSearch){
                document.getElementById("userAsign").value="";

                input.style.display = "none";
                input1.style.display = "block";

                flitrotext.style.display = "block";
                flitro1.style.display = "block";
                flitro2.style.display = "block";
                flitro3.style.display = "block";

            }
        }

        var oneUser = function(){
            var seleccion = document.getElementById("userAsign").value;

            var input = document.getElementById("userABuscar");
            
            if (seleccion=="One"){
                input.style.display = "block";
            }
            else{
                input.style.display = "none";
            }
        }


        var mostrarfecha = function(){
            var fechacheck = document.getElementById("fechacheck").checked;
            var input = document.getElementById("fechaOpt");

            if (fechacheck){
                input.style.display = "block";
            }
            else{
                input.style.display = "none";
            }
        }

        var mostrartipos = function(){
            var tipocheck = document.getElementById("tipocheck").checked;
            var input = document.getElementById("tipoOpt");

            if (tipocheck){
                input.style.display = "block";
            }
            else{
                input.style.display = "none";
            }
        }

        var mostrarvalidos = function(){
            var validocheck = document.getElementById("validocheck").checked;
            var input = document.getElementById("ValidoOpt");

            if (validocheck){
                input.style.display = "block";
            }
            else{
                input.style.display = "none";
            }
        }

        var imprimirtiquete = function(tiquete){
            $("#keywords tbody tr").remove(); 
             
            var contenedor = "<tr><td class=\"lalign\">"+tiquete.id+"</td>  <td>"+ tiquete.tipo+"</td>  <td>"+ tiquete.fecha+"</td>  <td>"+ tiquete.valido+"</td> <td>"+ tiquete.usuario+"</td> </tr>";

            $("#keywords tbody").append(contenedor);
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

            var idSearch = document.getElementById("idSearch").checked;

            var userSearch = document.getElementById("userSearch").checked;

            if(idSearch){
                var ID = $('#idABuscar').val();
                tiqueteClient.getTiquete(imprimirtiquete,ID);
            }
            else if(userSearch){
                var seleccion = document.getElementById("userAsign").value;
                var user = null;
                if (seleccion=="All"){
                    user="anybody";
                }else if(seleccion=="One"){
                    user = $('#userABuscar').val();
                }else if(seleccion=="None"){
                    user="none";
                }
                    
                tiqueteClient.getTiquetesbyuser(imprimirTiquetes,user);
            }
            else {
                tiqueteClient.getTiquetesbyuser(imprimirTiquetes,"none");
            }
        

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
                AgregarTiquetes: AgregarTiquetes,
                changeDisplay: changeDisplay,
                oneUser: oneUser,
                mostrarfecha: mostrarfecha,
                mostrartipos: mostrartipos,
                mostrarvalidos: mostrarvalidos,
                imprimirtiquete: imprimirtiquete
	};
})();


