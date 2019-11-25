colaClient= (function(){
    return {

        saveCola: function(cola){

            $.ajax({
                url: "cola/" ,
                type: "POST",
                data: JSON.stringify(cola),
                contentType: "application/json",
                success: function() {
                   
                   location.href = "/main.html";
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Error al entrar a la cola"+textStatus+" "+ errorThrown); 
                }
            });
        },

        getColasByUsuario: function(username,callback){
            jQuery.ajax({
                url: "cola/usuario/" + username ,
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Usuario no encontrado");
                     
                } ,
                async: true
            });
        },

        getColasByAtraccion: function(atraccion,activo,boton,callback){
            jQuery.ajax({
                url: "cola/atraccion/" + atraccion.id ,
                success: function(result) {
                    callback(atraccion,result,activo,boton);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Atraccion no encontrada");
                     
                } ,
                async: true
            });
        },
        getcolasByAtraccionAndUser: function(atraccion,username,callback){
            jQuery.ajax({
                url: "cola/atraccion/" + atraccion +"/usuario/"+username,
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Usuario no encontrado");
                     
                } ,
                async: true
            });
        }


    };
})();