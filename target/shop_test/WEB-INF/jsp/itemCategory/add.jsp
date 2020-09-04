<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 下午4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台管理页面</title>
</head>
<body>
        <div>
            <div>
                    <label>新增类目</label>
            </div>
            <div>
                    <form action="/itemCategory/exAdd" method="post" >
                            <div>
                                <label>一级类目名称</label>
                                <input type="text" name="name" />
                            </div>
                            <input type="submit" value="提交"/>
                    </form>
            </div>
        </div>

</body>
</html>
