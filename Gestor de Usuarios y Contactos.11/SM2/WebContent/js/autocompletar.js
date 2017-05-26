function busquedas_ajax(){

	this.ancla = 'buscador';
	this.respuesta   = '.sujerencia-response';
	this.input_top = '';
	this.input_left = '';
	this.form = document.getElementById("buscador");
}


busquedas_ajax.prototype.fijar_lugar = function(elem){
		var actual = this.ancla.val();
		var lugar = $(elem).html();
		this.ancla.val(lugar);
		this.cerrar();
}
busquedas_ajax.prototype.limpiar_sujerencia = function(elem){
		this.ancla.attr('placeholder','Poblacion');
}
busquedas_ajax.prototype.mostrar = function(){
		$(this.respuesta).addClass('sujerencia-on').removeClass('sujerencia-off');
}
busquedas_ajax.prototype.cerrar = function(){
		$(this.respuesta).addClass('sujerencia-off').removeClass('sujerencia-on');
}



busquedas_ajax.prototype.consultar = function(name,surname,empresa,telefono){

	var object = this;
	$.ajax({
		type:'get',
		url:'Buscadorcontacto',
		data:({	
			name:name,
			surname:surname,
			empresa:empresa,
			telefono:telefono
				}),
		success: function(response){
			$(object.respuesta).html(response);
			object.mostrar();
		}
	});	


}



busquedas_ajax.prototype.resetnotselectedinputs = function(selected){
	var string = $('input[name="'+selected+'"]').val();
	this.form.reset();
	$('input[name="'+selected+'"]').val(string);
}


busquedas_ajax.prototype.prepare = function() {

	var name 	= $('input[name="nombre"]').val();
	var surname = $('input[name="apellido"]').val();
	var empresa = $('input[name="empresa"]').val();
	var telefono = $('input[name="telefono"]').val();
	if(name.length > 2){	sujerencia.consultar(name,surname,empresa,telefono);}
	if(surname.length > 2){	sujerencia.consultar(name,surname,empresa,telefono);}
	if(empresa.length > 2){	sujerencia.consultar(name,surname,empresa,telefono);}
	if(telefono.length > 2){sujerencia.consultar(name,surname,empresa,telefono);}

	if(name.length == 0 && surname.length == 0 && empresa.length == 0 && telefono.length == 0){
		sujerencia.cerrar();
	}
}

busquedas_ajax.prototype.prepareUser = function() {

	var name 	= $('input[name="nombre"]').val();
	var email 	= $('input[name="email"]').val();
	var permiso = $('select[name="permiso"]').val();
	if(name.length > 2){	sujerencia.consultarUser(name,email,permiso);}
	if(email.length > 2){	sujerencia.consultarUser(name,email,permiso);}
	if(name.length == 0 && email.length == 0){sujerencia.cerrar();	}

}

busquedas_ajax.prototype.consultarUser = function(name,email,permiso){

	var object = this;
	$.ajax({
		type:'get',
		url:'Buscadorusuario',
		data:({	
			name:name,
			email:email,
			permiso:permiso
				}),
		success: function(response){
			$(object.respuesta).html(response);
			object.mostrar();
		}
	});	


}




	var sujerencia = new busquedas_ajax();

		//al escribir muestro
	$('#buscador input[name="nombre"]').bind('input',function(){	sujerencia.prepare(); });
	$('#buscador input[name="apellido"]').bind('input',function(){	sujerencia.prepare(); });
	$('#buscador input[name="empresa"]').bind('input',function(){	sujerencia.prepare(); }); 
	$('#buscador input[name="telefono"]').bind('input',function(){	sujerencia.prepare(); });	

	$('#buscador input[name="nombre"]').on('click',function(){	 	sujerencia.prepare(); });	
	$('#buscador input[name="apellido"]').on('click',function(){ 	sujerencia.prepare(); });
	$('#buscador input[name="empresa"]').on('click',function(){	 	sujerencia.prepare(); });
	$('#buscador input[name="telefono"]').on('click',function(){ 	sujerencia.prepare(); });

	$('#buscaruser input[name="nombre"]').bind('input',function(){	sujerencia.prepareUser(); });	
	$('#buscaruser input[name="email"]').bind('input',function(){	sujerencia.prepareUser(); });	
	$('#buscaruser input[name="nombre"]').on('click',function(){	sujerencia.prepareUser(); });
	$('#buscaruser input[name="email"]').on('click',function(){		sujerencia.prepareUser(); });		
	$('#buscaruser select[name="email"]').change(function(){		sujerencia.prepareUser(); });

	$('.sujerencia-response').on('focusout', function(){			sujerencia.cerrar();  });




	$('a.lisener1').click(function(){
		var href = $(this).attr('href');
	    if(confirm("Se va a eliminar el usuario. ¿Continuar?")) {
	        document.location.href=href;
	    }
	});

	$('a.lisener2').click(function(){
		var href = $(this).attr('href');
	    if(confirm("Se va a eliminar el contacto. ¿Continuar?")) {
	        document.location.href=href;
	    }
	});
