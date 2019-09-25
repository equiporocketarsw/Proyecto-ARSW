var apimock = (function () {

    var mockdata=[];
    mockdata["santiago"]=[{"author":"santiago","points":[{"x":0,"y":0},{"x":20,"y":0},{"x":20,"y":20},{"x":0,"y":20}],"name":"cuadrado"},{"author":"Santiago","points":[{"x":10,"y":10},{"x":20,"y":20},{"x":30,"y":30}],"name":"recta"}];
    mockdata["andres"]=[{"author":"andres","points":[{"x":14,"y":14},{"x":15,"y":15}],"name":"linea"}];
    mockdata["mateo"]=[{"author":"mateo","points":[{"x":4,"y":4},{"x":7,"y":6},{"x":11,"y":15},{"x":9,"y":10}],"name":"pintura"},];
	mockdata["david"]=[{"author":"david","points":[{"x":0,"y":0},{"x":30,"y":0},{"x":15,"y":25}],"name":"triangulo"},];
	
    return {
      getBlueprintsByAuthor: function (author, callback) {
        callback(
            mockdata[author]
        );
      }
    };
  
  })();