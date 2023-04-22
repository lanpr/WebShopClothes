<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url var="url" value="/cart"></c:url>
<article>
	<div class="thanhToan mt-5 col-10 mx-auto row">
		<div class="col-12 ">
			<h3 class="fw-bold">GIỎ HÀNG</h3>
		</div>
		<div class="col-12 col-lg-9  p-0">
			<table class="table">
				<tr>
					<th class="text-black-50 col-3 h6 col-md-5 text-center">Sản phẩm</th>
					<th class="text-black-50 col-1 h6 text-center">Giá bán</th>
					<th class="text-black-50 col-4 h6 text-center">Số lượng</th>
					<th class="text-black-50 col-2 h6 text-center">Tổng tiền</th>
					<th class="text-black-50 col-1 h6 text-center"></th>
				</tr>
				<c:if test="${listCart!=null}">
					<c:forEach var="cart" items="${listCart}">
						<tr>
							<td class="col-3">
								<div class="col-11 col-sm-9 col-md-5 float-start">
									<img src="${cart.hinh}" alt="" width="100%">
								</div>
								<div>
									<h6>${cart.tenSP}(Size${cart.tensize})</h6>
								</div>
							</td>
							<td style="padding: 65px 0; text-align: center;">${cart.giaban}</td>
							<td class="col-1">
								<div class="input-group d-flex justify-content-center" style="padding: 50px 0; text-align: center;">
									<a class="input-group-text" href="${url}/changeSL?sl=-1&masp=${cart.maSP}&size=${cart.size}">-</a>
									<input type="number" class=" text-center" disabled="disabled" value="${cart.sl}" style="width: 45px">
									<a class="input-group-text" href="${url}/changeSL?sl=1&masp=${cart.maSP}&size=${cart.size}">+</a>
								</div>
							</td>
							<td style="padding: 65px 0; text-align: center;"><fmt:formatNumber type="number" pattern="#,###.##" value="${cart.tongtien}" /> VND</td>
							<td style="padding: 60px 0; text-align: center;"><a href="${url}/remove?masp=${cart.maSP}&size=${cart.size}">
									<i class="fa-regular fa-trash-can fs-2 text-danger"></i>
								</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${listCart==null}">Bạn chưa có sản phẩm nào trong giỏ hàng !</c:if>
			</table>
			<div>
				<c:url var="product" value="/products"></c:url>
				<a class="btn btn-dark  fw-bold col-12   col-lg-4 " style="border-radius: 120px;" href="${product}/all">TIẾP TỤC MUA SẮM</a>
			</div>
		</div>
		<div class="col-12 my-4 col-lg-3">
			<div class="card">
				<div class="card-header bg-white">
					<h6 class="text-black-50 float-start mt-1">Tổng tiền</h6>
					<span class="me-auto float-end fw-bold"><fmt:formatNumber type="number" pattern="#,###.##" value="${thanhTien}" /></span>
				</div>
				<div class="card-footer py-4">
					<button class="btn btn-dark mx-auto d-block fw-bold" style="border-radius: 120px;">THANH TOÁN</button>
				</div>
			</div>
		</div>
	</div>
	<div class="sp_Lien_Quan mt-2">
		<div>
			<h3 class="text-center">SẢN PHẨM LIÊN QUAN</h3>
		</div>
	</div>
</article>