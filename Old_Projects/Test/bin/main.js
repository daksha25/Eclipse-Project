/**
 * http://usejsdoc.org/
 */
var http = require("http");
var heading= document.
http.createServer(function (request, response) {

   response.writeHead(200, {'Content-Type': 'text/plain'});

   response.redirect("http://www.nodeclipse.org/")
   response.end('Hello World\n');

}).listen(9090);

console.log('Server running');
