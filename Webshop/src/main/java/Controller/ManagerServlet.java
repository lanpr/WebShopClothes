package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtilsBean;

import DAO.DanhMucDAO;
import DAO.HinhDAO;
import DAO.SanPhamDAO;
import DAO.UserDAO;
import Utils.JPAUtils;
import Utils.UploadFile;
import model.Danhmuc;
import model.Hinh;
import model.Sanpham;
import model.User;

@MultipartConfig
@WebServlet({ "/manager/index", "/manager/qldanhmuc", "/manager/qltaikhoan", "/manager/thongke" })
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("index")) {
			qlSanPham(req, resp);
		} else if (uri.contains("qltaikhoan")) {
			qlTaiKhoan(req, resp);
		}
	}

	protected void qlSanPham(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Sanpham> listSP = new ArrayList<>();
			request.setAttribute("listDM", DanhMucDAO.findAll());
			
			listSP = SanPhamDAO.getAllSanPham();
			request.setAttribute("listSP", listSP);
			
			
			request.setAttribute("views", "/Admin/SanPhamManager.jsp");
			request.getRequestDispatcher("/Admin/indexManager.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	protected void qlTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<User> listUser = new ArrayList<>();
			listUser = UserDAO.findAllUser();
			
			
			request.setAttribute("listUser", listUser);
			
			
			request.setAttribute("views", "/Admin/QLTaiKhoan.jsp");
			request.getRequestDispatcher("/Admin/indexManager.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
