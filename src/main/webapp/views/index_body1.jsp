<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:if test="${errorMessage != null}">
	<h1 style="color:red;"><c:out value="${errorMessage}"/></h1>
</c:if>

<div>
<a href="?locale=en_US">ENGLISH</a> | <a href="?locale=np_NP">NEPALI</a>
</div>

<div class="row">
			<div class="col-md-9">
				<div class="well well-lg offer-box text-center">


					<spring:message code="label.todaysOffer"/> : &nbsp; <span class="glyphicon glyphicon-cog"></span>&nbsp;40
					% off on purchase of $ 2,000 and above till 1st March !


				</div>
				<div class="main box-border">
					<div id="mi-slider" class="mi-slider">
						<ul>

							<li><a href="#"> <img
									src="assets/ItemSlider/images/1.jpg" alt="img01">
								<h4>Boots</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/2.jpg" alt="img02">
								<h4>Oxfords</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/3.jpg" alt="img03">
								<h4>Loafers</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/4.jpg" alt="img04">
								<h4>Sneakers</h4>
							</a></li>
						</ul>
						<ul>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/5.jpg" alt="img05">
								<h4>Belts</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/6.jpg" alt="img06">
								<h4>Hats &amp; Caps</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/7.jpg" alt="img07">
								<h4>Sunglasses</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/8.jpg" alt="img08">
								<h4>Scarves</h4>
							</a></li>
						</ul>
						<ul>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/9.jpg" alt="img09">
								<h4>Casual</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/10.jpg" alt="img10">
								<h4>Luxury</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/11.jpg" alt="img11">
								<h4>Sport</h4>
							</a></li>
						</ul>
						<ul>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/12.jpg" alt="img12">
								<h4>Carry-Ons</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/13.jpg" alt="img13">
								<h4>Duffel Bags</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/14.jpg" alt="img14">
								<h4>Laptop Bags</h4>
							</a></li>
							<li><a href="#"> <img
									src="assets/ItemSlider/images/15.jpg" alt="img15">
								<h4>Briefcases</h4>
							</a></li>
						</ul>
						<nav> <a href="#">Shoes</a> <a href="#">Accessories</a> <a
							href="#">Watches</a> <a href="#">Bags</a> </nav>
					</div>

				</div>
				<br />
			</div>
			<!-- /.col -->

			<div class="col-md-3 text-center">
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="offer-text">30% off here</div>
					<div class="thumbnail product-box">
						<img src="assets/img/dummyimg.png" alt="" />
						<div class="caption">
							<h3>
								<a href="#">Samsung Galaxy </a>
							</h3>
							<p>
								<a href="#">Ptional dismiss button </a>
							</p>
						</div>
					</div>
				</div>
				<div class=" col-md-12 col-sm-6 col-xs-6">
					<div class="offer-text2">30% off here</div>
					<div class="thumbnail product-box">
						<img src="assets/img/dummyimg.png" alt="" />
						<div class="caption">
							<h3>
								<a href="#">Samsung Galaxy </a>
							</h3>
							<p>
								<a href="#">Ptional dismiss button </a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->