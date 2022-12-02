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
        <h2 class="article-heading">Product Items</h2>
        <table>
            <tr>
                <th class="col-left">Id</th>
                <th class="col-left">Product Name</th>
                <th class="col-left">Price</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${productItemList}" var="productItem">
                <tr>
                    <td class="col-left">${productItem.id}</td>
                    <td class="col-left">${productItem.name}</td>
                    <td class="col-left">${productItem.price}</td>
                    <td>
                        <a class="action-link" href="/show-edit-product-item?productItemId=${productItem.id}">Edit</a>
                        <a class="action-link" href="/delete-product-item?productItemId=${productItem.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </article>
    <jsp:include page="footer.jsp"/>
</body>
</html>