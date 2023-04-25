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
   <h1>All dojos</h1>
   <c:forEach items="${allDojos}" var ="oneDojo">
   <li><a href="/dojos/${oneDojo.id }">${oneDojo.name}</a></li>
   </c:forEach>
   <hr>
   		<form:form action="/dojos" method="post" modelAttribute="dojo">

			<div class="mb-3">
				<form:label class="form-label" path="name">Dojo Name :</form:label>
				 <form:input class="form-control" path="name"/>
				 <form:errors path="name" class="text-danger"/>

			</div>
		<button type="submit" class="btn btn-primary">Create</button>
		</form:form>
   </div>
</body>
</html>

