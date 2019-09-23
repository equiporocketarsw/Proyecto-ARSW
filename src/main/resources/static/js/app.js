var Module =( function (){
	var c=0;
	var sumaDePuntos = function(total,num){
		return total+num;
	};
	
	var mapeador = function(plano){
		if(plano){
				
				
				$("#BP tbody").empty();
				
                var objetos = plano.map(function (plane){
					
					return {"name":plane.name,"n_points":plane.points.length}
				}
				)
				
				var numberpoints = objetos.map(function (plano){
					return plano.n_points;
					
				}
				)
				
				document.getElementById("userPoints").innerHTML = numberpoints.reduce(sumaDePuntos);
				
				
				objetos.map(function (obj){
					var name = obj.name;
					var numpoints = obj.n_points;
					var fila = "<tr><td>" + name + "</td><td>" + numpoints + "</td></tr>";
					$("#BP tbody").append(fila);
				})
            }
	};
	
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
		newInput: newInput
	};
})();