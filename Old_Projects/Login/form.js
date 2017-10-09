var express = require('express');
var app = express();
var ejs = require('ejs');
var mysql = require('mysql');
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true })); 
var HOST = 'localhost';
var PORT = 1443
var MYSQL_USER = 'root';
var MYSQL_PASS = 'daksha25*';
var DATABASE = 'Login';
var TABLE = 'info'; 
///////////////

var router = express.Router();

//////////////////
var mysql = mysql.createConnection({
host: HOST,
port: PORT,
user: MYSQL_USER,
password: MYSQL_PASS,
});
mysql.connect(function(error) {
	  if (error) throw error
	  console.log('You are now connected...');
})
app.get('/',function(req,res,next){
res.sendfile('reg.html');
});

///////////

router.get('/', function(req, res, next) {
	mysql.query( "SELECT * FROM info", function(err, row, fields) {
	    if (err) throw err;
	    else {
	      // We got a result: render it
	      console.log(row);
	      res.render("index", { title:'Mysql Data Fetch',userresults: row});
	    }
	  });
	});
	module.exports = router;

/////////


app.post('/myaction', function(req, res) {
console.log('req.body');
console.log(req.body);
res.write('You sent the name "' + req.body.name+'".\n');
res.write('You sent the Email "' + req.body.email+'".\n');
res.write('You sent the City "' + req.body.city+'".\n');
res.write('You sent the Pincode "' + req.body.pincode+'".\n');
res.end()
mysql.query('use '+ DATABASE);
mysql.query("Insert into "+TABLE+" (name,email,city,pincode) VALUES ('"+req.body.name+"','"+req.body.email+"','"+req.body.city+"','"+req.body.pincode+"')",function(err, result)      
{                                                      
  if (err)
     throw err;
});
});
/*mysql.query('use '+ DATABASE);
mysql.query("DELETE FROM"+TABLE+" WHERE name = ?"+","+req.body.name+"')",function (err, result) {
  if (err) throw err;

  console.log('Deleted ' + result.affectedRows + ' rows');
}
);*/
app.listen(1881);
console.log('Example app listening at port:1881');