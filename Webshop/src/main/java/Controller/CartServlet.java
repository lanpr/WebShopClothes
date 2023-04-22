package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DAO.SanPhamDAO;
import Utils.CookieUtils;
import model.CartSanPham;
import model.Sanpham;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet({ "/cart/addCart", "/cart/products", "/cart/changeSL", "/cart/remove" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("addCart")) {
			addCart(req, resp);

		} else if (uri.contains("products")) {
			cartProduct(req, resp);
		} else if (uri.contains("changeSL")) {
			changeSL(req, resp);
		} else if (uri.contains("remove")) {
			removeCart(req, resp);
		}

	}

	protected void addCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String maSP = (String) session.getAttribute("masp");
		String size = request.getParameter("size");

		if (size == null || size.trim().isEmpty()) {
			HttpSession sess = request.getSession();
			sess.setAttribute("message", "Vui long chon size");

		} else {

			String txtCart = "";
			String valueCart = CookieUtils.get("cart", request);
			if (valueCart != null) {
				txtCart = txtCart + valueCart;
				CookieUtils.add("cart", valueCart, 0, response);
			}
			if (txtCart.isEmpty()) {
				txtCart = maSP + ":" + size;
			} else {
				txtCart += "/" + maSP + ":" + size;
			}
			int hour = 2 * 24 * 60 * 60;
//			
			CookieUtils.add("cart", txtCart, hour, response);
		}

		response.sendRedirect("../products/detail?masp=" + maSP);

	}

	protected void cartProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String txtCart = CookieUtils.get("cart", request);
		if (txtCart != null) {
			if (!txtCart.trim().equals("")) {
				CartDAO.setListCart(txtCart);
				List<CartSanPham> listCart = CartDAO.getListCart();
				request.setAttribute("listCart", listCart);
				request.setAttribute("thanhTien", CartDAO.getThanhTien());
			}
		}
		request.setAttribute("views", "/VIEWS/gioHang.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void changeSL(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String maSP = request.getParameter("masp");
			String size = request.getParameter("size");
			String sl = request.getParameter("sl");

			CartDAO.giamCartSP(maSP, size, sl);
			request.setAttribute("listCart", CartDAO.getListCart());
			request.setAttribute("thanhTien", CartDAO.getThanhTien());
			CookieUtils.add("cart", CartDAO.getStringtxtCart(), 2 * 24 * 60 * 60, response);

			request.setAttribute("views", "/VIEWS/gioHang.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void removeCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String maSP = request.getParameter("masp");
			String size = request.getParameter("size");

			CartDAO.removeCart(maSP, size);
			request.setAttribute("listCart", CartDAO.getListCart());
			request.setAttribute("thanhTien", CartDAO.getThanhTien());
			CookieUtils.add("cart", CartDAO.getStringtxtCart(), 2 * 24 * 60 * 60, response);

			request.setAttribute("views", "/VIEWS/gioHang.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
