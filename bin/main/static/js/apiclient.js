apiClient= (function(){
    return {

        saveCuenta: function(usuario){

            $.ajax({
                url: "usuario/" ,
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

        checkPassword: function(username,callback){
            jQuery.ajax({
                url: "usuario/" + username ,
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