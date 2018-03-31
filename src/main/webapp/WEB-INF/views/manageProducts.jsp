<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<div class="container"> 
    <div class="row">
        <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4>Product Management</h4>
                </div>
                <div class="panel-body">
                    <sf:form modelAttribute="product" class="form-horizontal" action="${contextRoot}/product" method="POST">
                    	<div class="form-group">
                    		<label for="name" class="control-label col-md-4">Product Name:</label>
                    		<div class="col-md-8">
                    			<sf:input path="name" type="text" id="name" class="form-control" placeholder="Product Name"/>
                    			<em class="help-block">Please enter product name</em>
                    		</div>
                    		<label for="quantity" class="control-label col-md-4">Quantity:</label>
                    		<div class="col-md-8">
                    			<sf:input type="number" path="quantity" id="quantity" class="form-control" value="0"/>
                    		</div>
                    		<label for="category" class="control-label col-md-4">Categories:</label>
                    		<div class="col-md-8">
                    			<sf:select  path="categoryId" items="${categories}" itemLabel="name" itemValue="id" id="categoryId" class="form-control"/>
                    		</div>
                    	</div>
                    	<div class="form-group">
                    		<div class="col-offset-4 col-md-8">
                    			<input type="submit" name="submit" id="submit" class="btn btn-primary"/>
                    		</div>
                    	</div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>