<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Chapaar</title>
		<link rel="icon" type="image/ico" href="/resources/images/logo.png" />
		<link rel="stylesheet" type="text/css" href="/resources/style/style.css" />
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<article>
			<h2 class="article-heading">${headline}</h2>
			<p class="article-notification col-left">${msg}</p>
		</article>
		<jsp:include page="footer.jsp"/>
	</body>
</html>