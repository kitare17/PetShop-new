<%-- 
    Document   : login
    Created on : Mar 4, 2023, 9:23:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <link rel="stylesheet" href="css/login.style.css">
    </head>
    <body>


        <div class="form-login">
            <div class="center">
                <div class="ear ear--left"></div>
                <div class="ear ear--right"></div>
                <div class="face">
                    <div class="eyes">
                        <div class="eye eye--left">
                            <div class="glow"></div>
                        </div>
                        <div class="eye eye--right">
                            <div class="glow"></div>
                        </div>
                    </div>
                    <div class="nose">
                        <svg width="38.161" height="22.03">
                        <path
                            d="M2.017 10.987Q-.563 7.513.157 4.754C.877 1.994 2.976.135 6.164.093 16.4-.04 22.293-.022 32.048.093c3.501.042 5.48 2.081 6.02 4.661q.54 2.579-2.051 6.233-8.612 10.979-16.664 11.043-8.053.063-17.336-11.043z"
                            fill="#243946"></path>
                        </svg>
                        <div class="glow"></div>
                    </div>
                    <div class="mouth">
                        <svg class="smile" viewBox="-2 -2 84 23" width="84" height="23">
                        <path d="M0 0c3.76 9.279 9.69 18.98 26.712 19.238 17.022.258 10.72.258 28 0S75.959 9.182 79.987.161"
                              fill="none" stroke-width="3" stroke-linecap="square" stroke-miterlimit="3"></path>
                        </svg>
                        <div class="mouth-hole"></div>
                        <div class="tongue breath">
                            <div class="tongue-top"></div>
                            <div class="line"></div>
                            <div class="median"></div>
                        </div>
                    </div>
                </div>
                <div class="hands">
                    <div class="hand hand--left">
                        <div class="finger">
                            <div class="bone"></div>
                            <div class="nail"></div>
                        </div>
                        <div class="finger">
                            <div class="bone"></div>
                            <div class="nail"></div>
                        </div>
                        <div class="finger">
                            <div class="bone"></div>
                            <div class="nail"></div>
                        </div>
                    </div>
                    <div class="hand hand--right">
                        <div class="finger">
                            <div class="bone"></div>
                            <div class="nail"></div>
                        </div>
                        <div class="finger">
                            <div class="bone"></div>
                            <div class="nail"></div>
                        </div>
                        <div class="finger">
                            <div class="bone"></div>
                            <div class="nail"></div>
                        </div>
                    </div>
                </div>
                <form action="login" method="post" class="login" >
                    <label class="khung-user">
                        <div class=""></div>
                        <input name="username" class="username" type="text" autocomplete="on" placeholder="User name" value="${cookie.username.value}" />
                    </label>
                    <label class="khung-pass">
                        <div class=""></div>
                        <input name="password" class="password" type="password" autocomplete="off" placeholder="Password" value="${cookie.password.value}" />
                    </label>
                    <label>
                        <input type="submit" value="Login" class="login-button">
                    </label>
                </form>
                
                <%-- sua cai nay--%>
                ${thongbao}
                <div class="social-buttons">
                    <h3>Don't have any account yet? <a href="register.jsp">Sign up</a></h3>
                </div>
            </div>

            <script src="js/login.js"></script>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
            <script src="https://kit.fontawesome.com/78025ca858.js" crossorigin="anonymous"></script>

    </body>
</html>
