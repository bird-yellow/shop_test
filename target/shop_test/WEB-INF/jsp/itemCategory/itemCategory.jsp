<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 上午10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台管理页面</title>
</head>
<body>
        <div>
            <div>

                    <li> <input type="text"><a href="/itemCategory/add">新增类目</a></li>
            </div>
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
                                        <a href="/itemCategory/findBySql2?pid=${data.id}"><span>查看二级分类</span></a>
                                        <a href="/itemCategory/update?id=${data.id}"><span>修改</span></a>
                                        <a href="/itemCategory/delete?id=${data.id}"><span>删除</span></a>
                                </div>
                            </td>
                        </tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>
