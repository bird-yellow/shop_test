<%--
  Created by IntelliJ IDEA.
  User: duck
  Date: 2020/9/5
  Time: 下午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>后台管理页面</title>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
    <script src="${ctx}/static/ueditor/ueditor.config.js"></script>
    <script src="${ctx}/static/ueditor/ueditor.all.min.js"></script>
</head>
<body>
        <div>
            <strong><span>商品维护</span></strong>
        </div>
        <div>
                <form action="/item/exUpdate" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${obj.id}"/>
                    <div>
                        <label>商品名称</label>
                        <input type="text" name="name"  value="${obj.name}"/>
                    </div>
                    <div>
                            <label>商品价格</label>
                            <input type="text" name="price" value="${obj.name}"/>
                    </div>
                    <div>
                            <label>商品折扣</label>
                            <input type="text" name="zk" value="${obj.zk}"/>
                    </div>
                    <div>
                            <label>商品类别</label>
                            <select name="categoryIdTwo" >
                                <c:forEach items="${types}" var="data" varStatus="1">
                                    <option value="${data.id}" ${obj.categoryIdTwo == data.id?"selected":""}>
                                        ${data.name}
                                    </option>
                                </c:forEach>
                            </select>
                    </div>
                    <div>
                            <label>主图</label>
                            <input type="file" name="file" >
                            <div>
                                <img src="${obj.url1}" alt="${obj.url1}">
                            </div>
                    </div>
                    <div>
                        <label>副图1</label>
                        <input type="file" name="file" >
                        <div>
                            <img src="${obj.url2}" alt="${obj.url2}">
                        </div>
                    </div>
                    <div>
                        <label>副图2</label>
                        <input type="file" name="file" >
                        <div>
                            <img src="${obj.url3}" alt="${obj.url3}">
                        </div>
                    </div>
                    <div>
                        <label>副图3</label>
                        <input type="file" name="file" >
                        <div>
                            <img src="${obj.url4}" alt="${obj.url4}">
                        </div>
                    </div>
                    <div>
                        <label>副图4</label>
                        <input type="file" name="file" >
                        <div>
                            <img src="${obj.url5}" alt="${obj.url5}">
                        </div>
                    </div>
                    <div>
                        <div class="label"><label>描述：</label></div>
                        <div class="field">
                            <script type="text/plain" id="remark_txt_1" name="ms" style="width: 100%;height: 300px;"></script>
                            <script type="text/javascript">
                                var editor = UE.getEditor('remark_txt_1');
                                UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
                                UE.Editor.prototype.getActionUrl = function (action) {
                                    if(action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo'){
                                        return '${ctx}/ueditor/saveFile';
                                    }else{
                                        return this._bkGetActionUrl.call(this,action);
                                    }
                                }
                            </script>
                             </div>
                    </div>
                    <div>
                        <input type="submit" value="提交"/>
                    </div>
                </form>
        </div>
</body>
</html>
