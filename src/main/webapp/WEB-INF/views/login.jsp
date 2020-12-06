<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
<jsp:include page="header.jsp"></jsp:include>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,500;1,500&display=swap" rel="stylesheet">
</head>
<body id="body-login">
	<div id="body-flex-login">
	
		<div id="container-login">
		
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<span id="text-logo">Welcome</span><br>
					<span id="hint-text-logo">Hãy tạo nên phong cách của bạn cùng HARU Shop !</span>
				</div>
				<div id="header-bottom-left">
					<p><img alt="icon_oval" src='<c:url value="/resources/images/icon_oval.png" />'><span>Luôn cập nhật xu hướng thời trang mới nhất</span></p>
					<p><img alt="icon_oval" src='<c:url value="/resources/images/icon_oval.png" />'><span>Giảm hơn 50% tất cả các mặt hàng dành cho khách VIP</span></p>
					<p><img alt="icon_oval" src='<c:url value="/resources/images/icon_oval.png" />'><span>Tận tình tư vấn để tạo nên phong cách của bạn</span></p>
				</div>
			</div>
			
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span id="login" class="actived">Đăng nhập</span> / 
					<span id="signup">Đăng ký</span>
				</div>
				
				<div id="container-center-login-right">
					
					
					<div class="container-login-form" id="container-center-login-right">
						<span id="msg" class="msg"></span>
						<!-- <form action="" method="post"> -->
						<input id="email" class="material-textinput input-icon-email" type="text" name="email" placeholder="Email"><br>
						<input id="password" class="material-textinput input-icon-password" type="password" name="password" placeholder="Mật khẩu"><br>
						<input id="btnLogin" class="material-primary-button" type="submit" name="submit" value="ĐĂNG NHẬP"><br>
						<!-- </form> -->
					</div>
					
					<div class="container-signup-form" id="container-center-login-right">
						<span class="msg">${msg}</span>
						<form action="" method="post">
							<input id="userName" class="material-textinput input-icon-userName" type="text" name="userName" placeholder="Username"><br>
							<input id="email" class="material-textinput input-icon-email" type="text" name="email" placeholder="Email"><br>
							<input id="password" class="material-textinput input-icon-password" type="password" name="password" placeholder="Mật khẩu"><br>
							<input id="repassword" class="material-textinput input-icon-password" type="password" name="rePassword" placeholder="Nhập lại mật khẩu"><br>
							<input id="btnLogin" class="material-primary-button" type="submit" name="submit" value="ĐĂNG KÝ"><br>
						</form>
					</div>
					
				</div>
				
				<div id="container-social-login">
					<img alt="icon_oval" src='<c:url value="/resources/images/icon_facebook.png" />'>
					<img alt="icon_oval" src='<c:url value="/resources/images/icon_google.png" />'>
				</div>
			</div>
			
		</div>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>