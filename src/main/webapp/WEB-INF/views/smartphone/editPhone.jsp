<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Thay Đổi Thông Tin Sản Phẩm</title>
</head>
<body>
	<div class="container">
	<h2 class="text-center mt-5">Thay Đổi Thông Tin Sản Phẩm</h2>
		<form:form class="mt-5" action="/admin/smartphone/update/${ fone.id }" method="post" modelAttribute="fone">
			<div class="col-6 offset-3 p-2">
				<form:label path="name">Tên Sản Phẩm</form:label>
				<form:input path="name" type="text" class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				
				<form:input path="image" type="hidden" class="form-control" />
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="ram">Ram</form:label>
				<form:select path="ram"  items="${ listRam }" class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="rom">Bộ nhớ trong</form:label>
				<form:select path="rom"  items="${ listRom }" class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="camera">Camera</form:label>
				<form:input path="camera" type="text"  class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="pin">Dung lượng pin</form:label>
				<form:input path="pin" type="text"   class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="price">Giá thành</form:label>
				<form:input path="price" type="number" class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="quantity">Số lượng</form:label>
				<form:input path="quantity" type="number"  class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="brand">Hãng</form:label>
				<form:select path="brand" items="${ listBrand }" class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">
				<form:label path="createDate">Ngày tạo</form:label>
				<form:input path="createDate" type="date"  class="form-control"/>
			</div>
			<div class="col-6 offset-3 p-2">			
			<form:button class="btn bg-primary fw-bold text-light">Cập Nhật</form:button>
			<form:button class="btn bg-danger fw-bold text-light" type="reset">Làm Mới</form:button>
			</div>
		</form:form>


	</div>
	
	
</body>
</html>