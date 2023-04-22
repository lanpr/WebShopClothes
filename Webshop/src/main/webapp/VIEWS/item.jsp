<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../CSS/item.css">
<c:url var="url" value="/products"></c:url>

	<div class="card p-0 border-0">
		<a href="${url}/detail?masp=${param.masp}" style="color: black; text-decoration: none">
			<div class="card-img p-0">
				<img src="${param.hinh}" alt=" " width="100% ">
			</div>
			<div class="card-title column-gap-0">
				<h4 class="text-center fw-bold " style="font-family: Courier;">${param.ten}</h4>
				<h5 class="text-center fw-bold text-danger" style="font-family: Courier;"><fmt:formatNumber type="number" pattern="#,###.##" value="${param.gia}"/>VND</h5>
				<c:if test="${param.sale > 0.0}">
					<del class="text-center d-block" style="font-family: Courier; margin-top: -10px;"><fmt:formatNumber type="number" pattern="#,###.##" value="${param.gia-(param.gia*param.sale)}"/>VND</del>
				</c:if>
			</div>
		</a>
	</div>
