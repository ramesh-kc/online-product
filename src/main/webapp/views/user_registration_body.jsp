<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<section class="container">
	<h3>User Registration Form</h3>
	<div class="col-lg-12 well">
		<div class="row">
			<form:form modelAttribute="user" method="post" id="formreg"
				data-toggle="validator" role="form">
				
				<div class="col-sm-12">
				
					<div class="form-group">
						<label>Status</label><br>
						<form:select path="status" class="inputField">
							<form:option value="Normal" label="NORMAL" class="inputField"/>
							<form:option value="Admin" label="ADMIN" class="inputField"/>
						</form:select>
					</div>
					
					<div class="form-group">
						<label>Full Name</label>
						<form:input path="name" type="text" required="required"
							placeholder="Enter FullName " class="inputField" />

					</div>
					<div class="form-group">
						<label>Gender</label><br>
						<form:radiobutton path="sex" value="Male" />
						Male
						<form:radiobutton path="sex" value="Female" />
						Female
					</div>
					<div class="form-group">
						<!-- <label>DOB</label> -->
						<label class="control-label" for="dateOfBirth">Date of
							Birth</label>
						<form:input path="dateOfBirth" type="text" required="required"
							id="dateOfBirth" placeholder="Ex: MM/DD/YYYY"
							class="inputField form-control" />
					</div>
					<div class="form-group">
						<label>Email</label>
						<form:input path="email" type="email"
							placeholder="example@example.com" required="required"
							class="inputField" />
					</div>
					<div class="form-group">
						<label>Contact</label>
						<form:input path="contact" type="text" required="required"
							placeholder="Example : 6414513156" class="inputField" />
					</div>
					<div class="form-group">
						<label>Address</label>
						<form:input path="address" type="text" required="required"
							placeholder="Forth Worth , Texas" class="inputField" />
					</div>
					<div class="form-group">
						<label>Username</label>
						<form:input type="text" path="username" required="required"
							placeholder="Your Username" class="inputField" />

					</div>

					<div class="form-group">
						<label>Password</label>
						<form:input type="password" required="required" path="password"
							pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,})"
							placeholder="Enter Password Here.."
							title="Password should be minimum 6 char and one number one capital and one small letter required"
							class="inputField" />
					</div>
					<button type="submit" id="btnRegister" class="btn btn-lg btn-info">Register</button>
				</div>

			</form:form>
		</div>
	</div>

	<script>
		$(document).ready(
				function() {
					var date_input = $('input[name="dateOfBirth"]');
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
