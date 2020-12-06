<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Thêm Sản Phẩm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<link
	href='https://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- admin -->
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin_template/css/bootstrap.min.css"/>' />
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin_template/css/style.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin_template/css/morris.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources//css/styles.css"/>' />
<!-- Graph CSS -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin_template/css/font-awesome.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin_template/css/bootstrap.css.map"/>' />
	<script src='<c:url value="/resources/js/jquery-3.5.1.min.js"/>'></script>

<!-- jQuery -->
<%-- <script src='<c:url value="/resources/admin_template/js/jquery-2.1.4.min.js"/>'></script> --%>
<!-- //jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin_template/css/icon-font.min.css"/>' />
<!-- //lined-icons -->
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="row">
				<br>
				<div class="col-md-4 col-sm-12">
					<div>
						<h4>Thêm Sản Phẩm</h4>
					</div>
					<form id="form-product" action="">
						<div class="form-group">
							<label for="productName">Tên sản phẩm</label> <input type="text"
								class="form-control" id="productName" name="productName" placeholder="Tên sản phẩm">
						</div>
						<div class="form-group">
							<label for="category">Danh mục</label> <select
								class="form-control" id="category" name="category">
								<c:forEach items="${categories}" var="category">
									<option value="${category.categoryId}">${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<!-- <div class="form-group"> -->
							<label for="dedicated">Dành cho</label><br>
							<!-- </div> -->
							<div class="radio-inline">
								<label><input type="radio" name="dedicated" checked="checked" id="radio-nam" value="Nam">&nbsp;&nbsp;Nam</label>
							</div>
							<div class="radio-inline">
								<label><input type="radio" name="dedicated" id="radio-nu" value="Nữ">&nbsp;&nbsp;Nữ</label>
							</div>
						</div>
						<div class="form-group">
							<label for="price">Giá tiền</label> <input type="text"
								class="form-control" id="price" name="price" placeholder="Giá tiền">
						</div>
						<div class="form-group">
							<label for="description">Mô tả</label>
							<textarea class="form-control" id="description" name="description"
								placeholder="Mô tả" rows="5"></textarea>
						</div>
	
						<div class="form-group">
							<label for="image">Hình ảnh</label> <input type="file"
								class="form-control" id="image" name="image">
						</div>
						<br>
					</form>
					<div id="container-productdetail">
						<div class="productdetail">
							<div>
								<h4 class="text-default">Chi Tiết Sản Phẩm</h4>
							</div>
							<div class="form-group">
								<label for="size">Size</label> 
								<select class="form-control" id="size" name="size">
									<c:forEach items="${productSizes}" var="size">
										<option value="${size.productSizeId}">${size.size}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="color">Màu</label>
								<select class="form-control" id="color" name="productColor">
									<c:forEach items="${productColors}" var="color">
										<option value="${color.productColorId}">${color.productColorName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="quality">Số lượng</label>
								<input type="number" value="1" class="form-control" max="200" min="1" id="quality" name="quality" placeholder="Số lượng">
							</div>
							<button id="btn-detail" class="btn btn-primary btn-detail">Thêm chi tiết</button>
						</div>
					</div>
					<div id="productdetail" class="productdetail">
						<div>
							<h4 class="text-default">Chi Tiết Sản Phẩm</h4>
						</div>
						<div class="form-group">
							<label for="size">Size</label> 
							<select class="form-control" id="size" name="size">
								<c:forEach items="${productSizes}" var="size">
									<option value="${size.productSizeId}">${size.size}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="color">Màu</label>
							<select class="form-control" id="color" name="productColor">
								<c:forEach items="${productColors}" var="color">
									<option value="${color.productColorId}">${color.productColorName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="quality">Số lượng</label>
							<input type="number" value="1" class="form-control" max="200" min="1" id="quality" name="quality" placeholder="Số lượng">
						</div>
						<button id="btn-detail" class="btn btn-primary btn-detail">Thêm chi tiết</button>
					</div><br>
					<p>
						<button id="btn-add-product" class="btn btn-primary">Thêm sản shẩm</button>
						<button id="btn-update-product" class="btn btn-primary hidden">Cập nhật sản shẩm</button>
						<button id="btn-exit" class="btn btn-primary hidden ">Thoát</button>
					</p>
					<br><br><br><br>
				</div>
								

				<div class="col-md-8 col-sm-12 table-product">
					<div>
						<h4>Danh Sách Sản Phẩm</h4>
					</div>
					<!-- <div style="float: right; position: relative; top: -35px;">
						<button class="btn btn-primary" type="button">Thêm sản
							shẩm</button>
						<button id="delete-product" class="btn btn-danger" type="button">Xóa</button>
					</div> -->
					<table id="table-product" class="table table-hover">
						<thead>
							<tr>
								<th>
									<div class="checkbox">
										<label><input id="check-all" class="checkbox-product"
											type="checkbox" value=""></label>
									</div>
								</th>
								<th>Hình sản phẩm</th>
								<th>Tên sản phẩm</th>
								<th>Giá tiền</th>
								<th>Giành cho</th>
								<th>Sửa</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products}" var="product">
								<tr>
									<td>
										<div class="checkbox">
											<label><input class="checkbox-product"
												type="checkbox" value="${product.productId}"></label>
										</div>
									</td>
									<td class='image text-dark'><img class='image-admin'
										src='<c:url value='/resources/images/product/${product.image}'/>'></td>
									<%-- <td class="image text-dark"><img class="image-admin" src="<c:url value="/resources/images/product/${product.image}"/>"></td> --%>
									<td class="name text-cart productName text-dark"
										data-productId="${product.productId}">${product.productName}</td>
									<td class="price text-danger text-cart text-dark">${product.price} 00
										VND</td>
									<td class="dedicated text-danger">${product.dedicated}</td>
									<td class="update-product btn btn-warning text-white" data-id="${product.productId}">Sửa</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- <button id="delete-product" class="btn btn-danger" type="button">Xóa</button> -->
					<div style="float: right; position: relative;">
						<!-- <button class="btn btn-primary" type="button">Thêm sản shẩm</button> -->
						<button id="delete-product" class="btn btn-danger" type="button">Xóa</button>
						<!-- <button id="btn-update-product" class="btn btn-primary hidden">Cập nhật sản shẩm</button> -->
					</div>
					<center>
						<ul class="pagination pagination-sm">
							<c:forEach var="i" begin="1" end="${sumPage}">
								<c:choose>
									<c:when test="${i == 1}">
										<li class="active paging-item"><a href="#">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="paging-item"><a href="#">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</center>

				</div>
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1"> <a href="#" class="sidebar-icon">
				<span class="fa fa-bars"></span>
			</a> </header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				<ul id="menu">
					<li><a href='<c:url value="dashboard"></c:url>'><i class="fa fa-tachometer"></i>
							<span>Dashboard</span>
							<div class="clearfix"></div></a></li>


					<li id="menu-academico"><a
						href='<c:url value="/addproduct"></c:url>'><i
							class="fa fa-cubes nav_icon" aria-hidden="true"></i><span>
								Sản phẩm</span>
							<div class="clearfix"></div></a></li>
					<li>
						<a href="#">
							<i class="fa fa-picture-o" aria-hidden="true"></i>
							<span>Hóa Đơn</span>
							<div class="clearfix"></div>
						</a>
					</li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-bar-chart"></i><span>Charts</span>
							<div class="clearfix"></div></a></li>
					<!-- <li id="menu-academico"><a href="#"><i
							class="fa fa-list-ul" aria-hidden="true"></i><span> Short
								Codes</span> <span class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="icons.html">Icons</a></li>
							<li id="menu-academico-avaliacoes"><a href="typography.html">Typography</a></li>
							<li id="menu-academico-avaliacoes"><a href="faq.html">Faq</a></li>
						</ul>
					</li> -->
						
					<li id="menu-academico"><a href="#"><i
							class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error
								Page</span>
							<div class="clearfix"></div></a>
					</li>
					<!-- <li id="menu-academico"><a href="#"><i class="fa fa-cogs"
							aria-hidden="true"></i><span> UI Components</span> <span
							class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="button.html">Buttons</a></li>
							<li id="menu-academico-avaliacoes"><a href="grid.html">Grids</a></li>
						</ul>
					</li> -->
					<li><a href="#"><i class="fa fa-table"></i> <span>Tables</span>
							<div class="clearfix"></div></a></li>
					<li><a href="#"><i class="fa fa-map-marker"
							aria-hidden="true"></i> <span>Maps</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#">
						<i class="fa fa-file-text-o"></i> <span>Pages</span> 
							<!-- <span class="fa fa-angle-right" style="float: right"></span> -->
							<div class="clearfix"></div></a>
						<!-- <ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="calendar.html">Calendar</a></li>
							<li id="menu-academico-avaliacoes"><a href="signin.html">Sign
									In</a></li>
							<li id="menu-academico-avaliacoes"><a href="signup.html">Sign
									Up</a></li>


						</ul> -->
					</li>
					<li><a href="#"><i class="fa fa-table"></i> <span>Calenda</span>
							<div class="clearfix"></div></a></li>
					<!-- <li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span>
							<span class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul>
							<li><a href="input.html"> Input</a></li>
							<li><a href="validation.html">Validation</a></li>
						</ul>
					</li> -->
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!-- admin -->
	<!--js -->
	<script src='<c:url value="/resources/js/jquery-3.5.1.min.js"/>'></script>
	<%-- <script src='<c:url value="/resources/admin_template/js/jquery.nicescroll.js"/>'></script> --%>
	<script src='<c:url value="/resources/admin_template/js/scripts.js"/>'></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src='<c:url value="/resources/admin_template/js/bootstrap.min.js"/>'></script>
	<!-- /Bootstrap Core JavaScript -->
	<!-- morris JavaScript -->
	<script
		src='<c:url value="/resources/admin_template/js/raphael-min.js"/>'></script>
	<script src='<c:url value="/resources/admin_template/js/morris.js"/>'></script>
	<script src='<c:url value="/resources/js/custom.js"/>'></script>
	<%-- <script src='<c:url value="/resources/admin_template/js/jquery-2.1.4.min.js"/>'></script> --%>
	<script>
		$(document).ready(
				function() {
					//BOX BUTTON SHOW AND CLOSE
					jQuery('.small-graph-box').hover(function() {
						jQuery(this).find('.box-button').fadeIn('fast');
					}, function() {
						jQuery(this).find('.box-button').fadeOut('fast');
					});
					jQuery('.small-graph-box .box-close').click(function() {
						jQuery(this).closest('.small-graph-box').fadeOut(200);
						return false;
					});

					//CHARTS
					function gd(year, day, month) {
						return new Date(year, month - 1, day).getTime();
					}

					graphArea2 = Morris.Area({
						element : 'hero-area',
						padding : 10,
						behaveLikeLine : true,
						gridEnabled : false,
						gridLineColor : '#dddddd',
						axes : true,
						resize : true,
						smooth : true,
						pointSize : 0,
						lineWidth : 0,
						fillOpacity : 0.85,
						data : [ {
							period : '2014 Q1',
							iphone : 2668,
							ipad : null,
							itouch : 2649
						}, {
							period : '2014 Q2',
							iphone : 15780,
							ipad : 13799,
							itouch : 12051
						}, {
							period : '2014 Q3',
							iphone : 12920,
							ipad : 10975,
							itouch : 9910
						}, {
							period : '2014 Q4',
							iphone : 8770,
							ipad : 6600,
							itouch : 6695
						}, {
							period : '2015 Q1',
							iphone : 10820,
							ipad : 10924,
							itouch : 12300
						}, {
							period : '2015 Q2',
							iphone : 9680,
							ipad : 9010,
							itouch : 7891
						}, {
							period : '2015 Q3',
							iphone : 4830,
							ipad : 3805,
							itouch : 1598
						}, {
							period : '2015 Q4',
							iphone : 15083,
							ipad : 8977,
							itouch : 5185
						}, {
							period : '2016 Q1',
							iphone : 10697,
							ipad : 4470,
							itouch : 2038
						}, {
							period : '2016 Q2',
							iphone : 8442,
							ipad : 5723,
							itouch : 1801
						} ],
						lineColors : [ '#ff4a43', '#a2d200', '#22beef' ],
						xkey : 'period',
						redraw : true,
						ykeys : [ 'iphone', 'ipad', 'itouch' ],
						labels : [ 'All Visitors', 'Returning Visitors',
								'Unique Visitors' ],
						pointSize : 2,
						hideHover : 'auto',
						resize : true
					});

				});
	</script>
</body>
</html>