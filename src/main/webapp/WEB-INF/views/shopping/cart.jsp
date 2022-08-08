<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<c:if test="${ empty cart }">
		<p class="alert alert-warning">Không có dữ liệu</p>
	</c:if>
	<c:if test="${ !empty cart }">
		<div class="mt-5">
			<h2 class="section-title">Giỏ Hàng</h2>
		</div>
		<table class="table table-striped mt-3 text-nowrap border border-primary">
			<thead class="bg-info">
				<tr>
					<th scope="col">CartID</th>
					<th scope="col">Name</th>
					<th scope="col">Image</th>
					<th scope="col">Memory</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Bill</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ cart }" var="cart">
				<c:set var="s" value="${s + cart.phone.price * cart.quantity}"> </c:set>
				<form action="/shopping/cart/${ cart.phone.id }">
					<tr>
						<td>${ cart.id }</td>
						<td>${ cart.phone.name }</td>
						<td><img alt="" src="/img/${ cart.phone.image }" width="70px"
							height="70px"></td>
						<td>${ cart.phone.ram }/${ cart.phone.rom }</td>
						<td>${ cart.phone.price } VNĐ</td>
						<td><input type="number" value="${ cart.quantity }" name="soluong" id="soluong"/></td>
						<td>${ cart.phone.price * cart.quantity } VNĐ</td>
						<td><a class="btn btn-danger"
							href="/shopping/delete/${cart.id}">Xóa</a> <a
							class="btn btn-success" href="#">Mua</a>
							<button
							class="btn btn-primary">update</button>
							</td>
					</tr>
					
					</form>
				</c:forEach>
				<tr>
		<td colspan="7"  class="text-end fw-bold">Tổng tiền:</td>
		<td class="product-carousel-price"> <ins> ${s} VNĐ</ins></td>
		</tr>
			</tbody>
		</table>
		
	</c:if>
</div>

