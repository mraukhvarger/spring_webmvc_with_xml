<%@page pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <title>List of entities</title>

</head>
<body>
<div class="container">

    <c:forEach var="i" items="${entities}" >
        <h3>${i}</h3><br>
    </c:forEach>

</div>
</body>
</html>