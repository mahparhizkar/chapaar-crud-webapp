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
        <h2 class="article-heading">Order Items</h2>
        <table>
            <tr>
                <th class="col-left">Order Id</th>
                <th class="col-left">Customer Name</th>
                <th class="col-left">Product Name</th>
                <th class="col-left">Price (fee)</th>
                <th class="col-left">Count</th>
                <th class="col-left">Price (total)</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${orderItemDTOS}" var="orderItemDTO">
                <tr>
                    <td class="col-left">${orderItemDTO.orderId}</td>
                    <td class="col-left">${orderItemDTO.customerName}</td>
                    <td class="col-left">${orderItemDTO.productName}</td>
                    <td class="col-left">${orderItemDTO.price}</td>
                    <td class="col-left">${orderItemDTO.productCount}</td>
                    <td class="col-left">${orderItemDTO.totalPrice}</td>
                    <td>
                        <a class="action-link" href="/delete-order-item?orderItemId=${orderItemDTO.orderId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </article>
    <jsp:include page="footer.jsp"/>
</body>
</html>