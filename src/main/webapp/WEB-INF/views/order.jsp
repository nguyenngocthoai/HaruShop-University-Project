<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hóa Đơn</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid" id="header-detail">
		<!-- start header -->
		<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light none_nav"> -->
		<nav class="navbar navbar-expand-lg navbar-dark none_nav">
			<a class="navbar-brand" href="#"> <img alt=""
				src='<c:url value="/resources/images/icon_yame_shop.png"/>'>
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
								href='<c:url value="/login/"/>'>ĐĂNG NHẬP</a></li>
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
							src='<c:url value="/resources/images/ic_shopping_cart.png"/>'>
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
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>