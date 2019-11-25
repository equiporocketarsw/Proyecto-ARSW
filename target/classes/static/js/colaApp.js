var colaApp =( function (){
    
    var atraccion ;
    var numTiquetesUsados;    
    var user;

	var addCola = function(){
        user = sessionStorage.getItem('currentUser');
        atraccion = sessionStorage.getItem('atraccion');
        colaClient.getcolasByAtraccionAndUser(atraccion,user,añadirCola);
        
    }

    var añadirCola=function(tiquetes){
        numTiquetesUsados=tiquetes.length;
        tiqueteClient.getTiquetesbyuser(añadirAlaCola,user);
    }

   
    var añadirAlaCola=function(tiquetes){
        var numTiquetes= document.getElementById('numtiquetes').innerHTML;
        
 
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
                    alert(i); 
                    var cola={"atraccion":parseInt(atraccion),"tiquete":tiquetes[i].id};
                    alert(JSON.stringify(cola));
                    colaClient.saveCola(cola);
                }
                alert(cantidadAIngresar+" personas mas dentro de la cola");
            }
        
        }
        else{
            alert("Numero de personas no valido");
        }

    }
	
	return {
        addCola: addCola,
        añadirAlaCola: añadirAlaCola,
        añadirCola: añadirCola
                
	};
})();