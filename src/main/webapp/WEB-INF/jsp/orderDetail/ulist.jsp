<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/6
  Time: 下午7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>订单详情</title>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body>
            <div>
                    <table>
                        <tr>
                            <td>商品名称</td>
                            <td>商品主图</td>
                            <td>商品单价</td>
                            <td>购买数量</td>
                            <td>总计</td>
                            <td>状态</td>
                        </tr>
                        <c:forEach items="${pagers.datas}" var="data">
                                <tr>
                                    <td>${data.item.name}</td>
                                    <td><img src="${data.item.url1}" style="width:100px;height:100px"/></td>
                                    <td>${data.item.price}</td>
                                    <td>${data.num}</td>
                                    <td>${data.total}</td>
                                    <td style="color:red">
                                        <c:if test="${data.status == 0}">未退货</c:if>
                                        <c:if test="${data.status ==1}">已退货</c:if>
                                    </td>
                                </tr>
                        </c:forEach>
                    </table>
            </div>
</body>
</html>
