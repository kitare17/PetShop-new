<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <style>
    $text-color: #30373B;
    $success-color: #7AB55C;
    $error-color: #C23628;
    $border-color: #A7A7A7;
    $body-font-size: 13px;
    $title-font-size: 32px;
    $subtitle-font-size: 20px;
    $form-font-size: 16px;
    *,
    *:before,
    *:after {
      -moz-box-sizing: border-box;
      -webkit-box-sizing: border-box;
      box-sizing: border-box;
    }

    hr {
      background: #4bc970;
      height: 1px;
      border: 0;
      border-top: 1px solid #ccc;
      padding: 0;
      text-align: right;
      width: 5%;
      float: center;
    }
    span{
      color: red;
    }
    label {
      padding-top: 15px;
      font-weight: bold;
    }

    body {
      font-size: 13px;
      font-family: 'Nunito', sans-serif;
      color: #384047;
    }

    form {
      font-size: 16px;
      max-width: 300px;
      margin: 10px auto;
      padding: 10px 20px;
      background: #f4f7f8;
      border-radius: 0px;
    }

    h1 {
      padding-top: 2em;
      font-size: 32px;
      margin: 0 0 30px 0;
      text-align: center;
    }

    h3 {
      padding-top: 1em;
      font-size: 20px;
      margin: 0 0 30px 0;
      text-align: center;
    }

    input[type="text"],
    input[type="password"],
    input[type="date"],
    input[type="datetime"],
    input[type="email"],
    input[type="number"],
    input[type="search"],
    input[type="tel"],
    input[type="time"],
    input[type="url"],
    textarea,
    select {
    //background: rgba(255,255,255,0.1);
      border: none;
      font-size: 16px;
      height: auto;
      margin: 0;
      outline: 0;
      padding: 15px;
      width: 66%;
    //background-color: #e8eeef;
      color: #8a97a0;
      box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
      margin-bottom: 30px;
    }

    button {
      padding: 12px 39px 13px 39px;
      color: #FFF;
      background-color: #4bc970;
      font-size: 18px;
      text-align: center;
      font-style: normal;
      border: 1px solid #3ac162;
    //border-width: 1px 1px 3px;
      margin-bottom: 10px;
      overflow: hidden;
    }

    label {
      display: block;
      margin-bottom: 8px;
    }

    @media screen and (min-width: 480px) {
      form {
        max-width: 480px;
      }
    }
  </style>
</head>

<body>
<h1>Quên mật khẩu</h1>
<hr></hr>
<h3>Chúng tôi đã gửi otp đến mail của bạn</h3>

<form action="otp" method="post">
  <label for="otp">Nhập OTP</label></br>
  <input type="text" id="otp" name="otp" placeholder="Nhập otp" required >
  <button type="submit">Submit</button>
  <span id="nameError" style="display: none;" >There was an error with your email</span>
  <div>
    <p style="color: red">${thongbao}</p>
  </div>
</form>
<%--<script>--%>
<%--  function validateName(x)--%>
<%--  {--%>
<%--    var re = /[A-Za-z@0-9.]/--%>
<%--    if(re.test(document.getElementById(x).value)){--%>
<%--      return true;--%>
<%--    }else{--%>
<%--      // document.getElementById(x ).style.background ='#e35152';--%>
<%--      document.getElementById(x + 'Error').style.display = "block";--%>
<%--      return false;--%>
<%--    }--%>
<%--  }--%>
<%--</script>--%>
</body>
</html>