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
                            <h3 class="card-title">内容列表</h3>
                            <br>
                            <div class="row" style="padding-left: 12px; padding-top: 10px" >
                                <a href="/content/form" type="button" class="btn  btn-default btn-sm"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn  btn-default btn-sm" onclick="App.deleteMulti('/content/delete')">删除</button>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                <a href="#" type="button" class="btn  btn-default btn-sm"><i class="fa fa-upload"></i>导出</a>
                            </div>

                            <div class="box-body">
                                <div class="row form-horizontal">
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="title" class="col-sm-4 control-label">标题</label>

                                            <div class="col-sm-8">
                                                <input id="title" class="form-control" placeholder="标题" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="subTitle" class="col-sm-4 control-label">子标题</label>

                                            <div class="col-sm-8">
                                                <input id="subTitle"  class="form-control" placeholder="子标题" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="titleDesc" class="col-sm-4 control-label">标题描述</label>

                                            <div class="col-sm-8">
                                                <input id="titleDesc"  class="form-control" placeholder="标题描述" />
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
                                        <th>所属分类</th>
                                        <th>标题</th>
                                        <th>子标题</th>
                                        <th>标题描述</th>
                                        <th>链接</th>
                                        <th>图片1</th>
                                        <th>图片2</th>
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
            {"data":"tbContentCategory.name"},
            {"data": "title"},
            {"data": "subTitle"},
            {"data": "titleDesc"},
            {"data": function (row,type,val,meta) {
                   if(row.url==null){
                       return '';
                   }
                    return '<a href="'+row.url+'" target="_blank">查看</a>';
                }},
            {"data": function (row,type,val,meta) {
                    if(row.pic==null){
                        return '';
                    }
                    return '<a href="'+row.pic+'" target="_blank">查看</a>';
                }},
            {"data": function (row,type,val,meta) {
                    if(row.pic2==null){
                        return '';
                    }
                    return '<a href="'+row.pic2+'" target="_blank">查看</a>';
                }},
            {"data": function (row,type,val,meta) {
                    return DateTime.format(row.updated,"yyyy-MM-dd HH:mm:ss");
                }},
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/content/detail?id=" + row.id;
                    var deleteUrl = "/content/delete";
                    return '<button type="button" class="btn  btn-default btn-sm" onclick="App.showDetail(\''+detailUrl+'\')">查看</button>' +
                        '<a href="/content/form?id='+row.id+'" type="button" class="btn  btn-primary btn-sm">编辑</a>' +
                        '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\'' + deleteUrl + '\', \'' + row.id + '\')"><i class="fa fa-trash-o"></i> 删除</button>';
                }
            }
        ];
        _dataTable = App.initDataTables("/content/page",_columns);
    });

    function search() {
        //获取被选择的元素的值
        var title = $("#title").val();
        var subTitle = $("#subTitle").val();
        var titleDesc = $("#titleDesc").val();
        var param = {
            "title": title,
            "subTitle": subTitle,
            "titleDesc": titleDesc
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>

