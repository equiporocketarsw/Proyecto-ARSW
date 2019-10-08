tiqueteClient= (function(){
    return {

        saveTiquete: function(tiquete){

            $.ajax({
                url: "http://localhost:8080/tiquete/" ,
                type: "POST",
                data: JSON.stringify(tiquete),
                contentType: "application/json",
                success: function() {
                  alert("Tiquete añadido satisfactoriamente");
                   location.href = "/index.html";
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Error: Nombre de usuario ya tomado"); 
                }
            });
        },

        getTiquetes: function(callback){
            jQuery.ajax({
                url: "tiquete/",
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error obteniendo tiquete");
                     
                } ,
                async: true
            });
        }
    };
})();

