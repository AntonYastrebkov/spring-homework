<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>Users : "${users}"</div>

<c:forEach var="user" items="${users}">
    <div>UserId : ${user.id}</div>
    <div>Username : ${user.username}</div>
    <div>Password : ${user.password}</div>
</c:forEach>

<form action="/example2" method="post">
    <button>Upvote</button>
    <form>

            <%
    /*Java code*/
%>

</body>
</html>
