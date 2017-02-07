<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--Footer -->
	<div class="col-md-12 footer-box">


		<div class="row small-box ">
			<strong>Mobiles :</strong> <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> |<a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | view all items

		</div>
		<div class="row small-box ">
			<strong>Laptops :</strong> <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx Laptops</a> | <a href="#">samsung</a> | <a
				href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony Laptops</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> | <a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> | view all items
		</div>
		<div class="row small-box ">
			<strong>Tablets : </strong><a href="#">samsung</a> | <a href="#">Sony
				Tablets</a> | <a href="#">Microx</a> | <a href="#">samsung </a>| <a
				href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung
				Tablets</a> | <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung
				Tablets</a> | <a href="#">Sony</a> | <a href="#">Microx</a> | <a
				href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
			|<a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx
				Tablets</a> | view all items

		</div>
		<div class="row small-box pad-botom ">
			<strong>Computers :</strong> <a href="#">samsung</a> | <a href="#">Sony</a>
			| <a href="#">Microx</a> | <a href="#">samsung Computers</a> | <a
				href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx</a> |<a href="#">samsung</a>
			| <a href="#">Sony</a> | <a href="#">Microx Computers</a> |<a
				href="#">samsung Computers</a> | <a href="#">Sony</a> | <a href="#">Microx</a>
			| <a href="#">samsung</a> | <a href="#">Sony</a> | <a href="#">Microx
				Computers</a> |<a href="#">samsung</a> | <a href="#">Sony</a> | <a
				href="#">Microx</a> | view all items

		</div>
		<div class="row">
			<div class="col-md-4">
				<strong><spring:message code="label.sendQuickQuery"></spring:message></strong>
				<hr>
				<form>
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<input type="text" class="form-control" required="required"
									placeholder="<spring:message code="label.namePlaceholder"/>">
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<input type="text" class="form-control" required="required"
									placeholder="<spring:message code="label.emailPlaceholder"/>">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<div class="form-group">
								<textarea name="message" id="message" required="required"
									class="form-control" rows="3" 
									placeholder="<spring:message code="label.messagePlaceholder"/>"></textarea>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary"><spring:message code="label.submitRequest"/></button>
							</div>
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-4">
				<strong><spring:message code="label.ourLocation"/></strong>
				<hr>
				<p>
					1000, North Forth Street,<br /> Fairfield, USA<br /> <spring:message code ="label.call"/>:
					+09-456-567-890<br> <spring:message code ="label.emailPlaceholder"/>: info@yourdomain.com<br>
				</p>

				www.yourdomain.com | &copy; <spring:message code ="label.year"/> | <spring:message code ="label.allRightReserved"/>
			</div>
			<div class="col-md-4 social-box">
				<strong><spring:message code ="label.socialLinks"/> </strong>
				<hr>
				<a href="#"><i class="fa fa-facebook-square fa-3x "></i></a> <a
					href="#"><i class="fa fa-twitter-square fa-3x "></i></a> <a
					href="#"><i class="fa fa-google-plus-square fa-3x c"></i></a> <a
					href="#"><i class="fa fa-linkedin-square fa-3x "></i></a> <a
					href="#"><i class="fa fa-pinterest-square fa-3x "></i></a>
				<p><spring:message code ="description.socialLinks"/></p>
			</div>
		</div>
		<hr>
	</div>
	<!-- /.col -->
	<div class="col-md-12 end-box ">&copy; <spring:message code ="label.year"/> | &nbsp; <spring:message code ="label.allRightReserved"/> | &nbsp; www.yourdomain.com | &nbsp; <spring:message code ="label.support"/> | &nbsp;
		<spring:message code ="label.emailPlaceholder"/>: info@yourdomain.com</div>
	<!-- /.col -->
	<!--Footer end -->