<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
	<head>
		<title>Chapaar</title>
		<link rel="icon" type="image/ico" href="/resources/images/logo.png" />
		<link rel="stylesheet" type="text/css" href="/resources/style/style.css" />
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<article>
			<h2 class="article-heading">Add Customer Item</h2>
			<sf:form name="addCustomerItemForm" action="add-customer-item" modelAttribute="customerItem" method="POST">
				<sf:input path="id" type="number" style="display:none"/>
				<table class="form-table">
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">First Name</label>
							<sf:input path="firstName" class="form-input" type="text" name="firstName"
								id="field-title"/>
							<sf:errors path="firstName" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Last Name</label>
							<sf:input path="lastName" class="form-input" type="text" name="lastName"
									  id="field-title"/>
							<sf:errors path="lastName" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Email</label>
							<sf:input path="email" class="form-input" type="text" name="email"
									  id="field-title" placeholder="info@gmail.com"/>
							<sf:errors path="email" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Description</label>
							<sf:input path="description" class="form-input" type="text" name="description"
									  id="field-title"/>
							<sf:errors path="description" />
						</td>
					</tr>
					<tr colspan=4>
						<td><input class="form-button" type="submit" name="submit"
							value="Save"></input></td>
					</tr>
				</table>
			</sf:form>
		</article>
		<jsp:include page="footer.jsp"/>
	</body>
</html>