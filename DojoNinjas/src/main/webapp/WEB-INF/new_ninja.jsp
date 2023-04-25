<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<form:form action="/ninjas" method="post" modelAttribute="ninja">
			<form:errors path="*" class="text-danger" />
			<div>
				<form:select path="dojo">
					<c:forEach items="${allDojos}" var="dojo">
						<form:option value="${dojo.id }">${dojo.name }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<p>
				<form:label path="firstname">First name :</form:label>

				<form:input path="firstname" />
			</p>
			<p>
				<form:label path="lastname">Last name :</form:label>

				<form:input path="lastname" />
			</p>
			<p>
				<form:label path="age">Age:</form:label>

				<form:input type="number" path="age" />
			</p>

			<br />
			<input type="submit" value="Submit" class="btn btn-success" />
		</form:form>

	</div>
</body>
</html>

