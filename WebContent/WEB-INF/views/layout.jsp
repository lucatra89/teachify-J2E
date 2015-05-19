<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="contextpath" content="${pageContext.request.contextPath}">
<base href="${pageContext.request.contextPath}">
<title>Home</title>
<link href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/libs/leaflet/leaflet.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/libs/sweetalert/sweetalert.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
	<header>

		<security:authorize access="!isAuthenticated()">
			<%@ include file="/WEB-INF/views/header/guest.jsp"%>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<%@ include file="/WEB-INF/views/header/auth.jsp"%>
		</security:authorize>


	</header>

	<div ng-view class="content"></div>

	<script src="${pageContext.request.contextPath}/resources/libs/sweetalert/sweetalert.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/libs/angular/angular.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/libs/angular/angular-route.min.js"></script>
	<script data-main="${pageContext.request.contextPath}/resources/main" src="${pageContext.request.contextPath}/resources/libs/require/require.js"></script>
</body>

</html>
