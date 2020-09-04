<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员页面</title>
</head>
<body>
        <div>
                <ul>
                    <li><a href="/itemCategory/add2?pid=${obj.pid}"><span>新增二级类目</span></a></li>
                </ul>
                <div>
                    <table>
                            <tr>
                                <th>ID</th>
                                <th>类别名称</th>
                                <th>操作</th>
                            </tr>
                        <c:forEach items="${pagers.datas}" var="data" varStatus="1">
                            <tr>
                                    <td>${data.id}</td>
                                    <td>${data.name}</td>
                                    <td>
                                        <div>
                                            <a href="/itemCategory/update2?id=${data.id}"><span>修改</span></a>
                                            <a href="/itemCategory/delete2?id=${data.id}&pid=${data.pid}"><span>删除</span></a>
                                        </div>
                                    </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
        </div>
</body>
</html>
