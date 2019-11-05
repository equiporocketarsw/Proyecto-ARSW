atraccionClient= (function(){
    return {

        saveAtraccion: function(atraccion){

            $.ajax({
                url: "atraccion/" ,
                type: "POST",
                data: JSON.stringify(atraccion),
                contentType: "application/json",
                success: function() {
                  alert("Atraccion "+atraccion.nombre+" creado satisfactoriamente");
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
        },

        getAtraccion: function(callback,id,tipo){
            jQuery.ajax({
                url: "atraccion/"+id,
                success: function(result) {
                  callback(result,tipo);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error obteniendo atraccion");
                     
                } ,
                async: true
            });
        },

        changeState: function(atraccion){

            $.ajax({
                url: "atraccion/"+atraccion.id,
                type: "PUT",
                data: JSON.stringify(atraccion),
                contentType: "application/json",
                success: function() {

                   
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Error al cambiars"); 
                }
            });
        }
    };
})();
