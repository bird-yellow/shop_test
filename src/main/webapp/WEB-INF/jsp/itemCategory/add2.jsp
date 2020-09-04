<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 下午4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台管理页面</title>
</head>
<body>
        <div>
                <div>
                    <strong><span>新增二级类目</span></strong>
                </div>
                <div>
                        <form method="post" action="/itemCategory/exAdd2">
                                <input type="hidden" value="${pid}" name="pid"/>
                                <div>
                                        <label>二级类目名称:</label>
                                        <input type="text" name="name" value=""/>
                                </div>
                                <input type="submit" value="提交"/>
                        </form>
                </div>
        </div>
</body>
</html>
