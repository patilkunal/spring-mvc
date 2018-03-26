<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<jsp:include page="../shared/flows-header.jsp"/>
<jsp:include page="../shared/flows-navbar.jsp"/>

	<!-- Page Content -->
    <div id="content">
    	<div class="row">
    		<div class="col-sm-4 col-sm-offset-4">
    			<div class="text-center">
    				<h1>welcome!</h1>
    				<h6>Use your email address to login</h6>
    				<div>
    				<a href="${contextRoot}/login" class="btn btn_lg btn_primary">Login</a>
    				</div>
    			</div>
			</div>    		
    	</div>
	</div>
	
<jsp:include page="../shared/flows-footer.jsp"/>