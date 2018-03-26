<jsp:include page="../shared/flows-header.jsp"/>
<jsp:include page="../shared/flows-navbar.jsp"/>

	<!-- Page Content -->
    <div id="content">
    	<div class="row">
    		<div class="col-sm-6">
    			<div class="panel panel-primary">
    				<div class="panel-heading">
    					<h4>Personal Details</h4>
    				</div>
    				<div class="panel-body">
    					<div class="text-center">
    						<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
    						<h3>Email: ${registerModel.user.email}</h3>
    						<h3>Contact Number: ${registerModel.user.contactNumber}</h3>
    						<h3>Role: ${registerModel.user.role}</h3>
    					</div>
    				</div>
    				<div class="panel-footer">
    					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn_primary">Edit Personal</a>
    				</div>
    			</div>    			
    		</div>

    		<div class="col-sm-6">
    			<div class="panel panel-primary">
    				<div class="panel-heading">
    					<h4>Billing Address</h4>
    				</div>
    				<div class="panel-body">
    					<div class="text-center">
    						<h4>${registerModel.billing.addressLine1}</h4>
    						<h4> ${registerModel.billing.addressLine2}</h4>
    						<h3>${registerModel.billing.city} - ${registerModel.billing.postalCode}</h3>
    						<h3>${registerModel.billing.state} - ${registerModel.billing.country}</h3>
    					</div>
    				
    				</div>
    				<div class="panel-footer">
    				<!-- This navigates to 'billing' transition, which in turn bring in billingState view state -->
    					<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn_primary">Edit Billing Address</a>
    				</div>
    			</div>    			
    		</div>
    	</div>
    	<div class="row">
    		<div class="col-sm-4 col-sm-offset-4">
    			<div class="text-center">
    				<!-- This navigates to action state 'submit' rather than a transition -->
    				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn_primary">Confirm</a>
    			</div>
			</div>    		
    	</div>
	</div>
	
<jsp:include page="../shared/flows-footer.jsp"/>