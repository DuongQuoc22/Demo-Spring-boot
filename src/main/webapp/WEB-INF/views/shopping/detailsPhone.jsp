<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<form:form action="/shopping/cart/${ fone.id }/1" method="GET" modelAttribute="fone">
	<div class="container mt-5">
	<div class="row">
		<div class="col-4">
			<div class="fw-bolder fs-2 text-center">Điện thoại ${ fone.name }</div>
			<img class="mt-3" src="/img/${ fone.image }">
			<div class="text-center mt-3 product-carousel-price fs-2"><ins> ${ fone.price } VNĐ</ins> </div>
		 </div>
		<div class="col-4 offset-1">
			<h2 class="text-center text-danger">Thông tin chi tiết</h2>
			<div class="mt-5">
				<div class="fs-3">Tên máy: ${ fone.name }</div>
			<div class="fs-3">Ram: ${ fone.ram } </div>
			<div class="fs-3">Bộ nhớ trong: ${ fone.rom }</div>
			<div class="fs-3">Camera: ${ fone.camera }</div>
			<div class="fs-3">Dung lượng pin: ${ fone.pin }</div>
			<div class="fs-3">Hãng điện thoại: <span class="text-danger">${ fone.brand }</span></div>
			<form:button class="btn bg-primary fw-bold text-light mt-5">ADD TO CART</form:button>
			</div>
		</div>
	</div>
</div>
</form:form>