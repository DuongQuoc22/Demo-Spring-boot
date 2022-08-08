<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Điện Thoại Thông Minh</title>
<style type="text/css">
.btnSearch {
	margin-left: 52%;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row col-10 pt-5">
			<c:if test="${ empty phone }">
				<p class="alert alert-warning">Không có dữ liệu</p>
			</c:if>
			<h2 class="text-center">Danh Sách Sản Phẩm</h2>
			<hr>
			<br>
			<c:if test="${ !empty phone }"></c:if>
			<div class="row">
				<div class="d-flex offset-1">
					<form class="d-flex" action="/admin/smartphone/search">
						<select name="brand"
							class="form-control border border-primary me-2">
							<option value="Apple">Apple</option>
							<option value="Samsung">Samsung</option>
							<option value="Xiaomi">Xiaomi</option>
							<option value="Realme">Realme</option>
							<option value="Oppo">Oppo</option>
							<option value="Nokia">Nokia</option>
							<option value="Oneplus">Oneplus</option>
						</select>
						<button class="btn btn-outline-primary">Search</button>
					</form>

					<div class="btnSearch">
						<a id="btnAdd" class="btn btn-primary" href="/admin/smartphone/add">Thêm
							Mới</a>

					</div>
				</div>
			</div>

			<table class="table table-striped mt-3 text-nowrap offset-1">
				<thead class="bg-info">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Image</th>
						<th>Ram</th>
						<th>Rom</th>
						<th>Camera</th>
						<th>Pin</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Brand</th>
						<th>Ngày tạo</th>

						<th colspan="2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ phone }" var="f">
						<tr>
							<td>${f.id}</td>
							<td>${f.name}</td>
							<td><img height="80px" width="80px" src="/img/${f.image}" />
							</td>
							<td>${f.ram}</td>
							<td>${f.ram}</td>
							<td>${f.camera}</td>
							<td>${f.pin}</td>
							<td>${f.price}</td>
							<td>${f.quantity}</td>
							<td>${f.brand}</td>
							<td>${f.createDate}</td>


							<td><a href="/admin/smartphone/edit?id=${f.id}"
								class="btn btn-primary">Edit</a></td>
							<td>
								<!-- Modal  --> <!-- Button trigger modal -->
								<button type="button" class="btn btn-danger"
									data-bs-toggle="modal" data-bs-target="#exampleModal${ f.id }">
									Delete</button> <!-- Modal -->
								<div class="modal fade" id="exampleModal${ f.id }" tabindex="-1"
									aria-labelledby="exampleModalLabel${ f.id }" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel${ f.id }">Message</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">Bạn muốn xóa không ?</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Thoát</button>
												<a href="/delete?id=${ f.id }">
													<button type="button" class="btn btn-primary">Xóa</button>
												</a>
											</div>
										</div>
									</div>
								</div> <!-- End Modal -->
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>