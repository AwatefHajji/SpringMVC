<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
   <div class ="container">
   <h1>${dojo.name } Location Ninjas</h1>
   <table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${dojo.ninjas}">
					<tr>
						<td><c:out value="${ninja.firstname}" /></td>
						<td><c:out value="${ninja.lastname}" /></td>
						<td><c:out value="${ninja.age}" /></td>
					</tr>
				</c:forEach>
			</tbody>
   
   </div>
</body>
</html>

