define(function(require) {
	var app = require('app'),
		$ = require('jquery');
	
	require('services/validateForm');
	
	app.register.controller('registerController', [ '$scope', '$location','validateForm', function($scope, $location, validateForm) {
		
		var valid = true,
			form = document.forms[0], action = form.getAttribute('action'),
			action = contextPath + action;
			form.setAttribute("action", action),
			$form = $(form);
		
//		 function isEmpty() {
//			if(!this.value || this.value === ""){
//				valid = false;
//			}
//		}
//		 
//		function checkPasswords() {
//			var password = $form.find("[name='password']").val() ,
//			match = $form.find("[name='matchpassword']").val();
//			
//			if(password !== match){
//				valid = false;
//			}
//		}
//		 
//		function validate(event) {
//			
//			$form
//				.find(".required")
//				.each(isEmpty);
//			
//			checkPasswords();
//			
//			if(!valid){
//				window.sweetAlert("Attenzione", "Campi Errati" , "error");
//				event.preventDefault();
//			}
//		}
//		
//		$form.submit(validate);
		validateForm();
		
	}]);
});
