<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/6
  Time: 下午7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>后台管理系统</title>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body>
        <div>
                <form action="/itemOrder/findBySql" id="listForm" method="post">
                        <div>
                            <li><input type="text" placeholder="订单号" name="code"value="${obj.code}">
                                <a href="javascript:void(0)" onclick="changeSearch()">搜索</a>
                            </li>
                        </div>
                </form>
                <table>
                    <tr>
                        <td>订单号</td>
                        <td>下单时间</td>
                        <td>总金额</td>
                        <td>下单人</td>
                        <td>订单状态</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach  items="${pagers.datas}" var="data" varStatus="1">
                            <tr>
<%--                                    订单号--%>
                                <td>${data.id}</td>
                                <td>
                                    <fmt:formatDate value="${data.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>${data.total}</td>
                                <td>${data.user.username}</td>
                                <td>${data.status}</td>
                                <td>
                                    <a href="/orderDetail/ulist?order_id=${data.id}"><span>查看商品详情</span></a>
                                    <c:if test="${data.status == 0}">
                                        <a href=""><span>去发货</span></a>
                                    </c:if>
                                </td>

                            </tr>
                    </c:forEach>
                </table>
        </div>
        <script>
             function changeSearch() {
                    $("#listForm").submit();
             }
        </script>
</body>
</html>
