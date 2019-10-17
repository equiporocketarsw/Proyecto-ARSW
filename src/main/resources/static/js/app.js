var Module =( function (){
	
	var c=1;
        var nombreUsuario = ""; 
	
         var  checkPassword= function(){
            var username = $('#username').val();
            apiClient.checkPassword(username,validarCuenta);
        }
        
        var addAcount = function(){
            var name = $('#name').val();
            var password = $('#newpsw').val();
            var passwordtwo = $('#newconpsw').val();  
            
            if (password == passwordtwo){
                var hash=CryptoJS.SHA256(password);

                var user = {"username":name,"rol":"Cliente","contrasena":hash.toString()};
                apiClient.saveCuenta(user);

               
            }
            else{
                alert("Las contraseÃ±as no coinciden");
            }
            
        }
        
        var validarCuenta = function(username){
            var password = $('#psw').val();
            var hash = CryptoJS.SHA256(password); 
            

            sessionStorage.setItem("currentUser",username.username);
            sessionStorage.setItem("currentRol",username.rol);
            
            
            if (username.contrasena == hash){
                
                if(username.rol === "Admin"){
                    
                    location.href = "/adminMain.html"
                }
                else{
                    
                    location.href = "/ingresarTiquete.html"
                }
                
            }
            else {
                alert("ContraseÃ±a incorrecta");
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
    

    var deleteInput = function(){

        if (c==1){
            alert("Debe de haber al menos un tiquete");
        }
        else{
            var inpt = document.getElementById("input_"+(c-1));
            inpt.remove();
            c=c-1;
        }
    };
	
        var validarUsuario = function(){
            var user = sessionStorage.getItem('currentUser');
            
            if (user==null){
                location.href = "/index.html";
            }
               
        }
        
        
        var validarAdmin = function(){
            var user = sessionStorage.getItem('currentUser');
            var rol = sessionStorage.getItem('currentRol');
            
            if (rol!="Admin" && user!=null ){
                location.href = "/main.html";
            }
               
        }
        
        var validarCliente = function(){
            var user = sessionStorage.getItem('currentUser');
            var rol = sessionStorage.getItem('currentRol');
            
            if (rol!="Cliente" && user!=null){
                location.href = "/adminMain.html";
            }
               
        }
        
        var getC = function ()
	{

		return c;

	};
        
    var cerrarSesion = function(){
        sessionStorage.setItem("currentUser",null);
        sessionStorage.setItem("currentRol",null);
        location.href = "/index.html";

    }
	
	return {
		newInput: newInput,
                checkPassword: checkPassword,
                addAcount: addAcount,
                validarUsuario: validarUsuario,
                getC: getC,
                validarCliente: validarCliente,
                validarAdmin: validarAdmin,
                deleteInput: deleteInput,
                cerrarSesion: cerrarSesion
	};
})();