package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class QLTaiKhoanServlet
 */
@WebServlet({ "/QLTaiKhoan/edit", "/taikhoan/create", "/taikhoan/update", "/taikhoan/delete" })
public class QLTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("edit")) {
			edit(req, resp);
		}
	}
	
	
	
	
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			User user = UserDAO.findUserById(email);
			
			List<User> listUser = new ArrayList<>();
			listUser = UserDAO.findAllUser();
			request.setAttribute("listUser", listUser);
			
			request.setAttribute("user",user);
			request.setAttribute("views","/Admin/QLTaiKhoan.jsp");
			request.getRequestDispatcher("/Admin/indexManager.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}

		
	}
}
