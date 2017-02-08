
<%
	String userSession = (String) session.getAttribute("userName");
%>
<form id="member_login" action="logout"></form>
<script>
var session = <%=userSession%>;
	if (session == null || session == undefined) {
			document.forms['member_login'].submit();
	}
</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<a class="navbar-brand" href="<c:url value="/welcome" />"><strong>ONLINE</strong> Product
				System</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">


			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout">Logout</a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">${userInfo.name} <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><strong>Call: </strong>${userInfo.contact}</a></li>
						<li><a href="#"><strong>Mail: </strong>${userInfo.email}
						</a></li>
						<li class="divider"></li>
						<li><a href="#"><strong>Address: </strong>
								<div>${userInfo.address}</div> </a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" placeholder="Enter Keyword Here ..."
						class="form-control">
				</div>
				&nbsp;
				<button type="submit" class="btn btn-primary">Search</button>
			</form>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
