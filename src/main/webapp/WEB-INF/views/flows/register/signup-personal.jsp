<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<jsp:include page="../shared/flows-header.jsp"/>
<jsp:include page="../shared/flows-navbar.jsp"/>

	<!-- The paths in the spring form tags refers to the User variable created in the flow XML -->
	<!-- Page Content -->
    <div id="content">
    	<div class="container">
    		<div class="col-md-6 cold-md-offset-3">
    			<div class="panel panel-primary">
    				<div class="panel-heading">
    					<h4>Sign Up - Personal</h4>
    				</div>
    				<div class="panel-body">
    					<!-- the model is defined in the spring flow xml file -->
    					<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
    						<div class="form-group">
    							<label class="control-label col-md-4">First Name</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="firstName" class="form-control"
	    							placeholder="First Name"/>
    							</div>
    						</div>

    						<div class="form-group">
    							<label class="control-label col-md-4">Last Name</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="lastName" class="form-control"
	    							placeholder="Last Name"/>
    							</div>
    						</div>

    						<div class="form-group">
    							<label class="control-label col-md-4">Email</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="email" class="form-control"
	    							placeholder="email@domain.com"/>
    							</div>
    						</div>

    						<div class="form-group">
    							<label class="control-label col-md-4">Contact Number</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="contactNumber" class="form-control"
	    							placeholder="0000000000" maxlength="10"/>
    							</div>
    						</div>

    						<div class="form-group">
    							<label class="control-label col-md-4">Password</label>
    							<div class="col-md-8">
	    							<sf:input type="password" path="password" class="form-control"
	    							placeholder="password"/>
    							</div>
    						</div>

    						<div class="form-group">
    							<label class="control-label col-md-4">Select Role</label>
    							<div class="col-md-8">
    								<label class="radio-inline">
	    								<sf:radiobutton path="role" value="USER" checked="checked"/> User
	    							</label>
    								<label class="radio-inline">
	    								<sf:radiobutton path="role" value="SUPPLIER"/> Supplier
	    							</label>
    							</div>
    						</div>
    						
    						<div class="form-group">
    							<div class="col-md-offset-4 col-md-8">
    								<!-- Submit button -->
    								<button class="btn btn-primary" type="submit" name="_eventId_billing">Next - Billing <span class="glyphicon glyphicon-chevron-right"></span></button>
    							</div>
    						</div>
    					</sf:form>    					
    				</div>
    			</div>
    		</div>
    	</div>
	</div>
	
<jsp:include page="../shared/flows-footer.jsp"/>