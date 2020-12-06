<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Chi tiết sản phẩm</title>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"
  />
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid" id="header-detail"> <!-- start header -->
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
						aria-expanded="false"> DROPDOWN </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<!-- <a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a> -->
							<c:forEach var="category" items="${categories}">
								<a class="dropdown-item" href="">${category.categoryName}</a>
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

	</div> <!-- end header -->

	<div class="container content-detail">
		<div class="row">
			<div class="col-sm-2 col-md-2">
				<h5>Danh Mục</h5>
				<ul class="super-menu">
					<c:forEach var="category" items="${categories}">
						<li><a href="">${category.categoryName}</a>
							<!-- <ul>
								<li><a href="">Áo Sơ Mi</a></li>
								<li><a href="">Áo Khoác</a></li>
								<li><a href="">Quần</a></li>
								<li><a href="">Quần Dài</a></li>
							</ul> -->
						</li>
					</c:forEach>
				</ul>
			</div>
				
			<div class="col-sm-8 col-md-8">
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<img style="width: 100%" id="data-image" data-image="${product.image}" src="<c:url value="/resources/images/product/${product.image}"/>" alt="Product">
					</div>
					
					<div class="col-sm-8 col-md-8">
						<h4 class="text-primary" id="productName" data-productId="${product.productId}">${product.productName}</h4>
						<h5 class="text-danger" id="price" data-value="${product.price}">${product.price}00 VND</h5>
						<table class="table table-hover">
							<tr>
								<th>Màu sản phẩm</th>
								<th>Size</th>
								<th>Số lượng</th>
							</tr>
							<tbody>
								<c:forEach items="${product.productDetails}" var="productDetail">
									<tr>
										<td class="color" data-colorId="${productDetail.productColor.productColorId}">${productDetail.productColor.productColorName}</td>
										<td class="size" data-sizeId="${productDetail.productSize.productSizeId}">${productDetail.productSize.size}</td>
										<td class="quality" data-quality="${productDetail.quantity}">${productDetail.quantity}</td>
										<td><button data-detailId="${productDetail.productDetailId}" class="btn btn-success btn-cart">Giỏ hàng</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<div class="col-sm-2 col-md-2">
				<span class="font-weight-normal">${product.description}</span>
			</div>
			
		</div>
	</div>	
	
	<div id="footer" class="container-fluid"> <!-- start footer -->
	
		<div class="row">
			<div class="col-sm-4 col-md-4 wow headShake">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>
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