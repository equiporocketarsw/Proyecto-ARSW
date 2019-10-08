atraccionClient= (function(){
    return {

        saveAtraccion: function(usuario){

            $.ajax({
                url: "http://localhost:8080/atraccion/" ,
                type: "POST",
                data: JSON.stringify(usuario),
                contentType: "application/json",
                success: function() {
                  alert("Usuario "+usuario.username+" creado satisfactoriamente");
                   location.href = "/index.html";
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Error: Nombre de usuario ya tomado"); 
                }
            });
        },

        getAtracciones: function(callback,tipo){
            jQuery.ajax({
                url: "atraccion/",
                success: function(result) {
                  callback(result,tipo);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error obteniendo atracciones");
                     
                } ,
                async: true
            });
        }
    };
})();
