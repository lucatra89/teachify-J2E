<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html ng-app="backendApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="contextpath" content="${pageContext.request.contextPath}">
<base href="${pageContext.request.contextPath}/backend">
<title>Home</title>
<link href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/libs/sweetalert/sweetalert.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/backend.css" rel="stylesheet">
</head>
<body>
        <header ng-controller="backendHeaderController">
            <div class="row">
                <div class="col-md-6 nav-teachify">
                    <a ng-click="goToPublic()">
                        <div class="brand-teachify">
                            <i class="fa fa-graduation-cap"></i>
                            <h1>teachify <span class="backend">BackEnd</span></h1>
                        </div>
                    </a>
                </div>
                <div class="col-md-6 nav-teachify">
                    <ul class="nav navbar-nav navbar-right navbar-teachify">
                        <li>
                          <div class="backend-usr"></div>
                          {{authUser.name}} {{authUser.surname}}
                        </li>
                        <li>
                        </li>
                        <li>
                        	<button ng-click="logout()" class="btn btn-default" ng-click> Logout</button>
                        </li>
                    </ul>
                </div>
	</header>

    <div class="content">
        <div class="col-md-3 menu-nav">
          <ul class="list-unstyled" ng-controller="menuController">
            <li ng-click="goToAdministrators()" id="administrators">
            	<i class="fa fa-tachometer"></i> Administrators
            </li>
            <li ng-click="goToSubjects()" id="subjects">
            	<i class="fa fa-graduation-cap"></i> Subjects
            </li>
            <li ng-click="goToTypesOfEducation()" id="typesofeducation">
            	<i class="fa fa-university"></i> Types Of Education
            </li>
            <li ng-click="goToPrices()" id="prices">
            	<i class="fa fa-money"></i> Prices
            </li>
            <li ng-click="goToHours()" id="hours">
            	<i class="fa fa-clock-o"></i> Hours
            </li>
          </ul>
        </div>
        <div class="col-md-9" ng-view></div>
    </div>
	<script src="${pageContext.request.contextPath}/resources/libs/sweetalert/sweetalert.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/libs/underscore/underscore.js"></script>
	<script src="${pageContext.request.contextPath}/resources/libs/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/libs/angular/angular.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/libs/angular/angular-route.min.js"></script>
	<script src="${pageContext.request.contextPath}/app/backendApp.js"></script>
	<script src="${pageContext.request.contextPath}/app/controllers/backend/backendHeaderController.js"></script>
	<script src="${pageContext.request.contextPath}/app/controllers/backend/menuController.js"></script>
	<script src="${pageContext.request.contextPath}/app/controllers/backend/pricesController.js"></script>
	<script src="${pageContext.request.contextPath}/app/controllers/backend/hoursController.js"></script>
	<script src="${pageContext.request.contextPath}/app/controllers/backend/administratorsController.js"></script>
	<script src="${pageContext.request.contextPath}/app/controllers/backend/subjectsController.js"></script>
	<script src="${pageContext.request.contextPath}/app/controllers/backend/typesOfEducationController.js"></script>
</body>

</html>
