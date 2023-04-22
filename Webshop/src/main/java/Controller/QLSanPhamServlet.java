package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtilsBean;

import DAO.DanhMucDAO;
import DAO.HinhDAO;
import DAO.SPSIZEDAO;
import DAO.SanPhamDAO;
import DAO.SizeDAO;
import Utils.UploadFile;
import model.Danhmuc;
import model.Hinh;
import model.Sanpham;
import model.Size;
import model.SpSize;
import model.User;

@MultipartConfig
@WebServlet({ "/product/addSP", "/product/editSP", "/product/checkSize" })
public class QLSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("addSP")) {
			addSP(req, resp);
		} else if (uri.contains("editSP")) {
			editSP(req, resp);
		} else if (uri.contains("checkSize")) {
			checkSize(req, resp);
		}
	}

	protected void addSP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<Sanpham> listSP = new ArrayList<>();
		try {
			if (method.equals("POST")) {
				Sanpham sp = new Sanpham();
				BeanUtilsBean bean = new BeanUtilsBean();
				bean.populate(sp, request.getParameterMap());

				Danhmuc dm = DanhMucDAO.findByID(request.getParameter("danhmuc1"));
				sp.setDanhmuc(dm);
				// lấy đường dẫn hình upload
				List<String> listPath = UploadFile.uploadFile("hinh", request);
				// lấy đường dẫn hình sau khi upload binary
				List<String> listReturnURL = UploadFile.upCloudBinary(listPath);

				List<Hinh> listHinh = new ArrayList<>();
				for (String listpath : listReturnURL) {
					listHinh.add(new Hinh(listpath, sp));
				}
				sp.setHinh(listHinh);
				// add sản phẩm
				SanPhamDAO.insertSP(sp);

				for (Hinh hinh : listHinh) {
					HinhDAO.createHinh(hinh);
				}
				// quay lại trang lúc đầu
				response.sendRedirect("../manager/index");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void editSP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			if (method.equals("GET")) {
				String maSP = request.getParameter("masp");
				Sanpham sp = SanPhamDAO.findSanPhamByID(maSP);
				request.setAttribute("listSize", SizeDAO.getAllSize());
				request.setAttribute("listSPSize",SPSIZEDAO.getSPSizeByMaSP(maSP));
				request.setAttribute("sanpham", sp);
				request.setAttribute("listDM", DanhMucDAO.findAll());
				request.setAttribute("views", "/Admin/EditSanPham.jsp");
				request.getRequestDispatcher("/Admin/indexManager.jsp").forward(request, response);
			} else {
				String masp = request.getParameter("masp");
				Sanpham sp = SanPhamDAO.findSanPhamByID(masp);

				BeanUtilsBean bean = new BeanUtilsBean();
				bean.populate(sp, request.getParameterMap());
				Danhmuc danhmuc = DanhMucDAO.findByID(request.getParameter("danhmuc1"));
				
				Size size = SizeDAO.getSizeById(request.getParameter("size"));
				System.out.println(size.getMasize());
				Integer sl = Integer.parseInt(request.getParameter("slSize"));

				List<SpSize> listSPSize = SPSIZEDAO.getSPSizeByMaSP(masp);
				boolean ck = true;
				for (SpSize spsize : listSPSize) {
					if (spsize.getSanpham().getMasp().equals(sp.getMasp())
							&& spsize.getSize().getMasize().equals(size.getMasize())) {
						spsize.setSlcon(sl);
//						spsize.setSanpham(sp);
//						spsize.setSize(size);
//						sp.setSpSize(listSPSize);
//						sp.setDanhmuc(danhmuc);
//						SanPhamDAO.updateSP(sp);
						SPSIZEDAO.upadateSPSize(spsize);
						ck = false;
					}
				}
				if (ck) {
//					sp.setSpSize(listSPSize);
//					size.setSpSizes(listSPSize);
					sp.setDanhmuc(danhmuc);
					SanPhamDAO.updateSP(sp);
					SPSIZEDAO.insertSPSize(new SpSize(sl, sp, size));
					System.out.println(size.getTensize());
					listSPSize.add(new SpSize(sl, sp, size));
				}

				response.sendRedirect("../manager/index");
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	protected void checkSize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			if (method.equals("POST")) {
				String masp = request.getParameter("masp");
				String masize = request.getParameter("masize");

				SpSize spsize = SPSIZEDAO.checkSL(masp, masize);
				PrintWriter out = response.getWriter();
				if (spsize == null) {
					out.print(0);
				} else {
					out.print(spsize.getSlcon());
					System.out.println(masp + " " + masize);
					System.out.println(spsize.getSlcon());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
