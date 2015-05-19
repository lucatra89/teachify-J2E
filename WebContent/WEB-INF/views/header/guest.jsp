
<div class="row" ng-controller="headerGuestController">
	<div class="col-md-6 nav-teachify">
		<a ng-click="goToHome()">
			<div class="brand-teachify">
				<i class="fa fa-graduation-cap"></i>
				<h1>teachify</h1>
			</div>
		</a>
	</div>

	<div class="col-md-6 nav-teachify">
		<ul class="nav navbar-nav navbar-right navbar-teachify">
			<li><a ng-click="goToRegister()">{{lang.signup}}</a></li>
			<li><a ng-click="goToLogin()">{{lang.signin}}</a></li>
			<li>
				<button type="button" class="btn btn-success" ng-click="goToRegisterTutor()">{{lang.teachnow}}</button>
			</li>
		</ul>
	</div>
</div>