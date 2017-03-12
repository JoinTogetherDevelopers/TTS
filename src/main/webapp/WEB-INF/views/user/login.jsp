<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>BTMS Login</title>
   
</head>

<body class="gray-bg">
    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">BT+</h1>

            </div>
            <h3>Welcome to BTMS</h3>
            <form class="m-t" id="loginForm" role="form" id="loginForm" action="/login" method="post">
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="ID" required/>
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Password" required/>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">로그인</button>
                
                <a class="btn btn-sm btn-white btn-block" href="/register">계정 생성</a>
            </form>            
        </div>
    </div>
    <!-- Mainly scripts -->
   
</body>
</html>