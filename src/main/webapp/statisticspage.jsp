<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/07/2023
  Time: 9:30 SA
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="include/header.jsp" %>

<div class="container-fluid pt-5 ">
    <div class="container">
        <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
            <h6 class="text-primary text-uppercase">Thống kê</h6>
            <h1 class="display-5 text-uppercase mb-0">Thống kê bán hàng của hệ thống</h1>
        </div>
        <div class="col-md-12 statistical d-flex justify-content-around mb-5">
            <div class="d-flex register m-1">
                <div style="background-color: orange;" class="icon"><i class="fa-solid fa-person-circle-check"></i>
                </div>
                <div class="detail">
                    <div>${numberOfOrderToConfirm }</div>
                    <div>Tổng đơn hàng đợi xét duyệt</div>
                </div>
            </div>
            <div class="d-flex user m-1">
                <div style="background-color: rgba(0, 0, 255, 0.726);" class="icon"><i
                        class=" fa-solid fa-user"></i></div>
                <div class="detail">
                    <div>${numberOfUsers}</div>
                    <div>Số tài khoản đã đăng kí</div>
                </div>
            </div>
            <div class="d-flex pet-sold m-1">
                <div style="background-color: #7AB730;" class="icon"><i class="fa-solid fa-paw"></i></div>
                <div class="detail">
                    <div>${numberOfPetsLeft}</div>
                    <div>Tổng số thú cưng chưa bán</div>
                </div>
            </div>
            <div class="d-flex service m-1">
                <div style="background-color: rgb(255, 108, 133);" class="icon"><i
                        class="fa-solid fa-hand-holding-heart"></i></div>
                <div class="detail">
                    <div>120</div>
                    <div>Tổng doanh thu từ dịch vụ</div>
                </div>
            </div>
            <div class="d-flex money m-1">
                <div style="background-color: rgb(204, 0, 204);" class="icon"><i class=" fa-solid fa-coins"></i>
                </div>
                <div class="detail">
                    <div>${orderRevenue}</div>
                    <div>Doanh thu bán hàng trong năm nay</div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container-fluid mt-5 mb-5 ">

    <div class="row p-5 mb-5" style="background-color: #f3f3f3">
        <div class="col-8 offset-2">
            <canvas id="sanpham"></canvas>
        </div>
        <h5 class="text-center m-5">Biểu đồ doanh thu bán hàng hàng tháng trong năm nay</h5>
    </div>
    <div class="row p-5 mb-5" style="background-color: #f3f3f3">
        <div class="col-8 offset-2">
            <canvas id="dichvu"></canvas>
        </div>
        <h5 class="text-center m-5">Biểu đồ doanh thu dịch vụ hàng tháng trong năm nay</h5>
    </div>

</div>

<div class="container mt-3"  style="background-color: #f3f3f3">
    <h2>Danh sách thức ăn bán chạy trong tháng</h2>
    <p>Đây là danh sách các mặt hàng thức ăn bán chạy trong tháng</p>

    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Thứ hạng</th>

            <th>ID Thức ăn</th>
            <th>Tên thức ăn</th>
            <th>Số lượng đã bán</th>

        </tr>
        </thead>
        <tbody id="myTable">

        <c:forEach var="food" items="${listFood}" >
            <tr>
                <td>${listFood.indexOf(food)+1}</td>
                <td>${food.productId}</td>
                <td>${food.productName}</td>
                <td>${food.productAmount}</td>
            </tr>

        </c:forEach>

        </tbody>
    </table>


</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    const ctx = document.getElementById('sanpham');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
            datasets: [{
                label: 'Doanh thu bán hàng trong tháng',
                data: [1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }//
    });

</script>
<script>
    const ctd = document.getElementById('dichvu');

    new Chart(ctd, {
        type: 'bar',
        data: {
            labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
            datasets: [{
                label: 'Doanh thu dịch vụ trong tháng',
                data: [1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000, 1200000000],
                borderWidth: 1,
                color:'FF4848',
                borderColor: '#FF4848',
                backgroundColor: '#D84444'
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });


</script>

<style>
    .statistical .icon {

        color: white;
        align-self: center;
        padding: 30px 20px;
        font-size: xx-large;
        border-radius: 10% 0 0 10%;
    }

    .statistical .detail {
        background-color: rgba(128, 128, 128, 0.116);
        border-radius: 0 10% 10% 0;
        width: 150px;
        font-size: smaller;
        text-align: center;
    }

    .statistical .detail :first-child {
        font-size: 40px;
        width: 100%;

        padding-top: 5%;
    }

    .statistical .money .detail {
        width: 250px !important;
    }
</style>
<%@include file="include/footer.jsp" %>