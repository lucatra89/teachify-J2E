define(function (require) {
	
	var app = require('app'),
		$ =require('jquery'),
		_ = require('underscore'),
		lang = require('lang');
	
	require('services/validateForm');
	
    app.register.controller('upgradeController', ['$scope','$location', 'partialsPath', 'contextPath','urlGeo','validateForm',
		function ($scope, $location, partialsPath, contextPath, urlGeo, validateForm) {
		var form = document.forms[0], action = form.getAttribute('action'),
		action = contextPath + action;
		form.setAttribute("action", action);
		$scope.modal = partialsPath + 'insertPosition.html';
	
		var handlers = {
				savePosition : function() {
	    	    	var query = $('[name="queryLocation" ]').val(),
		    		promise = $.getJSON(urlGeo + query + "?format=json");
		    		
			    	promise.done(function(data) {
			    		var $el;
			    		
						if(data.length === 0){
							
				    		$el = $($("#alertFailed").html());
			    			$el.prependTo(".modal-body");
						}else{
							var lat = data[0].lat.substring(0 , data[0].lat.length - 2 ),
								lon = data[0].lon.substring(0 , data[0].lon.length - 2 );
							
							$el = $($("#alertSuccess").html());
							
							$el.find('#location_modal').text(data[0].display_name);
							$('[name="location.name"]').val(data[0].display_name);
							debugger;
							
							$('[name="location.latitude"]').val(lat);
							$('[name="location.longitude"]').val(lon);
							$el.find("#saved").text(lang.saved);
			    			$el.prependTo(".modal-body"); 
			    			
						}
							
					});
				}
				
		};
		
		validateForm();
		
		    	
		$scope.lang = lang;
		_.extend($scope , handlers);
		    	
	}]);
});
