<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Chapaar</title>
    <link rel="icon" type="image/ico" href="/resources/images/logo.png" />
    <link rel="stylesheet" type="text/css" href="/resources/style/style.css" />
</head>
<body>
    <jsp:include page="header.jsp"/>
    <article>
        <h2 class="article-heading">Customer Items</h2>
        <table>
            <tr>
                <th class="col-left">Id</th>
                <th class="col-left">First Name</th>
                <th class="col-left">Last Name</th>
                <th class="col-left">Email</th>
                <th class="col-left">Description</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${customerItemList}" var="customerItem">
                <tr>
                    <td class="col-left">${customerItem.id}</td>
                    <td class="col-left">${customerItem.firstName}</td>
                    <td class="col-left">${customerItem.lastName}</td>
                    <td class="col-left">${customerItem.email}</td>
                    <td class="col-left">${customerItem.description}</td>
                    <td>
                        <a class="action-link" href="/show-edit-customer-item?customerItemId=${customerItem.id}">Edit</a>
                        <a class="action-link" href="/delete-customer-item?customerItemId=${customerItem.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </article>
    <jsp:include page="footer.jsp"/>
</body>
</html>