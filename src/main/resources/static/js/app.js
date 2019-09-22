var Module =( function (){
	
	var sumaDePuntos = function(total,num){
		return total+num;
	}
	
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
	
	var porAutor = function(){
			author = document.getElementById("author").value;
			document.getElementById("bpname").innerHTML = author;
			apimock.getBlueprintsByAuthor(author,mapeador);
		};
	
	return {
		porAutor: porAutor
	};
})();