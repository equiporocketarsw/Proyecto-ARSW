var colaApp =( function (){
    
    

	var addCola = function(){
        var user = sessionStorage.getItem('currentUser');
        tiqueteClient.getTiquetesbyuser(añadirAlaCola,user);
        
    }
   
    var añadirAlaCola=function(tiquetes){
        var tiqDisponibles=tiquetes.length;
        var cantidadAIngresar = $('#cantidad').val();
        for (var i=0; i<cantidadAIngresar;i++){
            
        }
        

    }
	
	return {
        addCola: addCola,
        añadirAlaCola: añadirAlaCola
                
	};
})();