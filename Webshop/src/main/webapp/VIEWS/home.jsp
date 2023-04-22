<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="p-0">
	<%@ include file="header.jsp"%>
	<article>
		<div class="content container  mt-4">
			<div>
				<h3 class="text-center fw-bold">SẢN PHẨM MỚI</h3>
			</div>
			<div class="row box_SP">
				<c:forEach var="item" items="${listSP}">
					<div class="col-6 col-lg-3 p-0">
						<jsp:include page="/VIEWS/item.jsp">
							<jsp:param value="${item.tensp}" name="ten" />
							<jsp:param value="${item.hinh[0].tenhinh}" name="hinh" />
							<jsp:param value="${item.giaban}" name="gia" />
							<jsp:param value="${item.masp}" name="masp" />
						</jsp:include>
					</div>
				</c:forEach>
			</div>
			<div class="py-4">
				<button class="btn btn-secondary mx-auto  d-block">Xem tất cả</button>
			</div>
		</div>
	</article>
</div>
