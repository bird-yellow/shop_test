<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 2020/9/4
  Time: 下午5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户页面</title>
</head>
<body>
        <div>
                <form action="/user/findBySql" method="post">
                    <div>
                        <ul>
                            <li>
                                <input type="text" placeholder="请输入用户名" name="username" value="${obj.username}"/>

                            </li>
                        </ul>
                    </div>
                </form>
                <table>
                    <tr>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>真实姓名</th>
                        <th>性别</th>
                        <th>邮箱</th>
                        <th>地址</th>
                    </tr>
                    <c:forEach items="${pagers.datas}" var="data">
                        <tr>
                            <td>
                                ${data.username}
                            </td>
                            <td>${data.password}</td>
                            <td>${data.realname}</td>
                            <td>${data.sex}</td>
                            <td>${data.email}</td>
                            <td>${data.address}</td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
</body>
</html>
