<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<!-- /.col -->
	<div class="col-md-12">
		<section>
			<div id="prod" class="container">
				<div id="result" style="display: none"></div>
			</div>
		</section>

		<section class="container">
			<div>

				<div>
					<a href="#" class="btn btn-success pull-right"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Check out
					</a>
				</div>
				<table class="table table-hover">
					<tr>
						<th>Product Id</th>
						<th>Name</th>
						<th>Unit price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>

					<c:forEach var="item" items="${cart.cartItems}">
						<tr>
							<td>${item.value.product.productId}</td>
							<td>${item.value.product.name}</td>
							<td>${item.value.product.price}</td>
							<td>${item.value.quantity}</td>
							<td>${item.value.totalPrice}</td>
							<td><a href="#" class="label label-danger"
								onclick="removeFromCart('${item.value.product.productId}');">
									<span class="glyphicon glyphicon-remove" /></span> Remove
							</a></td>
						</tr>
					</c:forEach>

					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>${cart.grandTotal}</th>
						<th></th>
					</tr>
				</table>

				<a href="<c:url value="/welcome" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> Continue
					shopping
				</a>
			</div>
		</section>
	</div>
	<!-- /.col -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
	
	removeFromCart = function(productId) {
		$.ajax({
			url: '/online-product/removeFromCart/'+ productId,
	 		type: 'PUT',
			dataType: "json",
		 	 success: function (response) {
	 		 		location.reload(true);
				},
				error: function(){						
					alert('Error while request..');
		 	 } 
	   });
   }
	
});
</script>