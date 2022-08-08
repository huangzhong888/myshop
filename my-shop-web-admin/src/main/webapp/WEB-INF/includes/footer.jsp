<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">查看详情</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p id="modal-detail-body"></p>
            </div>
            <div class="modal-footer">
                <button  type="button" class="btn btn-primary " data-dismiss="modal" >确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- jQuery -->
<script src="/static/assets/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/static/assets/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="/static/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/static/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- overlayScrollbars -->
<script src="/static/assets/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/assets/js/adminlte.js"></script>
<%--iCheck--%>
<script src="/static/assets/plugins/iCheck/icheck.min.js"></script>
<!-- jQuery Validation Plugin - v1.14.0 -->
<script src="/static/assets/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="/static/assets/plugins/jquery-validation/additional-methods.min.js"></script>
<script src="/static/assets/plugins/jquery-validation/localization/messages_zh.min.js"></script>
<!-- App -->
<script src="/static/assets/app/validate.js"></script>
<script src="/static/assets/app/app.js"></script>
<!-- DataTables  & Plugins -->
<script src="/static/assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/static/assets/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/assets/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="/static/assets/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="/static/assets/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="/static/assets/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="/static/assets/plugins/jszip/jszip.min.js"></script>
<script src="/static/assets/plugins/pdfmake/pdfmake.min.js"></script>
<script src="/static/assets/plugins/pdfmake/vfs_fonts.js"></script>
<script src="/static/assets/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="/static/assets/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="/static/assets/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>


<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>