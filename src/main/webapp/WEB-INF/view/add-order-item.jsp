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
			<h2 class="article-heading">Add Order Item</h2>
			<sf:form name="addOrderItemForm" action="add-order-item" modelAttribute="orderItem" method="POST">
				<sf:input path="id" type="number" style="display:none"/>
				<table class="form-table">
					<tr>
						<td>
							<label class="form-item" for="field-title">Customer</label>
							<sf:select path="customer" class="form-input" name="customer" id="field-title">
								<sf:options items="${customerItemList}" itemValue="id" itemLabel="firstName"/>
							</sf:select>
						</td>
					</tr>
					<tr>
						<td>
							<label class="form-item" for="field-title">Product</label>
							<sf:select path="product" class="form-input" name="product" id="field-title">
								<sf:options items="${productItemList}" itemValue="id" itemLabel="name"/>
							</sf:select>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Count</label>
							<sf:input path="count" class="form-input" type="number" name="count"
									  id="field-title"/>
							<sf:errors path="count" />
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