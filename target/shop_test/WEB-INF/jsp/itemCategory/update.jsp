<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 下午4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员后台</title>
</head>
<body>
        <div>
                <span>商品维护</span>
        </div>
        <div>
                <form action="/itemCategory/exUpdate" method="post" >
<%--                                隐藏商品id,传递--%>
                        <input type="hidden" name="id" value="${obj.id}"/>
                        <div>
                            <input type="text" name="name" value="${obj.name}"/>
                        </div>
                        <input type="submit" value="提交"/>
                </form>
        </div>
</body>
</html>
