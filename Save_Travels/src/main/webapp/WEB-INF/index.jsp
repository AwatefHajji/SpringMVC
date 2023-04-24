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
    <title>Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
 <div class="container">
		<h1>Save Travels</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Expense Name</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${allExpenses}">
					<tr>
						<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}" /></a></td>
						<td><c:out value="${expense.vendor}" /></td>
						<td><c:out value="$ ${expense.amount}" /></td>
						<td>
						
						<a href="/expenses/edit/${expense.id}"><button class="btn btn-success">Edit</button></a> 
						<form action="/expenses/delete/${expense.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input type="submit" value="Delete" class="btn btn-danger">
						</form>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<h1>Add an expense </h1>
		<form:form action="/expenses" method="post" modelAttribute="expense">

			<div class="mb-3">
				<form:label class="form-label" path="name">Expense Name :</form:label>
				 <form:input class="form-control" path="name"/>
				 <form:errors path="name" class="text-danger"/>

			</div>
						<div class="mb-3">
				<form:label class="form-label" path="vendor">Vendor :</form:label> 
				<form:input class="form-control" path="vendor"/>
				<form:errors path="vendor" class="text-danger"/>
			</div>
			
			<div class="mb-3">
				<form:label class="form-label" path="amount">Amount :</form:label> 
				<form:input type="number" class="form-control" path="amount" step="0.01"/>
				<form:errors path="amount" class="text-danger"/> 
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="description">Description :</form:label>
				<form:textarea class="form-control" rows="3" path="description"></form:textarea>
				<form:errors path="description" class="text-danger"/>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
		</div>  
</body>
</html>

