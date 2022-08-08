<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ empty fone }">
	<p class="alert alert-warning mt-5">Không tìm thấy sản phẩm nào!</p>
</c:if>
<c:if test="${ !empty fone }">
	<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="latest-product">
						<h2 class="section-title mt-5">Sản Phẩm Nổi Bật</h2>

						<div class="product-carousel">
							<c:forEach items="${ fone }" var="f">
								<div class="single-product">
									<div class="product-f-image">
										<img src="/img/${f.image}" alt="">
										<div class="product-hover">
											<a href="/shopping/cart/${ f.id }/1" class="add-to-cart-link"><i
												class="fa fa-shopping-cart"></i> Add to cart</a>
										</div>
									</div>

									<h2>
										<a style="text-decoration: none;" href="/home/smartphone/details?id=${f.id}">${f.brand }
											${ f.name }</a>
									</h2>

									<div class="product-carousel-price">
										<ins>${f.price } VNĐ</ins>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>