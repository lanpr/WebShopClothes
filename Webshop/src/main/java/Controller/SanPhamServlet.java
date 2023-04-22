package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DanhMucDAO;
import DAO.HinhDAO;
import DAO.SPSIZEDAO;
import DAO.SanPhamDAO;
import Utils.CookieUtils;
import model.Danhmuc;
import model.Hinh;
import model.Sanpham;
import model.SpSize;

@WebServlet({ "/products/all", "/products/detail","/products/findGiaSX" })
public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("all")) {
			productsAll(req, resp);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else if (uri.contains("detail")) {
			productDetail(req, resp);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else if (uri.contains("findDM")) {
//			productFindDM(req, resp);
//			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else if (uri.contains("findGiaSX")) {
			productFindGiaSX(req, resp);
		}

		
	}

	protected void productsAll(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("views", "/VIEWS/products.jsp");
		try {
			HttpSession session = request.getSession();
			session.setAttribute("madanhmuc", null);
			List<Sanpham> listAllSP = SanPhamDAO.getAllSanPham();
			int indexPage = request.getParameter("indexPage") == null?0:Integer.parseInt(request.getParameter("indexPage"));
			int page = listAllSP.size()/6;
			if(listAllSP.size()%6!=0) {
				page++;
			}
			
	
			List<Sanpham> listSPPage = SanPhamDAO.getAllByPage(indexPage);
			List<Danhmuc> listDM = DanhMucDAO.findAll();
			request.setAttribute("page", page);
			request.setAttribute("listDM", listDM);
			request.setAttribute("listSP", listSPPage);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void productDetail(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("views", "/VIEWS/item_detail.jsp");
		String maSP = request.getParameter("masp");
		Sanpham sp = SanPhamDAO.findSanPhamByID(maSP);
		List<SpSize> listSPSize = SPSIZEDAO.getSPSizeByMaSP(maSP);
		request.setAttribute("listSPSize", listSPSize);
		request.setAttribute("product", sp);
	}


	protected void productFindGiaSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("views", "/VIEWS/products.jsp");
		response.setContentType("UTF-8");
		
		System.out.println(request.getMethod());
		
		String method = request.getMethod();
		String madanhmuc = null;
		int sapxep = 0;
		int khoanggia = 0;
		if(method.equals("POST")) {
			madanhmuc =  request.getParameter("madanhmuc");
			khoanggia = request.getParameter("khoanggia")==null?0:Integer.parseInt(request.getParameter("khoanggia"));
			sapxep = request.getParameter("sapxep")==null?0:Integer.parseInt(request.getParameter("sapxep"));
			System.out.println("ajax" + madanhmuc + " ---" + sapxep + "---"+khoanggia);
		}
		List<Sanpham> listSP = SanPhamDAO.findByDMGiaSapXep(madanhmuc, khoanggia, sapxep);
		List<Danhmuc> listDM = DanhMucDAO.findAll();
		PrintWriter out = response.getWriter();
		System.out.println(listSP.size());
		DecimalFormat df = new DecimalFormat("###,###.##");
		for(Sanpham sp:listSP) {
			String gia = df.format(sp.getGiaban());
			out.println("<div class=\"col-6 col-lg-4 p-0\">\r\n"
					+ "	<div class=\"card p-0 border-0\">\r\n"
					+ "		<a href=\""+"../products"+"/detail?masp="+sp.getMasp()+"\" style=\"color: black; text-decoration: none\">\r\n"
					+ "			<div class=\"card-img p-0\">\r\n"
					+ "				<img src=\""+sp.getHinh().get(0).getTenhinh()+"\" alt=\" \" width=\"100% \">\r\n"
					+ "			</div>\r\n"
					+ "			<div class=\"card-title column-gap-0\">\r\n"
					+ "				<h4 class=\"text-center fw-bold \" style=\"font-family: Courier;\">"+sp.getTensp()+"</h4>\r\n"
					+ "				<h5 class=\"text-center fw-bold text-danger\" style=\"font-family: Courier;\">"+gia+"VND</h5>\r\n"
					+ "				"
					+ "			</div>\r\n"
					+ "		</a>\r\n"
					+ "	</div>\r\n"
					+ "</div>");
		}
		
		request.setAttribute("listDM", listDM);
		request.setAttribute("listSP", listSP);
		
	}

}
