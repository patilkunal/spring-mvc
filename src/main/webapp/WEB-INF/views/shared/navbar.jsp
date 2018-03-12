<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

    <nav class="navbar navbar-expand-lg navbar-left navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">My MVC App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="${contextRoot}/home" class="active">Home                
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${contextRoot}/about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${contextRoot}/products">Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${contextRoot}/contact">Contact</a>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="nav-item">
              <a class="nav-link" href="${contextRoot}/register">Register</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${contextRoot}/register2">Register2</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${contextRoot}/login">Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
