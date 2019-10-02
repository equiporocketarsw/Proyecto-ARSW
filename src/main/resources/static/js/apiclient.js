apiClient= (function(){
    return {

        /*saveCuenta: function(cuenta){
            $.ajax({
                url: "cuentas/" + cuenta ,
                type: "POST",
                data: cuenta,
                contentType: "application/json"
            });
        },
*/
        checkPassword: function(username,callback){
            jQuery.ajax({
                url: "cuentas/" + username ,
                success: function(result) {
                    console.log(result);
                  callback(result);
                },
                async: true
            });
        }
    };
})();