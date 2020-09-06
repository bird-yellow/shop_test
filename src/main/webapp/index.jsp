<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Hello World!</h2>
<div id="list">
        <ul>
                <li><a href="/itemCategory/findBySql"><span>类目管理</span></a></li>
                <li><a href="/user/findBySql"><span >用户管理</span></a></li>
                <li><a href="/item/findBySql"><span>商品管理</span></a></li>
                <li><a href="/itemOrder/findBySql"><span>订单管理</span></a></li>
                <li><a href=""><span>公告管理</span></a></li>
                <li><a href=""><span>流言管理</span></a></li>
        </ul>
</div>
</body>
</html>
