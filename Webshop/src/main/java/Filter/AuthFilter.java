package Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import DAO.UserDAO;
import model.Sanpham;
import model.User;

@WebFilter(filterName = "AuthFilter",urlPatterns = {"/manager/*"})
public class AuthFilter implements HttpFilter{
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		String uri=req.getRequestURI();
		User user = (User) req.getSession().getAttribute("user");
		String error="";
		if (user==null) {
			error=resp.encodeURL("Vui lòng đăng nhập");
			req.setAttribute("message", "Vui lòng đăng nhập");
			req.setAttribute("views","/VIEWS/dangnhap.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}else if(user.getVaitro()==false && uri.contains("manager")){
			error=resp.encodeURL("Vui lòng đăng nhập");
			req.setAttribute("error", "Bạn không phải admin");
			req.setAttribute("views","/VIEWS/home.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		if(!error.isEmpty()) {
			req.setAttribute("views","/VIEWS/home.jsp");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}else if(uri.contains("/manager/index")){
			List<Sanpham> listSP = new ArrayList<>();
			req.setAttribute("listDM", DanhMucDAO.findAll());
			
			listSP = SanPhamDAO.getAllSanPham();
			req.setAttribute("listSP", listSP);
			req.setAttribute("views","/Admin/SanPhamManager.jsp");
			req.getRequestDispatcher("/Admin/indexManager.jsp").forward(req, resp);
		}else {
			List<User> listUser = new ArrayList<>();
			listUser = UserDAO.findAllUser();
			
			
			req.setAttribute("listUser", listUser);
			
			
			req.setAttribute("views", "/Admin/QLTaiKhoan.jsp");
			req.getRequestDispatcher("/Admin/indexManager.jsp").forward(req, resp);
			chain.doFilter(req, resp);
		}
	}

}
