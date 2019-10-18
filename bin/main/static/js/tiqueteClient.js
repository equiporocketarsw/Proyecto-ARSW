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

                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Error: Tiquete ya tomado"); 
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
                     alert("El tiquete no esta resgitrado");
                     
                } ,
                async: true
            });
        },
        
        getTiquete: function(callback,idTiq){
            jQuery.ajax({
                url: "tiquete/"+idTiq,
                success: function(result) {
                  callback(result);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Error obteniendo tiquete");
                     
                } ,
                async: true
            });
        },
        
        asignarTiqueteaUsuario: function(tiquete){

            $.ajax({
                url: "http://localhost:8080/tiquete/"+tiquete.id,
                type: "PUT",
                data: JSON.stringify(tiquete),
                contentType: "application/json",
                success: function() {

                   location.href = "/main.html";
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Error al asignar"); 
                }
            });
        },

        crearTiquete: function(tiquete){

            var postTiquete =$.ajax({
                url: "http://localhost:8080/tiquete/",
                type: "POST",
                data: JSON.stringify(tiquete),
                contentType: "application/json",
                
            });

            postTiquete.then(
                function () {
                    console.info("OK");
                },
                function () {
                    alert("ERROR");
                }

        );
                return postTiquete;
        }
        
    };
})();

