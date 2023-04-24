<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Burger Tracker</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
		<h1>Burger Tracker</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Burger Name</th>
					<th scope="col">Restaurant Name</th>
					<th scope="col">Rating (out of 5)</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${allBurgers}">
					<tr>
						<td><a href="/burgers/${burger.id}"><c:out value="${burger.name}" /></a></td>
						<td><c:out value="${burger.restaurant}" /></td>
						<td><c:out value="${burger.rate}" /></td>
						<td>
						
						<a href="/burgers/edit/${burger.id}"><button class="btn btn-success">Edit</button></a> 
						<form action="/burgers/delete/${burger.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input type="submit" value="Delete" class="btn btn-danger">
						</form>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<h1>Add a Burger </h1>
		<form:form action="/handelForm" method="post" modelAttribute="burger">

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