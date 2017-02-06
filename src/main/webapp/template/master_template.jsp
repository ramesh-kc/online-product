<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>ONLINE PRODUCT SYSTEM</title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />"
	rel="stylesheet">
<%-- <link href="<c:url value="/assets/css/bootstrap.css" />" rel="stylesheet"> --%>
<!-- <link href="assets/css/bootstrap.css" rel="stylesheet"> -->
<!-- Fontawesome core CSS -->
<link href="<c:url value="assets/css/font-awesome.min.css" />"
	rel="stylesheet">
<!-- <link href="assets/css/font-awesome.min.css" rel="stylesheet" /> -->
<!--GOOGLE FONT -->

<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<!--Slide Show Css -->
<link href="<c:url value="assets/ItemSlider/css/main-style.css" />"
	rel="stylesheet">
<!-- <link href="assets/ItemSlider/css/main-style.css" rel="stylesheet" /> -->
<!-- custom CSS here -->
<link href="assets/css/style.css" rel="stylesheet" />

<!--Core JavaScript file  -->

<script src="<c:url value="/assets/js/jquery-1.10.2.js" /> "></script>
<!--bootstrap JavaScript file  -->

<script src="<c:url value="assets/js/bootstrap.js" />"></script>
<!--Slider JavaScript file  -->

<script
	src="<c:url value="assets/ItemSlider/js/modernizr.custom.63321.js" /> "></script>

<script
	src="<c:url value="assets/ItemSlider/js/jquery.catslider.js" /> "></script>

</head>
<body>



	<tiles:insertAttribute name="header" />

	<div class="container">

		<tiles:insertAttribute name="i_body1" />

		<tiles:insertAttribute name="i_body2" />

	</div>
	<!-- /.container -->

	<div class="col-md-12 download-app-box text-center">

		<span class="glyphicon glyphicon-download-alt"></span>Download Our
		Android App and Get 10% additional Off on all Products . <a href="#"
			class="btn btn-danger btn-lg">DOWNLOAD NOW</a>

	</div>

	<tiles:insertAttribute name="footer" />



	<script>
		$(function() {

			$('#mi-slider').catslider();

		});
	</script>

</body>
</html>



