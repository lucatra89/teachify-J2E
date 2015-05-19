(function(require){

	var contextPath = document.querySelector("meta[name='contextpath']").getAttribute("content"),
		requestLang = navigator.language,
		baseUrl = contextPath + "/app";

	require.config({
        baseUrl: baseUrl,
        paths: {
            jquery:  '../resources/libs/jquery/jquery.min',
            underscore: '../resources/libs/underscore/underscore',
            leaflet: '../resources/libs/leaflet/leaflet',
            bootstrap: '../resources/libs/bootstrap/js/bootstrap.min',
            text : '../resources/libs/require/text',
            moment : '../resources/libs/moment/moment.min',
            langConf : '../languages/lang-conf'
        },
        shim: {
            'jquery': {
            exports: '$'
            },
            'underscore': {
            exports: '_'
            },

            'leaflet': {
            exports: 'L'
            }
        }
});
	
require(['moment', 'langConf'], function(moment , langConf) {
	var langCod = (langConf[requestLang]) ? requestLang : langConf['default'],
		languageUri = contextPath + langConf[langCod];
	
    require([languageUri], function(lang) {
    	define('lang', lang);
    	moment.locale(langCod);
    	init();
    });
});
	


function init() {
	require(['jquery', 'services/routeResolver'],
	    function () {	
	        require(['bootstrap', 'app', 'controllers/headerGuestController', 'controllers/headerAuthController', 'services/utilities' ] ,
	         function(){
	            var appName = 'teachifyApp';
	            document.getElementsByTagName('html')[0].setAttribute('ng-app' , appName);
	            angular.bootstrap(document, [appName]);
	     });
    });
}
})(require);