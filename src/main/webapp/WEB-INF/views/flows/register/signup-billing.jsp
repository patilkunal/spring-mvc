<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<jsp:include page="../shared/flows-header.jsp"/>
<jsp:include page="../shared/flows-navbar.jsp"/>

	<!-- Page Content -->
    <div id="content">
    	<div class="container">
    		<div class="col-md-6 col-md-offset-3">
    			<div class="panel panel-primary">
    				<div class="panel-heading">
    					<h4>Sign Up - Billing Address</h4>
    				</div>
    				<div class="panel-body">
    					<sf:form method="POST" class="form-horizontal" id="billingForm" modelAttribute="billing">
    						<div class="form-group">
    							<label class="control-label col-md-4">Address Line 1</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="addressLine1" class="form-control"
	    							placeholder="Address"/>
    							</div>
    						</div>

    						<div class="form-group">
    							<label class="control-label col-md-4">Address Line 2</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="addressLine2" class="form-control"
	    							placeholder="Address"/>
    							</div>
    						</div>
    						<div class="form-group">
    							<label class="control-label col-md-4">City</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="city" class="form-control"
	    							placeholder="City"/>
    							</div>
    						</div>
    						<div class="form-group">
    							<label class="control-label col-md-4">Postal Code</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="postalCode" class="form-control"
	    							placeholder="000000"/>
    							</div>
    						</div>
    						<div class="form-group">
    							<label class="control-label col-md-4">State</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="state" class="form-control"
	    							placeholder="State"/>
    							</div>
    						</div>
    						<div class="form-group">
    							<label class="control-label col-md-4">Country</label>
    							<div class="col-md-8">
	    							<sf:input type="text" path="country" class="form-control"
	    							placeholder="Country"/>
    							</div>
    						</div>
    						<div class="form-group">
    							<div class="col-md-offset-4 col-md-8">
    								<!-- Submit buttons -->
    								<button class="btn btn-primary" type="submit" name="_eventId_personal"><span class="glyphicon glyphicon-chevron-left"></span> Prev - Personal</button>
    								<button class="btn btn-primary" type="submit" name="_eventId_confirm">Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span></button>
    							</div>
    						</div>
    					</sf:form>
    				</div>
    			</div>
    		</div>
    	</div>
	</div>
	
<jsp:include page="../shared/flows-footer.jsp"/>