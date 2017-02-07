<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><strong>ONLINE</strong>Product System</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">


			<ul class="nav navbar-nav navbar-right">
				
				<li><a data-toggle="modal" data-target="#login-modal"><spring:message code = "label.login"/></a></li>
				<li><a href="userRegistration"><spring:message code="label.signup"/></a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><spring:message code ="label.support"/><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><strong><spring:message code ="label.call"/>: </strong>641-451-3156</a></li>
						<li><a href="#"><strong><spring:message code ="label.emailPlaceholder"/>: </strong>shrestha@gmail.com</a></li>
						<li class="divider"></li>
						<li><a href="#"><strong><spring:message code ="label.address"/>: </strong>
								<div>
									1000 N 4th Street,<br /> Fairfield, Iowa, USA
								</div> </a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" placeholder="Enter Keyword Here ..."
						class="form-control">
				</div>
				&nbsp;
				<button type="submit" class="btn btn-primary"><spring:message code ="label.search"/></button>
			</form>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>


	<div class="user-log">

		<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="display: none;">
			<div class="modal-dialog">
				<div class="loginmodal-container">
					<h1><spring:message code ="label.loginModelHeader"/></h1>
					<br>
					<form:form modelAttribute="user" action="login" method="POST">
						<form:input type="text" 
									path="username" 
									placeholder="Username"
									value = "${cookie.username.value}"
									required="required" />
					    <form:input type="password"
							 		path="password"
									placeholder="Password" 
									required="required" /> 
							<label><input type="checkbox" 
									name="remember" 
									<c:if test="${cookie.containsKey('username') }">checked</c:if> />
									Remember Me</label><br/>
							<button type="submit" class="login loginmodal-submit inputField">
							<spring:message code ="label.login"/></button>
					</form:form>
					<br/>
					<div class="login-help">
						<a href="userRegistration"><spring:message code="label.register"/></a> - <a href="#"><spring:message code="label.forgotPassword"/></a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- end .user-log -->