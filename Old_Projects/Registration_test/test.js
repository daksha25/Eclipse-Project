/**
 * http://usejsdoc.org/
 */
var express = require('express');
var app = express();
var http = require('http');
var fs = require('fs');
var bodyParser = require('body-parser');

//var server = http.createServer(function (req, res) {displayForm(res);});

var HOST = 'localhost';
var PORT = 1443
var MYSQL_USER = 'root';
var MYSQL_PASS = 'daksha25*';
var DATABASE = 'registration';
var TABLE = 'form1'; 

var mysql      = require('mysql');
var connection = mysql.createConnection({
   host     : HOST,
   user     : MYSQL_USER,
   password : MYSQL_PASS,
   port		: PORT,
   database : DATABASE });



connection.connect(function(error) {
	  if (error) throw error
	  console.log('You are now connected...');
})
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true })); 
app.get('/',function(req,res,next){
    res.sendfile('registration.html');
});

app.post('/', function(req, res) {
  
    console.log(req.body);
    res.write('You sent the Name "' + req.body.Name+ '".\n');
    res.write('You sent the Email "' + req.body.Email+ '".\n');
    res.write('You sent the Location "' + req.body.Location+ '".\n');
    res.end();
    connection.query('use '+ DATABASE);
    connection.query('Insert into ' + TABLE + '(Name, Email, Location) VALUES ("' + req.body.Name + '", "' + req.body.Email + '","' + req.body.Location + '")',function (err,result,fields)
    {

        if (err)
            throw err;
        else
        	res.send('success');

    });
});
app.listen(9008);
console.log('Example app listening at port:9008');


              

