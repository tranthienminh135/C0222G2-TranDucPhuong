<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../style/bootstrap/normalize.css">
    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<jsp:include page="web-service/header.jsp"/>
<div class="container-fluid" style="padding: 50px">
    <h2 class="" style="float: left">Management</h2>
    <div class="table-scrollable col-12 border-dark">
        <table id="tableCustomer" class="table table-light table-hover table-warning">
            <thead>
            <tr class="table-danger">
                <th class="table-warning">Id</th>
                <th class="table-warning">Name</th>
                <th class="table-warning">Point</th>
                <th class="table-warning">Status</th>
                <th class="table-warning">Delete</th>
                <th class="table-warning">Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach begin="1" end="5" var="i">
                <tr>
                    <td class="table-warning">id</td>
                    <td class="table-warning">name</td>
                    <td class="table-warning">point</td>
<%--                    <c:choose>--%>
<%--                        <c:when test="${i.status == 0}">--%>
<%--                            <td class="table-warning text-success">Active</td>--%>
<%--                            <td class="table-warning">--%>
<%--                                <a href="" class="text-danger text-decoration-none fw-bold hover-zoom"--%>
<%--                                   data-bs-toggle="modal" data-bs-target="#staticBackdrop${i.id}">--%>
<%--                                    Delete--%>
<%--                                </a>--%>
<%--                            </td>--%>
<%--                        </c:when>--%>
<%--                        <c:when test="${i.status == 1}">--%>
<%--                            <td class="table-warning text-danger">Deleted</td>--%>
<%--                            <td class="table-warning">--%>
<%--                                <span class="text-secondary text-decoration-line-through fw-bold hover-zoom">--%>
<%--                                    Delete--%>
<%--                                </span>--%>
<%--                            </td>--%>
<%--                        </c:when>--%>
<%--                    </c:choose>--%>

<%--                    <!-- Modal -->--%>
<%--                    <div class="modal fade" id="staticBackdrop${i.id}" data-bs-backdrop="static"--%>
<%--                         data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"--%>
<%--                         aria-hidden="true">--%>
<%--                        <div class="modal-dialog">--%>
<%--                            <div class="modal-content">--%>
<%--                                <div class="modal-header">--%>
<%--                                    <h5 class="modal-title text-danger" id="staticBackdropLabel">Yamete!</h5>--%>
<%--                                </div>--%>
<%--                                <div class="modal-body">--%>
<%--                                    <h5>Do you want delete <strong class="text-warning">${i.name}</strong> ?--%>
<%--                                    </h5>--%>
<%--                                </div>--%>
<%--                                <div class="modal-footer">--%>
<%--                                    <a href="employee?action=delete&idDelete=${i.id}"--%>
<%--                                       class="btn btn-pink text-white">Accept</a>--%>
<%--                                    <button type="button" class="btn btn-secondary text-white" data-bs-dismiss="modal"--%>
<%--                                            style="background-color: grey !important;">Close--%>
<%--                                    </button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <td class="table-warning"><a href="employee?action=edit&idEdit=${i.id}"--%>
<%--                                                 class="text-warning text-decoration-none fw-bold hover-zoom">Edit</a>--%>
<%--                </tr>--%>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="web-service/footer.jsp"/>
</body>
<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
