var Module =( function (){
	
	
	
         var  checkPassword= function(){
            var username = $('#username').val();
            apiClient.checkPassword(username,validarCuenta);
        }
        
        var addAcount = function(){
            var name = $('#name').val();
            var password = $('#newpsw').val();
            var passwordtwo = $('#newconpsw').val();  
            
            if (password == passwordtwo){
                var user = {"username":name,"rol":"Cliente","contrasena":password}
                apiClient.saveCuenta(user);
            }
            else{
                alert("Las contraseñas no coinciden");
            }
            
        }
        
        var validarCuenta = function(username){
            var password = $('#psw').val();
            var hash = CryptoJS.SHA256(password);           
            if (username.contrasena == hash){
                
                if(username.rol === "Admin"){
                    
                    location.href = "/adminMain.html"
                }
                else{
                    
                    location.href = "/ingresarTiquete.html"
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
                checkPassword: checkPassword,
                addAcount: addAcount
	};
})();