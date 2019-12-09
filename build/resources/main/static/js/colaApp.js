var colaApp =( function (){
    
    var atraccion ;
    var numTiquetesUsados;    
    var user;
    var estado;
    var stompClient= null;

	var addCola = function(){
        sessionStorage.setItem("fila",null);
        user = sessionStorage.getItem('currentUser');
        atraccion = sessionStorage.getItem('atraccion');
        colaClient.getcolasByAtraccionAndUser(atraccion,user,añadirCola);
        
    }

    var añadirCola=function(tiquetes){
        numTiquetesUsados=tiquetes.length;
        tiqueteClient.getTiquetesbyuser(añadirAlaCola,user);
    }

   
    var añadirAlaCola=function(tiquetes){
        var numTiquetes=parseInt( document.getElementById('numtiquetes').innerHTML);
        
 
        var cantidadAIngresar = $('#cantidad').val();
        var cantidadDisponible = numTiquetes - numTiquetesUsados;
        if (cantidadAIngresar>0){
            if (cantidadAIngresar>numTiquetes){
                alert("Solo tiene disponibles por el momento "+ cantidadDisponible +" espacios para la fila");

            }
            else if (cantidadAIngresar>cantidadDisponible){
                alert("Ya hay "+numTiquetesUsados+" personas haciendo fila, solo tiene disponibles "+ cantidadDisponible +" espacios para la fila");
            }
            else{

                for (var i=numTiquetes-cantidadDisponible;i<=(numTiquetes-cantidadDisponible)+(cantidadAIngresar-1);i++){

                    var cola={"atraccion":parseInt(atraccion),"tiquete":tiquetes[i].id};

                    colaClient.saveCola(cola);
                }
                stompClient.send('/atraccion/cola/estadoAdmin', {}, JSON.stringify(tiquetes));
                stompClient.send('/atraccion/cola/estadoCliente', {}, JSON.stringify(tiquetes));
                stompClient.send('/atraccion/cola/estadoFilas', {}, JSON.stringify(tiquetes));
                alert(cantidadAIngresar+" personas mas dentro de la cola");
                
            }
        
        }
        else{
            alert("Numero de personas no valido");
        }

    }

    var connectAndSubscribe = function () {

        es = sessionStorage.getItem('estadoFilas');
        if (es=="yes"){

            estado="Filas";
        }
        else{
            estado=sessionStorage.getItem('currentRol'); 
        }
        

        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        
        stompClient = Stomp.over(socket);
        
        

        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);

            stompClient.subscribe('/atraccion/cola/estado'+estado, function (eventbody) {

                if (estado=="Admin"){

                    atraccionApp.mostrarAtracciones();
                }
                else if (estado=="Cliente"){

                    atraccionApp.mostrarAtraccionesCliente();
                }
                else if (estado=="Filas"){
                    atraccionApp.mostrarAtraccionesFilas();
                }
                
                
            });
            
            
        });

    };
	
	return {
        addCola: addCola,
        añadirAlaCola: añadirAlaCola,
        añadirCola: añadirCola,
        connectAndSubscribe: connectAndSubscribe
                
	};
})();