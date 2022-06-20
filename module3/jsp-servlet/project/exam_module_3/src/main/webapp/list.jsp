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
<nav class="navbar navbar-expand-sm navbar-dark bg-warning p-2">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link text-white active" href="home">Home</a>
                </li>
            </ul>
            <form class="d-flex" method="get">

                <div class="form-outline mb-4">
                    <label class="form-label" for="form1Example12">Loại Văn Phòng</label>
                    <select class="form-select" aria-label="Default select example" id="form1Example12"
                            name="maloaiVanPhong">
                        <option selected disabled>Chon loại văn phòng</option>
                        <c:forEach items="${loaiVanPhongs}" var="i">
                            <c:choose>
                                <c:when test="${i.maLoaiVanPhong == maloaiVanPhong}">
                                    <option value="${i.maLoaiVanPhong}" selected>${i.tenLoaiVanPhong}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${i.maLoaiVanPhong}">${i.tenLoaiVanPhong}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <div class="text-black text-center bg-warning"></div>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form1Example11">Tầng</label>
                    <select class="form-select" aria-label="Default select example" id="form1Example11" name="tang">
                        <option selected disabled>Chon tầng</option>
                        <c:forEach begin="1" end="15" var="i">
                            <c:choose>
                                <c:when test="${i == tang}">
                                    <option value="${i}" selected>${i}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${i}">${i}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <div class="text-black text-center bg-warning"></div>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form1Example55">Ngày Bắt Đầu Thuê</label>
                    <input type="date" id="form1Example55" class="form-control" name="ngayBatDau"
                           value="${ngayBatDau}"/>
                    <div class="text-black text-center bg-warning"></div>
                </div>

                <div class="form-outline mb-4">
                    <label class="form-label" for="form1Example66">Ngày Kết Thúc Thuê</label>
                    <input type="date" id="form1Example66" class="form-control" name="ngayKetThuc"
                           value="${ngayKetThuc}"/>
                    <div class="text-black text-center bg-warning"></div>
                </div>
                <div class="form-outline mb-4">
                    <label class="form-label" for="form1Example555">Ngày Kết Thúc</label>
                    <button id="form1Example555" class="form-control btn btn-primary" type="submit">Search</button>
                </div>
                <input type="text" value="search" name="action" hidden>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding: 50px">
    <h2 class="" style="float: left">TComplex Management</h2>
    <a href="home?action=create" class="btn btn-success" style="float: right; background-color: deeppink !important;">Thêm
        mới mặt bằng</a>
    <div class="table-scrollable col-12 border-dark">
        <table id="myTable" class="table table-light table-hover table-warning">
            <thead>
            <tr class="table-danger">
                <th class="table-warning">Mã mặt bằng</th>
                <th class="table-warning">Diện tích</th>
                <th class="table-warning">Trạng thái</th>
                <th class="table-warning">Tầng</th>
                <th class="table-warning">Loại văn Phòng</th>
                <th class="table-warning">Mô tả chi tiết</th>
                <th class="table-warning">Giá cho thuê</th>
                <th class="table-warning">Ngày bắt đầu</th>
                <th class="table-warning">Ngày kết thúc</th>
                <th class="table-warning">Hành Động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${matBangs}" var="i">
                <tr>
                    <td class="table-warning">${i.maMatBang}</td>
                    <td class="table-warning">${i.dienTich}</td>
                    <c:forEach items="${trangThais}" var="o">
                        <c:if test="${i.maTrangThai == o.maTrangThai}">
                            <td class="table-warning">${o.tenTrangThai}</td>
                        </c:if>
                    </c:forEach>
                    <td class="table-warning">${i.tang}</td>
                    <c:forEach items="${loaiVanPhongs}" var="o">
                        <c:if test="${i.maLoaiVanPhong == o.maLoaiVanPhong}">
                            <td class="table-warning">${o.tenLoaiVanPhong}</td>
                        </c:if>
                    </c:forEach>
                    <td class="table-warning">${i.moTaChiTiet}</td>
                    <td class="table-warning"><fmt:formatNumber currencyCode="currency" value="${i.giaChoThue}"/></td>
                    <td class="table-warning">${i.ngayBatDau}</td>
                    <td class="table-warning">${i.ngayKetThuc}</td>
                    <td class="table-warning">
                        <a href="" class="text-danger text-decoration-none fw-bold hover-zoom"
                           data-bs-toggle="modal"
                           data-bs-target="#staticBackdrop${i.maMatBang}">
                            Delete
                        </a>
                    </td>


                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop${i.maMatBang}" data-bs-backdrop="static"
                         data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title text-danger" id="staticBackdropLabel">Cảnh Báo!</h5>
                                </div>
                                <div class="modal-body">
                                    <h5>Bạn có chắc chắn muốn xóa mặt bằng với mã số <strong
                                            class="text-warning">${i.maMatBang}</strong> ?
                                    </h5>
                                </div>
                                <div class="modal-footer">
                                    <a href="home?action=delete&idDelete=${i.maMatBang}"
                                       class="btn btn-pink text-white">Yes</a>
                                    <button type="button" class="btn btn-secondary text-white" data-bs-dismiss="modal"
                                            style="background-color: grey !important;">No
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>
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
        $('#myTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
