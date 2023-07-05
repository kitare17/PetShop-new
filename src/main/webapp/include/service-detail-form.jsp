<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 6/21/2023
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .rate {
        float: left;
        height: 46px;
        padding: 0 10px;
    }

    .rate:not(:checked)>input {
        position: absolute;
        top: -9999px;
    }

    .rate:not(:checked)>label {
        float: right;
        width: 1em;
        overflow: hidden;
        white-space: nowrap;
        cursor: pointer;
        font-size: 30px;
        color: #ccc;
    }

    .rate:not(:checked)>label:before {
        content: '★ ';
    }

    .rate>input:checked~label {
        color: #ffc700;
    }

    .rate:not(:checked)>label:hover,
    .rate:not(:checked)>label:hover~label {
        color: #deb217;
    }

    .rate>input:checked+label:hover,
    .rate>input:checked+label:hover~label,
    .rate>input:checked~label:hover,
    .rate>input:checked~label:hover~label,
    .rate>label:hover~input:checked~label {
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
<div class="container-fluid mt-5">
    <div class="container d-flex justify-content-around">
        <div class="col-md-4">
            <img class="w-100" src="${service.listImg.get(0).getUrl()}" alt="asdsd">
        </div>
        <div class="col-md-7">

            <h2>${service.serviceName}</h2>
            <p>${service.description}</p>
<%--            <p>${service.serviceID}</p>--%>
<%--            <p>${service.listImg.get(0).getUrl()}</p>--%>

            <h6>Thương hiệu: <a href="">FPT</a></h6>
            <div class="d-flex">
                <h4 class="mb-3 pb-3">đ</h4>
                <h1>${service.getPriceString()}</h1>
            </div>
            <div class="d-flex">
                <h6 class="align-self-center mb-0">Đánh giá dịch vụ </h6>
                <div class="rate align-self-auto">
                    <input type="radio" id="star5" name="rate" value="5" />
                    <label for="star5" title="text">5 stars</label>
                    <input type="radio" id="star4" name="rate" value="4" />
                    <label for="star4" title="text">4 stars</label>
                    <input type="radio" id="star3" name="rate" value="3" />
                    <label for="star3" title="text">3 stars</label>
                    <input type="radio" id="star2" name="rate" value="2" />
                    <label for="star2" title="text">2 stars</label>
                    <input type="radio" id="star1" name="rate" value="1" />
                    <label for="star1" title="text">1 star</label>
                </div>
            </div>
<%--            <div><i class=""></i> Vận chuyển tới: <select class="form-select w-25" name="" id="">--%>
<%--                <option value="hcm">TP.Hồ Chí Minh</option>--%>
<%--                <option value="dn">Đà Nẵng</option>--%>
<%--                <option value="hn">Hà Nội</option>--%>
<%--            </select>--%>
<%--            </div>--%>
            <hr>

            <form action="get-calendar-service">
<%--                <div>--%>
<%--                    <div class="shopee-input-quantity">--%>
<%--                        <input type="button" class="add-sl shopee-button-outline" title="Bớt"--%>
<%--                               onclick="var qty_el = document.getElementById('qty');--%>
<%--                                       var qty = qty_el.value;--%>
<%--                                       if (!isNaN(qty) && qty >1)--%>
<%--                                           qty_el.value--;--%>
<%--                                       return false;">--%>

<%--                        <input aria-label="Number" name="ammount" id="qty" type="text" size="1"--%>
<%--                               class="soluong_12 shopee-button-outline shopee-button-outline-mid" value="1" readonly>--%>
<%--                        <input type="button" class="sub-sl shopee-button-outline" title="Thêm"--%>
<%--                               onclick="var qty_el = document.getElementById('qty');--%>
<%--                                       var qty = qty_el.value;--%>
<%--                                       if (!isNaN(qty))--%>
<%--                                           qty_el.value++;--%>
<%--                                       return false;">--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="buttons">
                    <div>
                        <input name ="serviceID" type = "text" hidden="" value = "${service.serviceID}">
                        <input class="btn btn-primary" type="submit" value="Đặt ngay">
                    </div>
                    <h3>${message}</h3>
                </div>
            </form>
        </div>

    </div>
</div>
