colaClient= (function(){
    return {

        saveCola: function(cola){

            $.ajax({
                url: "cola/" ,
                type: "POST",
                data: JSON.stringify(cola),
                contentType: "application/json",
                success: function() {
                  alert("Cola del tiquete "+cola.tiquete+" en la fila "+ cola.atraccion+"creado satisfactoriamente");
                   location.href = "/main.html";
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Error al entrar a la cola"); 
                }
            });
        },

        getColasByUsuario: function(username,callback){
            jQuery.ajax({
                url: "cola/usuario" + username ,
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