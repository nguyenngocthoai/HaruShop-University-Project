$(document).ready(function() {
	var productId = 0;
	$("#btnLogin").click(function() {
		var email = $("#email").val();
		var password = $("#password").val();
		$.ajax({
			url : "/harushop/api/checkLogin",
			type : "GET",
			data : {
				email : email,
				password : password
			},
			success : function(msg) {
				if (msg == "true") {
					currentPath = window.location.href;
					path = currentPath.replace("login/", "");
					window.location = path;
				} else {
					$("#msg").text("Email hoặc Mật khẩu không hợp lệ !");
				}
			}
		})
	});

	$("#login").click(function() {
		$(this).addClass("actived");
		$("#signup").removeClass("actived");
		$(".container-login-form").show();
		$(".container-signup-form").hide();
	});

	$("#signup").click(function() {
		$(this).addClass("actived");
		$("#login").removeClass("actived");
		$(".container-login-form").hide();
		$(".container-signup-form").show();
	});

	$(".btn-cart").click(function() {
		var detailId = $(this).attr("data-detailId");
		var colorId = $(this).closest("tr").find(".color").attr("data-colorId");
		var colorName = $(this).closest("tr").find(".color").text();
		var sizeId = $(this).closest("tr").find(".size").attr("data-sizeId");
		var size = $(this).closest("tr").find(".size").text();
		var productId = $("#productName").attr("data-productId");
		var productName = $("#productName").text();
		var price = $("#price").attr("data-value");
		var quality = $(this).closest("tr").find(".quality").attr("data-quality");
		var image =$("#data-image").attr("data-image");

		$.ajax({
			url : "/harushop/api/addCart",
			type : "GET",
			data : {
				productId : productId,
				productName:productName,
				colorId:colorId,
				colorName:colorName,
				sizeId:sizeId,
				size:size,
				price:price,
				quality:quality,
				image:image,
				detailId:detailId
			},
			success : function() {
				
			}
		}).done(function(){
			$.ajax({
				url : "/harushop/api/getQualityCart",
				type : "GET",
				success : function(value) {
					$("#cart").find("div").addClass("cicle-cart");
					$("#cart").find("div").html("<span>"+ value + "</span>");
				}
			})
		})
	});
	
	/**
	 * when load page cart will change to pay
	 */
	/*var totalMoney = 0;
	$(".quality-cart").each(function(){
		var price = $(this).closest("tr").find(".price").attr("data-price");
		var quality = $(this).val();
		var sum = quality * parseFloat(price);
		var format = sum.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$(this).closest("tr").find(".price").html(format + " VND");
	});*/
	
	/**
	 * when change quality will change total money
	 */
	totalMoneyCart();
	
	function totalMoneyCart(isEventChange){
		var totalMoney = 0;
		$(".price").each(function(){
			var price = $(this).text();
			var quality = $(this).closest("tr").find(".quality-cart").val();
			var sum = parseInt(price) * quality;
			
			var format = parseFloat(sum).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
			
//			totalMoney = parseFloat(totalMoney) + parseFloat(price);
//			var format = parseFloat(price).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
//			totalMoney = totalMoney + parseFloat(price);
			if(!isEventChange){
				$(this).html(format + " VND");
			}
			totalMoney = parseFloat(totalMoney) + sum;
			var formatTotalMoney = totalMoney.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
			$("#totalmoney").html(formatTotalMoney + " VND");
		});
	}
	
	/**
	 * when change quality in page cart will change to pay
	 */
	$(".quality-cart").change(function(){
		var quality = $(this).val();
		var price = $(this).closest("tr").find(".price").attr("data-price");
		var sum = quality * parseInt(price);
		var format = sum.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
		$(this).closest("tr").find(".price").html(format + " VND");
		totalMoneyCart(true);
		
		var colorId = $(this).closest("tr").find(".color").attr("data-colorId");
		var sizeId = $(this).closest("tr").find(".size").attr("data-sizeId");
		var productId = $(this).closest("tr").find(".productName").attr("data-productId");
		$.ajax({
			url : "/harushop/api/updateCart",
			type : "GET",
			data : {
				productId : productId,
				colorId:colorId,
				sizeId:sizeId,
				quality:quality,
			},
			success : function() {
				
			}
		})
//		totalMoneyCart(true);
	});
	
	/*$(".quality-cart").change(function(){
		var quality = $(this).val();
		var colorId = $(this).closest("tr").find(".color").attr("data-colorId");
		var sizeId = $(this).closest("tr").find(".size").attr("data-sizeId");
		var productId = $(this).closest("tr").find(".productName").attr("data-productId");
		$.ajax({
			url : "/harushop/api/updateCart",
			type : "GET",
			data : {
				productId : productId,
				colorId:colorId,
				sizeId:sizeId,
				quality:quality,
			},
			success : function() {
				
			}
		})
	});*/
	
	$(".delete-cart").click(function(){
		var self=$(this);
		var colorId = $(this).closest("tr").find(".color").attr("data-colorId");
		var sizeId = $(this).closest("tr").find(".size").attr("data-sizeId");
		var productId = $(this).closest("tr").find(".productName").attr("data-productId");
		
		$.ajax({
			url : "/harushop/api/deleteCart",
			type : "GET",
			data : {
				productId : productId,
				colorId:colorId,
				sizeId:sizeId,
			},
			success : function() {
				self.closest("tr").remove();
				totalMoneyCart(true);
			}
		})
	});
	
	$("body").on("click",".paging-item",function(){
		$(".paging-item").removeClass("active");
		$(this).addClass("active");
		var countpage = ($(this).text());
		var beginsProduct = (countpage - 1) * 5;
		
		$.ajax({
			url : "/harushop/api/getProductLimit",
			type : "GET",
			data : {
				beginsProduct : beginsProduct
			},
			success : function(html) {
				var tbodyProduct = $("#table-product").find("tbody");
				tbodyProduct.empty();
				tbodyProduct.append(html);
			}
		})
	});
	
	$("#check-all").change(function(){
		if(this.checked){
			$("#table-product input").each(function(){
				$(this).attr("checked",true);
			});
		}else{
			$("#table-product input").each(function(){
				$(this).attr("checked",false);
			});
		}
	})
	
	$("#delete-product").click(function(){
		$("#table-product > tbody input:checked").each(function(){
			var productId = $(this).val();
			var thiss = $(this);
			$.ajax({
				url : "/harushop/api/deleteProduct",
				type : "GET",
				data : {
					productId : productId
				},
				success : function(html) {
					thiss.closest("tr").remove();
				}
			})
		});
	});
	
	var files = [];
	var image = "";
	$("#image").change(function(){
		/*return a choosefile when the user chooses*/
		files = event.target.files;
		image = files[0].name;
		/*create form*/
		forms = new FormData();
		 /*assign value to the form with name = file, value is file[0]*/
		forms.append("file",files[0]);
		
		$.ajax({
			url : "/harushop/api/uploadFile",
			type : "POST",
			data : forms,
			processData:false,
			enctype:"multipart/form-data",
			contentType:false,
			success : function() {
			}
		})
		
	});
	
	$("body").on("click",".btn-detail",function(){
		/*clone the content of #productdetail and delete this id because in css it's used to display:none*/
		var detailClone = $("#productdetail").clone().removeAttr("id");
		/*delete button add detail*/
		$(this).remove();
		/*append to #container-productdetail*/
		$("#container-productdetail").append(detailClone);
	});
	
	$("#btn-add-product").click(function(event){
		event.preventDefault();
		/**
		 * get all the value of the form tag
		 */
		var dataForm = $("#form-product").serializeArray();
		json = {};
		arrayDetail = [];
		
		/**
		 * convert the array dataForm to json of the form key and value
		 */
		$.each(dataForm, function(i, field){
			json[field.name] = field.value;
		    
		    /*if(field.name === "category"){
		    	objectCategory = {};
		    	objectCategory['categoryId'] = field.value;
		    	json[field.name] = objectCategory;
		    }*/
		  });
		
		/**
		 * convert to json array
		 * push to arrayDetail
		 */
		$("#container-productdetail > .productdetail").each(function(){
			objectDetail = {};
			/**
			 * get value of color, size, quality
			 */
			color = $(this).find('select[name="productColor"]').val();
			size = $(this).find('select[name="size"]').val();
			quantity = $(this).find('input[name="quality"]').val();
			/**
			 * create object
			 */
			objectDetail["productColor"] = color;
			objectDetail["size"] = size;
			objectDetail["quality"] = quantity;
			/**
			 * add the object to the array arrayDetail
			 */
			arrayDetail.push(objectDetail);
		});
		/**
		 * add that object array to json with name productDetails 
		 */
		json['productDetails'] = arrayDetail;
		json['image'] = image;
		/*console.log(JSON.stringify(json));*/
		 
		$.ajax({
			url : "/harushop/api/addProduct",
			type : "POST",
			data : {
				/**
				 * convent json to string
				 * send it to api
				 */
				dataJson:JSON.stringify(json)
			},
			success : function() {
			}
		})
	});
	
	$("#btn-update-product").click(function(event){
		event.preventDefault();
		/**
		 * get all the value of the form tag
		 */
		var dataForm = $("#form-product").serializeArray();
		json = {};
		arrayDetail = [];
		
		/**
		 * convert the array dataForm to json of the form key and value
		 */
		$.each(dataForm, function(i, field){
			json[field.name] = field.value;
		  });
		
		/**
		 * convert to json array
		 * push to arrayDetail
		 */
		$("#container-productdetail > .productdetail").each(function(){
			objectDetail = {};
			/**
			 * get value of color, size, quality
			 */
			color = $(this).find('select[name="productColor"]').val();
			size = $(this).find('select[name="size"]').val();
			quantity = $(this).find('input[name="quality"]').val();
			/**
			 * create object
			 */
			objectDetail["productColor"] = color;
			objectDetail["size"] = size;
			objectDetail["quality"] = quantity;
			/**
			 * add the object to the array arrayDetail
			 */
			arrayDetail.push(objectDetail);
		});
		/**
		 * add that object array to json with name productDetails 
		 */
		json['productId'] = productId;
		json['productDetails'] = arrayDetail;
		json['image'] = image;
		console.log(json);
		 
		$.ajax({
			url : "/harushop/api/updateProduct",
			type : "POST",
			data : {
				/**
				 * convent json to string
				 * send it to api
				 */
				dataJson:JSON.stringify(json)
			},
			success : function() {
			}
		})
	});
	
	$("body").on("click",".update-product",function(){
		productId = $(this).attr("data-id");
		
		$("#btn-update-product").removeClass("hidden");
		$("#btn-exit").removeClass("hidden");
		$("#btn-add-product").addClass("hidden");
		
		$.ajax({
			url : "/harushop/api/getListProductById",
			type : "POST",
			data : {
				productId:productId
			},
			success : function(value) {
				console.log(value);
				$("#productName").val(value.productName);
				$("#price").val(value.price);
				$("#description").val(value.description);
				$("#category").val(value.category.categoryId);
				if(value.dedicated === "Nam"){
					$("#radio-nam").prop("checked",true);
				}else{
					$("#radio-nu").prop("checked",true)
				}
				
				$("#container-productdetail").empty();
				var count = value.productDetails.length;
				for(i = 0; i < count; i++){
					var detailClone = $("#productdetail").clone().removeAttr("id");
					detailClone.find("#color").val(value.productDetails[i].productColor.productColorId);
					detailClone.find("#size").val(value.productDetails[i].productSize.productSizeId);
					detailClone.find("#quality").val(value.productDetails[i].quantity);
					if(i < count - 1){
						detailClone.find("#btn-detail").remove();
					}
					$("#container-productdetail").append(detailClone);
				}
				
			}
		})
	});
	
});
