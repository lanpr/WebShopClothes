package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CartDAO;
import DAO.SanPhamDAO;
import Utils.CookieUtils;
import model.CartSanPham;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home/index")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("views", "/VIEWS/home.jsp");

		req.setAttribute("listSP", SanPhamDAO.getAllSanPham());

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
