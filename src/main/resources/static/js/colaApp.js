var colaApp =( function (){
    
    

	var addCola = function(){
        var user = sessionStorage.getItem('currentUser');
        
        tiqueteClient.getTiquetesbyuser(añadirAlaCola,user);
        
    }
   
    var añadirAlaCola=function(tiquetes){
        var tiqDisponibles=tiquetes.length;
        var atraccion = sessionStorage.getItem('atraccion');
        var cantidadAIngresar = $('#cantidad').val();
        if (cantidadAIngresar>tiqDisponibles){
            alert("Cantidad de tiquetes ingresados no es suficiente para que esa cantidad de personas hagan fila");

        }
        else{
            for (var i=0;i<cantidadAIngresar;i++){
                var cola={"atraccion":atraccion,"tiquete":tiquetes[i].id}
                alert(cola);
                colaClient.saveCola(cola);
            }


        }
        
        

    }
	
	return {
        addCola: addCola,
        añadirAlaCola: añadirAlaCola
                
	};
})();