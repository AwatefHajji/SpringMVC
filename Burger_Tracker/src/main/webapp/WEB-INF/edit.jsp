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
    <title>Burger Tracker II</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
   <div class="container">

		<h1>Edit a Burger </h1>
		<form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
              <input type="hidden" name="_method" value="put">
			<div class="mb-3">
				<form:label class="form-label" path="name">Burger Name :</form:label>
				 <form:input class="form-control" path="name"/>
				 <form:errors path="name" class="text-danger"/>

			</div>
						<div class="mb-3">
				<form:label class="form-label" path="restaurant">Restaurant Name :</form:label> 
				<form:input class="form-control" path="restaurant"/>
				<form:errors path="restaurant" class="text-danger"/>
			</div>
			
			<div class="mb-3">
				<form:label class="form-label" path="rate">Rating :</form:label> 
				<form:input type="number" class="form-control" path="rate"/>
				<form:errors path="rate" class="text-danger"/> 
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="notes">Notes :</form:label>
				<form:textarea class="form-control" rows="3" path="notes"></form:textarea>
				<form:errors path="notes" class="text-danger"/>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
		</div>
</body>
</html>

