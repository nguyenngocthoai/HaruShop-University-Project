<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Giỏ hàng</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css" />
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid" id="header-detail">
		<!-- start header -->
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
							<!-- <a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a> -->
							<c:forEach var="category" items="${categories}">
								<a class="dropdown-item" href='<c:url value="/product/${category.categoryId}/${category.categoryName}"></c:url>'>${category.categoryName}</a>
							</c:forEach>
						</div></li>
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
							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/login/"/>">ĐĂNG NHẬP</a></li>
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
					<li id="cart" class="nav-item"><a class="nav-link" href='<c:url value="/cart/"></c:url>'>
							<img style="width: 24px; height: 24px;"
							src="<c:url value="/resources/images/ic_shopping_cart.png"/>">
							<c:if test="${qualityCarts > 0}">
								<div class="cicle-cart">
									<span>${qualityCarts}</span>
								</div>
							</c:if> <c:if test="${qualityCarts <= 0 || qualityCarts == null }">
								<div>
									<span>${qualityCarts}</span>
								</div>
							</c:if>

					</a></li>
				</ul>
			</div>
		</nav>

	</div>
	<!-- end header -->

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center text-primary title-cart">Danh sách sản phẩm giỏ hàng</h5>
				<table class="table table-hover table-cart">
					<tr>
						<th>Hình sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Màu sản phẩm</th>
						<th>Size</th>
						<th>Số lượng</th>
						<th>Giá tiền</th>
					</tr>
					<tbody>
						<c:forEach items="${carts}" var="cart">
							<tr data-detailId="${cart.productDetailId}">
								<td class="image" data-image="${cart.image}"><img class="image-cart" src="<c:url value="/resources/images/product/${cart.image}"/>"> </td>
								<td class="name text-cart productName" data-productId="${cart.productId}" data-productName="${cart.productName}">${cart.productName}</td>
								<td class="color text-cart" data-colorId="${cart.colorId}">${cart.colorName}</td>
								<td class="size text-cart" data-sizeId="${cart.sizeId}">${cart.size}</td>
								<td class="quality text-cart" data-quality="${cart.quality}"><input class="quality-cart" min="1" max="1000" type="number" value="${cart.quality}" style="width: 90px;"></td>
								<td class="price text-danger text-cart" data-price="${cart.price}">${cart.price}00 VND</td>
								<td class="text-cart"><button class="btn btn-danger delete-cart">Xóa</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h5>Tổng tiền: <span id="totalmoney" class="text-danger"></span></h5>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h5 class="text-primary title-cart">Thông tin khách hàng</h5>
				<div class="form-gruop">
					<form action="" method="post">
						<label for="customerName">Tên khách hàng mua/nhận</label>
						<input id="customerName" name="customerName" class="form-control">
						
						<label for="phoneNumber">Số điện thoại</label>
						<input id="phoneNumber" name="phoneNumber" class="form-control"><br>
						
						<div class="radio">
					      <label><input id="delivery" type="radio" name="form" checked="checked" value="Giao hàng tận nơi">&nbsp;&nbsp;Giao hàng tận nơi</label>
					    </div>
					    <div class="radio disabled">
					      <label><input type="radio" name="form" value="Nhận hàng tại cửa hàng">&nbsp;&nbsp;Nhận hàng tại cửa hàng</label>
					    </div>
					    
						<label for="deliveryAddress">Địa chỉ nhận hàng</label>
						<input id="deliveryAddress" name="deliveryAddress" class="form-control">
						
						<label for="note">Ghi chú</label>
						<textarea class="form-control" id="note" name="note" rows="3"></textarea>
						<br>
						<div class="radio">
							<label><input type="radio" name="formOfDelivery" checked>&nbsp;&nbsp;Thanh toán khi nhận hàng</label>
						</div>
						<div class="radio disabled">
							<label><input type="radio" name="formOfDelivery" disabled>&nbsp;&nbsp;Thanh toán qua momo</label>
						</div>
						<div class="radio disabled">
							<label><input type="radio" name="formOfDelivery" disabled>&nbsp;&nbsp;Thanh toán qua thẻ tín dụng</label>
						</div>
					    <input type="submit" class="btn btn-primary" value="Đặt hàng">
					</form>
				</div>
			</div>
			<div class="col-md-6">
				<h5 class="text-primary title-cart">Địa chỉ shop</h5>
				<div id="map" style="width:500px;height:500px;">
	            	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.3345704704498!2d106.71632321433674!3d10.785666861973477!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f54a199c189%3A0x9e504f57d7b5d5c1!2zQ-G6p3UgVGjhu6cgVGhpw6pt!5e0!3m2!1svi!2s!4v1599236660812!5m2!1svi!2s" 
	            		width="600" height="450" style="border:0;" aria-hidden="false" tabindex="0"></iframe>
	            </div>
			</div>	
		</div>
		
	</div>

	<div id="footer" class="container-fluid">
		<!-- start footer -->

		<div class="row">
			<div class="col-sm-4 col-md-4 wow headShake">
				<p>
					<span class="title-footer">THÔNG TIN SHOP</span>
				</p>
				<span>&bull;&nbsp;&nbsp;Yame là một thương hiệu thời trang
					đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách
					hàng</span>
			</div>
			<div class="col-sm-4 col-md-4 wow headShake">
				<p>
					<span class="title-footer">LIÊN HỆ</span>
				</p>
				<span>&bull;&nbsp;&nbsp;Địa chỉ: 100 Hai Bà Trưng, phường 10,
					quận 3, TP.HCM</span><br> <span>&bull;&nbsp;&nbsp;Email:
					thoainguyen603@gmail.com</span><br> <span>&bull;&nbsp;&nbsp;Số
					điện thoại: 0344775971</span>
			</div>
			<div class="col-sm-4 col-md-4 wow headShake">
				<p>
					<span class="title-footer">GÓP Ý</span>
				</p>
				<form action="">
					<input class="material-textinput feedback" type="text"
						name="email_feedback" placeholder="Email"><br>
					<textarea class="feedback" rows="4" cols="50"
						name="content_feedback" placeholder="Nội dung"></textarea>
					<button class="material-primary-button">ĐỒNG Ý</button>
				</form>
			</div>
		</div>

	</div>
	<!-- end footer -->

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>