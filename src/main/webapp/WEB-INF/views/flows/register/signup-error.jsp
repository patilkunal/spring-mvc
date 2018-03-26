<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../shared/flows-header.jsp"/>
<jsp:include page="../shared/flows-navbar.jsp"/>

	<!-- The paths in the spring form tags refers to the User variable created in the flow XML -->
	<!-- Page Content -->
    <div id="content">
    	<div class="container">
    		<div class="col-md-12">
    			<div class="panel panel-primary">
    				<div class="panel-heading">
    					<h4>Sign Up - Error</h4>
    				</div>
    				<div class="panel-body">
						<h3>Error completing the registration process.</h3>
						<div>You can <a href="${flowExecutionUrl}&_eventId_personal">Try Again</a></div> 
						<div>Or Go <a href="${flowExecutionUrl}&_eventId_home">home</a> and try later</div>
						<div class="well">
						<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
  <li>
    Message Source is ${message.source}
    <br>
    Message Text is ${message.text}
  </li>
</c:forEach>
						</div>   					
    				</div>
    			</div>
    		</div>
    	</div>
	</div>
	
<jsp:include page="../shared/flows-footer.jsp"/>