var colaApp =( function (){
	
	var addCola = function(){
        var user = sessionStorage.getItem('currentUser');
        tiqueteClient.getTiquetesbyuser(añadirAlaCola,user);
        
    }
   
    var añadirAlaCola=function(tiquetes){
        alert(tiquetes.length);

    }
	
	return {
        addCola: addCola,
        añadirAlaCola: añadirAlaCola
                
	};
})();