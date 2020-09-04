<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/4
  Time: 下午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="/WEB-INF/tlds/pager-taglib.tld" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>后台管理员</title>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body>
            <div>
                    <div>
                        <strong>
                            <span>新增商品</span>
                        </strong>
                    </div>
                    <div>
                        <form action="/item/exAdd" method="post" enctype="multipart/form-data">
                                <div>
                                    <label>商品名称</label>
                                    <input type="text" name="name"/>
                                </div>
                                <div>
                                        <label>商品价格</label>
                                        <input type="text" name="price"/>
                                </div>
                                <div >
                                        <label>商品折扣</label>
                                        <input type="text" name="zk"/>
                                </div>
                                <div>
                                        <label>商品类别</label>
                                        <select name="categoryIdTwo">
                                            <c:forEach items="${types}" var="data" varStatus="1">
                                                <option value="${data.id}">${data.name}</option>
                                            </c:forEach>
                                        </select>
                                </div>
                                <div>
                                        <label>主图</label>
                                        <input type="file" name="file"/>
                                </div>
                                <div>
                                    <label>副图1</label>
                                    <input type="file" name="file"/>
                                </div>
                                <div>
                                    <label>副图2</label>
                                    <input type="file" name="file"/>
                                </div>
                                <div>
                                    <label>副图3</label>
                                    <input type="file" name="file"/>
                                </div>
                                <div>
                                    <label>副图4</label>
                                    <input type="file" name="file"/>
                                </div>

                                <button type="submit">提交</button>
                        </form>
                    </div>
            </div>
</body>
</html>
