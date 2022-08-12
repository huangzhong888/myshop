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

    <%--treeTable插件css--%>
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/css/screen.css" media="screen" />
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/css/jquery.treetable.css" />
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/css/jquery.treetable.theme.default.css" />
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
            <!-- /.row -->
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">分类列表</h3>
                            <br>
                            <div class="row" style="padding-left: 12px; padding-top: 10px" >
                                <a href="/content/category/form" type="button" class="btn  btn-default btn-sm"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-upload"></i>导出</a>
                            </div>

                            <!-- /.card-header -->
                            <div class="card-body table-responsive p-0">
                                <table id="treeTable" class="table table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>ID</th>
                                        <th>排序</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                        <tr data-tt-id="${tbContentCategory.id}" data-tt-parent-id="${tbContentCategory.parentId}">
                                            <td>${tbContentCategory.name}</td>
                                            <td>${tbContentCategory.id}</td>
                                            <td>${tbContentCategory.sortOrder}</td>
                                            <td><a href="#" type="button" class="btn  btn-primary btn-sm">编辑</a>&nbsp;&nbsp;&nbsp;
                                                <button type="button" class="btn  btn-danger btn-sm">删除</button>&nbsp;&nbsp;&nbsp;
                                                <a href="#" type="button" class="btn  btn-default btn-sm">新增下级菜单</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>

    <jsp:include page="../includes/copyright.jsp"/>

</div>
<!-- ./wrapper -->

<jsp:include page="../includes/footer.jsp"/>
<!--自定义模态框-->
<sys:modal />
<script src="/static/assets/plugins/treeTable/jquery.treetable.js"></script>
<script>
    $(function () {
       $("#treeTable").treetable({
           expandable:true
       });
    });
</script>
</body>
</html>
