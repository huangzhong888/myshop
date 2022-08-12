<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户管理</title>
    <jsp:include page="../includes/header.jsp"/>
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
                        <h1 class="m-0">用户管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/main">首页</a></li>
                            <li class="breadcrumb-item active">用户管理</li>
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
                            <h3 class="card-title">用户列表</h3>
                            <br>
                            <div class="row" style="padding-left: 12px; padding-top: 10px" >
                                <a href="/user/form" type="button" class="btn  btn-default btn-sm"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn  btn-default btn-sm" onclick="App.deleteMulti('/user/delete')">删除</button>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-upload"></i>导出</a>
                            </div>

                            <div class="box-body">
                                <div class="row form-horizontal">
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="username" class="col-sm-4 control-label">姓名</label>

                                            <div class="col-sm-8">
                                                <input id="username" class="form-control" placeholder="姓名" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-4 control-label">邮箱</label>

                                            <div class="col-sm-8">
                                                <input id="email"  class="form-control" placeholder="邮箱" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="phone" class="col-sm-4 control-label">手机</label>

                                            <div class="col-sm-8">
                                                <input id="phone"  class="form-control" placeholder="手机" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                                    </div>
                                </div>
                            </div>
                        <!-- /.card-header -->
                        <div class="card-body table-responsive p-0">
                            <table id="dataTable" class="table table-hover text-nowrap">
                                <thead>
                                <tr>
                                    <!-- checkbox -->
                                    <th>
                                    <input type="checkbox" class="minimal icheck_master"/>
                                    </th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
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

<script>
    var _dataTable;
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input type="checkbox" id="'+row.id+'" class="minimal"/>';
                }
            },
            {"data": "id"},
            {"data": "username"},
            {"data": "phone"},
            {"data": "email"},
            {"data": "updated"},
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/user/detail?id=" + row.id;
                    var deleteUrl = "/user/delete";
                    return '<button type="button" class="btn  btn-default btn-sm" onclick="App.showDetail(\''+detailUrl+'\')">查看</button>' +
                        '<a href="/user/form?id='+row.id+'" type="button" class="btn  btn-primary btn-sm">编辑</a>' +
                        '<a href="#" type="button" class="btn  btn-danger btn-sm">删除</a>';
                }
            }
        ];
        _dataTable = App.initDataTables("/user/page",_columns);
    });

    function search() {
        //获取被选择的元素的值
        var username = $("#username").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var param = {
            "username": username,
            "phone": phone,
            "email": email
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>
