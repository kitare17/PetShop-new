<%@page contentType="text/html" pageEncoding="UTF-8" %>

<nav class="nav nav-pills nav-justified">
    <a class="nav-item nav-link active" href="#">Thông tin chung</a>
    <a class="nav-item nav-link " href="pet-image-manager?productId=${pet.productId}">Quản lí hình ảnh</a>
</nav>


<div class="container">

    <div class="row ">
        <form class="needs-validation mt-3" novalidate action="updatepet" method="post">

            <div class="row">
                <div class="col-12" style="background-color:#7ab730;border-radius: 10px ">
                    <h2>Cập nhật thông tin thú cưng</h2>
                </div>

                <%--input id pet--%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="petID">ID thú cưng <strong>${pet.productId}</strong></label>
                    <div class="input-group">
                        <input type="hidden" class="form-control" id="petID" placeholder="Tên thú cưng" name="petID"  value="${pet.productId}"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Username bắt đầu bằng chữ cái và từ 8 đến 20 kí tự không chứa kí tự đặc biệt
                        </div>
                    </div>
                </div>
                <%--input ten pet--%>
                <div class="col-md-6 offset-3 mb-3 mt-3">
                    <label for="petName">Tên thú cưng</label>
                    <div class="input-group">
                        <input maxlength="50" type="text" class="form-control" id="petName" placeholder="Tên thú cưng" name="petName" value="${pet.productName}"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Tối đa 1-50 ký tự
                        </div>
                    </div>
                </div>


                <%--input giá pet--%>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="petPrice">Giá thú cưng</label>
                    <div class="input-group">
                        <input type="text" pattern="^(?:\d+|\d*\.\d+)$" class="form-control" id="petPrice" placeholder="Giá thú cưng" name="petPrice" value="${pet.getPriceToDecimal()}"
                               aria-describedby="inputGroupPrepend"  required>
                        <div class="invalid-feedback">
                            Giá tiền chỉ bao gồm chữ số
                        </div>
                    </div>
                </div>
                <%--input loại pet--%>
                <div class="col-md-6 offset-3 mb-3">
                    <label for="petType" class="form-label">Chọn loại thú cưng</label>
                    <select class="form-select" id="petType" name="petType">
                        <option value="dog" ${(pet.productType.equals("dog")?"selected":" ")}>Chó</option>
                        <option value="cat" ${(pet.productType.equals("cat")?"selected":" ")}>Mèo</option>
                    </select>
                </div>

                <div class="col-md-6 offset-3 mb-3">
                    <label for="status" class="form-label">Trạng thái</label>
                    <select class="form-select" id="status" name="status" >
                        <option value="0" ${(pet.status.equals("0")?"selected":" ")}>Đã bán</option>
                        <option value="1" ${(pet.status.equals("1")?"selected":" ")}>Đang bán</option>
                    </select>
                </div>
                <div class="row">
                    <div class="col-3 offset-3">
                        <button class="btn btn-primary" type="submit">Cập nhật</button>
                    </div>
                    <div class="col-6">${thongbao}  </div>
                </div>
            </div>
        </form>


    </div>
</div>


<!-- Contact End -->
<script>
    // Lấy giá trị từ phần tử option
    var defaultValue ="${pet.status}";

    // Đặt giá trị mặc định cho phần tử select
    document.getElementById("status").value = defaultValue;
</script>


<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>