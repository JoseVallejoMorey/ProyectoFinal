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

			//this.resetnotselectedinputs(name);
			//enviara ajax
			console.log(name+"____"+surname+"____"+empresa+"____"+telefono);
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

		var name = $('input[name="nombre"]').val();
		var surname = $('input[name="apellido"]').val();
		var empresa = $('input[name="empresa"]').val();
		var telefono = $('input[name="telefono"]').val();
		if(name.length > 2){sujerencia.consultar(name,surname,empresa,telefono);}
		if(surname.length > 2){sujerencia.consultar(name,surname,empresa,telefono);}
		if(empresa.length > 2){sujerencia.consultar(name,surname,empresa,telefono);}
		if(telefono.length > 2){sujerencia.consultar(name,surname,empresa,telefono);}

		if(name.length == 0 && surname.length == 0 && empresa.length == 0 && telefono.length == 0){
			sujerencia.cerrar();
		}



}



	var sujerencia = new busquedas_ajax();

		//al escribir muestro
	$('input[name="nombre"]').bind('input',function(){	 	sujerencia.prepare(); });
	$('input[name="apellido"]').bind('input',function(){	sujerencia.prepare(); });
	$('input[name="empresa"]').bind('input',function(){		sujerencia.prepare(); }); 
	$('input[name="nombre"]').on('click',function(){	 	sujerencia.prepare(); });	
	$('input[name="telefono"]').on('click',function(){	 	sujerencia.prepare(); });	
	$('input[name="apellido"]').on('click',function(){	 	sujerencia.prepare(); });	
	$('input[name="empresa"]').on('click',function(){	 	sujerencia.prepare(); });
	$('input[name="telefono"]').on('click',function(){	 	sujerencia.prepare(); });	
	$('.sujerencia-response').on('focusout', function(){	sujerencia.cerrar();  });




// function forminspect(){


// 	this.elem = '';

// }

// forminspect.prototype.validateContact(){
// 	//interceptar el form
// 	//quitar campos vacios solo se enviaran los no vacios
// 	//revisar el ceckbox
// 	var this.elem = elem;

// 	alert(elem);
// }




// var forminspect = new forminspect();




