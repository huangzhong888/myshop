<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css">
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/dropzone.css">
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css">
    <link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>

    <jsp:include page="../includes/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">内容管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/main">首页</a></li>
                            <li class="breadcrumb-item active">内容管理</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->


        <!-- Main content -->
        <section class="content">
            <c:if test="${baseResult!=null}">
                <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        ${baseResult.message}
                </div>
            </c:if>
            <!-- Horizontal Form -->
            <div class="card card-info">
                <div class="card-header">
                    <h3 class="card-title">${tbContent.id == null ? "新增" : "编辑"}内容</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                <form:form  id = "inputForm" cssClass="form-horizontal" action="/content/save" method="post" modelAttribute="tbContent">
                    <form:hidden path="id" />
                    <div class="card-body">
                        <div class="form-group row ">
                            <label class="col-sm-2 col-form-label">父级类目</label>
                            <div class="col-sm-10">
                                <form:hidden id="categoryId"  path="tbContentCategory.id"/>
                                <input id="categoryName" class="form-control required" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-default" value="${tbContent.tbContentCategory.name}"/>
                            </div>
                        </div>
                        <div class="form-group row ">
                            <label for="title" class="col-sm-2 col-form-label">标题</label>
                            <div class="col-sm-10">
                                <form:input path="title" class="form-control required" placeholder="标题" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="subTitle" class="col-sm-2 col-form-label">子标题</label>
                            <div class="col-sm-10">
                                <form:input path="subTitle" class="form-control required" placeholder="子标题" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="titleDesc" class="col-sm-2 control-label">标题描述</label>

                            <div class="col-sm-10">
                                <form:input path="titleDesc" class="form-control required" placeholder="标题描述" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="url" class="col-sm-2 control-label">链接</label>

                            <div class="col-sm-10">
                                <form:input path="url" class="form-control" placeholder="链接" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="url" class="col-sm-2 control-label">图片1</label>

                            <div class="col-sm-10">
                                <form:input path="pic" class="form-control" placeholder="图片1" />
                                <div id="dropz" class="dropzone"></div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="url" class="col-sm-2 control-label">图片2</label>

                            <div class="col-sm-10">
                                <form:input path="pic2" class="form-control" placeholder="图片2" />
                                <div id="dropz2" class="dropzone"></div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">详情</label>

                            <div class="col-sm-10">
                                <form:hidden path="content" />
                                <div id="editor">${tbContent.content}</div>
                            </div>
                        </div>
                    </div>
            </div>
                    <!-- /.card-body -->
                    <div class="card-footer">
                        <button id="btnSubmit" type="submit" class="btn btn-info" >提交</button>
                        <button type="button" class="btn btn-default float-right" onclick="history.go(-1);">返回</button>
                    </div>
                    <!-- /.card-footer -->
                </form:form>
    </div>
        </section>
        <!-- /.content -->
    </div>

    <jsp:include page="../includes/copyright.jsp"/>


</div>
<!-- ./wrapper -->
<jsp:include page="../includes/footer.jsp"/>
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>
<!--自定义模态框-->
<sys:modal title="请选择" message="<ul id='myTree' class='ztree'></ul>" />
<script>
    $(function () {
        App.initZTree("/content/category/tree/data",["id"],function (nodes) {
            var node = nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        });

        initWangEditor();
    });

    /**
     * 初始化富文本编辑器
     */
    function initWangEditor () {
        var E = window.wangEditor;
        var editor = new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFile';
        editor.create();
        $("#btnSubmit").bind("click", function() {
            var contentHtml = editor.txt.html();
            $("#content").val(contentHtml);
        });
    }

    App.initDropzone({
        id:"#dropz",
        url:"upload",
        init:function () {
            this.on("success",function (file,data) {
                $("#pic").val(data.filename);
            });
        }
    });

    App.initDropzone({
        id: "#dropz2",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });
</script>
</body>
</html>
