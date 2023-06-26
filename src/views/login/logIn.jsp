<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/logIn.css">
    <title>Log In</title>
</head>
<body class="container vh-100 d-flex justify-content-center align-items-center">
    <section>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 text-black">
    
                    <div class="px-4 mt-3 ms-xl-4">
                        <img src="<%= request.getContextPath() %>/static/images/logo.png" alt="" style="width: 100px; height: 50px">
                    </div>
    
                    <div class="d-flex h-custom-2 mt-1 px-5 pt-5" style="height: fit-content;">
    
                        <form action="<%= request.getContextPath() %>/login/authenticate" method="post" style="width: 23rem;">
    
                            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>
    
                            <div class="form-group mb-4">
                                <label class="form-label" for="form2Example18">Email address</label>
                                <input type="email" id="form2Example18" class="form-control form-control-lg" name="email" value="cap@gmail.com" required/>
                            </div>
    
                            <div class="form-group mb-4">
                                <label class="form-label" for="form2Example28">Password</label>
                                <input type="password" id="form2Example28" class="form-control form-control-lg" name="password" value="1234" required/>
                            </div>
    
                            <div class="pt-1 mb-4">
                                <input class="btn btn-info btn-lg btn-block" type="submit" value="Login"></input>
                            </div>
    
                            <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Forgot password?</a></p>
                            <p>Don't have an account? <a href="#!" class="link-info">Register here</a></p>
    
                        </form>
    
                    </div>
    
                </div>
                <div class="col-md-6 px-0 d-none d-sm-block">
                    <img src="<%= request.getContextPath() %>/static/images/harbor.jpg"
                        alt="Login image" class="w-100 h-100" style="object-fit: cover; object-position: left; border-radius: 20px">
                </div>
            </div>
        </div>
    </section>
</body>
</html>