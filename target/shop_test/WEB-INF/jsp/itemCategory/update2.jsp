<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 下午4:59
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
                <strong><span>修改二级管理目录</span></strong>
            </div>
            <div>
                    <form action="/itemCategory/exUpdate2" method="post">
                            <input type="hidden" name="id" value="${obj.id}"/>
                            <input type="hidden" name="pid" value="${obj.pid}"/>
                            <div>
                                <label>二级类目名称</label>
                                <input type="text" name="name" value="${obj.name}"/>
                            </div>
                            <div>
                                    <input type="submit" value="提交"/>
                            </div>
                    </form>
            </div>
    </div>
</body>
</html>
