var colaApp =( function (){
	
	var addCola = function(){
        var user = sessionStorage.getItem('currentUser');
        tiqueteClient.getTiquetesbyuser(añadirAlaCola,user);
        
    }
   
    var añadirAlaCola=function(tiquetes){
        var tiqDisponibles=tiquetes.length;
        var name = $('#cantidad').val();

        

    }
	
	return {
        addCola: addCola,
        añadirAlaCola: añadirAlaCola
                
	};
})();