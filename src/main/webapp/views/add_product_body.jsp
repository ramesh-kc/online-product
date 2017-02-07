<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<section class="container">
	<h3>Add Product Form</h3>
	<div class="col-lg-12 well">
		<div class="row">
			<form:form modelAttribute="product"
					   method="post" id="formreg"
					   enctype="multipart/form-data"
					   data-toggle="validator" 
					   role="form">

				<div class="col-sm-12">
					<div class="form-group">
						<label>Product Title</label>
						<form:input path="name" type="text" required="required"
							placeholder="Enter Product Title " class="inputField" />

					</div>
					
					<div class="form-group">
						<label>Category</label><br>
						<form:select path="category" class="inputField">
							<form:option value="NONE" label="----SELECT ONE ---" class="inputField"/>
							<form:option value="Electronics" label="Electronics" class="inputField"/>
							<form:option value="Clothing" label="Clothing & Wears" class="inputField"/>
							<form:option value="Accessories" label="Accessories & Extras" class="inputField"/>
						</form:select>
					</div>
					
					<div class="form-group">
						
						<label class="control-label" for="dateManufacture">Date Manufacture</label>
						<form:input path="dateManufacture" type="text" required="required"
							id="dateManufacture" placeholder="Ex: MM/DD/YYYY"
							class="inputField form-control" />
					</div>
					
					<div class="form-group">
						<label>Price</label>
						<form:input path="price" type="number" required="required"
							placeholder="Example : 450" class="inputField" />
					</div>
					<div class="form-group">
						<label>Description</label>
						<form:textarea path="description" rows="5" cols="30" required="required"
							placeholder="Product Description..." class="inputField" />
					</div>
					<div class="form-group">
						<label>Product Photo</label>
						<form:input path="image" type="file" required="required" class="inputField"/>
						
					</div>

					
					<button type="submit" id="btnRegister" class="btn btn-lg btn-info">Add Product</button>
				</div>

			</form:form>
		</div>
	</div>

	<script>
		$(document).ready(
				function() {
					var date_input = $('input[name="dateManufacture"]');
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					var options = {
						format : 'mm/dd/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
					};
					date_input.datepicker(options);
				})
	</script>

</section>
