var Module =( function (){
	
	
	
         var  checkPassword= function(){
            var username = $('#username').val();
            apiClient.checkPassword(username,validarCuenta);
        }
        /*
        var addAcount = function(){
            var correo = $('#nick').val();
            var nick = $('#nick').val();
            var password = $('#nick').val();        
        }
        */
        var validarCuenta = function(username){
            var password = $('#psw').val();
            console.log(password + " username"+ username)
            if (username.contrasena === password){
                console.log(password + " "+ cuenta[0]);
                if(username.rol === "Admin"){
                    
                    location.href = "/adminMain.html"
                }
                else{
                    
                    location.href = "/main.html"
                }
                
              
            }
            else {
                alert("Incorrect password");
            }
        }
	
	var newInput = function ()
	{
		var inpt = document.createElement("input");
		inpt.type="number";
		inpt.name="ticket_"+c;
		inpt.id="input_"+c;
		inpt.placeholder="Ticket Number";
		c+=1;
		
		
		var formulario = document.getElementById("IngresoDeTiquetes");
		var boton = document.getElementById("boton");
		formulario.insertBefore(inpt,boton);

	};
	

	
	return {
		newInput: newInput,
                checkPassword: checkPassword
	};
})();