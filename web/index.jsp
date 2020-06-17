<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录界面</title>
</head>
<body>
<form action="/loginSession" method="post">
  账号：<input type="text" name="account"><br><br>
  密码：<input type="text" name="password"><br><br>

  <input type="submit" value="登录">
</form>
</body>
</html>
