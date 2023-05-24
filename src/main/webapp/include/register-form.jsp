<%-- 
    Document   : register-form
    Created on : Mar 6, 2023, 4:58:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Contact Start -->
<div class="container-fluid pt-5">
    <div class="container">
        <div class="border-start border-5 border-primary ps-5 mb-5" style="max-width: 600px;">
            <h6 class="text-primary text-uppercase">Contact Us</h6>
            <h1 class="display-5 text-uppercase mb-0">Sign up</h1>
        </div>
        <div class="row g-5">
            <div class="col-lg-7">
                <h1>${message}</h1>
                <form onsubmit="return validateForm()" action="register" method="post">
                    <div class="row g-3">
                        <div class="col-12">
                            <input type="text" name ="username" minlength="7" maxlength="50" required pattern="[a-zA-Z0-9]+" class="form-control bg-light border-0 px-4" placeholder="User Name" style="height: 55px;">
                        </div>
                        <div class="col-12">
                            <input type="password" minlength="7" maxlength="50" name ="password" id="password" class="form-control bg-light border-0 px-4" placeholder="Password" style="height: 55px;" required>
                        </div>
                        <div class="col-12">
                            <input type="password" minlength="7" maxlength="50" name ="confirmPassword" id="confirm-password" class="form-control bg-light border-0 px-4" placeholder="Confirm Password" style="height: 55px;" required>
                        </div>
                        <div class="col-12">
                            <input type="text" name ="fullName" class="form-control bg-light border-0 px-4" placeholder="Full Name" style="height: 55px;" required>
                        </div>
                        <div class="col-12">
                            <input type="number" name ="age" class="form-control bg-light border-0 px-4" placeholder="Age" min="10" max="100" style="height: 55px;" required>
                        </div>
                        <div class="col-12">
                            <input type="email" name ="email" class="form-control bg-light border-0 px-4" placeholder="Your Email" style="height: 55px;" required>
                        </div>
                        <div class="col-12">
                            <input type="tel" maxlength="10" minlength="10" required pattern="[0-9]{10}" name = "phone" class="form-control bg-light border-0 px-4" placeholder="Phone number" style="height: 55px;" required>
                        </div>
                        <div class="col-12">
                            <input type="text" name ="address" class="form-control bg-light border-0 px-4" placeholder="Address" style="height: 55px;" required>
                        </div>
                        <div class="col-12">
                            <button class="btn btn-primary w-100 py-3" type="submit">Register</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-5">
                <div class="bg-light mb-5 p-5">
                    <div class="d-flex align-items-center mb-2">
                        <i class="bi bi-geo-alt fs-1 text-primary me-3"></i>
                        <div class="text-start">
                            <h6 class="text-uppercase mb-1">Our Office</h6>
                            <span>123 Street, Danang, VietNam</span>
                        </div>
                    </div>
                    <div class="d-flex align-items-center mb-2">
                        <i class="bi bi-envelope-open fs-1 text-primary me-3"></i>
                        <div class="text-start">
                            <h6 class="text-uppercase mb-1">Email Us</h6>
                            <span>info@fpt.edu.vn</span>
                        </div>
                    </div>
                    <div class="d-flex align-items-center mb-4">
                        <i class="bi bi-phone-vibrate fs-1 text-primary me-3"></i>
                        <div class="text-start">
                            <h6 class="text-uppercase mb-1">Call Us</h6>
                            <span>+012 345 6789</span>
                        </div>
                    </div>
                    <div>
                        <iframe class="position-relative w-100"
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3835.863822872289!2d108.25633498226848!3d15.968486316307787!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142116949840599%3A0x365b35580f52e8d5!2zxJDhuqFpIGjhu41jIEZQVCAoRlBUIHVuaXZlcnNpdHkp!5e0!3m2!1sen!2s!4v1677941614321!5m2!1sen!2s"
                                frameborder="0" style="height: 205px; border:0;" allowfullscreen="" aria-hidden="false"
                                tabindex="0"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        function validateForm() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirm-password").value;

            if (password!==confirmPassword) {
                alert("Mật khẩu nhập lại không khớp!");
                return false;
            }
            return true;
        }
    </script>
</div>
<!-- Contact End -->