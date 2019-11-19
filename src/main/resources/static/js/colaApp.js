var colaApp =( function (){
    
    

	var addCola = function(){
        var user = sessionStorage.getItem('currentUser');
        
        tiqueteClient.getTiquetesbyuser(añadirAlaCola,user);
        
    }
   
    var añadirAlaCola=function(tiquetes){
        var tiqDisponibles=tiquetes.length;
        var atraccion = sessionStorage.getItem('Objetoatraccion');
        var cantidadAIngresar = $('#cantidad').val();
        if (cantidadAIngresar>tiqDisponibles){
            alert("Cantidad de tiquetes ingresados no es suficiente para que esa cantidad de personas hagan fila");

        }
        else{
            tiquetes.map(function(tiquete){
                var cola={"atraccion":atraccion,"tiquete":tiquete}
                colaClient.saveCola(cola);
            })

        }
        
        

    }
	
	return {
        addCola: addCola,
        añadirAlaCola: añadirAlaCola
                
	};
})();