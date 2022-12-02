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
			<h2 class="article-heading">Add Product Item</h2>
			<sf:form name="addProductItemForm" action="add-product-item" modelAttribute="productItem" method="POST">
				<sf:input path="id" type="number" style="display:none"/>
				<table class="form-table">
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Product Name</label>
							<sf:input path="name" class="form-input" type="text" name="name"
								id="field-title"/>
							<sf:errors path="name" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<label class="form-item" for="field-title">Price</label>
							<sf:input path="price" class="form-input" type="number" name="price"
									  id="field-title"/>
							<sf:errors path="price" />
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