<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="/WEB-INF/tlds/pager-taglib.tld" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/static/css/admin.css">
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
    <script type="text/javascript" src="${ctx}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx}/static/ueditor/ueditor.all.min.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">新增商品</span> </strong>
    </div>
    <div class="body-content">
        <form action="/item/exAdd" method="post" class="form-x" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label"><label>商品名称：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入商品名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品价格：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="price" data-validate="required:请输入商品价格" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品折扣：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="zk" data-validate="required:请输入商品折扣" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品类别：</label></div>
                <div class="field">
                    <select name="categoryIdTwo" class="input w50">
                        <c:forEach items="${types}" var="data" >
                            <option value="${data.id}">${data.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>主图：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图1：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图2：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图3：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图4：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
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
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>