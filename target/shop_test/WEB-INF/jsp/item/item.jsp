<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 下午9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="/WEB-INF/tlds/pager-taglib.tld" %>
<html>
<head>
    <title>后台管理员</title>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body>
        <div>
                <form acion="/item/findBySql"  id="listform" method="post">
                        <ul>
                            <li><a href="/item/add">添加商品</a></li>
                            <li><input type="text" name="name" value="${obj.name}"/>
                                <a href="javascript:void(0)" onclick="changeSearch()"><span>搜索</span></a>
                            </li>
                        </ul>
                </form>
                <div>
                        <table>
                                <tr>
                                    <th>商品名称</th>
                                    <th>商品主图</th>
                                    <th>商品价格</th>
                                    <th>商品一级分类</th>
                                    <th>商品二级分类</th>
                                    <th>操作</th>
                                </tr>
                            <c:forEach items="${pagers.datas}" var="data">
                                    <tr>
                                        <td>${data.name}</td>
                                        <td><img src="${data.url1}" style="width:100px;height:100px;"></td>
                                        <td>${data.price}</td>
                                        <td>${data.yiji.name}</td>
                                        <td>${data.erji.name}</td>
                                        <td>
                                                <a href="/item/update?id=${data.id}"><span>修改</span></a>
                                                <a href="/item/delete?id=${data.id}"><span>下架</span></a>
                                        </td>
                                    </tr>
                            </c:forEach>
                        </table>
                </div>
        </div>
        <script>
                function changeSearch() {
                        $("#listform").submit();
                }
        </script>
</body>
</html>
