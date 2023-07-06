<%-- 
    Document   : cart-form
    Created on : Mar 15, 2023, 2:41:01 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>


<style>
    .rate {
        float: left;
        height: 46px;
        padding: 0 10px;
    }

    .rate:not(:checked) > input {
        position: absolute;
        top: -9999px;
    }

    .rate:not(:checked) > label {
        float: right;
        width: 1em;
        overflow: hidden;
        white-space: nowrap;
        cursor: pointer;
        font-size: 30px;
        color: #ccc;
    }

    .rate:not(:checked) > label:before {
        content: '★ ';
    }

    .rate > input:checked ~ label {
        color: #ffc700;
    }

    .rate:not(:checked) > label:hover,
    .rate:not(:checked) > label:hover ~ label {
        color: #deb217;
    }

    .rate > input:checked + label:hover,
    .rate > input:checked + label:hover ~ label,
    .rate > input:checked ~ label:hover,
    .rate > input:checked ~ label:hover ~ label,
    .rate > label:hover ~ input:checked ~ label {
        color: #c59b08;
    }


    .shopee-input-quantity {
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        display: inline-flex;
        -webkit-box-align: center;
        -webkit-align-items: center;
        -moz-box-align: center;
        -ms-flex-align: center;
        align-items: center;
    }

    .shopee-button-outline {
        outline: 0;
        cursor: pointer;
        border: 0;
        font-size: 1.4rem;
        font-weight: 300;
        line-height: 1;
        letter-spacing: 0;
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-align: center;
        -webkit-align-items: center;
        -moz-box-align: center;
        -ms-flex-align: center;
        align-items: center;
        -webkit-box-pack: center;
        -webkit-justify-content: center;
        -moz-box-pack: center;
        -ms-flex-pack: center;
        justify-content: center;
        transition: background-color .1s cubic-bezier(.4, 0, .6, 1);
        border: 1px solid rgba(0, 0, 0, .09);
        border-radius: 2px;
        background: transparent;
        color: #7AB730;
    }

    .add-sl {
        background: url(https://etoy.vn/images/input-previou.png) no-repeat scroll center center #fffefe !important;
        height: 32px;
        width: 30px;
        border: 1;
        box-shadow: none;
        margin-left: -1px;
    }

    .sub-sl {
        background: url(https://etoy.vn/images/input-next.png) no-repeat scroll center center #fffefe !important;
        float: left;
        height: 32px;
        margin: 0;
        width: 30px;
        border: 1;
        box-shadow: none;
        margin-right: -1px;
    }

</style>
<div class="container-fluid">
    <div class="container d-flex justify-content-around">
        <div class="col-md-4">
            <img class="w-100" src="${product.listImg.get(0).getUrl()}" alt="asdsd">
        </div>
        <div class="col-md-7">

            <h2>${product.productName}</h2>
            <p>- Sản phẩm sở hữu cho bản thân mình một loại công thức đặc biệt đã được nghiên cứu và kiểm chứng tại
                Thái Lan trong suốt nhiều năm dài.
            </p>
            <p>- Công thức này là sự tổng hợp của 3 nhóm Omega 3-6-9. Đây là 3 nhóm Omega mà cơ thể của cún cưng
                không thể tự tổng hợp, cũng như không thể được đưa vào từ các loại thực phẩm thông thường.</p>
            <p>- Hơn nữa, Omega 3-6-9 còn giúp cải thiện sức khỏe mắt và sức chịu đựng, tính bền trong các tế bào,
                mô cơ của cún cưng. Giúp xương của cún chắc khỏe hơn, cơ bắp có sức chịu đựng cao hơn.</p>
            <h6>Thương hiệu: <a href="">Rlex</a></h6>
            <div class="d-flex">
                <h4 class="mb-3 pb-3">đ</h4>
                <h1>${product.getPriceString()}</h1>
            </div>
            <div class="d-flex">
                <h6 class="align-self-center mb-0">Đánh giá sản phẩm: </h6>
                <div class="rate align-self-auto">
                    <input type="radio" id="star5" name="rate" value="5"/>
                    <label for="star5" title="text">5 stars</label>
                    <input type="radio" id="star4" name="rate" value="4"/>
                    <label for="star4" title="text">4 stars</label>
                    <input type="radio" id="star3" name="rate" value="3"/>
                    <label for="star3" title="text">3 stars</label>
                    <input type="radio" id="star2" name="rate" value="2"/>
                    <label for="star2" title="text">2 stars</label>
                    <input type="radio" id="star1" name="rate" value="1"/>
                    <label for="star1" title="text">1 star</label>
                </div>
            </div>
            <div><i class=""></i> Vận chuyển tới: <select class="form-select w-25" name="" id="">
                <option value="hcm">TP.Hồ Chí Minh</option>
                <option value="dn">Đà Nẵng</option>
                <option value="hn">Hà Nội</option>
            </select>
            </div>
            <hr>


            <c:if test="${sessionScope.user.userId.startsWith('C')}">

                <form action="additem">
                    <div>
                        <div class="shopee-input-quantity">
                            <input type="button" class="add-sl shopee-button-outline" title="Bớt"
                                   onclick="var qty_el = document.getElementById('qty');
                                       var qty = qty_el.value;
                                       if (!isNaN(qty) && qty >1)
                                           qty_el.value--;
                                       return false;">

                            <input aria-label="Number" name="ammount" id="qty" type="text" size="1"
                                   class="soluong_12 shopee-button-outline shopee-button-outline-mid" value="1"
                                   readonly>
                            <input type="button" class="sub-sl shopee-button-outline" title="Thêm"
                                   onclick="var qty_el = document.getElementById('qty');
                                       var qty = qty_el.value;
                                       if (!isNaN(qty))
                                           qty_el.value++;
                                       return false;">
                        </div>
                    </div>
                    <div class="buttons">
                        <div>
                            <input name="id" type="text" hidden="" value="${product.productId}">
                            <input class="btn btn-primary" type="submit" value="Thêm vào giỏ hàng">
                        </div>
                        <h3>${message}</h3>
                    </div>
                </form>
            </c:if>
            <c:if test="${sessionScope.user==null}">

                <a href="login.jsp" class="btn btn-primary">Mua ngay</a>

            </c:if>
        </div>

    </div>
</div>
