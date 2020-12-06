<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Trang chủ</title>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid" id="header"> <!-- start header -->
		<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light none_nav"> -->
		<nav class="navbar navbar-expand-lg navbar-dark none_nav">
			<a class="navbar-brand" href="#"> <img alt=""
				src="<c:url value="/resources/images/icon_yame_shop.png"/>">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto mx-auto">
					<li class="nav-item active"><a class="nav-link" href='<c:url value="/"></c:url>'>TRANG
							CHỦ <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> SẢN PHẨM </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<!-- a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a> -->
							<c:forEach var="category" items="${categories}">
								<a class="dropdown-item" href='<c:url value="/product/${category.categoryId}/${category.categoryName}"></c:url>'>${category.categoryName}</a>
							</c:forEach>
						</div>
						
					</li>
					<li class="nav-item"><a class="nav-link" href="#">DỊCH VỤ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a></li>
				</ul>
				<!-- <form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form> -->
				<ul class="nav navbar-nav navbar-right">
					<!-- <li class="nav-item"><a class="nav-link" href="login/">ĐĂNG -->
					
					
					<c:choose>
						<c:when test="${userNameLoginAvatar != null}">
						<%-- 	<li class="nav-item"><a class="nav-link cicle-avatar" href="#">${userNameLoginAvatar}</a></li> --%>
							<li class="nav-item dropdown"><a
								class="nav-link  cicle-avatar" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> ${userNameLoginAvatar} </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#">L</a> <a
										class="dropdown-item" href="#">A</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">E</a>
						</div></li>
						</c:when>
						<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="<c:url value="login/"/>">ĐĂNG NHẬP</a></li>
						</c:otherwise>
					</c:choose>
					
					
					<%-- <c:choose>
						<c:when test="${userNameLoginAvatar != null}">
							<li class="nav-item"><a class="nav-link cicle-avatar" href="#">${userNameLoginAvatar}</a></li>
						</c:when>
						<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="<c:url value="login/"/>">ĐĂNG NHẬP</a></li>
						</c:otherwise>
					</c:choose> --%>
					
					<!-- <li class="nav-item"><a class="nav-link" href="#">ĐĂNG KÝ</a></li> -->
					<%-- <li class="nav-item"><a class="nav-link" href="#"><img
							alt=""
							src="<c:url value="/resources/images/ic_shopping_cart.png"/>"></a></li> --%>
							
							<li id="cart" class="nav-item">
						<a class="nav-link" href='<c:url value="/cart/"></c:url>'>
								<img style="width: 24px;height: 24px;" src="<c:url value="/resources/images/ic_shopping_cart.png"/>">
								<c:if test="${qualityCarts > 0}">
									<div class="cicle-cart">
										<span>${qualityCarts}</span>
									</div>
								</c:if>
								
								<c:if test="${qualityCarts <= 0 || qualityCarts == null }">
									<div>
										<span>${qualityCarts}</span>
									</div>
								</c:if>
								
						</a>
					</li>
				</ul>
			</div>
		</nav>

		<div class="event-header container wow bounceInDown" data-wow-duration="1s">
			<span> Ngày 1/8 - 30/8/2020</span><br> <span
				style="font-size: 50px;"> MUA 1 TẶNG 1</span><br>
			<button>XEM NGAY</button>
		</div>

	</div> <!-- end header -->

	<div id="info" class="container"> <!-- start content -->
	
		<div class="row column-icon">
			<div class="col-12 col-sm-4 col-lg-4 wow fadeInLeft">
				<img class="icon" alt="" src="<c:url value="/resources/images/icon_quality.png"/>"><br>
				<span id="text-icon-quality">CHẤT LƯỢNG</span><br>
				<span>Chúng tôi cam kết sẽ mang đến cho các bạn chất lượng sản phẩm tốt nhất</span>
			</div>
			<div class="col-12 col-sm-4 col-lg-4 wow fadeInDown">
				<img class="icon" alt="" src="<c:url value="/resources/images/icon_cost_savings.png"/>"><br>
				<span id="text-icon-quality">TIẾT KIỆM CHI PHÍ</span><br>
				<span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm 20% cho từng sản phẩm</span>
			</div>
			<div class="col-12 col-sm-4 col-lg-4 wow fadeInRight">
				<img class="icon" alt="" src="<c:url value="/resources/images/icon_delivery.png"/>"><br>
				<span id="text-icon-quality">GIAO HÀNG</span><br>
				<span>Cam kết giao hàng tận nơi trong ngày để mang sản phẩm đến cho khách hàng nhanh nhất</span>
			</div>
		</div>
	</div> <!-- end content -->
	
	<div id="title-product-hot" class="container">
			<span class="text-danger wow flash" data-wow-duration="1s">SẢN PHẨM HOT</span>
			<div class="row image-title"> <!-- start product row -->
				<c:forEach items="${products}" var="p">
					<div class="col-md-3 col-sm-6">
						<div class="card text-center wow pulse">
							<a href='<c:url value="detail/${p.productId}"/>' data-toggle="popover" data-trigger="hover" data-content="Some content">
								<img class="card-img-top" src="<c:url value="/resources/images/product/${p.image}"/>" alt="Card image cap">
							</a>
							<div class="card-body">
								<h6 class="card-title">${p.productName}</h6>
								<h6 class="card-title text-danger">${p.price}00 VND</h6>
								<!-- <a href="#" class="btn btn-primary">Mua ngay</a> -->
								<br><br>
							</div>
						</div>
					</div>
				</c:forEach>
			</div> <!-- end product row -->
	</div>
	
	<div id="footer" class="container-fluid"> <!-- start footer -->
	
		<div class="row">
			<div class="col-sm-4 col-md-4 wow headShake">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>&bull;&nbsp;&nbsp;Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
			<div class="col-sm-4 col-md-4 wow headShake">
				<p><span class="title-footer">LIÊN HỆ</span></p>
				<span>&bull;&nbsp;&nbsp;Địa chỉ: 100 Hai Bà Trưng, phường 10, quận 3, TP.HCM</span><br>
				<span>&bull;&nbsp;&nbsp;Email: thoainguyen603@gmail.com</span><br>
				<span>&bull;&nbsp;&nbsp;Số điện thoại: 0344775971</span>
			</div>
			<div class="col-sm-4 col-md-4 wow headShake">
				<p><span class="title-footer">GÓP Ý</span></p>
				<form action="">
					<input class="material-textinput feedback" type="text" name="email_feedback" placeholder="Email"><br>
					<textarea class="feedback" rows="4" cols="50" name="content_feedback" placeholder="Nội dung"></textarea>
					<button class="material-primary-button">ĐỒNG Ý</button>
					</form>
			</div>
		</div>
	
	</div> <!-- end footer -->
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>