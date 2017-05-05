<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>LaLiga</title>
<link rel="shortcut icon" type="image/png" href="img\icono.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link href ="estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
<header id="main-header">
  
  <a id="logo-header" href="#">
    <span class="site-name">LaLiga</span>
    <span class="site-desc">Resultados | Calendario | Estadísticas</span>
  </a> <!-- / #logo-header -->

  <nav>
    <ul>
      <!-- Trigger the modal with a button -->
      <li><button type="button" class="btn btn-default" id="myBtn" onclick="login()">Iniciar Sesión</button></li>
    </ul>
  </nav><!-- / nav -->

</header><!-- / #main-header -->

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Iniciar Sesión</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        
        
        
          <form role="form" action="Iniciar" method="post" >
            <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-user"></span> Email</label>
              <input type="text" class="form-control" name="email" id="email" placeholder="Introduce un correo electrónico">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Contraseña</label>
              <input type="password" class="form-control" name="pass" id="psw" placeholder="Introduce Contraseña">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Recuérdame</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Iniciar Sesión</button>
          </form>
          
          
          
          
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
          <p>¿Aún no eres miembro? <a href="../jsp/registro.jsp">Regístrate</a></p>
          <p>He olvidado mi <a href="#">contraseña</a></p>
        </div>
      </div>
      
    </div>
  </div> 

<div class="container" style="margin-top: 120px;">
<ul class="nav nav-tabs">
<li class="active"><a href="#clasificacion" data-toggle="tab">Clasificación</a></li>
<li><a href="#reglamento" data-toggle="tab">Reglamento</a></li>
<li><a href="#estadisticas" data-toggle="tab">Estadísticas</a></li>
</ul>

<div class="tab-content">
<div class="tab-pane fade in active" id="clasificacion">
<h4>Clasificación</h4>
<table class="table table-striped">
    <thead>
      <tr>
      	<th>Equipo</th>
      	<th><img src="img\playstation.png"/> ID Online </th>
		<th> P.J</th>  
		<th>P.G</th>
		<th>P.E</th> 
		<th>P.P</th>   
        <th>G.F</th>
        <th>G.C</th>
        <th>Puntos</th>
      </tr>
    </thead>
    <tbody id="miTabla">
      <tr>
		<td>Real Madrid</td>      
        <td>Y5030</td>
        <td>3</td>
        <td>2</td>
        <td>1</td>
        <td>0</td>
        <td>10</td>
        <td>5</td>
        <td>7</td>
      </tr>
      <tr>
      	<td>Barça</td>    
        <td>Andrea</td>
        <td>3</td>
        <td>2</td>
        <td>1</td>
        <td>0</td>
        <td>10</td>
        <td>5</td>
        <td>7</td>
      </tr>
      <tr>
      	<td>Atletico de Madrid</td>    
        <td>StreetMagic19</td>
        <td>3</td>
        <td>2</td>
        <td>1</td>
        <td>0</td>
        <td>10</td>
        <td>5</td>
        <td>7</td>
      </tr>
    </tbody>
  </table>
</div>
<div class="tab-pane fade" id="reglamento">
	<h3 style="font-size: 40px;margin: 25px 0 25px;vertical-align: middle;">
	Reglamento
	</h3>
	<span class="info">
	<p><strong>REGLAMENTO ESPECIFICO FIFA 17 <br />
	REGLAMENTO Y PREFERENCIAS DEL JUEGO&nbsp;</strong></p>

	<p>Juego: FIFA 17<br />
	Modalidad: 1 vs 1<br />
	Formato del desaf&iacute;o: Liga</p>

	<p><strong>CREACI&Oacute;N DE DESAF&Iacute;OS&nbsp;</strong><br />
	Los partidos se deben jugar como partidos amistosos. Tendr&aacute;s que agregar a tu oponente como amigo para poder jugar el partido. Los desaf&iacute;os se deben crear con la siguiente configuraci&oacute;n.&nbsp;<br />
	Equipos: Cualquiera<br />
	Duraci&oacute;n: 6 minutos por parte.<br />
	Tipo de partida: Igualada</p>

	<p>
	<strong>Prohibiciones:&nbsp;</strong><br />
	Alineaci&oacute;n personalizada que tenga m&aacute;s de cinco o menos de tres jugadores por l&iacute;nea, en defensa o en el medio campo, en la delantera se pueden tener hasta 4 jugadores. Quedan excluidas de esta prohibici&oacute;n cualquier alineaci&oacute;n predefinida del juego, cumplan o no con esta norma, como por ejemplo la 5-2-2-1<br />
	Jugadores editados o personalizados. Los cambios en la alineaci&oacute;n los ten&eacute;is que hacer antes del comienzo del partido, las estad&iacute;sticas de los equipos no pueden estar modificadas antes del comienzo del partido.&nbsp;</p>

  <div class="container-fluid">
    <div class="row">
      <div class="col-md-3">
        <img src="img\523.png" class="img-responsive" alt="5-2-3">
      </div>
      <div class="col-md-3">
        <img src="img\532.png" class="img-responsive" alt="5-3-2">
      </div>
      <div class="col-md-3">
        <img src="img\541.png" class="img-responsive" alt="5-4-1">
      </div>
      <div class="col-md-3">
        <img src="img\5212.png" class="img-responsive" alt="5-2-1-2">
      </div>
    </div>
  </div>
<br/>
	<p><strong>FUNCIONAMIENTO DE LOS DESAF&Iacute;OS&nbsp;</strong><br />
	Preferencias:&nbsp;<br />
	Antes de empezar, tanto t&uacute; como tu rival deb&eacute;is aseguraros que todas las preferencias del juego est&aacute;n configuradas de acuerdo al reglamente de la Liga y a las condiciones que hab&iacute;ais acordado.</p>
	</span>
</div>

<div class="tab-pane fade" id="estadisticas">
<h4>Estadísticas</h4>
Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos saepe similique ratione, quo soluta assumenda explicabo animi asperiores ex possimus, debitis deserunt maiores illo repudiandae vitae perferendis, neque amet. Soluta!</div>
</div>

</div> 

<footer id="main-footer">
  <p>&copy; 2017 <a href="#">- YMC</a></p>
</footer>

</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>
</html>