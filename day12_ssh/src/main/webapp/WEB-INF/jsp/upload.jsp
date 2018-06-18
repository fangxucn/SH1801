<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
普通情况,form表单默认的enctype是application/x-www-form-urlencoded
当表单内部有文件的时候，我们需要设置enctype为multipart/form-data
不然，文件后端是拿不到的。

--%>
    <form action="fileupload" method="post" enctype="multipart/form-data">

        <input type="file" name="icon"/>
        <button>提交</button>
    </form>
</body>
</html>
