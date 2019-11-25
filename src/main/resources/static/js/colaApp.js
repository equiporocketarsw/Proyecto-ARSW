var colaApp =( function (){
    
    var atraccion ;
    

	var addCola = function(){
        var user = sessionStorage.getItem('currentUser');
        atraccion = sessionStorage.getItem('atraccion');
        colaClient.getcolasByAtraccionAndUser(atraccion,user,añadirAlaCola);
        
    }
   
    var añadirAlaCola=function(tiquetes){
        var numTiquetes= document.getElementById('numtiquetes').innerHTML;
        
        var atraccion = sessionStorage.getItem('atraccion');
        var cantidadAIngresar = $('#cantidad').val();
        var cantidadDisponible = numTiquetes - tiquetes.length;
        alert("Empieza en "+(numTiquetes-cantidadDisponible));
        alert ("Termina en "+ ((numTiquetes-cantidadDisponible)+(cantidadAIngresar-1)) );
        if (cantidadAIngresar>0){
            if (cantidadAIngresar>numTiquetes){
                alert("Solo tiene disponibles por el momento"+ cantidadDisponible +" espacios para la fila");

            }
            else if (cantidadAIngresar>cantidadDisponible){
                alert("Ya hay "+tiquetes.length+" personas haciendo fila, solo tiene disponibles "+ cantidadDisponible +" espacios para la fila");
            }
            else{
                for (var i=numTiquetes-cantidadDisponible;i<(numTiquetes-cantidadDisponible)+(cantidadAIngresar-1);i++){
                    var cola={"atraccion":parseInt(atraccion),"tiquete":tiquetes[i].id};
                    
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
        añadirAlaCola: añadirAlaCola
                
	};
})();