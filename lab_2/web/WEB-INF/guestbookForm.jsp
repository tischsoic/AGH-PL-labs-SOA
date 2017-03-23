<%--
  Created by IntelliJ IDEA.
  User: Jakub
  Date: 2017-03-23
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="">
    Please submit your feedback: <br/>
    Your name: <input type="text" name="name" value=""><br><br>
    Your email: <input type="text" name="email" value=""><br><br>
    Comment: <input type="text" name="comment" value=""><br><br>
    <input type="submit" value="Send feedback">
</form>
${comments} <br/> <br/>
</body>
</html>
